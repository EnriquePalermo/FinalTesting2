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

@Tag("TRANSFER")
public class testTransfer {

    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Transfer-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void run() {
        System.out.println("<<< COMIENZAN LOS TEST DE TRANSFERENCIA DE CUENTAS >>>");
        ExtentSparkReporter spark = new ExtentSparkReporter("reportes/Transfer-Test.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeEach
    public void precondiciones() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        TransferPage transferPage = new TransferPage(driver, wait);
        transferPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("TRANSFERENCIATEXTO")
    @Tag("EXITOSO")
    public void test_TransferenciaTextoExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Resumen Transferencia Exitosa");
        test.log(Status.INFO, "Comienza el Test");

        TransferPage transferPage = new TransferPage(driver, wait);
        try {
            transferPage.escribirNombre("1234");
            transferPage.escribirPassword("1234");
            transferPage.clickRegistrarse();
            test.log(Status.INFO, "Ingreso en el Usuario");
            Thread.sleep(1000);
            transferPage.clickTransferFunds();
            Thread.sleep(1000);
            if (transferPage.accesoTransferenciaTexto().equals("Transfer Funds")) {
                test.log(Status.PASS, "Validar texto en Transferencia de cuentas");
            } else {
                test.log(Status.FAIL, "Fallo validación en Transferencia de cuentas");
            }

            test.log(Status.PASS, "Validación de texto en Transferencia de cuentas Exitoso");
        } catch (Exception error) {
            test.log(Status.FAIL, "FALLO EL TEST DE TRANSFERENCIA DE CUENTA" + error.getMessage());

        }
        test.log(Status.INFO, "Finaliza el Test");
    }

    @Test
    @Tag("TRANSFERENCIA")
    @Tag("EXITOSO")
    public void test_TransferenciaExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Resumen Transferencia Exitosa");
        test.log(Status.INFO, "Comienza el Test");

        TransferPage transferPage = new TransferPage(driver, wait);
        try {
            transferPage.escribirNombre("1234");
            transferPage.escribirPassword("1234");
            transferPage.clickRegistrarse();
            test.log(Status.INFO, "Ingreso en el Usuario");
            Thread.sleep(1000);

            transferPage.clickTransferFunds();
            Thread.sleep(1000);

            transferPage.escribirImporte("100");
            transferPage.clickDesplegable1();
            transferPage.clickCuenta1Desplegable1();
            transferPage.clickDesplegable2();
            transferPage.clickCuenta2Desplegable2();
            transferPage.clickTransferOk();
            Thread.sleep(1000);


            if (transferPage.transferenciaTextoOk().contains("Transfer Complete!")) {
                test.log(Status.PASS, "Validacion de Traspaso Exitoso");
            } else {
                test.log(Status.FAIL, "Validacion de Traspaso Fallido");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Validación de Traspaso Fallido" + e.getMessage());
        }
        test.log(Status.INFO, "Finaliza el Test");
    }

    @AfterEach
    public void cerrar() {
      //  RegisterPage registerPage = new RegisterPage(driver, wait);
       // registerPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE REGISTRO >>>");
    }
}

