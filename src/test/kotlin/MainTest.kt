import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MainTest {


    @Before
    fun clearBeforeTest() {
        WallService.clean()
    }


    @Test
    fun addTest() {
        val post = Post(
            1,
            2,
            3,
            4,
            5,
            "text",
            6,
            7,
            true,
            null,
            "original",
            0,
            0,
            null,
            null,
            "Post",
            "Source"
        )

        WallService.add(post)
        val result = "${post.id}"
        assertEquals("1", result)

    }

    @Test
    fun updateTrue() {
        val post = Post(1)
        WallService.add(post)
        val result = WallService.update(1, "update", true, 6)
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val post = Post(1)
        WallService.add(post)
        val result = WallService.update(9, "update", true, 2)
        assertFalse(result)
    }

}