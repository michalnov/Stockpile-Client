package sk.akademiasovy.stockpile.objects;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class Communication {

    public String loginHandler(String username, String password){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"username\":\""+username+"\",\n\t\"password\":\""+password+"\"\n}");
        System.out.println(body);
        Request request = new Request.Builder()
                .url("http://itsovy.sk:3311/login")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            AuthResponse authResponse = gson.fromJson(String.valueOf(response),AuthResponse.class);
            if (authResponse.getToken().equals("")){
                return "";
            } else {
                return authResponse.getToken();
            }
        } catch (
                IOException e1) {
            e1.printStackTrace();
            return "";
        }
    }

    public StockList getUpdate(String token){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"token\":\""+token+"\"\n}");
        Request request = new Request.Builder()
                .url("http://itsovy.sk:3311/update")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            StockList output = gson.fromJson(String.valueOf(response),StockList.class);
            return output;
        } catch (
                IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public boolean insertItem(StockUnit item){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"name\":\""+item.getName()+"\"," +
                "\n\t\"origin\":\""+item.getOrigin()+"\"," +
                "\n\t\"quantity\":\""+item.getQuantity()+"\"," +
                "\n\t\"recipient\":\""+item.getRecipient()+"\"" +
                "\n}");
        Request request = new Request.Builder()
                .url("http://itsovy.sk:3311/insert")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.code() != 200){
                return false;
            } else {
                return true;
            }
        } catch (
                IOException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    public boolean withdrawItem(StockUnit item){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"name\":\""+item.getName()+"\"," +
                "\n\t\"origin\":\""+item.getOrigin()+"\"," +
                "\n\t\"quantity\":\""+item.getQuantity()+"\"," +
                "\n\t\"recipient\":\""+item.getRecipient()+"\"" +
                "\n}");
        Request request = new Request.Builder()
                .url("http://itsovy.sk:3311/withdraw")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.code() != 200){
                return false;
            } else {
                return true;
            }
        } catch (
                IOException e1) {
            e1.printStackTrace();
            return false;
        }
    }

                    /*
                    HttpClient httpClient = HttpClient.newBuilder()
                            .version(HttpClient.Version.HTTP_2)  // this is the default
                            .build();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://itsovy.sk:3311/login"))
                            .POST(HttpRequest.BodyPublishers.ofString(""))
                            .build();
                    httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                            .thenAccept(response -> {
                                System.out.println("Response body: " + response.body());
                            });
                    */

}