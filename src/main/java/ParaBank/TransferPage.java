package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferPage extends BasePage {

    private By userName = By.name("username");
    private By password = By.name("password");
    private By btnLogIn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");

    private By transferFunds = By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a");
    private By textTrasnfer = By.xpath("//*[@id=\"showForm\"]/h1");
    private By amount = By.id("amount");
    private By desplegable1 = By.xpath("//*[@id=\"fromAccountId\"]");
    private By cuenta1 = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");
    private By desplegable2 = By.xpath("//*[@id=\"toAccountId\"]");
    private By cuenta2 = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    private By btnTransfer = By.xpath("//*[@id=\"transferForm\"]/div[2]/input");
    private By textTrasferOk = By.xpath("//*[@id=\"showResult\"]/h1");


    public TransferPage(WebDriver driver, WebDriverWait wait) {
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

    /** Hace click en "Transfer Funds".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTransferFunds() throws InterruptedException {
        this.click(transferFunds);
    }


    /** Obtiene el texto de "Transfer Funds" indicando el acceso a la seccion.
     * @return el texto del mensaje de "Transfer Funds"
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String accesoTransferenciaTexto() throws InterruptedException {
        String res = this.getText(textTrasnfer);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    /** Hace click en "Transfer Funds".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTransfer() throws InterruptedException {
        this.click(btnTransfer);
    }

    /** Ingresa un importe proporcionado en el campo de monto.
     * @param monto el importe a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirImporte(String monto) throws InterruptedException {
        this.sendText(monto, amount);
    }

    /** Hace click en el desplegable "From account".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickDesplegable1() throws InterruptedException {
        this.click(desplegable1);
    }

    /** Hace click en la primera cuenta del desplegable "From account".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickCuenta1Desplegable1() throws InterruptedException {
        this.click(cuenta1);
    }

    /** Hace click en el desplegable "to account".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickDesplegable2() throws InterruptedException {
        this.click(desplegable2);
    }

    /** Hace click en la segunda cuenta del desplegable "to account".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickCuenta2Desplegable2() throws InterruptedException {
        this.click(cuenta2);
    }
    /** Hace click en boton "Transfer".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickTransferOk() throws InterruptedException {
        this.click(btnTransfer);
    }

    /** Obtiene el texto de "Transfer Complete!" indicando la realizacion de la transferencia.
     * @return el texto del mensaje de "Transfer Complete!"
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String transferenciaTextoOk() throws InterruptedException {
        String res = this.getText(textTrasferOk);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

}
