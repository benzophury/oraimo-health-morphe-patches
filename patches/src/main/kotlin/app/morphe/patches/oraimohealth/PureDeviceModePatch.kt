package app.morphe.patches.oraimohealth

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Unified core patch that transforms the application into an offline, dedicated Device Manager.
 * Preserves the full Bluetooth Low Energy peripheral connection, pairing, and synchronization stack.
 */
@Suppress("unused")
val pureDeviceModePatch = bytecodePatch(
    name = "Pure Device Mode",
    description = "Converts the app into a dedicated offline Device Manager: boots directly into the Device tab, bypasses startup ads, provisions guest profile and database bindings, and safely neutralizes cloud telemetry.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        // 1. Navigation: Hide extraneous tabs in MainActivity
        MainActivityInitViewsFingerprint.method.addInstructions(
            0,
            """
                iget-object v0, p0, Lcom/transsion/oraimohealth/module/main/MainActivity;->mBinding:Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;
                if-eqz v0, :cond_no_binding
                const/16 v1, 0x8
                iget-object v0, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbData:Landroid/widget/RadioButton;
                if-eqz v0, :cond_skip_data
                invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_data
                iget-object v0, p0, Lcom/transsion/oraimohealth/module/main/MainActivity;->mBinding:Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;
                if-eqz v0, :cond_no_binding
                iget-object v0, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbSport:Landroid/widget/RadioButton;
                if-eqz v0, :cond_skip_sport
                invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_sport
                iget-object v0, p0, Lcom/transsion/oraimohealth/module/main/MainActivity;->mBinding:Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;
                if-eqz v0, :cond_no_binding
                iget-object v0, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbMall:Landroid/widget/RadioButton;
                if-eqz v0, :cond_skip_mall
                invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_mall
                iget-object v0, p0, Lcom/transsion/oraimohealth/module/main/MainActivity;->mBinding:Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;
                if-eqz v0, :cond_no_binding
                iget-object v0, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbMine:Landroid/widget/RadioButton;
                if-eqz v0, :cond_skip_mine
                invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_mine
                :cond_no_binding
            """
        )

        // 2. Navigation: Default directly to Device Tab in MainActivity
        MainActivityInitEventFingerprint.method.addInstructions(
            0,
            """
                iget-object v0, p0, Lcom/transsion/oraimohealth/module/main/MainActivity;->mBinding:Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;
                if-eqz v0, :cond_no_init_device
                iget-object v0, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbDevice:Landroid/widget/RadioButton;
                if-eqz v0, :cond_no_init_device
                const/4 v1, 0x1
                invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setChecked(Z)V
                :cond_no_init_device
            """
        )

        // 3. Offline Core: Force local guest authentication and initialize SQLite database bindings
        IsLoginFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )

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
                :cond_guest_ok
                invoke-static {}, Lcom/transsion/oraimohealth/utils/SPManager;->getUserInfo()Lcom/transsion/data/model/entity/UserInfo;
                move-result-object v0
                if-eqz v0, :cond_cache_ok
                invoke-virtual {v0}, Lcom/transsion/data/model/entity/UserInfo;->getId()Ljava/lang/String;
                move-result-object v0
                if-eqz v0, :cond_cache_ok
                invoke-static {v0}, Lcom/transsion/devices/cache/DeviceCache;->saveUserId(Ljava/lang/String;)V
                :cond_cache_ok
                const/4 v0, 0x1
                return v0
            """
        )

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

        // 4. Launch & Ads: Neutralize startup ads and cloud query delays
        RequestLaunchAdFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        OnGetLaunchAdFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        QueryAIConferenceConfigFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        QueryStravaTokenStatusFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        RequestDevicePicturesFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        // 5. Cloud Telemetry & Uploads: Neutralize background services and force offline network utility
        DataUploadOnHandleWorkFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        DataUploadEnqueueWorkFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        DataUploadEnqueueWorkContextFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )

        NetworkUtilIsConnectedFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x0
                return v0
            """
        )

        // 6. Store: Disable mall display
        IsShowMallFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x0
                return v0
            """
        )

        RequestMallInfoListFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )
    }
}
