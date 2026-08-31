package app.morphe.patches.oraimohealth

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

/**
 * Fingerprint matching the isLogin method in LaunchPresenter.
 */
object IsLoginFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "isLogin",
    returnType = "Z"
)

/**
 * Fingerprint matching the isInGuestMode method in LaunchPresenter.
 */
object IsInGuestModeFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "isInGuestMode",
    returnType = "Z"
)

/**
 * Fingerprint matching the needSetUserInfo method in LaunchPresenter.
 */
object NeedSetUserInfoFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "needSetUserInfo",
    returnType = "Z"
)

/**
 * Fingerprint matching the needSetGoal method in LaunchPresenter.
 */
object NeedSetGoalFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "needSetGoal",
    returnType = "Z"
)

/**
 * Fingerprint matching the refreshToken method in LaunchPresenter.
 */
object RefreshTokenFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "refreshToken",
    returnType = "V"
)

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
    parameters = listOf("Lcom/transsion/data/model/entity/RecommendEntity;")
)

/**
 * Fingerprint matching the queryAIConferenceConfig method in LaunchPresenter.
 */
object QueryAIConferenceConfigFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "queryAIConferenceConfig",
    returnType = "V"
)

/**
 * Fingerprint matching the queryStravaTokenStatus method in LaunchPresenter.
 */
object QueryStravaTokenStatusFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "queryStravaTokenStatus",
    returnType = "V"
)

/**
 * Fingerprint matching the requestDevicePictures method in LaunchPresenter.
 */
object RequestDevicePicturesFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/launch/LaunchPresenter;",
    name = "requestDevicePictures",
    returnType = "V"
)

/**
 * Fingerprint matching the onHandleWork method in DataUploadService.
 */
object DataUploadOnHandleWorkFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/service/DataUploadService;",
    name = "onHandleWork",
    returnType = "V",
    parameters = listOf("Landroid/content/Intent;")
)

/**
 * Fingerprint matching the enqueueWork(Context, Intent) method in DataUploadService.
 */
object DataUploadEnqueueWorkFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/service/DataUploadService;",
    name = "enqueueWork",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;", "Landroid/content/Intent;")
)

/**
 * Fingerprint matching the enqueueWork(Context) method in DataUploadService.
 */
object DataUploadEnqueueWorkContextFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/service/DataUploadService;",
    name = "enqueueWork",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;")
)

/**
 * Fingerprint matching the isConnected method in NetworkUtil.
 */
object NetworkUtilIsConnectedFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/net/utils/NetworkUtil;",
    name = "isConnected",
    returnType = "Z",
    parameters = listOf("Landroid/content/Context;")
)

/**
 * Fingerprint matching the isShowMall method in SPManager.
 */
object IsShowMallFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/utils/SPManager;",
    name = "isShowMall",
    returnType = "Z"
)

/**
 * Fingerprint matching the requestMallInfoList method in MainPresenter.
 */
object RequestMallInfoListFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/module/main/MainPresenter;",
    name = "requestMallInfoList",
    returnType = "V"
)
