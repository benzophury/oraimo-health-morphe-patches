package app.morphe.patches.oraimohealth.ui

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that completely eliminates the Store/Mall tab from the application UI and navigation.
 */
@Suppress("unused")
val removeStoreTabPatch = bytecodePatch(
    name = "Remove Store Tab",
    description = "Completely removes the Store/Mall tab from the bottom navigation bar and disables store catalog requests.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
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
