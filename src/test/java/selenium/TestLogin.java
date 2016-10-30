package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLogin {
	
	@Test
	public void AloginFallido(){
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://localhost:8090/Tienda/views/login.html");
	    
	    driver.findElement(By.id("usuario")).sendKeys("usuarioExistente");
	    driver.findElement(By.id("pass")).sendKeys("1");
	    driver.findElement(By.id("botonIngresar")).click();
	      
	    assertEquals("Usuario y/o contraseña incorrecto", driver.switchTo().alert().getText());
	}
	
	@Test
	public void AloginCorrecto(){
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://localhost:8090/Tienda/views/login.html");
	    
	    driver.findElement(By.id("usuario")).sendKeys("usuarioExistente");
	    driver.findElement(By.id("pass")).sendKeys("1234");
	    driver.findElement(By.id("botonIngresar")).click();
	      
	    assertEquals("Bienvenido", driver.switchTo().alert().getText());
	}
	
}
