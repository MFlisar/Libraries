---
icon: lucide/combine
title: Compatibility
---

## Overview

This documentation shows the compatibility of all libraries with the following base versions:

| Dependency                 | Version  |
|----------------------------|----------|
| Jetbrains Compose          | `1.11.1` |
| Jetbrains Compose Material | `1.9.0`  |

**Version Updates:** As long as the major version remains the same, updates are safe. For new major versions, this documentation will be updated.

### Categories

- **Small Utilities** — Independent of Compose versions, always safe to update
- **Libraries** — Base libraries (some with Compose modules)
- **Compose Libraries** — Directly bound to Compose versions

## Small Utilities

!!! note

    Utilities do not depend on any compose version!
    It's safe to update them even when their major number has changed.

| Library            | Version | Dependencies |
|--------------------|---------|--------------|
| KMPParcelize       | `2.0.0` | --           | 
| KMPPlatformContext | `2.0.0` | --           |
| KMPMail            | `1.0.0` | --           |
| KMPIcon            | `1.0.0` | --           |

## Libraries

!!! note

    Following libraries are no composable libraries but may contain a composable module.

| Library        | Version  | Dependencies   | Info                                                                             |
|----------------|----------|----------------|----------------------------------------------------------------------------------|
| KotPreferences | `4.0.0`  | --             |                                                                                  |
| Lumberjack     | `10.0.0` | `KMPParcelize` | the `feedback`[^1] and `composeviewer`[^2] modules have an additional dependency |    

[^1]: depends on `KMPMail`
[^2]: depends on `KMPPlatformContext`

## Compose Libraries

!!! note

    Following libraries are composable libraries and do depend on the compose version.
    Usually it's safe to update the compose version to a newer versions but following libraries are using the above mentioned compose versions.


| Library            | Version | Dependencies                         | Info                                                                                              |
|--------------------|---------|--------------------------------------|---------------------------------------------------------------------------------------------------|
| ComposeChangelog   | `4.0.0` | `KMPParcelize`, `KMPPlatformContext` | the `statesaver-preferences`[^3] module has an additional dependency                              |
| ComposeColors      | `2.0.0` | --                                   |                                                                                                   |
| ComposeDebugDrawer | `3.0.0` | `KMPParcelize`, `KMPPlatformContext` | the `plugin-kotpreferences`[^4] and `plugin-lumberjack`[^5] modules have an additional dependency |
| ComposeDialogs     | `4.0.0` | --                                   | the `dialog-color`[^6] module has additional dependencies                                         |
| ComposePreferences | `3.0.0` | `KMPParcelize`, `ComposeDialogs`     | the `kotpreferences`[^7] module has an additional dependency                                      |
| ComposeThemer      | `2.0.0` | --                                   |                                                                                                   |

[^3]: depends on `KotPreferences`
[^4]: depends on `KotPreferences`
[^5]: depends on `Lumberjack`
[^6]: depends on `KMPParcelize` and `ComposeColors`
[^7]: depends on `KotPreferences`