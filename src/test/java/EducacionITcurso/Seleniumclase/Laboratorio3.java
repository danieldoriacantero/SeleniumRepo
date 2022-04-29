package EducacionITcurso.Seleniumclase;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	
	String Url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String Chromedriverpath = "..\\Seleniumclase\\DRIVERS\\chromedriver.exe";
	WebDriver driver;
	
	@Test
	
	public void registrarUsuario() 
	{
	       
		System.setProperty("webdriver.chrome.driver", Chromedriverpath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito "); // abrir navegador en modo incognito
		
		
		/* Opciones de Chrome  Chrome options
		 * - incognito
		 * - start-maximized
		 * - headless
		*/
		driver = new ChromeDriver(options);
		 
		driver.get(Url); // abrir navegador de chrome
		driver.manage().window().maximize(); // maximizar pantalla para probar
		driver.manage().deleteAllCookies(); // borrar las cookies 
		
		
		// ingresar el correo y hacer clic en el boton Create Account
		driver.findElement(By.id("email_create")).sendKeys("micorreo"+ Math.random() +"@correo.com");// sendKeys("micorreo"+ Math.random() +"correo.com") es para que se valla generando un mail aleatorio de prueba
		driver.findElement(By.name("SubmitCreate")).click();		
		
		//cuando la pagina necesita esperar hay que usar un tiempo de espera 
		//idealmente entre pagina y pagina
		//espera para capturar la transicion de pagina 
		//espera expliciuta
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		
		//Completar formulario y hacer click en el boton 
		
		driver.findElement(By.cssSelector("#id_gender1")).click();//Title
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Patricio"); //Nombre
		driver.findElement(By.id("customer_lastname")).sendKeys("Romero"); //Apellido
		driver.findElement(By.name("passwd")).sendKeys("1a2b3c"); // Password
		
		Select dia = new Select(driver.findElement(By.cssSelector("#days")));
		dia.selectByValue("18"); // seleccionar dia de nacimiento
		
		Select mes = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		mes.selectByVisibleText("June ");// mes de nacimiento
		
		Select anio = new Select(driver.findElement(By.id("years")));  
		anio.selectByIndex(20); // año de nacimiento 
		
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click(); // check box Sing up...
		driver.findElement(By.cssSelector("#optin")).click();//check box receive especial offers from ....
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("MiDireccion 1254 5c"); //Direccion Address
		driver.findElement(By.id("city")).sendKeys("BuenosAires"); //Ciudad city
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Florida"); // estado
		
		driver.findElement(By.name("postcode")).sendKeys("55565"); // Codigo postal
		
		Select pais = new Select(driver.findElement(By.cssSelector("#id_country")));
		pais.selectByValue("21"); // pais
		
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("4545454545"); // Telefono 
		
		WebElement alias= driver.findElement(By.id("alias"));
		alias.clear();
		alias.sendKeys("MyCasa");
		
	   	driver.findElement(By.name("submitAccount")).click();
	   	
		
		
		
	}
	
	

}
