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
            service[index] = post
            true
        }
        else false
    }
}

data class Post(
    val id: Int = 0,
    val ownerId: Int? = null,
    val fromId: Int? = null,
    val createdBy: Int? = null,
    val date: Int? = null,
    val text: String,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean? = null,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Likes? = null,
    val reposts: Reposts? = null,
    val views: Views? = null,
    val postType: Unit? = null,
    val signerId: Int? = null,
    val canPin: Boolean? = null,
    val canDelete: Boolean? = null,
    val canEdit: Boolean? = null,
    val isPinned: Boolean? = null,
    val markedAsAds: Boolean? = null,
    val isFavorite: Boolean? = null,
    val donut: Donut? = null,
    val postponedId:Int? = null
)
//{
  //  val id: Int get() = hashCode()
//}
data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val CanClose: Boolean,
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