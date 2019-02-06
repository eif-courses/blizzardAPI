import retrofit2.Call
import retrofit2.http.POST
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded



interface AccessTokenService {

  @FormUrlEncoded
  @POST("/oauth/token")
  fun getAccessToken(@Field("client_id") id: String,
                   @Field("client_secret") secret: String,
                     @Field("grant_type") grant_type: String
  ): Call<ResponseBody>

}