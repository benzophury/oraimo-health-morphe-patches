package app.morphe.patches.oraimohealth.ui

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

/**
 * Patch that isolates the application interface exclusively to the Device management tab while preserving Bluetooth binding stack.
 */
@Suppress("unused")
val pureDeviceModePatch = bytecodePatch(
    name = "Pure Device Mode",
    description = "Forces the Device management tab as the dedicated single view and hides all extraneous health, sport, and profile tabs.",
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
                if-eqz v2, :cond_skip_data
                invoke-virtual {v2, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_data
                iget-object v2, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbSport:Landroid/widget/RadioButton;
                if-eqz v2, :cond_skip_sport
                invoke-virtual {v2, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_sport
                iget-object v2, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbMall:Landroid/widget/RadioButton;
                if-eqz v2, :cond_skip_mall
                invoke-virtual {v2, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_mall
                iget-object v2, v0, Lcom/transsion/oraimohealth/databinding/ActivityMainBinding;->rbMine:Landroid/widget/RadioButton;
                if-eqz v2, :cond_skip_mine
                invoke-virtual {v2, v1}, Landroid/widget/RadioButton;->setVisibility(I)V
                :cond_skip_mine
                :cond_no_binding
            """
        )

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
