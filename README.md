# Oraimo Health Offline Morphe Patches

Privacy-preserving offline patches for the Oraimo Health companion Android app (`com.transsion.oraimohealth`).

## About

This patch bundle converts the Oraimo Health app into a 100% local, offline utility:
- **Forced Local Offline Mode**: Bypasses cloud authentication and routes startup directly to the main interface without requiring Transsion SSO accounts.
- **Neutralize Cloud Telemetry & Uploads**: Stubs out `DataUploadService` and marks the internal network utility offline to prevent cloud metric collection.
- **Preserve Watch Remote Functions**: Keeps all notification forwarding, Bluetooth calling, contact syncing, and background BLE keep-alive services fully operational.
- **Preserve Local DIY Watchfaces**: Keeps custom photo/PNG watch face generation and Bluetooth transfer fully functional without remote dependencies.
- **Disable Cloud Ads & External Queries**: Stubs launch ads, AI conference queries, and Strava cloud synchronization.

### How to use these patches in Morphe Manager

Add this custom source in Morphe Manager (Settings > Sources):
`benzophury/oraimo-health-morphe-patches`

Direct Link: `https://morphe.software/add-source?github=benzophury/oraimo-health-morphe-patches`

## 🩹 Patches list

<!-- PATCHES_START EXPANDED -->
> **[v1.1.0](https://github.com/benzophury/oraimo-health-morphe-patches/releases/tag/v1.1.0)**&nbsp;&nbsp;•&nbsp;&nbsp;`main`&nbsp;&nbsp;•&nbsp;&nbsp;4 patches total
<details open>
<summary>📦 oraimo health&nbsp;&nbsp;•&nbsp;&nbsp;4 patches</summary>
<br>

**🎯 Supported versions:**

| 2.0.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable Cloud Ads & External Queries](#disable-cloud-ads-external-queries) | Stubs remote launch advertising, AI config queries, and Strava cloud synchronization while keeping local DIY watchface intact. |  |
| [Force Local Offline Mode](#force-local-offline-mode) | Initialises an offline guest profile, registers the user ID, and creates local SQLite tables before routing to the main view. |  |
| [Neutralize Cloud Telemetry & Uploads](#neutralize-cloud-telemetry-uploads) | Stubs out background data upload service to prevent cloud metric collection. |  |
| [Remove Store Tab](#remove-store-tab) | Completely removes the Store/Mall tab from the bottom navigation bar and disables store catalog requests. |  |

</details>

<!-- PATCHES_END -->

### 🛠️ Building locally

- Run `./gradlew buildAndroid`
- The built patches .mpp file is found in `patches/build/libs/patches-*.mpp`
- Patch the mpp file using [Morphe-Desktop](https://github.com/MorpheApp/morphe-desktop)
  like any other patch bundle.

See the [Morphe documentation](https://github.com/MorpheApp/morphe-documentation) for more information.

## 📜 License

UserXYZ Patches are licensed under the [GNU General Public License v3.0](LICENSE)
