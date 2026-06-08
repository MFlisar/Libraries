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

| Library            | Version | Dependencies |
|--------------------|---------|--------------|
| KMPParcelize       | `2.0.0` | --           | 
| KMPPlatformContext | `2.0.0` | --           |
| KMPMail            | `1.0.0` | --           |
| KMPIcon            | `1.0.0` | --           |

## Libraries

!!! note

    Following libraries are no composable libraries but may contain a composable module.

| Library        | Version  | Dependencies | Info                                                                                                                                                                                                                                                                     |
|----------------|----------|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| KotPreferences | `4.0.0`  | --           |                                                                                                                                                                                                                                                                          |
| Lumberjack     | `10.0.0` | KMPParcelize | the `feedback`{ title="depends on KMPMail - the mail library is needed to send the feedback mails" } and `composeviewer`{ title = "depends on KMPPlatformContext - the context is needed for the copy to clipboard functionality" } module have an additional dependency |    

## Compose Libraries

!!! note

    Following libraries are composable libraries and do depend on the compose version.
    Usually it's safe to update the compose version to a newer versions but following libraries are using the above mentioned compose versions.

| Library            | Version | Dependencies                     | Info                                                                                                                                                               |
|--------------------|---------|----------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ComposeChangelog   | `4.0.0` | KMPParcelize, KMPPlatformContext | the `statesaver-preferences`{ title = "depends on KotPreferences"} module has an additional dependency                                                             |
| ComposeColors      | `2.0.0` | --                               |                                                                                                                                                                    |
| ComposeDebugDrawer | `3.0.0` | KMPParcelize, KMPPlatformContext | the `plugin-kotpreferences`{ title = "depends on KotPreferences" } and `plugin-lumberjack`{ title = "depends on Lumberjack" } modules have additional dependencies |
| ComposeDialogs     | `4.0.0` | --                               | the `dialog-color`{ title = "depends on KMPParcelize and ComposeColors"} module depends on additional dependencies                                                 |
| ComposePreferences | `...`   | --                               | ...                                                                                                                                                                |
| ComposeThemer      | `2.0.0` | --                               | **independent** of any of my other libraries                                                                                                                       |
