import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MainTest {


    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }



    @Test
    fun addTest() {
        val post = Post(1,2,3,"Test", true, 5, 6, 7)
        WallService.add(post)
        val result = "${post.id}"
        assertEquals("7", result)

    }

    @Test
    fun updateTrue() {
        val post = Post(1,2,3,"sd", true, 5,6,1)
        WallService.add(post)
        val result = WallService.update(3, "update", true, 6)
        val a = post.id
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val post = Post(1,2,3,"Test", true, 5, 6, 1)
        WallService.add(post)
        val result = WallService.update(9, "update", true, 2)
        assertFalse(result)
    }



}