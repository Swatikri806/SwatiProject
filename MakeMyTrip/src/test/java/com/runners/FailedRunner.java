package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"stepDefinition","hook"},
                 features= {"@target/rerun.txt"},
                 plugin={"rerun:target/rerun.txt",
		                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                		})

public class FailedRunner extends AbstractTestNGCucumberTests{

}
