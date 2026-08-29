package app.morphe.patches.oraimohealth.offline

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the `isLogin` method in LaunchPresenter.
 */
object IsLoginFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "isLogin",
    returnType = "Z"
)

/**
 * Fingerprint matching the `isInGuestMode` method in LaunchPresenter.
 */
object IsInGuestModeFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "isInGuestMode",
    returnType = "Z"
)

/**
 * Fingerprint matching the `needSetUserInfo` method in LaunchPresenter.
 */
object NeedSetUserInfoFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "needSetUserInfo",
    returnType = "Z"
)

/**
 * Fingerprint matching the `needSetGoal` method in LaunchPresenter.
 */
object NeedSetGoalFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "needSetGoal",
    returnType = "Z"
)

/**
 * Fingerprint matching the `refreshToken` method in LaunchPresenter.
 */
object RefreshTokenFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "refreshToken",
    returnType = "V"
)
