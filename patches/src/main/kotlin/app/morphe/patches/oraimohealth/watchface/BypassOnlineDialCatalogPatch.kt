package app.morphe.patches.oraimohealth.watchface

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that disables cloud ads, AI configuration queries, Strava sync, and remote pictures on launch.
 */
@Suppress("unused")
val bypassOnlineDialCatalogPatch = bytecodePatch(
    name = "Disable Cloud Ads & External Queries",
    description = "Stubs remote launch advertising, AI config queries, and Strava cloud synchronization while keeping local DIY watchface intact.",
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
    }
}
