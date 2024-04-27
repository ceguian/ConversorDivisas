import java.util.HashMap;

public record UsdDivisaApi(HashMap<String, Double> conversion_rates) {

    public record  Conversion_rates(
            HashMap<String,Double> conversion_rates
    ){

    }

}
