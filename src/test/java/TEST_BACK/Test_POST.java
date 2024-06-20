package TEST_BACK;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import reportes.ReportFactory;

import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_POST {
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/APIPOST-Test.html");
    static ExtentReports extent;
    ExtentTest test;

    private static int authToken;
    private static String username = "1234";
    private static String password = "1234";


    @BeforeAll
    public static void setup() {
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
    }

    @Test
    @Tag("POST")
    public void POST_NuevaCuenta() {
        test = extent.createTest("Test Nueva Cuenta POST de la API");
        test.log(Status.INFO, "Comienza el Test");

        System.out.println("Iniciando Nueva Cuenta Test Post");
        test.log(Status.INFO, "Iniciando Nueva Cuenta Test Post");

        JsonObject request = new JsonObject();
        request.addProperty("username", username);
        request.addProperty("password", password);


        given()
                .auth().basic(username, password)
                .contentType("application/json")
                .body(request.toString())
                .when().post("https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=" + authToken + "&newAccountType=1&fromAccountId=13899")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();

        System.out.println("Test Nueva Cuenta Post finalizado");
        test.log(Status.INFO, "Validacion de estado 200 correcto");
        test.log(Status.PASS, "Test Nueva Cuenta Post finalizado");
    }

    @Test
    @Tag("POST")
    public void POST_Transferencia() {
        test = extent.createTest("Test Transferencia POST de la API");
        test.log(Status.INFO, "Comienza el Test");

        System.out.println("Iniciando Transferencia Test Post");
        test.log(Status.INFO, "Iniciando Transferencia Test Post");

        JsonObject request = new JsonObject();
        request.addProperty("username", username);
        request.addProperty("password", password);


        given()
                .auth().basic(username, password)
                .contentType("application/json")
                .body(request.toString())
                .when().post("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13899&toAccountId=15453&amount=100")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();

        System.out.println("Test Transferencia Post finalizado");
        test.log(Status.INFO, "Validacion de estado 200 correcto");
        test.log(Status.PASS, "Test Transferencia Post finalizado");
    }


    }
