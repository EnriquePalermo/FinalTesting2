package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPage extends BasePage {
    private By userName = By.name("username");
    private By password = By.name("password");
    private By btnLogIn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    private By textOverview = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");


    public OverviewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Ingresa el userName proporcionado en el campo de userName.
     * @param name el nombre a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, userName);
    }

    /** Ingresa el password proporcionado en el campo de userName.
     * @param pass el nombre a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirPassword(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }

    /** Hace click en el botón "Log In".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickRegistrarse() throws InterruptedException {
        this.click(btnLogIn);
    }

    /** Obtiene el texto del mensaje de "Balance..." indicando la creación de la cuenta.
     * @return el texto del mensaje de "Balance..."
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaTexto() throws InterruptedException {
        String res = this.getText(textOverview);
        System.out.println("Resultado Card value: " + res);
        return res;
    }


}