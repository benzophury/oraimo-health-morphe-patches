package app.morphe.patches.oraimohealth.ui

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that removes the Health dashboard tab from the bottom navigation bar.
 */
@Suppress("unused")
val removeHealthTabPatch = bytecodePatch(
    name = "Remove Health Tab",
    description = "Hides the Health metrics dashboard tab from the bottom navigation bar.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        MainActivityInitViewsFingerprint.method.addInstructions(
            0,
            """
                iget-object v0, p0, Lcom/transsion/oraimohealth/module/main/MainActivity;->mBinding:Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;
                if-eqz v0, :cond_no_binding
                const/16 v1, 0x8
                iget-object v2, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbData:Landroid/widget/RadioButton;
                if-eqz v2, :cond_no_binding
                invoke-virtual {v2, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_no_binding
            """
        )
    }
}
