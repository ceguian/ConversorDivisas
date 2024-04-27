# ConversorDivisas
Conversor de Divisas que usa la api https://www.exchangerate-api.com/

<h1>Acerca del Proyecto</h1>
Ha sido un excelente reto para mí poder implementar correctamente una API. Uno considera que tiene el conocimeinto necesario para poder implementarlas de manera correcta y mostrar los datos sin ningún problema, sin embargo , sino se tiene el conocimiento adecuado para tratar los datos y poder despleagarlos de la manera que se busca; puede que llegues a encontrarte con el mismo problema que yo.<br>
El proyecto parte de un reto impuesto por Alura Latam para poder desafiarnos a noostros mismos y realizar un proyecto para nuestro portafolio.<br>
El primer reto con el cual me cruce, fue utilizar el campo <b>conversion_rates</b> correctamente, debido a que es una clase anidada al json original y por tanto se considera un <b>JsonObject</b>. Para poder tratar esta situación lo primero que se me ocurrió fue el implementar un record de la clase <b>convertion_rates</b> declarando su atributos como un HashMap, sin embargo, el resultado daba nulo al realizar un búsqueda por el método propio de Map <b>"get"</b>. Dada está respuesta, mi segundo planteamiento fue generar una clase récord para la Divisa y generar una clase anidada llamada <b>conversion_rates</b> con su atributo HashMap como <b>conversion_rates</b>, por tanto quedo como se muestra en el código.<br>
  public record DivisaApi(HashMap(String, Double)){
  public record ConversionRates(HashMap(String, Double)){
  }
  }

Siendo sincero, no considero que sea la manera correcta de utilizar los datos Json con Gson, no obstante, para esté caso funcionó. Si lees esto y tienes una mejor forma de implementar la respuesta de una solicitud de una clase anidada, por favor enviame un mensaje al correo: mangaka.orozco@gmail.com. Espero poder aprender algo nuevo. Si no es el caso, espero haberte ayudado dándote una idea de como puedes manejar esté tipo de situaciones.

<h1>Guía de Usuario</h1>
El conversor de Divisas funciona utilizando la API de https://www.exchangerate-api.com/. En el código aparecerá mi clave para usarla, sin embargo, recomiendo usar la propia ya que solo es para fines educativos.

Esté conversor toma el valor brindado al programa y genera una conexión a la API dando una respuesta general del tipo de cambio a USD (United States Dollar), esto debido al mi falta de experiencia usandop y tratando respuestas Gson, y genera las búsqueda de la primera Divisa la cuál se utilizará dando el valor y después busca el valor de la segunda Divisa, generando una simple transformación de los datos y regresando una cadena de texto indicando las Divisas y el valor conevrtido. Además, se incluyo la opción de generar un historial de conversiones y poder guardarlo en un archivo JSon.

<h3>Al ejecutar el programa:</h3>
<ul>
  <li>Primero nos aparecera una lista de Divisas, estás son opcionales, ya que puede manejar todas las que soporta la API.</li>
  <li>Despúes nos solicitará el ISO 4217 de la Divisa a utilizar.</li>
  <li>Una vez ingresada está información, nos solicitará la Divisa a la cuál vamos a tranformar.</li>
  <li>Por último, ingresaremos el valor el cual deseamos convertir. Acepta valores décimales.</li>
  <li>Una vez ingresada esta información se realizará la consulta y nos brindará la información solicitada.</li>
  <li>Seguido de esto, nos preguntará si deseamos incluir la consulta al historial de consultas, y daremos la respuesta con un 1 para sí.</li>
  <li>Se nos cuestionará si deseamos seguir convirtiendo, en caso de que querramos salir, unicamente hay que ingresar <b>salir</b>.</li>
  <li>Al ingresar <b>salir</b> nos preguntará si deseamos ver el historial.</li>
  <li>Por último, nos preguntará si deseamos generar el archivo del historial.</li>
  <li>Procederá a finalizarse el programa.</li>
</ul>
<br><br>
Programa realizado completamente por:   Alejandro Orozco (ceguian)<br>
Agradecimientos especiales para:   AluraONE y Oracle México.


