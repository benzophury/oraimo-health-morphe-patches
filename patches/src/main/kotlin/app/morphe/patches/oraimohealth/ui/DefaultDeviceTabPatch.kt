package app.morphe.patches.oraimohealth.ui

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that makes the Device management tab the default landing view on application startup.
 */
@Suppress("unused")
val defaultDeviceTabPatch = bytecodePatch(
    name = "Default to Device Tab",
    description = "Sets the Device management tab as the initial active page upon opening the application.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
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
    }
}
