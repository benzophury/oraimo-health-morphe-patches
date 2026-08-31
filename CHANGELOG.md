## [1.2.1](https://github.com/benzophury/oraimo-health-morphe-patches/compare/v1.2.0...v1.2.1) (2026-08-31)

### 🐛 Bug Fixes

* **launch:** correct onGetLaunchAd parameter type to RecommendEntity ([280f9d4](https://github.com/benzophury/oraimo-health-morphe-patches/commit/280f9d4e0f94d86a63c0e75553e345a5d9ca3e04))

## [1.2.0](https://github.com/benzophury/oraimo-health-morphe-patches/compare/v1.1.1...v1.2.0) (2026-08-31)

### 🐛 Bug Fixes

* **ci:** add PATCHES_START/PATCHES_END markers to README for generate_patches_readme.py ([f5df5c8](https://github.com/benzophury/oraimo-health-morphe-patches/commit/f5df5c860f0bf57f9acb4f7372e29e1bb343f763))
* **ci:** correct README marker from [EXPANDED] to EXPANDED to match generate_patches_readme.py regex ([9638dcd](https://github.com/benzophury/oraimo-health-morphe-patches/commit/9638dcdc5ea042e83996092862a6899b42f41fb3))
* **manifest:** use document() API instead of xmlEditor for RemoveInternetPermissionPatch ([19310e0](https://github.com/benzophury/oraimo-health-morphe-patches/commit/19310e066c27e71b6c44e19f1e3c3dd16191745f))
* **test:** add kotlin-test dependency so PatchIntegrityTest compiles ([681cbbf](https://github.com/benzophury/oraimo-health-morphe-patches/commit/681cbbf915ee3ac47bcfd04fa147f33dec7f189b))

### ✨ New Features

* **patches:** decompose into granular single-responsibility offline patches ([af81d36](https://github.com/benzophury/oraimo-health-morphe-patches/commit/af81d3644209338b4455819784c49526c65bac9c))
* **ui:** add Pure Device Mode and granular navigation tab patches ([5bf2ff8](https://github.com/benzophury/oraimo-health-morphe-patches/commit/5bf2ff873b32a2511848df9300323d6efac9ae04))
* **ui:** merge Pure Device Mode into main ([ea76223](https://github.com/benzophury/oraimo-health-morphe-patches/commit/ea762234e2a6d001113912953102992ed8883eee))

## [1.1.1](https://github.com/benzophury/oraimo-health-morphe-patches/compare/v1.1.0...v1.1.1) (2026-08-29)

### 🐛 Bug Fixes

* **ci:** remove dev backmerge plugin from semantic release ([e5614d7](https://github.com/benzophury/oraimo-health-morphe-patches/commit/e5614d7dbb30d209f38b9fb7a9d755eab9a29c7f))

## [1.1.0](https://github.com/benzophury/oraimo-health-morphe-patches/compare/v1.0.0...v1.1.0) (2026-08-29)

### 🐛 Bug Fixes

* **offline:** IsLogin returns true & initialise DB in guest mode ([780b6d1](https://github.com/benzophury/oraimo-health-morphe-patches/commit/780b6d14ab648c22792eb846b0d3911fe0e51905))

### ✨ New Features

* keep NeutralizeCloudUploadPatch unchanged ([fa74cdd](https://github.com/benzophury/oraimo-health-morphe-patches/commit/fa74cddd44d6f03c1ff140fd489767ce228dbe66))

## 1.0.0 (2026-08-29)

### ✨ New Features

* initial offline and privacy patches for Oraimo Health ([2e64bd3](https://github.com/benzophury/oraimo-health-morphe-patches/commit/2e64bd3d75261c2a07ee01c0e7a7e61b562229dc))
