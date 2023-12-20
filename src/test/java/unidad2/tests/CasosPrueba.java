package unidad2.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import unidad2.pages.HomePage;
import unidad2.pages.LoginPage;
import unidad2.pages.RegisterPage;
import unidad2.utils.DataDriven;
import unidad2.utils.PropertiesManager;

import java.util.ArrayList;

public class CasosPrueba {
    //Atributos
    WebDriver driver; //null
    ArrayList<String> data; //null
    //PAGE
    HomePage homePage; //null
    RegisterPage registerPage; //null
    LoginPage loginPage; // null

    String browser = PropertiesManager.obtenerProperty("browser");
    String propertyDriver = PropertiesManager.obtenerProperty("propertyDriver");
    String rutaDriver = System.getProperty("user.dir") + PropertiesManager.obtenerProperty("rutaDriver");
    String url = PropertiesManager.obtenerProperty("url");

    @BeforeEach
    public void preCondiciones(){
        data = new ArrayList<String>(); //ArrayList de tamaño 0
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
        data = DataDriven.prepararData("CP001_creacion_cta");
        homePage.IrARegistrarse();
        registerPage.crearCuenta(data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6), Integer.parseInt(data.get(7)),true,true);
        Assertions.assertEquals(data.get(8),homePage.obtenerNombreUsuario());
    }

    @Test
    public void CP002_iniciar_sesion(){
        data = DataDriven.prepararData("CP002_iniciar_sesion");
        homePage.IrAIniciarSesion();
        loginPage.iniciarSesion(data.get(1),data.get(2));
        Assertions.assertEquals(data.get(3),homePage.obtenerNombreUsuario());
    }

    @AfterEach
    public void posCondiciones(){
        homePage.cerrarPagina();
    }
}
