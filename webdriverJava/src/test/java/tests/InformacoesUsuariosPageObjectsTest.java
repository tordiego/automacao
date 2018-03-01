package tests;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class InformacoesUsuariosPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        new LoginPage(navegador)
                .clickSignIn()
                .fazerLogin("julio0001","123456")
                .clicarEmMe();

    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
