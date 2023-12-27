package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class HomePage extends ClaseBase {

    //Centralizar los BY
    private By locatorMyAccount =  By.xpath(" //span[@class='caret']");
    private By locatorRegister = By.xpath("//a[normalize-space()='Register']");
    private By locatorLogin = By.xpath("//a[normalize-space()='Login']");
    private By locatorProductoMac = By.xpath("//div[@class='image']//img[@title='MacBook']");


    //ACCIONES
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void IrAMyAccount(){
        click(esperarPorElementoAClickear(locatorMyAccount));
        esperarXSegundos(2000);
    }

    public void IrARegister(){
        click(esperarPorElementoAClickear(locatorRegister));
        esperarXSegundos(2000);
    }

    public void IrALogin(){
        click(esperarPorElementoAClickear(locatorLogin));
        esperarXSegundos(2000);
    }
    public void IrAProductoMac(){
        click(esperarPorElementoAClickear(locatorProductoMac));
        esperarXSegundos(2000);
    }

}
