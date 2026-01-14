package classes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import utils.MarkdownUtil

@Serializable
data class ProjectItem(
    val name: String,
    val description: String,
    val image: String? = null,
    @SerialName("main-maven-id") val mainMavenId: String,
) {
    fun markdownTableCellImage(defaultImage: String): String {
        val img = image ?: defaultImage
        return "![image]($img)"
    }

    fun markdownTableCellLibrary(): String {
        val repoUrl = "https://github.com/MFlisar/$name"
        return "[$name]($repoUrl)"
    }

    fun markdownTableCellDescription() : String {
        //val desc = MarkdownUtil.convertMarkdownToHtml(description)
        val imageUrl = "https://img.shields.io/maven-central/v/$mainMavenId?label=&style=for-the-badge&labelColor=444444&color=grey"
        val image = "![maven version]($imageUrl)"
        return "$description<br>$image"
    }
}