package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class HomePage extends ClaseBase {

    //Centralizar los BY
    private By localizadorRegistrarte = By.xpath("//button[contains(text(),'Reg')]");
    private By localizadorIniciarSesion = By.xpath("//button[@data-testid='login-button']");
    private By locatorUsername = By.xpath("//button[@data-testid='user-widget-link']");


    //ACCIONES
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void IrARegistrarse(){
        click(esperarPorElementoAClickear(localizadorRegistrarte));
    }

    public void IrAIniciarSesion(){
        click(esperarPorElementoAClickear(localizadorIniciarSesion));
    }

    public String obtenerNombreUsuario() {
        return obtenerAtributoAriaLabel(esperarPorPresenciaElementoWeb(locatorUsername));
    }
}
