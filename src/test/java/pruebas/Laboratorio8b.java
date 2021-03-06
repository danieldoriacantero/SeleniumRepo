package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio8b {
	String url = "https://demoqa.com/alerts";
	String driverPath = "..\\Seleniumclase\\DRIVERS\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alerta1() {
		// Clic en el boton
		driver.findElement(By.id("alertButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
	}
	
	@Test
	public void alerta2() {
		driver.findElement(By.id("timerAlertButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept(); 
	}
	
	@Test
	public void alerta3() {
		driver.findElement(By.id("confirmButton")).click();
		
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void alerta4() {
		driver.findElement(By.id("promtButton")).click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Clase de Automatizacion");
		alerta.accept();
	}

}
