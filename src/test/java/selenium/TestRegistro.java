package selenium;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRegistro {

	@Test
	public void AcontraseniasNoConcuerdan(){
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://localhost:8090/Tienda/views/sign-up.html");
	    driver.findElement(By.id("usuario")).sendKeys("jhon");
	    driver.findElement(By.id("pass")).sendKeys("abc");
	    driver.findElement(By.id("pass2")).sendKeys("abcc");
	    driver.findElement(By.id("botonRegistrar")).click();
	      
	    assertEquals("Las contraseñas dadas no concuerdan", driver.switchTo().alert().getText());
	}
	
	@Test
	public void BfaltaUsuario(){
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://localhost:8090/Tienda/views/sign-up.html");
	    driver.findElement(By.id("usuario")).sendKeys("");
	    driver.findElement(By.id("pass")).sendKeys("abc");
	    driver.findElement(By.id("pass2")).sendKeys("abc");
	    driver.findElement(By.id("botonRegistrar")).click();
	      
	    assertEquals("Llene todos los campos", driver.switchTo().alert().getText());
	}
	
	@Test
	public void CusuarioCorrecto(){
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://localhost:8090/Tienda/views/sign-up.html");
	    driver.findElement(By.id("usuario")).sendKeys("jhonatan");
	    driver.findElement(By.id("pass")).sendKeys("abc");
	    driver.findElement(By.id("pass2")).sendKeys("abc");
	    driver.findElement(By.id("botonRegistrar")).click();
	      
	    assertEquals("Usuario creado exitosamente", driver.switchTo().alert().getText());
	}
	
	@Test
	public void DusuarioRepetido(){
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://localhost:8090/Tienda/views/sign-up.html");
	    driver.findElement(By.id("usuario")).sendKeys("jhonatan");
	    driver.findElement(By.id("pass")).sendKeys("abc");
	    driver.findElement(By.id("pass2")).sendKeys("abc");
	    driver.findElement(By.id("botonRegistrar")).click();
	      
	    assertEquals("Este usuario ya se encuentra registrado", driver.switchTo().alert().getText());
	}
	
	
	
	
}
