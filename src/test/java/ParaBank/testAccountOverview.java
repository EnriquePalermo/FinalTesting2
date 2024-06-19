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

@Tag("ACCOUNTOVERVIEW")
public class testAccountOverview {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/AccountOverview-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void run() {
        System.out.println("<<< COMIENZAN LOS TEST DE RESUMEN DE CUENTA >>>");
        ExtentSparkReporter spark = new ExtentSparkReporter("reportes/AccountOverview-Test.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeEach
    public void precondiciones() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        AccountOverview accountOverview = new AccountOverview(driver, wait);
        accountOverview.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("PRIMERAPANTALLARESUMENCUENTA")
    @Tag("EXITOSO")
    public void test_Overview1PantallaExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Resumen de Cuentas Texto Exitoso");
        test.log(Status.INFO, "Comienza el Test");

        AccountOverview accountOverview = new AccountOverview(driver, wait);
        try {
            accountOverview.escribirNombre("1234");
            accountOverview.escribirPassword("1234");
            accountOverview.clickRegistrarse();
            test.log(Status.INFO, "Ingreso en el Usuario");
            Thread.sleep(1000);

            if (accountOverview.cuentaCreadaTexto().equals("*Balance includes deposits that may be subject to holds")) {
                test.log(Status.PASS, "Validar texto en Resumen de cuentas");
            } else {
                test.log(Status.FAIL, "Fallo validación en Resumen de cuentas");
            }

            test.log(Status.PASS, "Validación de texto en Resumen de cuentas Exitoso");
        } catch (Exception error) {
            test.log(Status.FAIL, "FALLO EL TEST DE RESUMEN DE CUENTA" + error.getMessage());

        }
        test.log(Status.INFO, "Finaliza el Test");
    }

    @Test
    @Tag("RESUMENINGRESOAUNACUENTA")
    @Tag("EXITOSO")
    public void test_OverviewIngreso1CuentaExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Resumen Detalle de 1 Cuenta Exitoso");
        test.log(Status.INFO, "Comienza el Test");

        AccountOverview accountOverview = new AccountOverview(driver, wait);
        try {
            accountOverview.escribirNombre("1234");
            accountOverview.escribirPassword("1234");
            accountOverview.clickRegistrarse();
            test.log(Status.INFO, "Ingreso en el Usuario");
            Thread.sleep(1000);

            accountOverview.elegirCuenta();
            Thread.sleep(1000);

            if (accountOverview.cuentaDetalleTexto().equals("Account Details")) {
                test.log(Status.PASS, "Validar texto en Detalle de cuenta");
            } else {
                test.log(Status.FAIL, "Fallo validación en Detalle de cuenta");
            }

            test.log(Status.PASS, "Validación de texto en Detalle de cuenta Exitoso");
        } catch (Exception error) {
            test.log(Status.FAIL, "FALLO EL TEST DE RESUMEN DE CUENTA" + error.getMessage());

        }
        test.log(Status.INFO, "Finaliza el Test");
    }

    @Test
    @Tag("RESUMENINGRESODETALLECUENTA")
    @Tag("EXITOSO")
    public void test_OverviewIngresoDetalleCuentaExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Resumen Ingreso Detalle de 1 Cuenta Exitoso");
        test.log(Status.INFO, "Comienza el Test");

        AccountOverview accountOverview = new AccountOverview(driver, wait);

        accountOverview.escribirNombre("1234");
        accountOverview.escribirPassword("1234");
        accountOverview.clickRegistrarse();
        test.log(Status.INFO, "Ingreso en el Usuario");
        Thread.sleep(1000);

        accountOverview.elegirCuenta();
        Thread.sleep(1000);

        accountOverview.clickPeriodo();
        accountOverview.clickPeriodoTodos();
        accountOverview.clickTipo();
        accountOverview.clickTipoTodos();
        test.log(Status.INFO, "Finaliza el Test");
    }


    @AfterEach
    public void endTest() throws InterruptedException {
        OverviewPage loginPage = new OverviewPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE RESUMEN DE CUENTA >>>");
    }
}




