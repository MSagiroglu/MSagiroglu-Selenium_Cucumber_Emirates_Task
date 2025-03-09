package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.EmiratesHomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Emirates2 {
    EmiratesHomePage emirates = new EmiratesHomePage();
    Actions actions = new Actions(Driver.getDriver());
    WebElement secondDate;
    WebElement firstDate;
    Random random = new Random();

    @Given("User should choose first {string}")
    public void userShouldChooseFirst(String arg0) {
        ReusableMethods.waitForVisibility(emirates.acceptButton, 5);
        emirates.acceptButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForClickablility(emirates.xButton, 5);
        actions.click(emirates.xButton).perform();
        actions.sendKeys(arg0).perform();
        WebElement country = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown__link js-select-body js-location-link' and @aria-label[contains(., '" + arg0 + "')]]"));
        ReusableMethods.waitForVisibility(country, 5);
        actions.click(country).perform();
        ReusableMethods.wait(2);
    }

    @And("User should choose second {string}")
    public void userShouldChooseSecond(String arg0) {
        actions.sendKeys(arg0).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @And("User should choose flights {string}")
    public void userShouldChooseFlights(String arg0) {
        ReusableMethods.waitForVisibility(emirates.nextButton, 5);
        actions.click(emirates.nextButton).perform();
        firstDate = Driver.getDriver().findElement(By.xpath("(//td[@data-date='" + arg0 + "' and @data-month='3' and @data-year='2025']/button)[1]"));
        ReusableMethods.waitForClickablility(firstDate, 5);
        actions.click(firstDate).perform();
    }

    @And("User should choose return date {string}")
    public void userShouldChooseReturnDate(String arg0) {
        secondDate = Driver.getDriver().findElement(By.xpath("(//td[@data-date='" + arg0 + "' and @data-month='4' and @data-year='2025']/button)\n"));
        ReusableMethods.waitForClickablility(secondDate, 5);
        actions.click(secondDate).perform();
    }

      @And("User should choose {string} of Adult passenger")
    public void userShouldChooseOfAdultPassenger(String arg0) {
          ReusableMethods.waitForClickablility(emirates.oneAdult, 5);
          int number = Integer.parseInt(arg0);
          for (int i = 0; i < number; i++) {
              actions.click(emirates.oneAdult).perform();
          }
        
    }

    @And("User should choose {string} of child passengers")
    public void userShouldChooseOfChildPassengers(String arg0) {
        ReusableMethods.waitForClickablility(emirates.oneChildren, 5);
        int number = Integer.parseInt(arg0);
        for (int i = 0; i < number; i++) {
            actions.click(emirates.oneChildren).perform();
        }
    }

    @And("User should choose {string} of baby passengers")
    public void userShouldChooseOfBabyPassengers(String arg0) {
        ReusableMethods.waitForClickablility(emirates.oneBaby, 5);
        int number = Integer.parseInt(arg0);
        for (int i = 0; i < number; i++) {
            actions.click(emirates.oneBaby).perform();
        }
    }

    @And("User Should choose {string} of flight")
    public void userShouldChooseOfFlight(String arg0) {
        ReusableMethods.waitForClickablility(emirates.classButton, 5);
        actions.click(emirates.classButton).perform();
        WebElement selectoption = Driver.getDriver().findElement(By.xpath("//a[@role='option' and @data-dropdown-display='" + arg0 + "']"));
        ReusableMethods.waitForClickablility(selectoption, 5);
        actions.click(selectoption).perform();
    }
}
