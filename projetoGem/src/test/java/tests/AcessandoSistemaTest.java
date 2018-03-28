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

        /* Acessa a página de cálculo da média do aluno*/


        /* Limpa os campos de texto que recebem os dados do aluno */


        /* Preenche o campo de texto referente a 1ª avaliação */
        navegador.findElement(By.id("avaliacao1")).sendKeys("10");


        /* Preenche o campo de texto referente ao 2ª avaliação */
        navegador.findElement(By.id("avaliacao2")).sendKeys("10");


        /* Preenche o campo de texto referente ao trabalho */
        navegador.findElement(By.id("trabalho")).sendKeys("10");


        /* Submete o formulário para o cálculo da média*/
        navegador.findElement(By.id("calculo")).click();


        /* Retorna a mensagem exibida pelo sistema */


        /* Fecha um browser */
    }
}
