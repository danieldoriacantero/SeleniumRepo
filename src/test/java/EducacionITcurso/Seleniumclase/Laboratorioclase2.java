// nombre del paquete donde esta el archivo
package EducacionITcurso.Seleniumclase;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



//inicio de la clase 
public class Laboratorioclase2 {

	String Chromedriverpath = "..\\Seleniumclase\\DRIVERS\\chromedriver.exe";
	String Firefoxdriverpath = "..\\Seleniumclase\\DRIVERS\\geckodriver.exe";
	String url = "http://automationpractice.com";
	
	
	WebDriver driver;
	// metodos
	@Test 
	 public void buscarpalabraChrome() {
		//paso 1 indicar donde esta nuestro driver .exe
		
		System.setProperty("webdriver.chrome.driver", Chromedriverpath);
		
		// paso 3 - abrir el navegador en la pagina que queremos probar
		driver = new ChromeDriver();
		driver.get(url);
		
		// paso 3- hacer las acciones propias de la prueba
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // escribir en el campo de texto
		txtBuscador.sendKeys(Keys.ENTER); // simular que presiono la tecla ENTER

	}
	@Test 
	 public void buscarpalabraFirefox() {
		//paso 1 indicar donde esta nuestro driver .exe
		
		System.setProperty("webdriver.gecko.driver", Firefoxdriverpath);
		
		// paso 3 - abrir el navegador en la pagina que queremos probar
		driver = new FirefoxDriver();
		driver.get(url);
		
		// paso 3- hacer las acciones propias de la prueba
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // escribir en el campo de texto
		txtBuscador.sendKeys(Keys.ENTER); // simular que presiono la tecla ENTER

	}
	
	
	
	
}
