fun main(){
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
    val servicenew = WallService
    servicenew.add(post)
    val postTwo = post.copy(text = "обновленный пост1", fromId = 121, date =55)
    val test = servicenew.add(postTwo)
    //println("${servicenew.service}")
    var id = servicenew.service[1].id
    //val id= 99999
    val comment = Comment(
        id = 1,
        postId = id,
        text = "Новый комментарий"
    )
    //val postId = comment.postId
    //servicenew.find{it.id == comment.id}?.text ?: throw NotFoundException("нет поста с таким id $postId")
    //comments.add(comment)
    servicenew.createComment(comment)
    //val postNew = post.copy(text = "обновленный пост44", id = id, fromId = 1, date = 1, ownerId = 88)
    //val result = servicenew.update(postNew)
    //println("результат обновления поста $result")
    println("${servicenew.comments}")
}