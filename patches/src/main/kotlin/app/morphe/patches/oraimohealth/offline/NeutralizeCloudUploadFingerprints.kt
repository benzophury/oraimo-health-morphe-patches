package app.morphe.patches.oraimohealth.offline

import app.morphe.patcher.Fingerprint

/**
 * Fingerprint matching the `onHandleWork` method in DataUploadService.
 */
object DataUploadOnHandleWorkFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/service/DataUploadService;",
    name = "onHandleWork",
    returnType = "V",
    parameters = listOf("Landroid/content/Intent;")
)

/**
 * Fingerprint matching the `enqueueWork(Context, Intent)` method in DataUploadService.
 */
object DataUploadEnqueueWorkFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/service/DataUploadService;",
    name = "enqueueWork",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;", "Landroid/content/Intent;")
)

/**
 * Fingerprint matching the `enqueueWork(Context)` method in DataUploadService.
 */
object DataUploadEnqueueWorkContextFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/oraimohealth/service/DataUploadService;",
    name = "enqueueWork",
    returnType = "V",
    parameters = listOf("Landroid/content/Context;")
)

/**
 * Fingerprint matching the `isConnected` method in NetworkUtil.
 */
object NetworkUtilIsConnectedFingerprint : Fingerprint(
    definingClass = "Lcom/transsion/net/utils/NetworkUtil;",
    name = "isConnected",
    returnType = "Z",
    parameters = listOf("Landroid/content/Context;")
)
