package com.test.bean;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SumBeanTest {

	private WebDriver driver;
	private int invalidLinksCount;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:9080/HelloDynamic/");
	}

	@Test
	public void allPagesCheck() {

		// verify back link and click on it
		goToAddPageLinkCheck("go back");

	}

	/*
	 * @Test public void getFirstNumber() { System.out.println("FirstNumber::");
	 * 
	 * }
	 * 
	 * @Test public void getResult() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void getSecondNumber() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void setFirstNumber() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void setResult() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void setSecondNumber() { throw new
	 * RuntimeException("Test not implemented"); }
	 */private void goToAddPageLinkCheck(String expectedLinkText) {
		try {
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By
					.tagName("a"));
			System.out.println("Total no. of links are "
					+ anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						verifyURLStatus(url);
					} else {
						invalidLinksCount++;
					}
				}
				anchorTagElement.click();
			}

			System.out.println("Total no. of invalid links are "
					+ invalidLinksCount);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void verifyURLStatus(String URL) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			if (response.getStatusLine().getStatusCode() != 200) {
				invalidLinksCount++;
				Assert.fail("URL failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.close();
	}
}
