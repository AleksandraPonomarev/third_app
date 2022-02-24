object WallService {
    val service = mutableListOf<Post>()
    fun add(post: Post): Post {
        val size = service.size
        val postNew = post.copy(id = size+1)
        service.add(postNew)
        return service.last()
    }
    fun update(post: Post): Boolean {
        val postId = post.id
        val size = service.size
        var arrId = listOf<Int>()
        for (y in 0 until size){
            arrId += service[y].id
        }
        val index = arrId.indexOf(postId)
        return if (index != -1){
            val postNew = post.copy(fromId = service[index].fromId, date = service[index].date)
            service[index] = postNew
            true
        }
        else false
    }
}

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright?,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: Unit,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId:Int
)
data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

data class Views(
    val count: Int
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: Placeholder,
    val canPublishFreeCopy: Boolean,
    val edit_mode: String
)

data class Placeholder(
    val all: Unit,
    val duration: Int
)