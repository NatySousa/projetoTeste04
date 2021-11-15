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
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarTipoDeContratacaoTest {

	WebDriver webdriver;

	@Dado("^Acessar a página de cadastro de tipo de contratação$")
	public void acessar_a_página_de_cadastro_de_tipo_de_contratação() {

		// configurando o driver para abrir o navegador
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// abrindo o navegador do googlechrome
		webdriver = new ChromeDriver();

		// maximizando o navegador
		webdriver.manage().window().maximize();

		// acessando a página de teste
		webdriver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio02");
	}

	@Dado("^Selecionar o funcionário \"([^\"]*)\"$")
	public void selecionar_o_funcionário(String funcionario) {

		// capturando o campo de selecão e definindo qual funcionário será selecionado
		Select select = new Select(webdriver.findElement(By.xpath("//*[@id=\"Funcionario\"]")));
		select.selectByVisibleText(funcionario);
	}

	@Dado("^Selecionar o tipo de contratação \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contratação(String tipocontratacao) {

		// capturando o campo de seleção
//e definindo qual tipo de contratação será selecionado
		Select select = new Select(webdriver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]")));
		select.selectByVisibleText(tipocontratacao);
	}

	@Quando("^Confirmar a realização do cadastro$")
	public void confirmar_a_realização_do_cadastro() {

		// clicar no botão de cadastro 'Salvar alterações'
		webdriver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Então("^Sistema exibe a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_a_mensagem(String mensagem) {

		// ler a mensagem exibida pelo sistema na página (resultado obtido)
		String resultado = webdriver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando o resultado obtido com o resultado esperado
		assertEquals(resultado, mensagem);

		try {
			File arquivo = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo,
					new File("c:\\evidencias_teste\\Tipo de Contratação cadastrado com sucesso.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Então("^Sistema informa que a seleção do funcionário é obrigatória$")
	public void sistema_informa_que_a_seleção_do_funcionário_é_obrigatória() {

		// ler a mensagem de erro exibida pelo sistema
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();

		// comparando o resultado obtido com o resultado esperado
		assertEquals(resultado, "Por favor, selecione o funcionário.");

		try {
			File arquivo = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo,
					new File("c:\\evidencias_teste\\Validação de campos obrigatórios.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Então("^Sistema informa que a seleção do tipo de contratação é obrigatória$")
	public void sistema_informa_que_a_seleção_do_tipo_de_contratação_é_obrigatória() {

		// ler a mensagem de erro exibida pelo sistema
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();

		// comparando o resultado obtido com o resultado esperado
		assertEquals(resultado, "Por favor, informe o tipo de contratação.");

		try {
			File arquivo = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo,
					new File("c:\\evidencias_teste\\Validação de campos obrigatórios.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
