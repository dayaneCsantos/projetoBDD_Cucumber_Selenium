package br.ce.wcaquino.runners;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/",
		glue = "br.ce.wcaquino.runners.steps",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		tags = {"@unitarios"},
		//tags= {"@tipo1", "@tipo2"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = true,
		strict = false)
public class RunnerTest {

}
