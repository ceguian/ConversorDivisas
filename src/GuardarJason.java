import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardarJason {

    public void generarArchivo (ArrayList arrayList) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("HistorialDivisas.json");
        escritura.write(gson.toJson(arrayList));
        escritura.close();

    }
}
