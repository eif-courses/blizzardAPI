import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class AccessToken {
   public static String get_token() throws IOException {
      //final String Auth = "Basic MY_AUTH_CODE";
      final String app_id = "1c9dba3c1cdd4b5699c41b00c3ea680d";
      final String app_key = "veOUqBorXQfdxSDc8CU1ihPFu7m9FVu8";
      HttpClient httpclient = HttpClients.createDefault();
      HttpPost httppost = new HttpPost("https://us.battle.net/oauth/token");

// Request parameters and other properties.
      List<NameValuePair> params = new ArrayList<NameValuePair>(2);
      params.add(new BasicNameValuePair("client_id", app_id));
      params.add(new BasicNameValuePair("client_secret", app_key));
      params.add(new BasicNameValuePair("grant_type", "client_credentials"));

      httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

//Execute and get the response.
      HttpResponse response = httpclient.execute(httppost);
      HttpEntity entity = response.getEntity();
      String token = null;
      if (entity != null) {
        String content = EntityUtils.toString(entity);
        // GSON READ RESPONSE
        JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject();
        String access_token = jsonObject.get("access_token").getAsString();
        System.out.println(access_token); // tokenas
        token = access_token;
      }
      return token;
    }

  }