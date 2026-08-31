# Oraimo Health Offline Morphe Patches

Privacy-preserving offline patches for the Oraimo Health companion Android app (`com.transsion.oraimohealth`).

## About

This patch suite converts the Oraimo Health application into a fully isolated, offline utility through granular, single-responsibility patches:

- **Remove Store Tab**: Strips the Mall/Store tab from the bottom navigation bar and disables catalog requests.
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
| Remove Store Tab | UI | Completely removes the Store/Mall tab from the bottom navigation bar and disables store catalog requests. |
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
