
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.*
import java.io.IOException
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import jdk.nashorn.internal.objects.NativeFunction.call
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


data class Mobilusis(var modelis: String = "NOKIA")

fun main(args: Array<String>) {

  val app_id = "1c9dba3c1cdd4b5699c41b00c3ea680d"
  val app_key = "veOUqBorXQfdxSDc8CU1ihPFu7m9FVu8"
  val BASE_URL = "https://us.battle.net/"
//  var generatedAccessToken = ""
//
//  val retrofit = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//
//  val accessTokenService = retrofit.create(AccessTokenService::class.java)
//  val call = accessTokenService.getAccessToken(app_id, app_key, "client_credentials")
//
//    call.enqueue(object : retrofit2.Callback<ResponseBody> {
//      override fun onResponse(call: Call<ResponseBody>, response: retrofit2.Response<ResponseBody>) {
//        //println(response.toString())
//        try {
//          val content = response.body()!!.string()
//          //System.out.println();
//          val jsonObject = JsonParser().parse(content).asJsonObject
//          val access_token = jsonObject.get("access_token").asString
//          generatedAccessToken = access_token
//          println(access_token) // tokenas
//
//        } catch (e: IOException) {
//          e.printStackTrace()
//        }
//
//      }
//
//      override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//
//      }
//    })

  val token = AccessToken.get_token()

    val baseUrl = "https://eu.api.blizzard.com/d3/data/item-type?locale=en_US&access_token=$token"
    val request = Request.Builder().url(baseUrl).build()  //UStEIRiKy7nGh5kF62z1IfxrcvD8vaPY08
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

// curl -u 1c9dba3c1cdd4b5699c41b00c3ea680d:veOUqBorXQfdxSDc8CU1ihPFu7m9FVu8 -d grant_type=client_credentials https://us.battle.net/oauth/token



