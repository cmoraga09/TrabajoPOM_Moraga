package unidad2.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import unidad2.pages.HomePage;
import unidad2.pages.LoginPage;
import unidad2.pages.RegisterPage;

public class CasosPrueba {
    //Atributos
    WebDriver driver; //null

    //PAGE
    HomePage homePage; //null
    RegisterPage registerPage; //null
    LoginPage loginPage; // null

    String browser = "chrome";
    String propertyDriver = "webdriver.chrome.driver";
    String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    String url = "https://open.spotify.com/";

    @BeforeEach
    public void preCondiciones(){
        homePage = new HomePage(driver);
        homePage.conexionDriver(rutaDriver,browser,propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        registerPage = new RegisterPage(homePage.getDriver());
        homePage.cargarPagina(url);
        homePage.prepararEsperas(10);
        homePage.maximizarVentana();
    }

    @Test
    public void CP001_creacion_cta(){
        homePage.IrARegistrarse();
        registerPage.crearCuenta("e4r53678@algo.com","adasdas12","Pobre Dgo","13","12","1991",0,true,true);
        Assertions.assertEquals("Pobre Dgo",homePage.obtenerNombreUsuario());
    }

    @Test
    public void CP002_iniciar_sesion(){
        homePage.IrAIniciarSesion();
        loginPage.iniciarSesion("e4587y87678@algo.com","adasdas12");
        Assertions.assertEquals("USer Test 001",homePage.obtenerNombreUsuario());
    }

    @AfterEach
    public void posCondiciones(){
        homePage.cerrarPagina();
    }
}
