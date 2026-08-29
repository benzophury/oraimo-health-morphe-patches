package app.morphe.patches.oraimohealth.ui

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the `isShowMall` method in SPManager.
 */
object IsShowMallFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/utils/SPManager;",
    name = "isShowMall",
    returnType = "Z"
)

/**
 * Fingerprint matching the `requestMallInfoList` method in MainPresenter.
 */
object RequestMallInfoListFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/main/MainPresenter;",
    name = "requestMallInfoList",
    returnType = "V"
)
