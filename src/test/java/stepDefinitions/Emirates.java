package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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

public class Emirates {
    EmiratesHomePage emirates = new EmiratesHomePage();
    Actions actions = new Actions(Driver.getDriver());
    WebElement secondDate;
    WebElement firstDate;

    @Given("User should choose first city")
    public void userShouldChooseFirstCity() {
        ReusableMethods.waitForVisibility(emirates.acceptButton, 5);
        emirates.acceptButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForClickablility(emirates.xButton, 5);
        actions.click(emirates.xButton).perform();
        actions.sendKeys("Dubai").perform();
        WebElement country = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown__link js-select-body js-location-link' and @aria-label[contains(., 'Dubai')]]"));
        ReusableMethods.waitForVisibility(country,5);
        actions.click(country).perform();
        ReusableMethods.wait(2);


    }

    @And("User should choose second city")
    public void userShouldChooseSecondCity() {
        actions.sendKeys("İstanbul").perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @And("User should choose flights dates")
    public void userShouldChooseFlightsDates() {
        secondDate = Driver.getDriver().findElement(By.xpath("(//div[contains(@class, 'ek-datepicker__column')][2]/table/tbody/tr[3]/td[3]/button)[1]"));
        firstDate = Driver.getDriver().findElement(By.xpath("(//div[contains(@class, 'ek-datepicker__column')][1]/table/tbody/tr[3]/td[3]/button)[1]"));
        ReusableMethods.waitForClickablility(firstDate, 5);
        actions.click(firstDate).perform();
        ReusableMethods.waitForClickablility(secondDate, 5);
        actions.click(secondDate).perform();

    }

    @And("Uer should choose number of passengers")
    public void uerShouldChooseNumberOfPassengers() {
        ReusableMethods.waitForClickablility(emirates.oneAdult, 5);
        int number;
        Random random = new Random();
        number = random.nextInt(1,4);
        for (int i = 0; i < number; i++) {
            actions.click(emirates.oneAdult).perform();
        }
        number = random.nextInt(4);
        for (int i = 0; i < number; i++) {
            actions.click(emirates.oneChildren).perform();
        }
        number = random.nextInt(3);
        for (int i = 0; i < number; i++) {
            actions.click(emirates.oneBaby).perform();
        }
    }

    @And("User Should choose class of flight")
    public void userShouldChooseClassOfFlight() {
        ReusableMethods.waitForClickablility(emirates.classButton, 5);
        actions.click(emirates.classButton).perform();
        List<String> options = new ArrayList<>();
        options.add("Economy Class");
        options.add("Business Class");
        options.add("First Class");
        options.add("Premium Economy");
        Random random = new Random();
        int index = random.nextInt(options.size());
        String selectedOption = options.get(index);
        WebElement selectoption = Driver.getDriver().findElement(By.xpath("//a[@role='option' and @data-dropdown-display='" + selectedOption + "']"));
        ReusableMethods.waitForClickablility(selectoption, 5);
        actions.click(selectoption).perform();


    }

    @When("User should click on search button")
    public void userShouldClickOnSearchButton() {
        ReusableMethods.waitForClickablility(emirates.searchButton, 5);
        actions.click(emirates.searchButton).perform();
    }

    @Then("User should see available flights for correct dates")
    public void userShouldSeeAvailableFlightsForCorrectDates() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Arama Sonuçları | Emirates Türkiye";
        Assert.assertEquals( expectedTitle,actualTitle);
        System.out.println("User has successfully found available flights for the given dates.");
    }

}
