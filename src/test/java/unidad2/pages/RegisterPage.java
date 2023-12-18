package unidad2.pages;

import unidad2.utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends ClaseBase {

    //Centralizar Localizadores
    By locatorTxtUsername = By.id("username");

    By locatorBtnCerrarPopUp = By.xpath("//button[@aria-label='Cerrar']");

    By locatorBtnSiguiente = By.xpath("//button[@data-testid='submit']");

    By locatorTxtPass = By.id("new-password");

    By locatorTxtNickname = By.id("displayName");

    By locatorTxtDia = By.xpath("//input[@id='day']");

    By locatorDDLMes = By.xpath("//select[@id='month']");

    By locatorTxtAnnio = By.xpath("//input[@id='year']");

    By locatorOptionGender = By.xpath("//label[contains(@for,'gender')]");

    By locatorCheck = By.xpath("//label[contains(@for,'checkbox')]");

    //Funciones

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarDia(String dia){
        agregarTexto(esperarPorPresenciaElementoWeb(locatorTxtDia),dia);
    }

    public void siguiente(){
        esperarXSegundos(2000);
        click(locatorBtnSiguiente);
    }

    public void crearCuenta(String email,String pass,String nick,String dia,String mes,String annio,int genero,boolean checkPriv,boolean checkEnvioInfo) {
        if(estaDesplegado(esperarPorPresenciaElementoWeb(locatorBtnCerrarPopUp))){
            click(locatorBtnCerrarPopUp);
        }
        agregarTexto(esperarPorPresenciaElementoWeb(locatorTxtUsername),email);
        siguiente();
        if(estaDesplegado(esperarPorPresenciaElementoWeb(locatorBtnCerrarPopUp))){
            click(locatorBtnCerrarPopUp);
        }
        agregarTexto(esperarPorPresenciaElementoWeb(locatorTxtPass),pass);
        siguiente();
        if(estaDesplegado(esperarPorPresenciaElementoWeb(locatorBtnCerrarPopUp))){
            click(locatorBtnCerrarPopUp);
        }
        agregarTexto(esperarPorPresenciaElementoWeb(locatorTxtNickname),nick);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorTxtDia),dia);
        selecionarComboBoxPorValue(esperarPorPresenciaElementoWeb(locatorDDLMes), mes);
        agregarTexto(esperarPorPresenciaElementoWeb(locatorTxtAnnio),annio);
        List<WebElement> generos = buscarElementosWeb(locatorOptionGender);
        click(generos.get(genero));
        click(esperarPorElementoAClickear(locatorBtnSiguiente));
        List<WebElement> checks = buscarElementosWeb(locatorCheck);

        if(checkPriv){
            click(checks.get(0));
        }

        if(checkEnvioInfo){
            click(checks.get(1));
        }
        click(esperarPorElementoAClickear(locatorBtnSiguiente)); //Registrate
    }


}
