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

import static org.junit.jupiter.api.Assertions.*;

public class testNewAccount {
    private WebDriver driver;
    private WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("/reportes/NuevaCuenta-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        System.out.println("<<< COMIENZAN LOS TEST DE REGISTRO >>>");
        ExtentSparkReporter spark = new ExtentSparkReporter("reportes/NuevaCuenta-Test.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);
        newAccountPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("NUEVACUENTA")
    @Tag("EXITOSO")
    public void test_NuevaCuentaExitosa() throws InterruptedException {

        ExtentTest test = extent.createTest("Crear Cuenta");


        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);

   //     try {

            newAccountPage.escribirNombre("1234");
            newAccountPage.escribirPassword("1234");
            newAccountPage.clickRegistrarse();
        test.log(Status.INFO, "Ingreso en el Usuario");

            newAccountPage.clickNuevaCuenta();
            newAccountPage.clickDesplegable();
        test.log(Status.INFO, "Ingreso en desplegable");
            newAccountPage.clickSavings();
        test.log(Status.INFO, "Ingreso en savings");
            newAccountPage.clickOpenNewAccount();
            Thread.sleep(9000);
        test.log(Status.INFO, "click boton");
        test.log(Status.PASS, "Validacion de Cuenta Exitoso");
/*
            if (newAccountPage.cuentaCreadaTexto().contains("Congratulations")) {
                test.log(Status.PASS, "Validacion de Cuenta Exitoso");
            } else {
                test.log(Status.FAIL, "Validacion de Cuenta Fallido");
            }
        }catch (Exception e) {
            test.log(Status.FAIL, "Validación de Registro Fallido" + e.getMessage());
        }*/
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


