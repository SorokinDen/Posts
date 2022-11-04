

import WallService.posts


data class Post(

    val onwerId: Int = 0, // id владельца
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "Text",
    val friendsOnly: Boolean = false,
    val likes: Int = 0,
    val count: Int = 0,
    val id: Int = 0, // id записи
    val repost: Post? = null
)



object WallService {
    var posts = emptyArray<Post>()
    var newId: Int = 0

    fun clear() {
        posts = emptyArray()
    }

    // добавляем пост и присваиваем ему ID
    fun add(post: Post){
        newId ++;
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
    fun print(id: Int){
        for(post in posts){
            if(post.id == id){
                println("ID = ${post.id}")
                println(post)
            }

        }
        println()
    }
    // печать всех постов
    fun printAll(){
        for(post in posts){
            println("ID = ${post.id}")
            println(post)
        }
        println()
    }
}

// Добавляем лайки и понравившиеся записи
object Likes{
    fun like(id: Int){
        for ((index, post) in posts.withIndex()){
            if(post.id == id){
                posts[index] = post.copy(likes =  post.likes + 1)
            }
        }
    }
    fun count(id: Int){
        for ((index, post) in posts.withIndex()){
            if(post.id == id){
                posts[index] = post.copy(count =  post.count + 1)
            }
        }
    }
}
fun main(){
    val post = Post()
    val repost = Post(repost = post)
    WallService.add(post)
    WallService.add(repost)
    WallService.printAll()

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