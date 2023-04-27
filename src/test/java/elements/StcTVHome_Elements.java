package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StcTVHome_Elements {
    WebDriver driver;
    @FindBy(id = "jawwy-logo-web") public WebElement jawwyTvLogo;
    @FindBy(className = "country-current") public WebElement currentCountryButton;
    @FindBy(id = "country-selct") public WebElement countriesList;
    @FindBy(id = "eg") public WebElement egypt;
    @FindBy(id = "ae") public WebElement uae;
    @FindBy(id = "dz") public WebElement algeria;
    @FindBy(id = "dj") public WebElement djibouti;
    @FindBy(id = "td") public WebElement chad;
    @FindBy(id = "iq") public WebElement iraq;
    @FindBy(id = "jo") public WebElement jordan;
    @FindBy(id = "lb") public WebElement lebanon;
    @FindBy(id = "ma") public WebElement morocco;
    @FindBy(id = "om") public WebElement oman;
    @FindBy(id = "tn") public WebElement tunisia;
    @FindBy(id = "ye") public WebElement yemen;
    @FindBy(id = "ps") public WebElement palestine;
    @FindBy(id = "name-lite") public WebElement litePlan;
    @FindBy(id = "name-classic") public WebElement classicPlan;
    @FindBy(id = "name-premium") public WebElement premiumPlan;
    @FindBy(xpath = "//div[@class = 'giftcard small trial-card']") public WebElement classicOffer;
    @FindBy(id = "currency-lite") public WebElement litePlanPrice;
    @FindBy(id = "currency-classic") public WebElement classicPlanPrice;
    @FindBy(id = "currency-premium") public WebElement premiumPlanPrice;
    @FindBy(xpath = "//div[@class = 'trial-cost']/b/..") public WebElement classicOfferPrice;

    public StcTVHome_Elements (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
