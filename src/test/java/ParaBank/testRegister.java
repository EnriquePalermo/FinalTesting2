package ParaBank;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testRegister {
    private WebDriver driver;
    private WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("/reportes/Registro-Test.html");
    static ExtentReports extent;


    @BeforeAll
    public static void createReport() {
        System.out.println("<<< COMIENZAN LOS TEST DE REGISTRO >>>");
        ExtentSparkReporter spark = new ExtentSparkReporter("reportes/Registro-Test.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("REGISTRO")
    @Tag("EXITOSO")
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Crear usuario");
        test.log(Status.INFO, "Ingreso en el Registro");

        RegisterPage registerPage = new RegisterPage(driver, wait);


     try {
         registerPage.clickCrearCuenta();

         registerPage.escribirNombre("1234");
         registerPage.escribirApellido("1234");
         registerPage.escribirDireccion("1234");
         registerPage.escribirCiudad("1234");
         registerPage.escribirEstado("1234");
         registerPage.escribirZip("1234");
         registerPage.escribirTelefono("1234");
         registerPage.escribirSsn("1234");
         registerPage.escribirUserName("1234");
         registerPage.escribirContraseña("1234");
         registerPage.repetirContraseña("1234");
         registerPage.clickRegistrarse();
         if (registerPage.cuentaCreadaTexto().equals("Your account was created successfully. You are now logged in.")) {
             test.log(Status.PASS, "Validacion de Registro Exitoso");
         } else {
             test.log(Status.FAIL, "Validacion de Registro Fallido");
         }

     }
     catch (Exception e) {
         test.log(Status.FAIL, "Validación de Registro Fallido" + e.getMessage());
     }

        test.log(Status.INFO, "Finaliza el Test");
    }


    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE REGISTRO >>>");
    }
}
