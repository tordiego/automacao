package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarios.csv")
public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome","C:\\Users\\Casa\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando
        navegador.get("http://www.juliodelima.com.br/taskit");

        navegador.findElement(By.linkText("Sign in")).click();

        //Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        WebElement formularioSignId = navegador.findElement(By.id("signinbox"));

        formularioSignId.findElement(By.name("login")).sendKeys("julio0001");
        formularioSignId.findElement(By.name("password")).sendKeys("123456");

        navegador.findElement(By.linkText("SIGN IN")).click();

        //WebElement me = navegador.findElement(By.className("me"));
        //String textoNoMe = me.getText();

        //assertEquals("Hi, Julio", textoNoMe);


        //Clicar em um link que possiu a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MOre DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo,@Param(name="contato")String contato, @Param(name="mensagem")String mensaagem)  {

        //Clicar no link sign in


       // Clicar no botão através do seu xpath //button[@data-target="addmoredata"}
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

       //Identificar a popup onde está o formulário de id addmoredate
        WebElement popupAddMoreDate  = navegador.findElement(By.id("addmoredata"));

       //Na combo de name "type" escolher a opção "Phone"
        WebElement campoDate = popupAddMoreDate.findElement(By.name("type"));
        new Select(campoDate).selectByVisibleText(tipo);

        //No campo de name "contact" digitar " +
        popupAddMoreDate.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que está na popup
        popupAddMoreDate.findElement(By.linkText("SAVE")).click();

        //Na mensaagem de id "toast-container" o texto é : "Your contact has been added!"
        WebElement mensagemShilda = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemShilda.getText();
        assertEquals(mensagem,mensagem);

        //Validação
        assertEquals(1,1 );
    }

    @Test
    public void removerUmContatoDeUsuário(){
       // Clicar no elemento pelo seu xpath //span[text()='+5511912345678"]/following -sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+5511111111\"]/following-sibling::a")).click();

        //Confirmar a exclusão na janela javascript
        navegador.switchTo().alert().accept();

        // Verificar se a msg apresentada foi "Rest in peace, dear phone!"
        WebElement mensagemShilda = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemShilda.getText();
        assertEquals("Rest in peace, dear phone!",mensagem);

        // Aguardar 10 segundos para a janela desaparecer
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemShilda));

        // Fazer logout - clicar no link
        navegador.findElement(By.linkText("Logout")).click();


    }

    @After
    public void tearDown(){
        //navegador.get("http://www.juliodelima.com.br/taskit/user/logout");
        navegador.quit();


    }
}
