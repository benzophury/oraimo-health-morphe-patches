package app.morphe.patches.oraimohealth.manifest

import app.morphe.patcher.patch.resourcePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH
import org.w3c.dom.Node

/**
 * Patch that strips internet and network state permissions from AndroidManifest.xml.
 */
@Suppress("unused")
val removeInternetPermissionPatch = resourcePatch(
    name = "Remove Internet Permission",
    description = "Strips internet, network state, and WiFi permissions from AndroidManifest.xml to enforce complete offline confinement.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        val disallowedPermissions = setOf(
            "android.permission.INTERNET",
            "android.permission.ACCESS_NETWORK_STATE",
            "android.permission.ACCESS_WIFI_STATE",
            "android.permission.CHANGE_WIFI_STATE"
        )

        document("AndroidManifest.xml").use { document ->
            val nodesToRemove = mutableListOf<Node>()
            val permissionNodes = document.getElementsByTagName("uses-permission")
            for (i in 0 until permissionNodes.length) {
                val node = permissionNodes.item(i)
                val nameAttr = node.attributes?.getNamedItem("android:name")?.nodeValue
                if (nameAttr in disallowedPermissions) {
                    nodesToRemove.add(node)
                }
            }
            for (node in nodesToRemove) {
                node.parentNode?.removeChild(node)
            }
        }
    }
}
