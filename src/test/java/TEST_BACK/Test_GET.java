package TEST_BACK;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import reportes.ReportFactory;
import static org.junit.jupiter.api.Assertions.*;


import static io.restassured.RestAssured.given;

public class Test_GET {
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/APIGET-Test.html");
    static ExtentReports extent;

    private static int authToken;
    private static String username = "1234";
    private static String password = "1234";


    @BeforeAll
    public static void setup() {
        System.out.println("<<< COMIENZAN LOS TEST DE BACK >>>");
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);

        // Hacer la URL del login con usuario y contraseña con variables
        String loginUrl = "https://parabank.parasoft.com/parabank/services/bank/login/{username}/{password}";

        // Hago el GET para el login
        Response response = given()
                .pathParams("username", username)
                .pathParams("password", password)
                .when()
                .get(loginUrl);

        // Verifico que la respuesta sea correcta (200)
        assertEquals(200, response.getStatusCode(), "Error al autenticar. Codigo de estado: " + response.getStatusCode());

        // Extraigo el "customerId"(token de la pagina) de la respuesta XML
        int customerId = response.xmlPath().getInt("customer.id");

        // Pongo el token que tengo en el "customerID" en el authToken para poder usarlo en todas las pruebas que necesite
        authToken = customerId;
    }

    @AfterAll
    public static void teardown() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE BACK >>>");
    }

    @Test
    @Tag("GET")
    public void GET_RegistroURL() {
        ExtentTest test = extent.createTest("Test de Registro GET de la API");
        test.log(Status.INFO, "Comienza el Test");
        System.out.println("Iniciando Registro Test Get");
        test.log(Status.INFO, "Iniciando Registro Test Get");

        Response responseGet = RestAssured.get(" https://parabank.parasoft.com/parabank/register.htm");
        System.out.println(responseGet.statusCode());
        test.log(Status.INFO, String.valueOf(responseGet.statusCode()));
        System.out.println(responseGet.getHeader("Date"));
        System.out.println(responseGet.getTime());
        if (responseGet.getStatusCode() == 200) {
            test.log(Status.PASS, "Validacion de estado 200 correcto");
        } else {
            test.log(Status.FAIL, "Validacion de estado fallido");
        }
        System.out.println("Registro Test Get finalizado");

    }

    @Test
    @Tag("GET")
    public void GET_ResumenCuenta() {
        ExtentTest test = extent.createTest("Test Resumen Cuenta GET de la API");
        test.log(Status.INFO, "Comienza el Test");
        System.out.println("Iniciando Resumen Cuenta Test Get");
        test.log(Status.INFO, "Iniciando Resumen Cuenta Test Get");

        // Utilizo el ENDPOINT del Swagger de la pagina. No el que me da la letra del examen, porque no funciona. Utilizando el token para que sea mas automatizado.
        Response responseGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/"+authToken+"/accounts");

        System.out.println(responseGet.statusCode());
        test.log(Status.INFO, String.valueOf(responseGet.statusCode()));
        System.out.println(responseGet.getHeader("Date"));
        System.out.println(responseGet.getTime());
        if (responseGet.getStatusCode() == 200) {
            test.log(Status.PASS, "Validacion de estado 200 correcto");
        } else {
            test.log(Status.FAIL, "Validacion de estado fallido");
        }
        System.out.println("Resumen Cuenta Test Get finalizado");

    }

    @Test
    @Tag("GET")
    public void GET_ActividadCuenta() {
        ExtentTest test = extent.createTest("Test Actividad Cuenta GET de la API");
        test.log(Status.INFO, "Comienza el Test");
        System.out.println("Iniciando Actividad Cuenta Test Get");
        test.log(Status.INFO, "Iniciando Actividad Cuenta Test Get");


        Response responseGet = given()
                .auth().basic(username,password)
                .get("https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13899/transactions/month/All/type/All");

        System.out.println(responseGet.statusCode());
        test.log(Status.INFO, String.valueOf(responseGet.statusCode()));
        System.out.println(responseGet.getHeader("Date"));
        System.out.println(responseGet.getTime());
        if (responseGet.getStatusCode() == 200) {
            test.log(Status.PASS, "Validacion de estado 200 correcto");
        } else {
            test.log(Status.FAIL, "Validacion de estado fallido");
        }
        System.out.println("Actividad Cuenta Test Get finalizado");

    }







}
