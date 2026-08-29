package app.morphe.patches.oraimohealth.offline

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that forces local guest offline mode on startup.
 */
@Suppress("unused")
val forceLocalGuestModePatch = bytecodePatch(
    name = "Force Local Offline Mode",
    description = "Bypasses cloud authentication and routes startup directly to the main view in local offline mode.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
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
    }
}
