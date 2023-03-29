package Step;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"Step"},
tags="",
plugin = {"pretty","junit:target/JUnitReports/report.xml",		
		"json:target/JSONReports/report.json",
		"html:target/HtmlReport/report.html"},monochrome = true)

public class Testrunner {	
}
