import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class GetRequest {
  public static void main(String[] args) throws IOException {

    OkHttpClient client = new OkHttpClient();

    final String app_id = "1c9dba3c1cdd4b5699c41b00c3ea680d";
    final String app_key = "veOUqBorXQfdxSDc8CU1ihPFu7m9FVu8";
    HttpUrl.Builder urlBuilder = HttpUrl.parse("https://us.battle.net/oauth/token").newBuilder();

    urlBuilder.addQueryParameter("client_id", app_id);
    urlBuilder.addQueryParameter("client_secret", app_key);
    urlBuilder.addQueryParameter("grant_type", "client_credentials");

    String url = urlBuilder.build().toString();

    Request request = new Request.Builder()
        .url(url)
        .build();
    Response response = client.newCall(request).execute();

    String access_token = response.body().string();

    Gson gson = new Gson();
    Token token = gson.fromJson(access_token, Token.class);
    System.out.println(token.access_token);







  }
}
