import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Conexion {

    public UsdDivisa.Convertion_rates nuevaConexion() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient
                .newHttpClient();

        URI uriUrl = new URI("https://v6.exchangerate-api.com/v6/9352692a44313fb4adec0186/latest/USD/");

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uriUrl)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());



       return new Gson().fromJson(response.body(), UsdDivisa.Convertion_rates.class);
    }
}
