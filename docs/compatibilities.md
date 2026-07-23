---
icon: lucide/combine
title: Compatibilities
---

This documentation provides compatibility information for all libraries.

!!! info "Version Updates"

    As long as the major version remains the same, updates are safe. For new major versions, this documentation provides a history section below.

## Current Compatibility

**Used Compose Versions**

| Dependency                 | Version  |
|----------------------------|----------|
| Jetbrains Compose          | `1.11.1` |
| Jetbrains Compose Material | `1.9.0`  |

**Libraries**

| Library               | Version | Latest Version | Dependencies                         | Info                                                                                                  |
|-----------------------|-------------|---------|--------------------------------------|-------------------------------------------------------------------------------------------------------|
| **Small Utilities**   |             |         |                                      |                                                                                                       |
| KMPParcelize          | `2.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.kmpparcelize/library?style=flat-square&label=) | --                                   |                                                                                                       |
| KMPPlatformContext    | `2.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.kmpplatformcontext/core?style=flat-square&label=) | --                                   |                                                                                                       |
| KMPMail               | `1.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.kmpmail/library?style=flat-square&label=) | --                                   |                                                                                                       |
| KMPIcon               | `1.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.kmpicon/plugin?style=flat-square&label=) | --                                   |                                                                                                       |
| **Libraries**         |             |         |                                      |                                                                                                       |
| KotPreferences        | `4.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.kotpreferences/core?style=flat-square&label=) | --                                   |                                                                                                       |
| Lumberjack            | `12.x`      | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.lumberjack/core?style=flat-square&label=) | `KMPParcelize`, `KMPPlatformContext` | the `feedback`[^MAIL] and `composeviewer`[^CONTEXT] modules have an additional dependency             |
| **Compose Libraries** |             |         |                                      |                                                                                                       |
| ComposeChangelog      | `4.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.composechangelog/core?style=flat-square&label=) | `KMPParcelize`, `KMPPlatformContext` | the `statesaver-preferences`[^PREFS] module has an additional dependency                              |
| ComposeColors         | `2.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.composecolors/core?style=flat-square&label=) | --                                   |                                                                                                       |
| ComposeDebugDrawer    | `4.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.composedebugdrawer/core?style=flat-square&label=) | `KMPParcelize`, `KMPPlatformContext` | the `plugin-kotpreferences`[^PREFS] and `plugin-lumberjack`[^L] modules have an additional dependency |
| ComposeDialogs        | `4.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.composedialogs/core?style=flat-square&label=) | --                                   | the `dialog-color`[^PARC+COLORS] module has additional dependencies                                   |
| ComposePreferences    | `3.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.composepreferences/core?style=flat-square&label=) | `KMPParcelize`, `ComposeDialogs`     | the `kotpreferences`[^PREFS] module has an additional dependency                                      |
| ComposeThemer         | `2.x`       | ![Latest](https://img.shields.io/maven-central/v/io.github.mflisar.composethemer/core?style=flat-square&label=) | --  |   |     

## Compatibility History

!!! info "Compatibility Releases"

    When updating from an older compatibility release, check the compatibility history below. It identifies libraries that must be updated together due to **binary incompatible changes**.

#### Compatibility Release 1
<small><i>Released on 2026-07-24</i></small>

| Library            | Change            |
|--------------------|-------------------|
| Lumberjack         | `10.x` → `12.x`   |
| ComposeDebugDrawer | `3.x` → `4.x`     |

#### Initial Compatibility Release

??? abstract "View Details"

    Initial documented compatibility baseline.

    **Used Compose Versions**

    | Dependency                 | Version  |
    |----------------------------|----------|
    | Jetbrains Compose          | `1.11.1` |
    | Jetbrains Compose Material | `1.9.0`  |

    **Libraries**

    | Library               | Version |
    |-----------------------|---------|
    | **Small Utilities**   |         |
    | KMPParcelize          | `2.x`   |
    | KMPPlatformContext    | `2.x`   |
    | KMPMail               | `1.x`   |
    | KMPIcon               | `1.x`   |
    | **Libraries**         |         |
    | KotPreferences        | `4.x`   |
    | Lumberjack            | `10.x`  |
    | **Compose Libraries** |         |
    | ComposeChangelog      | `4.x`   |
    | ComposeColors         | `2.x`   |
    | ComposeDebugDrawer    | `3.x`   |
    | ComposeDialogs        | `4.x`   |
    | ComposePreferences    | `3.x`   |
    | ComposeThemer         | `2.x`   |

[^MAIL]: depends on `KMPMail`
[^CONTEXT]: depends on `KMPPlatformContext`
[^PREFS]: depends on `KotPreferences`
[^L]: depends on `Lumberjack`
[^PARC+COLORS]: depends on `KMPParcelize` and `ComposeColors`
