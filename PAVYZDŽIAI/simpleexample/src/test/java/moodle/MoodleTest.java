package moodle;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {
        "json:target/moodle/index.json",
        "html:target/moodle/index.html",
        "pretty"
}, features = {"classpath:moodle.feature"})
public class MoodleTest { }

