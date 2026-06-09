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
- 
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

| Library        | Version  | Dependencies                              | Info                                                                                                                                                                                                                                                                   |
|----------------|----------|-------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| KotPreferences | `4.0.0`  | --                                        |                                                                                                                                                                                                                                                                        |
| Lumberjack     | `10.0.0` | `KMPParcelize` | the `feedback`{ title="depends on `KMPMail` - the mail library is needed to send the feedback mails" } and `composeviewer`{ title="depends on `KMPPlatformContext` - the context is needed for the copy to clipboard functionality" } module have an additional dependency |    

## Compose Libraries

!!! note

    Following libraries are composable libraries and do depend on the compose version.
    Usually it's safe to update the compose version to a newer versions but following libraries are using the above mentioned compose versions.

| Library            | Version | Dependencies                          | Info                                                                                                                                                            |
|--------------------|---------|---------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ComposeChangelog   | `4.0.0` | `KMPParcelize`, `KMPPlatformContext` | the `statesaver-preferences`{ title="depends on `KotPreferences`"} module has an additional dependency                                                            |
| ComposeColors      | `2.0.0` | --                                    |                                                                                                                                                                 |
| ComposeDebugDrawer | `3.0.0` | `KMPParcelize`, `KMPPlatformContext` | the `plugin-kotpreferences`{ title="depends on `KotPreferences`" } and `plugin-lumberjack`{ title="depends on `Lumberjack`" } modules have an additional dependency |
| ComposeDialogs     | `4.0.0` | --                                    | the `dialog-color`{ title="depends on `KMPParcelize` and `ComposeColors`"} module has additional dependencies                                                       |
| ComposePreferences | `3.0.0` | `KMPParcelize`, `ComposeDialogs`      | the `kotpreferences`{ title="depends on `KotPreferences`" } module has an additional dependency                                                                   |
| ComposeThemer      | `2.0.0` | --                                    |                                                                                                                                                                 |
