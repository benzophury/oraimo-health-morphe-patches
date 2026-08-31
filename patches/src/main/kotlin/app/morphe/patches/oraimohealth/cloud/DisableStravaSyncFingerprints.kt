package app.morphe.patches.oraimohealth.cloud

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the queryStravaTokenStatus method in LaunchPresenter.
 */
object QueryStravaTokenStatusFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "queryStravaTokenStatus",
    returnType = "V"
)
