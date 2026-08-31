package app.morphe.patches.oraimohealth.cloud

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that disables cloud device banner and thumbnail queries on application launch.
 */
@Suppress("unused")
val disableCloudDevicePicturesPatch = bytecodePatch(
    name = "Disable Remote Device Pictures",
    description = "Stubs out remote device picture and thumbnail downloads on launch.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        RequestDevicePicturesFingerprint.method.addInstructions(
            0,
            """
                return-void
            """
        )
    }
}
