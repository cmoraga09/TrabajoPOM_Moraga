package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class LoginPage extends ClaseBase {
    //Centralizar By

    By locatorUserEmail = By.xpath("//input[@id='input-email']");
    By locatorPassword = By.xpath("//input[@id='input-password']");
    By locatorLoginBoton = By.xpath("//input[@value='Login']");
    By locatorMensajeActual = By.xpath("//h2[normalize-space()='My Account']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void iniciarSesion(String userEmail,String pass){
        agregarTexto(esperarPorPresenciaElementoWeb(locatorUserEmail),userEmail);
        esperarXSegundos(1000);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorPassword),pass);
        esperarXSegundos(3000);
        agregarCombinacionTeclado(locatorLoginBoton, Keys.ENTER);
        esperarXSegundos(1000);
    }

    public String obtenerMensaje() {
        return  obtenerTexto(esperarPorPresenciaElementoWeb(locatorMensajeActual));
    }
}
