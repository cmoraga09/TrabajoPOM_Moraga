package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class ProductPage extends ClaseBase {

    //Centralizar By

    By locatorBotonAddCart =  By.xpath("//button[@id='button-cart']");
    By locatorMensajeActual = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void AgregarACarro(){
        click(esperarPorElementoAClickear(locatorBotonAddCart));
        esperarXSegundos(2000);
    }

    public String obtenerMensaje() {
        return  obtenerTexto(esperarPorPresenciaElementoWeb(locatorMensajeActual));

    }
}
