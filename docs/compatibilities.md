---
icon: lucide/combine
title: Compatibility
---

Here you see the first documentation about the compatibility of the libraries. I will update this documentation when necessary.

The below defined compatible versions are all based on following compose versions:

| Dependency                 | Version  |
|----------------------------|----------|
| Jetbrains Compose          | `1.11.1` |
| Jetbrains Compose Material | `1.9.0`  |

You can be sure that it is safe to update library versions if newer versions exist as long as the major version number is the same.

If a new major version of any library is needed, I will update this documentation.

## Small Utilities

!!! note

    Utilities do not depend on any compose version!
    It's safe to update them even when their major number has changed.

| Library            | Version | Info                                         |
|--------------------|---------|----------------------------------------------|
| KMPParcelize       | `2.0.0` | **independent** of any of my other libraries |
| KMPPlatformContext | `2.0.0` | **independent** of any of my other libraries |
| KMPMail            | `1.0.0` | **independent** of any of my other libraries |
| KMPIcon            | `1.0.0` | **independent** of any of my other libraries |

## Libraries

!!! note

    Following libraries are no composable libraries but may contain a composable module.

| Library        | Version  | Info                                         |
|----------------|----------|----------------------------------------------|
| KotPreferences | `4.0.0`  | **independent** of any of my other libraries |
| Lumberjack     | `10.0.0` | **depends on** KMPParcelize *(1)*            |

`Some lumberjack modules do have additional dependencies`

:    `feedback` module... depends on `KMPMail` - the mail library is needed to send the feedback mails
     `composeviewer` module... depends on `KMPPlatformContext` - the context is needed for the copy to clipboard functionality

## Compose Libraries

!!! note

    Following libraries are composable libraries and do depend on the compose version.
    Usually it's safe to update compose version to newer versions but following libraries are using the above mentioned compose versions.

| Library            | Version | Info |
|--------------------|---------|------|
| ComposeChangelog   | `...`   | ...  |
| ComposeColors      | `...`   | ...  |
| ComposeDebugDrawer | `...`   | ...  |
| ComposeDialogs     | `...`   | ...  |
| ComposePreferences | `...`   | ...  |
| ComposeThemer      | `...`   | ...  |
