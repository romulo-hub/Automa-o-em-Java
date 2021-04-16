package Testes;

import static org.junit.Assert.*;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class acessarPagina {

    WebDriver driver;
    @Test


    @Dado("Que eu acesso a pagina")
    public void Que_eu_acesso_a_pagina(){
        System.setProperty("webdriver.chrome.driver","chromedriver");

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme_v4");
        driver.findElement(By.id("switch-version-select")).click();
        driver.findElement(By.id("switch-version-select")).sendKeys(Keys.PAGE_DOWN, Keys.ENTER);
        driver.findElement(By.className(("btn btn-default btn-outline-dark"))).click();

    }
    @Test
    @Quando("Eu preencho os campos do formulario")
    public void Eu_preencho_os_campos_do_formulario(){
        driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Romulo Cristiver");
        driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil,3970");
        driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
        driver.findElement(By.id("field-country")).sendKeys("Brasil");
        driver.findElement(By.className("chosen-single chosen-single-with-deselect chosen-default")).click();
        driver.findElement(By.className("chosen-search")).sendKeys("Fixter" + Keys.ENTER);
        driver.findElement(By.id("field-creditLimit")).sendKeys("200");
        driver.findElement(By.id("form-button-save")).click();

    }

    @Test
    @E("Valido a mensagem")
    public void E_valido_a_menssagem(){
        String menssagem = driver.findElement(By.id("report-success")).getText();
        assertEquals("Your data has been successfully stored into the database. EditCustomerorGoback to list", menssagem);
    }

    @Test
    @Entao("Fexar a pagina")
    public void Fexar_a_pagina(){
        driver.quit();

    }


}
