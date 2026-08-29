package app.morphe.patches.oraimohealth.watchface

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the `requestLaunchAd` method in LaunchPresenter.
 */
object RequestLaunchAdFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "requestLaunchAd",
    returnType = "V"
)

/**
 * Fingerprint matching the `queryAIConferenceConfig` method in LaunchPresenter.
 */
object QueryAIConferenceConfigFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "queryAIConferenceConfig",
    returnType = "V"
)

/**
 * Fingerprint matching the `queryStravaTokenStatus` method in LaunchPresenter.
 */
object QueryStravaTokenStatusFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "queryStravaTokenStatus",
    returnType = "V"
)

/**
 * Fingerprint matching the `requestDevicePictures` method in LaunchPresenter.
 */
object RequestDevicePicturesFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "requestDevicePictures",
    returnType = "V"
)
