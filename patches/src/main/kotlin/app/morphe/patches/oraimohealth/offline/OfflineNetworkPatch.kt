package app.morphe.patches.oraimohealth.offline

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH

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
 * Bytecode patch that forces NetworkUtil.isConnected() to return false.
 */
@Suppress("unused")
val offlineNetworkPatch = bytecodePatch(
    name = "Offline Network Mode",
    description = "Forces NetworkUtil.isConnected() to return false, making the app believe the phone has no internet.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        NetworkUtilIsConnectedFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x0
                return v0
            """
        )
    }
}
