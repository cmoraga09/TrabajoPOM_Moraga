package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class AccountPage extends ClaseBase {

    //Centralizar By
    By locatorMensajeActual = By.xpath("//h2[normalize-space()='My Account']");
    By locatorHome = By.xpath("//i[@class='fa fa-home']");
    By locatorBtnCarro = By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
    By locatorCheckOut = By.xpath("//strong[normalize-space()='Checkout']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void IrAHome(){
        click(esperarPorElementoAClickear(locatorHome));
        esperarXSegundos(2000);
    }
    public String obtenerMensaje() {
        return  obtenerTexto(esperarPorPresenciaElementoWeb(locatorMensajeActual));
    }
    public void IrACarro(){
        click(esperarPorElementoAClickear(locatorBtnCarro));
        esperarXSegundos(2000);
    }

    public void IrACheckout(){
        click(esperarPorElementoAClickear(locatorCheckOut));
        esperarXSegundos(2000);
    }

}
