import WallService.posts


data class Post(
    val id: Int = 0, // id записи
    val ownerId: Int = 0, // id владельца
    val fromId: Int = 0,
    val created_by: Int = 0,
    val date: Int = 0,
    val text: String = "Text",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comment? = null,
    val copyright: String = "Original",
    val likes: Int = 0,
    val count: Int = 0,
    val repost: Post? = null,
    val views: Views? = null,
    val postType: String = "Post", // Post, Copy, Reply, Postpone, Suggest
    val postSource: String = "Source",
    val attachment: Array<Attachment> = emptyArray()
)


object WallService {
    var posts = emptyArray<Post>()
    var newId: Int = 0

    fun clean() {
        posts = emptyArray()
        newId = 0
    }

    // добавляем пост и присваиваем ему ID
    fun add(post: Post) {
        newId++;
        posts += post.copy(id = newId)
    }

    // обновление поста
    fun update(id: Int, text: String, friendsOnly: Boolean, count: Int): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                //newId++
                posts[index] =
                    post.copy(id = id, text = text, friendsOnly = friendsOnly, count = count)
                return true
            }
        }
        return false
    }

    // печать выбранного по ID поста
    fun print(id: Int) {
        for (post in posts) {
            if (post.id == id) {
                println("ID = ${post.id}")
                println(post)
            }

        }
        println()
    }

    // печать всех постов
    fun printAll() {
        for (post in posts) {
            println("ID = ${post.id}")
            println(post)
        }
        println()
    }
}

// Добавляем лайки и понравившиеся записи
object Likes {
    fun like(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes + 1)
            }
        }
    }

    fun count(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(count = post.count + 1)
            }
        }
    }
}

object Comment {
    //TODO
}

object Views {
    //TODO
}

data class Audio(
    val id: Int,
    val ownerId: Int = 0,
    val artist: String = "unknown",
    val title: String = "unknown",
    val duration: Int = 0,
    val url: String = "url",
    val albumId: Int = 0,
    val genreId: Int = 0,
    val date: Int = 0,
    val noSearch: Int = 0,
    val isHq: Int = 0
)

data class Photo(
    val id: Int,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = "photo",
    val date: Int = 0,
    val width: Int = 0,
    val height: Int = 0
)

data class Video(
    val id: Int,
    val ownerId: Int = 0,
    val title: String = "title",
    val description: String = "description",
    val duration: Int = 0,
    val date: Int = 0,
    val addingDate: Int = 0,
    val views: Int = 0,
    val localViews: Int = 0,
    val comments: Int = 0,
    val player: String = "url",
    val platform: String = "platform"
)

data class Gift(
    val id: Int,
    val thumb256: String = "url256",
    val thumb96: String = "url96",
    val thumb48: String = "url48"
)


data class Graffiti(
    val id: Int,
    val ownerId: Int = 0,
    val url: String = "url",
    val wight: Int = 0,
    val height: Int = 0
)

interface Attachment{
    val type: String
}

data class AudioAttachment(val audio: Audio): Attachment{
    override val type: String
        get() = "audio"
}

data class VideoAttachment(val video: Video): Attachment{
    override val type: String
        get() = "video"
}

data class PhotoAttachment(val photo: Photo): Attachment{
    override val type: String
        get() = "photo"
}

data class GiftAttachment(val gift: Gift): Attachment{
    override val type: String
        get() = "gift"
}

data class GraffitiAttachment(val graffiti: Graffiti): Attachment{
    override val type: String
        get() = "graffiti"
}
fun main() {
    val post = Post(attachment = (arrayOf(
        AudioAttachment(Audio(2)),
        GiftAttachment(Gift(1)),
        VideoAttachment(Video(3))
    )) )
    WallService.add(post)
    WallService.printAll()
   /* val repost = Post(repost = post)

    WallService.add(repost)*/


    /* WallService.add(Post(text = "Cool"))
     WallService.add(Post(text = "NewCool"))
     Likes.like(1)
     WallService.print(1)

     Likes.like(1)
     WallService.printAll()
     val b = WallService.update(1, "update", true, 2)
     println(b)
     val c = WallService.update(20, "update", true, 2)
     val d = WallService.update(3, "up", true, 2)
     println(c)
     println(d)
     WallService.printAll()*/
}