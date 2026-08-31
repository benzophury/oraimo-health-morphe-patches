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

<!-- PATCHES_START EXPANDED -->
<!-- PATCHES_END -->

## Building Locally

- Run `./gradlew buildAndroid`
- Built patch archive is produced in `patches/build/libs/patches-*.mpp`
- Apply the `.mpp` patch archive using Morphe-Desktop or Morphe Manager.

## License

GNU General Public License v3.0
