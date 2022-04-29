package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio8 {
		WebDriver driver;
		String url = "http://automationpractice.com";
		String driverPath = "..\\Seleniumclase\\DRIVERS\\chromedriver.exe";

@BeforeSuite
public void setUp() {
	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
}
 
@Test(dataProvider="Datos Login")
 
public void login(String mail, String password) {
	PaginaInicio inicio = new PaginaInicio(driver);
	inicio.clicEnSignIn();
	
	PaginaLogin login = new PaginaLogin(driver);
	login.escribirEmail(mail);
	login.escribirPassword(password);
	login.clicEnSignIn();
}
	/*
	 *      1) Método @DataProvider que
			provea los datos en formato Object[]
			[]
			2) Agregar las variables en el
			método @Test
			3) Relacionar el método @Test y
			@DataProvider por medio del
			parámetro dataProvider que debe
			tener el mismo valor que el name de
			la anotación @DataProvider
	
	 */
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		/*
		 * Matriz Bidimensional (Arreglo) = Datos
		 * correo1@correo.com		3re34t4wt
		 * correo2@correo.com		u76ru5ur
		 * micorreo0.28325844194589145@correo.com    1q2w3e4r5t

		 * */
		
		Object[][] datos = new Object[3][2];
		datos[0][0] = "correo1@correo.com";
		datos[0][1] = "3re34t4wt";
		
		datos[1][0] = "correo2@correo.com";
		datos[1][1] = "u76ru5ur";
		
		datos[2][0] = "micorreo0.28325844194589145@correo.com";
		datos[2][1] = "1q2w3e4r5t";
		
		return datos;
	}

	
}










