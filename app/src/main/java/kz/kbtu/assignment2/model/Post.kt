package kz.kbtu.assignment2.model

data class Post(
    val username: String,
    val profileImage: Int,
    val postImage: Int,
    val caption: String,
    var likes: Int,     // Number of likes
    var liked: Boolean = false  // Whether the post is liked
)

