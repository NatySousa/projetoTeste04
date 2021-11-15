package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class CadastrarTipoDeContratacaoTest {

	WebDriver webdriver;

	@Dado("^Acessar a p�gina de cadastro de tipo de contrata��o$")
	public void acessar_a_p�gina_de_cadastro_de_tipo_de_contrata��o() {

		// configurando o driver para abrir o navegador
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// abrindo o navegador do googlechrome
		webdriver = new ChromeDriver();

		// maximizando o navegador
		webdriver.manage().window().maximize();

		// acessando a p�gina de teste
		webdriver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio02");
	}

	@Dado("^Selecionar o funcion�rio \"([^\"]*)\"$")
	public void selecionar_o_funcion�rio(String funcionario) {

		// capturando o campo de selec�o e definindo qual funcion�rio ser� selecionado
		Select select = new Select(webdriver.findElement(By.xpath("//*[@id=\"Funcionario\"]")));
		select.selectByVisibleText(funcionario);
	}

	@Dado("^Selecionar o tipo de contrata��o \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contrata��o(String tipocontratacao) {

		// capturando o campo de sele��o
//e definindo qual tipo de contrata��o ser� selecionado
		Select select = new Select(webdriver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]")));
		select.selectByVisibleText(tipocontratacao);
	}

	@Quando("^Confirmar a realiza��o do cadastro$")
	public void confirmar_a_realiza��o_do_cadastro() {

		// clicar no bot�o de cadastro 'Salvar altera��es'
		webdriver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Ent�o("^Sistema exibe a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_a_mensagem(String mensagem) {

		// ler a mensagem exibida pelo sistema na p�gina (resultado obtido)
		String resultado = webdriver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando o resultado obtido com o resultado esperado
		assertEquals(resultado, mensagem);

		try {
			File arquivo = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo,
					new File("c:\\evidencias_teste\\Tipo de Contrata��o cadastrado com sucesso.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ent�o("^Sistema informa que a sele��o do funcion�rio � obrigat�ria$")
	public void sistema_informa_que_a_sele��o_do_funcion�rio_�_obrigat�ria() {

		// ler a mensagem de erro exibida pelo sistema
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();

		// comparando o resultado obtido com o resultado esperado
		assertEquals(resultado, "Por favor, selecione o funcion�rio.");

		try {
			File arquivo = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo,
					new File("c:\\evidencias_teste\\Valida��o de campos obrigat�rios.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ent�o("^Sistema informa que a sele��o do tipo de contrata��o � obrigat�ria$")
	public void sistema_informa_que_a_sele��o_do_tipo_de_contrata��o_�_obrigat�ria() {

		// ler a mensagem de erro exibida pelo sistema
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();

		// comparando o resultado obtido com o resultado esperado
		assertEquals(resultado, "Por favor, informe o tipo de contrata��o.");

		try {
			File arquivo = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo,
					new File("c:\\evidencias_teste\\Valida��o de campos obrigat�rios.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
