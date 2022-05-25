package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.Base;

public class Courses extends Base {
	By search = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input");
	By button = By.xpath(
			"//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div");
	By apply = By.xpath("//span[text()='Apply']");
	By Beginner = By.xpath("//span[text()='Beginner']");
	By more = By.xpath("(//span[text()='Show more'])[4]");
	By english = By.xpath("//span[text()='English']");
	By name = By.xpath("//a/div/div[2]/h2");
	By rating = By.className("ratings-text");

	public void find() throws InterruptedException, IOException {
		exttest = report.createTest("Display two courses for beginner Web Development. ");
		wait(30, search);
		driver.findElement(search).sendKeys("Web Development");
		driver.findElement(button).click();
		wait(30, Beginner);
		driver.findElement(Beginner).click();
		exttest.log(Status.PASS, "Beginners selected Successfully");
		driver.findElement(more).click();
		wait(30, english);
		driver.findElement(english).click();
		driver.findElement(apply).click();
		exttest.log(Status.PASS, "English selected Successfully");
		Thread.sleep(5000);
		wait(30, name);
		System.out.println("");
		System.out.println("The courses and their ratings are: ");
		System.out.println("");
		List<WebElement> names = driver.findElements(name);
		List<WebElement> ratings = driver.findElements(rating);
		for (int j = 0; j < 2; ++j) {
			System.out.println(names.get(j).getText() + " - " + ratings.get(j).getText());
		}
		exttest.log(Status.PASS, "Couses are displayed Successfully");
		Thread.sleep(3000);
	}
}
