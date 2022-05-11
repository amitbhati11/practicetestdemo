package Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@ RunWith(Cucumber.class)
@ CucumberOptions(features="src/test/resources", glue= {"Cucumber"},
plugin= {"pretty","json:JSONReport/report.json","junit:JunitReport/report.xml","html:HTMLReport/report.html"}
,tags="@smoke or @sanity or @Regression")

public class CucumberRunner {

}
