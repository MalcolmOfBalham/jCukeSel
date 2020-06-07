package com.jcukesel.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.jcukesel.demo")
public class CucumberConfiguration {

	@Bean
	@Scope("cucumber-glue")
	public WebDriver getDriver(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/malco/dev/tools/webdriver/chromedriver.exe");
		return new ChromeDriver();
	}

}
