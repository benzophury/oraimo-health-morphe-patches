package app.morphe.patches.oraimohealth.launch

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the requestLaunchAd method in LaunchPresenter.
 */
object RequestLaunchAdFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "requestLaunchAd",
    returnType = "V"
)

/**
 * Fingerprint matching the onGetLaunchAd method in LaunchActivity.
 */
object OnGetLaunchAdFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchActivity;",
    name = "onGetLaunchAd",
    returnType = "V",
    parameters = listOf("Lcom/transsion/data/model/entity/AdInfo;")
)
