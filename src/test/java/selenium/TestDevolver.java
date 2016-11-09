package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDevolver {

	@Test
	public void devolver(){
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://localhost:8090/Tienda/views/devolver.html");
	    
	    driver.findElement(By.id("devolver")).sendKeys("5");
	    driver.findElement(By.id("botonDevolver")).click();
	      
	    assertEquals("Pague sus dias de mora y devuelva la peli", driver.switchTo().alert().getText());
	}
}
