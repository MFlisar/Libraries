import classes.ProjectGroup
import classes.ProjectItem
import classes.Projects
import kotlinx.serialization.json.Json
import utils.MarkdownUtil
import java.io.File
import java.lang.System

fun main() {

    val root = File(System.getProperty("user.dir")).parentFile

    // -----------------
    // Config
    // -----------------

    val pathProjectsJson = "data/projects.json"
    val pathPersonalProjectsJson = "data/personal.json"

    val pathFolderProjects = "docs/libraries/"
    val pathFolderPersonalProjects = "docs/personal/"

    val pathZensicalToml = "zensical.toml"

    // -----------------
    // 1) Files erstellen
    // -----------------

    val fileProjectsJson = File(root, pathProjectsJson)
    val filePersonalProjectsJson = File(root, pathPersonalProjectsJson)

    val fileZensical = File(root, pathZensicalToml)

    val folderLibraries = File(root, pathFolderProjects)
    val folderPersonalLibraries = File(root, pathFolderPersonalProjects)

    // -----------------
    // 2) Ordner leeren (alle md-Dateien löschen)
    // -----------------

    listOf(folderLibraries, folderPersonalLibraries).forEach { folder ->
        if (folder.exists()) {
            folder.listFiles { f -> f.extension == "md" }?.forEach { it.delete() }
        }
    }

    // -----------------
    // 3) Daten einlesen
    // -----------------

    val projects = readProjects(fileProjectsJson)
    val personalProjects = readPersonalProjects(filePersonalProjectsJson)

    // -----------------
    // 4) md-Dateien erstellen
    // -----------------

    for (projectGroup in projects.projects) {
        val items = projectGroup.items
        val fileNameFromGroup = projectGroup.fileNameFromGroup
        writeMarkdownFile(
            title = projectGroup.group,
            items = items,
            folder = folderLibraries,
            fileName = fileNameFromGroup
        )
    }

    writeMarkdownFile(
        title = "Personal Libraries",
        items = personalProjects,
        folder = folderPersonalLibraries,
        fileName = "libraries"
    )

    // -----------------
    // 5) update navigation in zensical
    // -----------------

    val navInset =      "        "
    val navStartTag =   "        # BEGIN-NAV-LIBRARIES"
    val navEndTag =     "        # END-NAV-LIBRARIES"
    val zensicalContent = fileZensical.readText(Charsets.UTF_8)
    val newNavigation = buildString {
        append("$navStartTag\n")
        for (projectGroup in projects.projects) {
            val group = projectGroup.group
            val fileNameFromGroup = projectGroup.fileNameFromGroup
            append("$navInset{ \"$group\" = \"libraries/$fileNameFromGroup.md\" },\n")
        }
        append(navEndTag)
    }

    val updatedZensicalContent = zensicalContent.replace(
        Regex("(?s)$navStartTag.*?$navEndTag"),
        newNavigation
    )
    fileZensical.writeText(updatedZensicalContent, Charsets.UTF_8)

    println("Docs generated.")
}

// -----------------
// Funktionen
// -----------------

private fun readProjects(file: File): Projects {
    val jsonContent = file.readText(Charsets.UTF_8)
    val projects = Json.decodeFromString<Projects>(jsonContent)
    return projects
}

private fun readPersonalProjects(file: File): List<ProjectItem> {
    val jsonContent = file.readText(Charsets.UTF_8)
    val projects = Json.decodeFromString<List<ProjectItem>>(jsonContent)
    return projects
}

private fun writeMarkdownFile(
    title: String,
    items: List<ProjectItem>,
    folder: File,
    fileName: String
) {
    val defaultImagePath = "../media/kotlin-icon.png"

    val pageHeader = """
            ---
            icon: lucide/blocks
            title: $title
            ---

        """.trimIndent()

    val tableHeaders = listOf("Image", "Library", "Description")
    val table = MarkdownUtil.buildTable(
        headers = tableHeaders,
        items = items
    ) { item: ProjectItem ->
        listOf(
            item.markdownTableCellImage(defaultImagePath) + "{: style=\"max-width:100%;height:auto;\"}",
            item.markdownTableCellLibrary(),
            item.markdownTableCellDescription()
        )
    }

    // baue Inhalt der Datei
    val content = buildString {
        append(pageHeader)
        appendLine()
        append(table)
        append("{: style=\"table-layout:fixed;width:100%;\"}")
    }

    // schreibe Datei
    val file = File(folder, "$fileName.md")
    file.writeText(content, Charsets.UTF_8)
}
