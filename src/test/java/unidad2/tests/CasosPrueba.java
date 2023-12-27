package unidad2.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import unidad2.pages.*;
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
    AccountPage accountPage; //null
    ProductPage productPage;
    CheckOutPage checkOutPage;


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
        accountPage = new  AccountPage(homePage.getDriver());
        productPage = new ProductPage(homePage.getDriver());
        checkOutPage = new CheckOutPage(homePage.getDriver());
        homePage.cargarPagina(url);
        homePage.prepararEsperas(10);
        homePage.maximizarVentana();
    }

    @Test
    public void CP001_creacion_cta(){
        data = DataDriven.prepararData("CP001_creacion_cta");
        homePage.IrAMyAccount();
        homePage.IrARegister();
        registerPage.crearCuenta(data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6) );
        homePage.esperarXSegundos(2000);
        Assertions.assertEquals(data.get(7),registerPage.obtenerMensaje());
    }

    @Test
    public void CP002_validar_creacion_cuenta_antigua(){
        data = DataDriven.prepararData("CP002_validar_creacion_cuenta_antigua");
        homePage.IrAMyAccount();
        homePage.IrARegister();
        registerPage.crearCuenta(data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6) );
        homePage.esperarXSegundos(2000);
        Assertions.assertEquals(data.get(7),registerPage.obtenerMensajeAlerta());
    }
    @Test
    public void CP003_validar_login_correcto(){
        data = DataDriven.prepararData("CP003_validar_login_correcto");
        homePage.IrAMyAccount();
        homePage.IrALogin();
        loginPage.iniciarSesion(data.get(1),data.get(2));
        homePage.esperarXSegundos(2000);
        Assertions.assertEquals(data.get(3), accountPage.obtenerMensaje());
    }

    @Test
    public void CP004_agregar_producto_carro(){
        data = DataDriven.prepararData("CP004_agregar_producto_carro");
        homePage.IrAMyAccount();
        homePage.IrALogin();
        loginPage.iniciarSesion(data.get(1),data.get(2));
        homePage.esperarXSegundos(2000);
        accountPage.IrAHome();
        homePage.esperarXSegundos(2000);
        homePage.IrAProductoMac();
        homePage.esperarXSegundos(2000);
        productPage.AgregarACarro();
        homePage.esperarXSegundos(1000);
        Assertions.assertEquals(data.get(3),productPage.obtenerMensaje().substring(0,54));
    }

    @Test
    public void CP005_producto_carro_confirm_order(){
        data = DataDriven.prepararData("CP005_producto_carro_confirm_order");
        homePage.IrAMyAccount();
        homePage.IrALogin();
        loginPage.iniciarSesion(data.get(1),data.get(2));
        homePage.esperarXSegundos(1000);
        accountPage.IrACarro();
        homePage.esperarXSegundos(1000);
        accountPage.IrACheckout();
        homePage.esperarXSegundos(1000);
        checkOutPage.IrABillingBtnContinue();
        homePage.esperarXSegundos(1000);
        checkOutPage.IrACheckPayment();
        homePage.esperarXSegundos(1000);
        checkOutPage.IrAPaymentBtnContinue();
        homePage.esperarXSegundos(1000);
        checkOutPage.IrABtnConfirmOrder();
        homePage.esperarXSegundos(1000);
        Assertions.assertEquals(data.get(3),checkOutPage.obtenerMensaje());
    }


    @AfterEach
    public void posCondiciones(){
        homePage.cerrarPagina();
    }
}
