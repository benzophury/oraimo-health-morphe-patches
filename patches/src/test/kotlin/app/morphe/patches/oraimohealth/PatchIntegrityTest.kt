package app.morphe.patches.oraimohealth

import app.morphe.patches.oraimohealth.cloud.disableAIConfigPatch
import app.morphe.patches.oraimohealth.cloud.disableCloudDevicePicturesPatch
import app.morphe.patches.oraimohealth.cloud.disableStravaSyncPatch
import app.morphe.patches.oraimohealth.launch.disableSplashPatch
import app.morphe.patches.oraimohealth.manifest.removeInternetPermissionPatch
import app.morphe.patches.oraimohealth.offline.forceLocalGuestModePatch
import app.morphe.patches.oraimohealth.offline.neutralizeCloudUploadPatch
import app.morphe.patches.oraimohealth.shared.COMPATIBILITY_ORAIMO_HEALTH
import app.morphe.patches.oraimohealth.ui.defaultDeviceTabPatch
import app.morphe.patches.oraimohealth.ui.pureDeviceModePatch
import app.morphe.patches.oraimohealth.ui.removeHealthTabPatch
import app.morphe.patches.oraimohealth.ui.removeMineTabPatch
import app.morphe.patches.oraimohealth.ui.removeSportTabPatch
import app.morphe.patches.oraimohealth.ui.removeStoreTabPatch
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * Unit test suite verifying patch definitions, naming, compatibility, and isolation.
 */
class PatchIntegrityTest {

    /**
     * Verifies that all granular patches are uniquely defined and have valid descriptions.
     */
    @Test
    fun testPatchMetadataIntegrity() {
        val allPatches = listOf(
            removeStoreTabPatch,
            removeSportTabPatch,
            removeHealthTabPatch,
            removeMineTabPatch,
            defaultDeviceTabPatch,
            pureDeviceModePatch,
            disableSplashPatch,
            removeInternetPermissionPatch,
            forceLocalGuestModePatch,
            neutralizeCloudUploadPatch,
            disableStravaSyncPatch,
            disableAIConfigPatch,
            disableCloudDevicePicturesPatch
        )

        val uniqueNames = allPatches.map { it.name }.toSet()
        assertEquals(allPatches.size, uniqueNames.size)

        for (patch in allPatches) {
            assertNotNull(patch.name)
            assertNotNull(patch.description)
            assertTrue(patch.name!!.isNotBlank())
            assertTrue(patch.description!!.isNotBlank())
            assertEquals(true, patch.default)
            assertEquals(listOf(COMPATIBILITY_ORAIMO_HEALTH), patch.compatibility)
        }
    }
}
