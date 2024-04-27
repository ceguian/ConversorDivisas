
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class UsdDivisa {
    HashMap<String, Double> conversion_rates;

    public UsdDivisa(UsdDivisaApi usdDivisaApi) {
        this.conversion_rates = usdDivisaApi.conversion_rates();
    }

    @Override
    public String toString() {
        return "Conversion Rates: " + conversion_rates;
    }

    public static class Convertion_rates {
        HashMap<String, Double> conversion_rates;

        public Convertion_rates(UsdDivisaApi.Conversion_rates conversion_rates) {
            this.conversion_rates = conversion_rates.conversion_rates();
        }

        public String getConversionRates(String busqueda, String busqueda2, Double valor, Date date){
            Double usd = 0.0;
           try{
               Double numero = conversion_rates.get(busqueda);
               Double numero2= conversion_rates.get(busqueda2);
               usd = (valor / numero) * numero2;

           }catch (NullPointerException e){
               return "Divisas inválidas, favor de usar el ISO 4217.";
           }
            return "La cantidad de: " + valor + " " + busqueda + " es igual a: " + usd + " " + busqueda2 +  " (Fecha y hora: "+ date + ")";

        }

        @Override
        public String toString() {
            return "conversion rates: " + conversion_rates;
        }
    }
}
