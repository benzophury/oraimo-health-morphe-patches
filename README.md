# Oraimo Health Offline Morphe Patches

Privacy-preserving offline patches for the Oraimo Health companion Android app (`com.transsion.oraimohealth`).

## About

This patch suite converts the Oraimo Health application into a fully isolated, offline utility through granular, single-responsibility patches:

- **Pure Device Mode**: Strips extraneous health, sport, and profile tabs to present a clean, dedicated Device management interface while preserving the Bluetooth binding stack.
- **Default to Device Tab**: Automatically boots directly into the Device management tab on launch.
- **Remove Store Tab**: Strips the Mall/Store tab from the bottom navigation bar and disables catalog requests.
- **Remove Sport Tab**: Hides the GPS sports and workout tracking tab from navigation.
- **Remove Health Tab**: Hides the health metrics dashboard tab from navigation.
- **Remove Mine Tab**: Hides the user profile and account tab from navigation.
- **Disable Splash & Launch Ads**: Bypasses launch ad downloads and splash countdowns for instant application startup.
- **Remove Internet Permission**: Removes internet, WiFi, and network state permissions from `AndroidManifest.xml`.
- **Force Local Offline Mode**: Auto-provisions guest profiles and binds local SQLite databases to bypass cloud authentication.
- **Neutralize Cloud Telemetry & Uploads**: Stubs out background data upload workers and forces offline network status.
- **Disable Strava Cloud Sync**: Stubs out external Strava token status queries.
- **Disable AI Config Queries**: Stubs out remote AI conference and backend configuration queries.
- **Disable Remote Device Pictures**: Stubs out dynamic device picture and thumbnail queries.

## Patches List

Target application: `com.transsion.oraimohealth` (version 2.0.4)

| Patch | Category | Description |
|---|---|---|
| Pure Device Mode | UI | Forces the Device management tab as the dedicated single view and hides all extraneous health, sport, and profile tabs. |
| Default to Device Tab | UI | Sets the Device management tab as the initial active page upon opening the application. |
| Remove Store Tab | UI | Completely removes the Store/Mall tab from the bottom navigation bar and disables store catalog requests. |
| Remove Sport Tab | UI | Hides the GPS sports and workout tracking tab from the bottom navigation bar. |
| Remove Health Tab | UI | Hides the Health metrics dashboard tab from the bottom navigation bar. |
| Remove Mine Tab | UI | Hides the User Profile and Account tab from the bottom navigation bar. |
| Disable Splash & Launch Ads | Launch | Stubs out launch ad requests and ad presentation callbacks to provide an instant startup experience. |
| Remove Internet Permission | Manifest | Strips internet, network state, and WiFi permissions from AndroidManifest.xml to enforce complete offline confinement. |
| Force Local Offline Mode | Offline | Initialises an offline guest profile, registers the user ID, and creates local SQLite tables before routing to the main view. |
| Neutralize Cloud Telemetry & Uploads | Offline | Stubs out background data upload service and forces network utility to report offline state. |
| Disable Strava Cloud Sync | Cloud | Stubs out Strava token status queries to eliminate cloud sync overhead. |
| Disable AI Config Queries | Cloud | Stubs out AI conference and backend configuration queries to prevent remote telemetry checks. |
| Disable Remote Device Pictures | Cloud | Stubs out remote device picture and thumbnail downloads on launch. |

## Building Locally

- Run `./gradlew buildAndroid`
- Built patch archive is produced in `patches/build/libs/patches-*.mpp`
- Apply the `.mpp` patch archive using Morphe-Desktop or Morphe Manager.

## License

GNU General Public License v3.0
