import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String monedas = """
               *********************************************
                                BIENVENIDO
                                :::::::::
                Divisas disponibles:
                
                    ARS - Peso argentino
                    BOB - Boliviano boliviano
                    BRL - Real brasileño
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar estadounidense
                    
               *********************************************
                """;
        System.out.println(monedas);
        ArrayList<String> listaHistorial = new ArrayList<>();

        Scanner lectura = new Scanner(System.in);

        Conexion buscar = new Conexion();
        int i = 1;
        while (true){
            Double cantidad;
            UsdDivisa.Convertion_rates usdDivisa = buscar.nuevaConexion();
            System.out.println("Elija la moneda a convertir (Ej. MXN).");
            String busqueda = lectura.next().toUpperCase();
            System.out.println("Elija la moneda objetivo (Ej. ZAR).");
            String busqueda2 = lectura.next().toUpperCase();
            System.out.println("Elija la cantidad a transformar.");
            try{
                 cantidad = lectura.nextDouble();
                String respuesta = usdDivisa.getConversionRates(busqueda,busqueda2,cantidad, new Date());
                System.out.println(respuesta);
                System.out.println("¿Desea guardar en el historial? \n Presione 1 para guardar.");
                int historial = lectura.nextInt();

                if(historial == 1){
                    listaHistorial.add("Busqueda " + i + " : "+ respuesta);
                    System.out.println("Guardado correctamente.");
                    i++;
                }else{
                    System.out.println("No se guardó la búsqueda.");
                }

            }catch (InputMismatchException e){
                System.out.println("Ingrese un valor númerico.");
            }


            System.out.println("Desea continuar?\n Escribe <<salir>> para salir o cualquier otra tecla para continuar.");

            if (lectura.next().equalsIgnoreCase("salir")){
                System.out.println("¿Desea ver el historial de búsquedas? \n Presione 1 para imprimir.");

                if (lectura.nextInt() == 1){
                    System.out.println("Historial: \n");
                    System.out.println(listaHistorial);
                }
                System.out.println("¿Desea guardar en un archivo el historial? \n Presione 1 para imprimir.");
                if (lectura.nextInt() == 1){
                    System.out.println("Generando archivo.");
                    GuardarJason guardarJason = new GuardarJason();
                    guardarJason.generarArchivo(listaHistorial);
                    System.out.println("Archivo Generado.");
                }else{
                    System.out.println("No se guardó el historial.");
                }
                System.out.println("Gracias por usar nuestros servicios. Vuelva pronto.");
                break;
            }
        }



    }
}
