package app.morphe.patches.oraimohealth.cloud

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the queryAIConferenceConfig method in LaunchPresenter.
 */
object QueryAIConferenceConfigFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "queryAIConferenceConfig",
    returnType = "V"
)
