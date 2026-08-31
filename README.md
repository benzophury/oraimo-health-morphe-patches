# Oraimo Health Offline Morphe Patches

Privacy-preserving offline patch for the Oraimo Health companion Android app (`com.transsion.oraimohealth`).

## About

This patch converts the Oraimo Health application into a clean, dedicated, offline Device Manager while strictly preserving the entire Bluetooth Low Energy (BLE) peripheral binding and synchronization stack.

### Key Highlights

- **Pure Device Mode (Unified Core)**: All-in-one patch that streamlines the app directly into a dedicated single-tab Device interface, skips startup ad delays, auto-provisions local guest profiles and SQLite tables, and safely neutralizes cloud telemetry.
- **Bluetooth Stack Preservation**: Full BLE GATT connectivity, device pairing handshake (`MoyConnectBindManagement`), notification filtering, alarm management, and local DIY watchface streaming operate with 100% stability.
- **Crash Prevention**: All network checks safely report offline status at line 0 without invoking system `ConnectivityManager`, preventing Android OS permission and verification crashes.

---

## Patches List

<!-- PATCHES_START EXPANDED -->
> **[v1.5.0](https://github.com/benzophury/oraimo-health-morphe-patches/releases/tag/v1.5.0)**&nbsp;&nbsp;•&nbsp;&nbsp;`main`&nbsp;&nbsp;•&nbsp;&nbsp;1 patches total
<details open>
<summary>📦 oraimo health&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Pure Device Mode](#pure-device-mode) | Converts the app into a dedicated offline Device Manager: boots directly into the Device tab, bypasses startup ads, provisions guest profile and database bindings, and safely neutralizes cloud telemetry. |  |

</details>

<!-- PATCHES_END -->

---

## Building Locally

- Run `./gradlew :patches:buildAndroid`
- Built patch archive is produced in `patches/build/libs/patches-*.mpp`
- Apply the `.mpp` patch archive using Morphe-Desktop, Morphe CLI, or Morphe Manager.

---

## License

GNU General Public License v3.0
