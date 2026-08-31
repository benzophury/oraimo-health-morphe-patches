# Oraimo Health Offline Morphe Patches

Privacy-preserving offline patches for the Oraimo Health companion Android app (`com.transsion.oraimohealth`).

## About

This patch suite converts the Oraimo Health application into a clean, dedicated, offline Device Manager while strictly preserving the entire Bluetooth Low Energy (BLE) peripheral binding and synchronization stack.

### Key Highlights

- **Pure Device Mode (Unified Core)**: All-in-one patch that streamlines the app directly into a dedicated single-tab Device interface, skips startup ad delays, auto-provisions local guest profiles and SQLite tables, and safely neutralizes cloud telemetry.
- **Bluetooth Stack Preservation**: Full BLE GATT connectivity, device pairing handshake (`MoyConnectBindManagement`), notification filtering, alarm management, and local DIY watchface streaming operate with 100% stability.
- **Granular Navigation Options**: Individual toggles for hiding or showing specific tabs (Sports, Health, Mall, Mine) according to user preference.
- **Air-Gapped Isolation Support**: Optional manifest-level permission stripping for complete sandbox containment when paired with the offline stubs.

---

## Recommended Patch Profiles

### 1. Minimal / Standard Profile (Recommended)
Select **Pure Device Mode** (default enabled).
- Directly boots into the Device management interface.
- Bypasses launch ads and cloud login requirements.
- Keeps Android OS permissions intact to eliminate any risk of system security exceptions.

### 2. Air-Gapped Sandbox Profile
Select **Pure Device Mode** + **Remove Internet Permission**.
- Revokes `INTERNET`, `ACCESS_NETWORK_STATE`, and `ACCESS_WIFI_STATE` at the OS level for complete network isolation.
- Fully protected by the offline stubs to ensure stable execution.

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
