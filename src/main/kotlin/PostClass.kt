data class Post(
    var id: Int = 0,
    var ownerId: Int = 0,
    val fromId: Int = 10,
    var createdBy: Int = 0,
    val date: Int,
    var text: String,
    var replyOwnerId: Int = 0,
    var replyPostId: Int = 0,
    var friendsOnly: Boolean = true,
    var comments: Comments? = Comments(),
    var copyright: Copyright? = Copyright(),
    var likes: Likes = Likes(),
    var reposts: Reposts? = Reposts(),
    var views: Views = Views(),
    var postType: Int = 1,
    var signerId: Int = 1,
    var canPin: Boolean = true,
    var canDelete: Boolean = true,
    var canEdit: Boolean = true,
    var isPinned: Boolean = true,
    var markedAsAds: Boolean = true,
    var isFavorite: Boolean = true,
    var donut: Donut = Donut(),
    var postponedId:Int = 1,
    var postSource: PostSource = PostSource(),
    var geo: Geo = Geo(),
    var copyHistory: Array<Any> = emptyArray(),
    var attachment: Array<Attachment> = emptyArray()
)
open class Attachment(open val type: String)

class GiftAttachment: Attachment("gift"){
    override val type = "gift"
    val gift: Gift = Gift()
}
class Gift(
    val id: Int=0,
    val thumb256: String = "",
    val thumb96: String = "",
    val thumb48: String = ""
)
class GraffitiAttachment: Attachment("giraffiti"){
    override val type = "giraffiti"
    val graffiti: GraffitiLink = GraffitiLink()
}
class GraffitiLink(
    val id: Int=0,
    val ownerId: Int=0,
    val url: String = "",
    val width: Int=0,
    val height: Int=0
)

class AudioAttachment: Attachment("audio"){
    override val type = "audio"
    val audio: Audio = Audio()
}
class Audio(
    val id: Int = 0,
    val owner_id: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
    val url: String = "",
    val lyrics_id: Int = 0,
    val album_id: Int = 0,
    val genre_id: Int = 0,
    val date: Int = 0,
    val no_search: Int = 0,
    val is_hq: Int = 0
)
class FileAttachment: Attachment("file"){
    override val type = "file"
    val file: File = File()
}
class File(
    val id: Int = 0,
    val owner_id: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
    val url: String = "",
    val date: Int = 0,
    val type: Int = 0,
    val preview: Preview = Preview(),
    val no_search: Int = 0,
    val is_hq: Int = 0
)
data class Preview(
    val photo: Photo? = Photo(),
    val graffiti: Graffiti? = Graffiti(),
    val audioMessage: AudioMessage? = AudioMessage()
)
data class Photo(
    val size: Array<Int> = emptyArray()
)
data class Graffiti(
    val src: String = "",
    val width: Int = 0,
    val height: Int = 0
)
data class AudioMessage(
    val duration: Int = 0,
    val waveform: Array<Int> = emptyArray(),
    val linkOgg: String = "",
    val linkMp3: String = ""
)
class AttachedLinkAttachment: Attachment("link"){
    override val type = "link"
    val link: Link = Link()
}
class Link(
    val url: String = "",
    val title: String = "",
    val caption: String = "",
    val description: String = "",
    val photo: Photo? = Photo(),
    val product: Product? = Product(),
    val button: Button? = Button(),
    val previewPage: String = "",
    val previewUrl: String = ""
)
data class Product(
    val price: Int = 0
)
data class Button(
    val button: Int =0
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Copyright(
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = ""
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = true
)

data class Views(
    val count: Int = 0
)

data class Donut(
    val isDonut: Boolean = true,
    val paidDuration: Int = 0,
    val placeholder: Placeholder = Placeholder(),
    val canPublishFreeCopy: Boolean = true,
    val edit_mode: String = ""
)

data class Placeholder(
    val all: Int = 0,
    val duration: Int = 0
)

data class Geo(
    val type: String = "",
    val coordinates: String = "",
    val place: Place = Place()
)
data class Place(
    val id: Int = 0,
    val title: String = "",
    val latitude: Int = 0,
    val longitude: Int = 0,
    val created: Int = 0,
    val icon: String = "",
    val checkins: Int = 0,
    val updated: Int = 0,
    val type: Int = 0,
    val country: Int = 0,
    val city: Int = 0,
    val address: String = ""
)
data class PostSource(
    val type: String = "",
    val platform: String = "",
    val data: String = "",
    val url: String = ""
)