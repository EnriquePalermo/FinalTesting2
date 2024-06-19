package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountOverview extends BasePage{
        private By userName = By.name("username");
        private By password = By.name("password");
        private By btnLogIn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
        private By textOverview = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
        private By account = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
        private By textAccountDetails = By.xpath("//*[@id=\"accountDetails\"]/h1");
        private By desplegableActivity = By.id("month");
        private By ActivityAll = By.xpath("//*[@id=\"month\"]/option[1]");
        private By desplegableType = By.id("transactionType");
        private By typeAll = By.xpath("//*[@id=\"transactionType\"]/option[1]");

    public AccountOverview(WebDriver driver, WebDriverWait wait) {
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

    /** Hace click en una cuenta.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void elegirCuenta() throws InterruptedException {
        this.click(account);
    }

    /** Obtiene el texto de "Account Details" indicando que estamos en la pantalla adecuada
     * @return el texto del mensaje de "Account Details"
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaDetalleTexto() throws InterruptedException {
        String res = this.getText(textAccountDetails);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    /** Hace click en una Periodo.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickPeriodo() throws InterruptedException {
        this.click(desplegableActivity);
    }

    /** Hace elige el Periodo "TODOS".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickPeriodoTodos() throws InterruptedException {
        this.click(ActivityAll);
    }

    /** Hace click en una Tipo.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTipo() throws InterruptedException {
        this.click(desplegableType);
    }

    /** Hace elige el Periodo "TODOS".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTipoTodos() throws InterruptedException {
        this.click(typeAll);
    }

}
