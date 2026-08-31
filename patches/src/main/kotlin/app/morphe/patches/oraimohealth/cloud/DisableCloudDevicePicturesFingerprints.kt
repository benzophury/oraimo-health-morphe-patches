package app.morphe.patches.oraimohealth.cloud

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the requestDevicePictures method in LaunchPresenter.
 */
object RequestDevicePicturesFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "requestDevicePictures",
    returnType = "V"
)
