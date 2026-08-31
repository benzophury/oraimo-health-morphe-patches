package app.morphe.patches.oraimohealth.ui

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the initViews method in MainActivity.
 */
object MainActivityInitViewsFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/main/MainActivity;",
    name = "initViews",
    returnType = "V"
)

/**
 * Fingerprint matching the initEvent method in MainActivity.
 */
object MainActivityInitEventFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/main/MainActivity;",
    name = "initEvent",
    returnType = "V"
)
