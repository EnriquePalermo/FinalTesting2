package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage extends BasePage {
    private By userName = By.name("username");
    private By password = By.name("password");
    private By btnLogIn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    private By openNewAccount = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");
    private By typeAccount = By.xpath("//*[@id=\"type\"]");
    private By savigns = By.xpath("//*[@id=\"type\"]/option[2]");
    private By btnOpenNewAccount = By.cssSelector("input.button");
    private By textNexAccount = By.xpath("//*[@id=\"openAccountResult\"]/p[1]");

    public NewAccountPage(WebDriver driver, WebDriverWait wait) {
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

    /**
     * Hace click en el botón "Nueva Cuenta".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickNuevaCuenta() throws InterruptedException {
        this.click(openNewAccount);
    }

    /**
     * Hace click en el desplegable de cuenta.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickDesplegable() throws InterruptedException {
        this.click(typeAccount);
    }

    /**
     * Hace click savings.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickSavings() throws InterruptedException {
        this.click(savigns);
    }

    /**
     * Hace click OpenNewAccount.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickOpenNewAccount() throws InterruptedException {
        this.click(btnOpenNewAccount);
    }

    /** Obtiene el texto del mensaje de "Congratulations" indicando la creación de la cuenta.
     * @return el texto del mensaje de "Congratulations"
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaTexto() throws InterruptedException {
        String res = this.getText(textNexAccount);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

}