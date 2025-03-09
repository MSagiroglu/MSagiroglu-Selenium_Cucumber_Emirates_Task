package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EmiratesHomePage {
    public EmiratesHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (id = "onetrust-accept-btn-handler")
    public WebElement acceptButton;
    @FindBy(xpath = "//*[@id=\"search-flight-control\"]/section/div[4]/div[1]/div[1]/div/div[1]/div/div/div[1]/div/button")
    public WebElement xButton;
    @FindBy (id="field-040b1b23-3324-45bc-bcbb-3efbbd9fe89a")
    public WebElement firstCity;

    @FindBy(name = "Varış havalimanı")
    public WebElement secondCity;
    @FindBy(xpath = "(//button[@type='button' and contains(@class, 'js-increment-increase') and contains(@class, 'increment-field__button') and @aria-disabled='false'])[1]\n")
    public WebElement oneAdult;
    @FindBy(xpath = "(//button[@type='button' and contains(@class, 'js-increment-increase') and contains(@class, 'increment-field__button') and @aria-disabled='false'])[4]")
    public WebElement oneChildren;
    @FindBy(xpath = "(//button[@type='button' and contains(@class, 'js-increment-increase') and contains(@class, 'increment-field__button') and @aria-disabled='false'])[5]")
    public WebElement oneBaby;
    @FindBy(xpath = "//a[@href='javascript:void(0)' and contains(@class, 'js-drop-open') and contains(@class, 'dropdown__clear--toggle') and @name='toggle search-flight-class']\n")
    public WebElement classButton;
    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'cta--primary') and span[contains(text(), 'Uçuşları ara')]]")
    public WebElement searchButton;
    @FindBy(xpath = "(//button[@class='ek-datepicker__button ek-datepicker__button--next icon-arrow-right'])[1]")
    public WebElement nextButton;

}
