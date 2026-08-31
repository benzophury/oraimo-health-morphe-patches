package app.morphe.patches.oraimohealth.cloud

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that disables Strava cloud synchronization queries on application launch.
 */
@Suppress("unused")
val disableStravaSyncPatch = bytecodePatch(
    name = "Disable Strava Cloud Sync",
    description = "Stubs out Strava token status queries to eliminate cloud sync overhead.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        QueryStravaTokenStatusFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )
    }
}
