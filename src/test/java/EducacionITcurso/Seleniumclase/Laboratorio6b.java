package EducacionITcurso.Seleniumclase;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Laboratorio6b {
	String url = "http://automationpractice.com";
	String chromeDriverPath = "..\\Seleniumclase\\DRIVERS\\chromedriver.exe";
	WebDriver driver;
	File screen;
	String imagePath = "..\\Seleniumclase\\Evidencias\\";
	String docPath = "..\\Seleniumclase\\Evidencias\\CP_BuscarPalabra.docx";


	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		 
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() throws Exception {	
		CapturaEvidencia.escribirTituloEnDocumento(docPath, "Documento de Evidencias - CP Buscar Palabra", 18); 
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "Pantalla Principal");
	
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("shirt");
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "Palabra buscada");
		txtBuscador.sendKeys(Keys.ENTER);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "Pantalla final");
	}
}
