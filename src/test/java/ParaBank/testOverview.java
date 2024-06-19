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
import reportes.ReportFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static reportes.ReportFactory.captureScreenshot;

@Tag("LOGIN")
public class testOverview {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Overview-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void run() {
        System.out.println("<<< COMIENZAN LOS TEST DE RESUMEN DE CUENTA >>>");
        ExtentSparkReporter spark = new ExtentSparkReporter("reportes/Overview-Test.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeEach
    public void precondiciones() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        OverviewPage loginPage = new OverviewPage(driver, wait);
        loginPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("RESUMEN")
    @Tag("EXITOSO")
    public void test_LogueoExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Resumen Cuenta Exitoso");
        test.log(Status.INFO, "Comienza el Test");

        OverviewPage overviewPage = new OverviewPage(driver, wait);
        try {
            overviewPage.escribirNombre("1234");
            overviewPage.escribirPassword("1234");
            overviewPage.clickRegistrarse();
            test.log(Status.INFO, "Ingreso en el Usuario");


            if (overviewPage.cuentaCreadaTexto().equals("*Balance includes deposits that may be subject to holds")) {
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
