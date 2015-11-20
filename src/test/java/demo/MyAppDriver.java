package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MyAppDriver {

	private final WebDriver driver;
	private String query;

	public MyAppDriver() {
		driver = new FirefoxDriver();
	}

	public void open(String url) {
		driver.get(url);
	}

	public void search(String query) {
		this.query = query;
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(query);
		element.submit();
	}

	public void assertThatElementsAreFound() {
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(query);
			}
		});
		assertThat(driver.getTitle(), containsString(query));
	}

	public void closeApp() {
		driver.quit();
	}
}
