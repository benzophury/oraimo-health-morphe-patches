package app.morphe.patches.oraimohealth.manifest

import app.morphe.patcher.patch.resourcePatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH
import org.w3c.dom.Element

/**
 * Resource patch that strips internet and network connectivity permissions from AndroidManifest.xml.
 */
@Suppress("unused")
val airGapManifestPatch = resourcePatch(
    name = "Air-Gap Manifest",
    description = "Strips INTERNET, ACCESS_NETWORK_STATE, and Wi-Fi permissions from AndroidManifest.xml for sandbox isolation.",
    default = true
) {
    compatibleWith(COMPATIBILITY_ORAIMO_HEALTH)

    execute {
        document("AndroidManifest.xml").use { doc ->
            val permissionsToRemove = setOf(
                "android.permission.INTERNET",
                "android.permission.ACCESS_NETWORK_STATE",
                "android.permission.ACCESS_WIFI_STATE",
                "android.permission.CHANGE_WIFI_STATE"
            )

            val root = doc.documentElement
            val permissionNodes = doc.getElementsByTagName("uses-permission")
            val toRemove = mutableListOf<Element>()

            for (i in 0 until permissionNodes.length) {
                val node = permissionNodes.item(i) as? Element ?: continue
                val permissionName = node.getAttribute("android:name")
                if (permissionName in permissionsToRemove) {
                    toRemove.add(node)
                }
            }

            for (node in toRemove) {
                root.removeChild(node)
            }
        }
    }
}
