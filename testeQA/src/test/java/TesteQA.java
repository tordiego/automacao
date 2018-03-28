package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteQA {
    @Test
    public void testAcessarSistemaGem(){
        /* Abre um browser */
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

        //Clicar no link GEM
        navegador.findElement(By.xpath("//a[.=\"GEM\"]")).click();

        //Clicar na opção Avaliações
        navegador.findElement(By.id("open-btn21")).click();

        //Clicar na Comum Congregação
        navegador.findElement(By.id("igreja")).click();
        navegador.findElement(By.id("igreja")).sendKeys("LAS PALMAS");

        //Clicar no pesquisar
        navegador.findElement(By.xpath("//input[@id=\"button\"]")).click();

        //git

        assertEquals(1,1);
    }
}
