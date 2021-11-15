package reports;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features", //pasta /features do projeto
		glue = { "tests" }, //pacote /src/tests do projeto
		plugin = { "pretty",
				"json:target/cucumber-reports/Cucumber.json", 
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports" }, 
		monochrome = true)

//classe criada para a geração de relatório, com resultado dos testes após rodar os mesmos 
public class CucumberReport {

}
