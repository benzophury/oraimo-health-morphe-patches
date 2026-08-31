package app.morphe.patches.oraimohealth.cloud

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that disables AI conference configuration queries on application launch.
 */
@Suppress("unused")
val disableAIConfigPatch = bytecodePatch(
    name = "Disable AI Config Queries",
    description = "Stubs out AI conference and backend configuration queries to prevent remote telemetry checks.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        QueryAIConferenceConfigFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )
    }
}
