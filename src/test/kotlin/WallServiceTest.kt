import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        val post = Post(text = "новый пост для проверки id")
        val servicenew = WallService
        val postId = servicenew.add(post).id
        assertNotEquals(postId, 0)
    }

    @Test
    fun updateOne() {
        val servicenew = WallService
        servicenew.add(post = Post(text = "стандартный текст"))
        val id = servicenew.add(post = Post(text = "стандартный текст1")).id
        val post = Post(text = "обновленный пост", id = id)
        val result = servicenew.update(post)
        assertEquals(result, true)
    }
    @Test
    fun updateTwo() {
        val servicenew = WallService
        servicenew.add(post = Post(text = "стандартный текст"))
        val id = 99999
        val post = Post(text = "обновленный пост", id = id)
        val result = servicenew.update(post)
        assertEquals(result, false)
    }
}