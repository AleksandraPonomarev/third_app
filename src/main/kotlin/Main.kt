fun main(){
    val servicenew = WallService
    servicenew.add(post = Post(text = "стандартный текст"))
    val test = servicenew.add(post = Post(text = "стандартный текст1"))
    var id = servicenew.service[1].id
    //val id= 99999
    val post = Post(text = "обновленный пост", id = id)
    val result = servicenew.update(post)
    println("$result")
    println("${servicenew.service}")
}