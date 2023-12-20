package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class LoginPage extends ClaseBase {
    //Centralizar By
    By locatorUserName = By.id("login-username");
    By locatorPassword = By.id("login-password");
    By locatorIniciarSesionBoton = By.xpath("//button[@data-testid='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void iniciarSesion(String user,String pass){
        agregarTexto(esperarPorPresenciaElementoWeb(locatorUserName),user);
        esperarXSegundos(1000);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorPassword),pass);
        esperarXSegundos(3000);
        agregarCombinacionTeclado(locatorIniciarSesionBoton, Keys.ENTER);
        esperarXSegundos(1000);
    }
}
