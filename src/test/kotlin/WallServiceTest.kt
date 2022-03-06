import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class WallServiceTest {

    val post = Post(
        id = 0,
        ownerId = 11,
        fromId = 111,
        createdBy = 1111,
        date = 1,
        text = "стандартный текст",
        replyOwnerId = 111,
        replyPostId = 111,
        friendsOnly = true,
        comments = Comments(
            count = 0,
            canPost = false,
            groupsCanPost = false,
            canClose = false,
            canOpen = true
        ),
        copyright = null,
        likes = Likes(
            count = 0,
            userLikes = true,
            canLike = true,
            canPublish = true
        ),
        reposts = Reposts(
            count = 0,
            userReposted = false
        ),
        views= Views(
            count = 0
        ),
        postType = 1,
        signerId=111,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = true,
        markedAsAds = true,
        isFavorite = true,
        donut = Donut(
            isDonut = false,
            paidDuration = 0,
            placeholder = Placeholder(
                all = 1,
                duration = 0
            ),
            canPublishFreeCopy = true,
            edit_mode = ""
        ),
        postponedId = 111
    )

    @Test
    fun add() {
        val servicenew = WallService
        val postId = servicenew.add(post).id
        assertNotEquals(postId, 0)
    }

    @Test
    fun updateOne() {
        val servicenew = WallService
        servicenew.add(post)
        val id = servicenew.add(post).id
        val postNew = post.copy(text = "обновленный пост", id = id)
        val result = servicenew.update(postNew)
        assertEquals(result, true)
    }
    @Test
    fun updateTwo() {
        val servicenew = WallService
        servicenew.add(post)
        val id = 99999
        val postNew = post.copy(text = "обновленный пост", id = id)
        val result = servicenew.update(postNew)
        assertEquals(result, false)
    }
    @Test
    fun comment(){
        val servicenew = WallService
        servicenew.add(post)
        val id = servicenew.add(post).id
        val comment = Comment(
            id = 1,
            postId = id,
            text = "Новый комментарий"
        )
        servicenew.createComment(comment)
        val text = servicenew.comments[0].text
        assertEquals(text, "Новый комментарий")
    }
    @Test (expected = WallService.NotFoundException::class)
    fun commentFailed(){
        val servicenew = WallService
        servicenew.add(post)
        val comment = Comment(
            id = 1,
            postId = 9999,
            text = "Новый комментарий"
        )
        servicenew.createComment(comment)
    }
}