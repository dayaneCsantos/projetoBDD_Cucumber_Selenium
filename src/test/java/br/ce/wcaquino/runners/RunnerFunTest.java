package br.ce.wcaquino.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/",
		glue = "br.ce.wcaquino.runners.steps",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		tags = {"@funcionais"},
		//tags= {"@tipo1", "@tipo2"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false)
public class RunnerFunTest {

	@BeforeClass
	public static void reset() {
		
		WebDriver driver = new ChromeDriver();	
		driver.get("https://srbarriga.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("usuarioteste@gmail.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
		
	}
}
