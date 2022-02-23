import java.util.*

fun main(){
    val servicenew = WallService

    // заполняем несколькими постами
    servicenew.add(post = Post(text = "стандартный текст"))
    //println("${servicenew.service[0].text}")
    //println("${servicenew.service[0].id}")
    val test = servicenew.add(post = Post(text = "стандартный текст1"))
    println("готовый объект ${servicenew.service}")
    //println("${servicenew.service[1].id}")
    var id = servicenew.service[1].id
    //val id= UUID.randomUUID()
    val post = Post(text = "обновленный пост", id = id)//servicenew.service[1]
    println("${servicenew.update(post)}")
    println("обновленный объект ${servicenew.service}")
    println("${servicenew.service[1].text}")
    //val mutableArray = servicenew.service.toMutableList()
    //servicenew.add(post)

}

