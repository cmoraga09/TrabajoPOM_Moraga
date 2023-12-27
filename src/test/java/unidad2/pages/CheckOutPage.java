package unidad2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import unidad2.utils.ClaseBase;

public class CheckOutPage extends ClaseBase {
    //Centralizar By
    By locatorBillingBtnContinue = By.xpath("//input[@id='button-payment-address']");
    By locatorCheckPayment = By.xpath("//input[@name='agree']");
    By locatorPaymentBtnContinue = By.xpath("//input[@id='button-payment-method']");
    By locatorBtnConfirmOrder = By.xpath("//input[@id='button-confirm']");
    By locatorMensajeActual = By.xpath("//h1[normalize-space()='Your order has been placed!']");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void IrABillingBtnContinue(){
        click(esperarPorElementoAClickear(locatorBillingBtnContinue));
        esperarXSegundos(2000);
    }

    public void IrACheckPayment(){
        click(esperarPorElementoAClickear(locatorCheckPayment));
        esperarXSegundos(2000);
    }

    public void IrAPaymentBtnContinue(){
        click(esperarPorElementoAClickear(locatorPaymentBtnContinue));
        esperarXSegundos(2000);
    }

    public void IrABtnConfirmOrder(){
        click(esperarPorElementoAClickear(locatorBtnConfirmOrder));
        esperarXSegundos(2000);
    }

    public String obtenerMensaje() {
        return  obtenerTexto(esperarPorPresenciaElementoWeb(locatorMensajeActual));

    }
}
