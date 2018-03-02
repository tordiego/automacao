package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcessandoSistemaTest {
    @Test
    public void testAcessarSistemaGem(){
        //Abrindo o navegador
        System.setProperty("WebDriver.chrome.driver","C\\Users\\Casa\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        //Acessando a página
        navegador.get("http://projetogem.ddns.net:99/csp/gem/menu/menu.csp");

        //Clicar e colocar o usuário
        //navegador.findElement(By.id("nome")).click();
        navegador.findElement(By.id("nome")).sendKeys("diego.torres");


        //Clicar e colocar a senha
        navegador.findElement(By.id("senha")).sendKeys("*P2154m*");

        //Clicar no botão login
        navegador.findElement(By.xpath("//input[@value=\"Login\"]")).click();

        assertEquals(1,1);
    }
}
