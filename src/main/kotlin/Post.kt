import java.util.*

object WallService {
    val service = mutableListOf<Post>()
    var comments = mutableListOf<Comment>()

    fun createComment(comment: Comment): MutableList<Comment> {
        val postId = comment.postId
        service.find{it.id == comment.postId}?.text ?: throw NotFoundException("нет поста с таким id $postId")
        comments.add(comment)
        return comments
    }

    class NotFoundException(message: String) : RuntimeException(message)
    private var id: Int = 0
    private fun increaseId() {
        this.id += 1
    }

    fun add(post: Post): Post {
        increaseId()
        post.id = id
        service.add(post)
        return service.last()
    }

    fun update(post: Post): Boolean {
        val index = service.indexOfFirst { it.id == post.id }
        return if(index != -1){
            service[index] = post.copy(date = service[index].date, fromId = service[index].fromId)
            true
        }
        else {
            false
        }
    }

}