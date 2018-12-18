
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun main(args: Array<String>) {
  val baseUrl: String =
    "https://eu.api.blizzard.com/d3/data/item-type?locale=en_US&access_token=USJrmHMAanACUN3IXrJxsHRE1npDkwCZq3"
  val request = Request.Builder().url(baseUrl).build()
  val client = OkHttpClient()
  client.newCall(request).enqueue(object : Callback {
    override fun onResponse(call: okhttp3.Call, response: Response) {
      val body = response.body()?.string()

      //print("${body}")

      val gson = GsonBuilder().create()
      val collectionType = object : TypeToken<List<ItemType>>() {}.type
      val items: List<ItemType> = gson.fromJson(body, collectionType)



      items.forEach {
        println("${it.name} | ${it.id} | ${it.path}")
      }
  }
    override fun onFailure(call: okhttp3.Call, e: IOException) {
      print("Failed to read response")
    }
  })
}

data class ItemType(val id: String, val name: String, val path: String)

