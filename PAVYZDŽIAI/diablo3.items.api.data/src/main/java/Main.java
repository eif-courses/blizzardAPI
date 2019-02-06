import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    final String app_id = "1c9dba3c1cdd4b5699c41b00c3ea680d";
    final String app_key = "veOUqBorXQfdxSDc8CU1ihPFu7m9FVu8";
    String BASE_URL = "https://us.battle.net/";

    Retrofit retrofit = new Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    AccessTokenService accessTokenService = retrofit.create(AccessTokenService.class);
    Call<ResponseBody> call =  accessTokenService.getAccessToken(app_id, app_key, "client_credentials");
    call.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        System.out.println(response.toString());
        try {
          String content = response.body().string();
          //System.out.println();

          JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject();
          String access_token = jsonObject.get("access_token").getAsString();
          System.out.println(access_token); // tokenas

        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<ResponseBody> call, Throwable t) {

      }
    });
  }
}
