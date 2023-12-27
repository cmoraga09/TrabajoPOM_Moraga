package unidad2.pages;

import unidad2.utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RegisterPage extends ClaseBase {

    //Centralizar Localizadores

    By locatorFirstName = By.xpath("//input[@id='input-firstname']");
    By locatorLastName = By.xpath("//input[@id='input-lastname']");
    By locatorEmail = By.xpath("//input[@id='input-email']");
    By locatorTelephone = By.xpath("//input[@id='input-telephone']");
    By locatorPass = By.xpath("//input[@id='input-password']");
    By locatorPassConfirm = By.xpath("//input[@id='input-confirm']");
    By locatorAgree = By.xpath("//input[@name='agree']");
    By locatorBtnContinue = By.xpath("//input[@value='Continue']");

    By locatorMensaje = By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]");

    By locatorMensajeAlerta = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    //Funciones

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void crearCuenta (String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {

        agregarTexto(esperarPorPresenciaElementoWeb(locatorFirstName),firstName);
        esperarXSegundos(2000);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorLastName),lastName);
        esperarXSegundos(2000);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorEmail),email);
        esperarXSegundos(2000);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorTelephone),telephone);
        esperarXSegundos(2000);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorPass),password);
        esperarXSegundos(2000);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorPassConfirm),passwordConfirm);
        esperarXSegundos(2000);
        esperarPorElementoAClickear(locatorAgree).click();
        esperarXSegundos(1000);
        esperarPorElementoAClickear(locatorBtnContinue).click();
        esperarXSegundos(1000);
        //siguiente();

    }

    public String obtenerMensaje() {

        return  obtenerTexto(esperarPorPresenciaElementoWeb(locatorMensaje));
    }

    public String obtenerMensajeAlerta() {
        return  obtenerTexto(esperarPorPresenciaElementoWeb(locatorMensajeAlerta));
    }

}
