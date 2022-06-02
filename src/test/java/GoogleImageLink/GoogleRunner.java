package GoogleImageLink;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/GoogleSearch.feature",glue= {"GoogleImageLink"},
monochrome = true,
plugin={"pretty","junit:target/JunitReports/report.xml",
		"json:target/Jenkin/googleimagereport.json",
		"html:target/Jenkin/googleimagereport.html"},
tags="@smoketest"
)

public class GoogleRunner {

}
