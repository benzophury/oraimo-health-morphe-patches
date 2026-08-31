package app.morphe.patches.oraimohealth.launch

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that disables startup splash advertising and eliminates launch delay.
 */
@Suppress("unused")
val disableSplashPatch = bytecodePatch(
    name = "Disable Splash & Launch Ads",
    description = "Stubs out launch ad requests and ad presentation callbacks to provide an instant startup experience.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
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
    }
}
