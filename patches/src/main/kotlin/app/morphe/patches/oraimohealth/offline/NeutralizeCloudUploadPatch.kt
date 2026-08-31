package app.morphe.patches.oraimohealth.offline

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that neutralizes cloud telemetry, background upload services, and network connectivity indicators.
 */
@Suppress("unused")
val neutralizeCloudUploadPatch = bytecodePatch(
    name = "Neutralize Cloud Telemetry & Uploads",
    description = "Stubs out background data upload service and forces network utility to report offline state.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
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

        NetworkUtilIsConnectedFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x0
                return v0
            """
        )
    }
}
