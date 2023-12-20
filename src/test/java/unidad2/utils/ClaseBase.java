package unidad2.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClaseBase {
    //Wrapper de selenium (envoltorio)
    //invocar a las funciones de selenium (click, sendKeys, getText, etc)

    //Atributos
    WebDriver driver;
    WebDriverWait wait;

    //Métodos
    public ClaseBase(WebDriver driver){
        this.driver = driver;
    }

    //Métodos que envuelvan las acciones del driver
    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return this.driver.findElements(localizador);
    }

    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }


    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void agregarTexto(By localizador,String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento,String texto){
        elemento.sendKeys(texto);
    }

    public void agregarCombinacionTeclado(By localizador, Keys keys){
        this.driver.findElement(localizador).sendKeys(keys);
    }

    public void maximizarVentana(){
        this.driver.manage().window().maximize();
    }

    public void selecionarComboBoxPorTextoVisible(By localizador,String texto){
        Select select = new Select(driver.findElement(localizador));
        select.selectByVisibleText(texto);
    }

    public void selecionarComboBoxPorTextoVisible(WebElement elemento,String texto){
        Select select = new Select(elemento);
        select.selectByVisibleText(texto);
    }

    public void selecionarComboBoxPorValue(By localizador,String value){
        Select select = new Select(driver.findElement(localizador));
        select.selectByVisibleText(value);
    }

    public void selecionarComboBoxPorValue(WebElement elemento,String value){
        Select select = new Select(elemento);
        select.selectByValue(value);
    }

    public void irAFramePorId(String id){
        this.driver.switchTo().frame(id);
    }

    public void cargarPagina(String url){
        this.driver.get(url);
    }

    public void cerrarPagina(){
        this.driver.quit();
    }

    public void refrescarPagina(){
        this.driver.navigate().refresh();
    }

    public void esperarXSegundos(int tiempoMili){
        try {
            Thread.sleep(tiempoMili);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement esperarPorElementoAClickear(By localizador){
        wait = new WebDriverWait(driver,8);
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public WebElement esperarPorPresenciaElementoWeb(By localizador){
        wait = new WebDriverWait(driver,8);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public boolean estaDesplegado(WebElement elemento){
        try {
            return elemento.isDisplayed();
        }catch (Exception ex){
            System.out.println("No pille el elemento. Detalle Error: "+ex.getStackTrace());
            return false;
        }
    }

    public void prepararEsperas(int segundos){
        this.driver.manage().timeouts().implicitlyWait(segundos,TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(segundos,TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(segundos,TimeUnit.SECONDS);
    }

    public WebDriver conexionDriver(String rutaDriver,String browser,String propertyDriver){
        switch (browser){//firefox
            case "firefox":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new EdgeDriver();
                break;
            default:
                this.driver = null;
        }
        return driver;

    }

    public String obtenerAtributoAriaLabel(By localizador){
        return driver.findElement(localizador).getAttribute("aria-label");
    }

    public String obtenerAtributoAriaLabel(WebElement elemento){
        return elemento.getAttribute("aria-label");
    }

    public void submitForm(WebElement elemento){
        elemento.submit();
    }
}
