package ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phoneNumber = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By userName = By.id("customer.username");
    // private By email = By.id("email");
    private By password = By.id("customer.password");
    private By repeatedPassword = By.id("repeatedPassword");
    private By crearCuenta = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    private By btnRegistrarse = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    private By texto = By.xpath("//*[@id=\"rightPanel\"]/p");
    private By exito = By.className("txt-exito");
    private By mailRegister = By.className("form-feedback");
    private By passwordDis = By.className("small-feedback");

    /**Constructor de la clase RegisterPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Hace click en el botón "Crear Cuenta".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickCrearCuenta() throws InterruptedException {
        this.click(crearCuenta);
    }

    /** Ingresa el nombre proporcionado en el campo de nombre.
     * @param name el nombre a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, firstName);
    }

    /** Ingresa el apellido proporcionado en el campo de apellido.
     * @param name el apellido a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, lastName);
    }

    /** Ingresa la direccion proporcionado en el campo de direccion.
     * @param direccion la direccion a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirDireccion(String direccion) throws InterruptedException {
        this.sendText(direccion, address);
    }

    /** Ingresa la ciudad proporcionado en el campo de ciudad.
     * @param ciudad la ciudad a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirCiudad(String ciudad) throws InterruptedException {
        this.sendText(ciudad, city);
    }

    /** Ingresa el estado proporcionado en el campo de estado.
     * @param estado el estado a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirEstado(String estado) throws InterruptedException {
        this.sendText(estado, state);
    }

    /** Ingresa el zip proporcionado en el campo de zip.
     * @param zip el zip a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirZip(String zip) throws InterruptedException {
        this.sendText(zip, zipCode);
    }

    /** Ingresa el phone proporcionado en el campo de phone.
     * @param phone el phone a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirTelefono(String phone) throws InterruptedException {
        this.sendText(phone, phoneNumber);
    }

    /** Ingresa el ssn proporcionado en el campo de ssn.
     * @param sSn el ssn a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirSsn(String sSn) throws InterruptedException {
        this.sendText(sSn, ssn);
    }

    /** Ingresa el username proporcionado en el campo de username.
     * @param Uname el username a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirUserName(String Uname) throws InterruptedException {
        this.sendText(Uname, userName);
    }

    /** Ingresa la contraseña proporcionada en el campo de contraseña.
     * @param pass la contraseña a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }

    /** Reingresa la contraseña proporcionada en el campo de confirm.
     * @param pass la contraseña a reingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void repetirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, repeatedPassword);
    }

    /** Hace click en el botón "Registrarse".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickRegistrarse() throws InterruptedException {
        this.click(btnRegistrarse);
    }

    /** Obtiene el texto del mensaje de "Gracias" indicando la creación de la cuenta.
     * @return el texto del mensaje de "Gracias"
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaTexto() throws InterruptedException {
        String res = this.getText(texto);
        System.out.println("Resultado Card value: " + res);
        return res;
    }


}
