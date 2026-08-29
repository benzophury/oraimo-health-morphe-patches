package app.morphe.patches.oraimohealth.offline

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that forces local offline guest mode and ensures the SQLite device database is
 * initialised. It creates a guest UserInfo, saves it, and registers the user ID with
 * DeviceSetActions and DBDataManager so that DeviceInfoItemDao can store bind data.
 */
@Suppress("unused")
val forceLocalGuestModePatch = bytecodePatch(
    name = "Force Local Offline Mode",
    description = "Initialises an offline guest profile, registers the user ID, and creates local SQLite tables before routing to the main view.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        // Replace isLogin() to always return true – the app treats the guest as logged in.
        IsLoginFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )

        // Replace isInGuestMode() with a full guest initialisation and DB registration.
        IsInGuestModeFingerprint.method.addInstructions(
            0,
            """
                invoke-static {}, Lcom/transsion/oraimohealth/utils/SPManager;->getUserInfo()Lcom/transsion/data/model/entity/UserInfo;
                move-result-object v0
                if-nez v0, :cond_guest_ok
                new-instance v0, Lcom/transsion/oraimohealth/module/account/presenter/BaseAccountPresenter;
                invoke-direct {v0}, Lcom/transsion/oraimohealth/module/account/presenter/BaseAccountPresenter;-><init>()V
                invoke-virtual {v0}, Lcom/transsion/oraimohealth/module/account/presenter/BaseAccountPresenter;->createGuestUserInfo()Lcom/transsion/data/model/entity/UserInfo;
                move-result-object v0
                const/4 v1, 0x1
                invoke-virtual {v0, v1}, Lcom/transsion/data/model/entity/UserInfo;->setGender(I)V
                const-string v1, "2000-01-01"
                invoke-virtual {v0, v1}, Lcom/transsion/data/model/entity/UserInfo;->setBirthday(Ljava/lang/String;)V
                const/16 v1, 0xaf
                invoke-virtual {v0, v1}, Lcom/transsion/data/model/entity/UserInfo;->setHeight(I)V
                const/16 v1, 0x46
                invoke-virtual {v0, v1}, Lcom/transsion/data/model/entity/UserInfo;->setWeight(I)V
                const/16 v1, 0x1f40
                invoke-virtual {v0, v1}, Lcom/transsion/data/model/entity/UserInfo;->setTargetSteps(I)V
                const/16 v1, 0x1f4
                invoke-virtual {v0, v1}, Lcom/transsion/data/model/entity/UserInfo;->setTargetCalories(I)V
                const/16 v1, 0x1e
                invoke-virtual {v0, v1}, Lcom/transsion/data/model/entity/UserInfo;->setTargetSportDuration(I)V
                invoke-static {v0}, Lcom/transsion/oraimohealth/utils/SPManager;->saveUserInfo(Lcom/transsion/data/model/entity/UserInfo;)V
                const/4 v1, 0x1
                invoke-static {v1}, Lcom/transsion/oraimohealth/utils/SPManager;->saveAgreedPolicy(Z)V
                // Register the generated user ID with the device manager and DB helper.
                invoke-virtual {v0}, Lcom/transsion/data/model/entity/UserInfo;->getId()Ljava/lang/String;
                move-result-object v1
                invoke-static {v1}, Lcom/transsion/oraimohealth/module/actions/DeviceSetActions;->setLoginUserId(Ljava/lang/String;)V
                invoke-static {v1}, Lcom/transsion/oraimohealth/module/db/DBDataManager;->setUserId(Ljava/lang/String;)V
                :cond_guest_ok
                const/4 v0, 0x1
                return v0
            """
        )

        // The following methods can remain no‑ops – they are not required for offline mode.
        NeedSetUserInfoFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x0
                return v0
            """
        )

        NeedSetGoalFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x0
                return v0
            """
        )

        RefreshTokenFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )
    }
}
