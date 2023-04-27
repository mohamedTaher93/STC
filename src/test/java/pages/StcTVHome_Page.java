package pages;

import elements.StcTVHome_Elements;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;
import steps.CommonSteps;
import java.util.List;
import java.util.Map;

public class StcTVHome_Page {
    private WebDriver driver;
    CommonSteps commonSteps;
    StcTVHome_Elements stcTVHome_elements;

    public StcTVHome_Page (BaseSteps baseSteps, CommonSteps commonSteps)
    {
        this.driver = baseSteps.getDriver();

        this.commonSteps = commonSteps;
        stcTVHome_elements = new StcTVHome_Elements(driver);
    }

    //Data
    String jawwyTvURL = "https://subscribe.jawwy.tv/eg-en";
    public void openJawwyTvWebsite()
    {
        commonSteps.navigateToUrl(jawwyTvURL);
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(stcTVHome_elements.jawwyTvLogo));

    }

    public void selectCountry(String country)
    {
        country = country.toLowerCase();
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(stcTVHome_elements.currentCountryButton));
        stcTVHome_elements.currentCountryButton.click();
        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(stcTVHome_elements.countriesList));

        switch (country)
        {
            case "egypt":
                stcTVHome_elements.egypt.click();
                break;
            case "uae":
                stcTVHome_elements.uae.click();
                break;
            case "algeria":
                stcTVHome_elements.algeria.click();
                break;
            case "djibouti":
                stcTVHome_elements.djibouti.click();
                break;
            case "chad":
                stcTVHome_elements.chad.click();
                break;
            case "iraq":
                stcTVHome_elements.iraq.click();
                break;
            case "jordan":
                stcTVHome_elements.jordan.click();
                break;
            case "lebanon":
                stcTVHome_elements.lebanon.click();
                break;
            case "morocco":
                stcTVHome_elements.morocco.click();
                break;
            case "oman":
                stcTVHome_elements.oman.click();
                break;
            case "tunisia":
                stcTVHome_elements.tunisia.click();
                break;
            case "yemen":
                stcTVHome_elements.yemen.click();
                break;
            case "palestine":
                stcTVHome_elements.palestine.click();
                break;
            default:
                System.out.printf("\n%s doesn't exist", country);
                Assert.fail();
                break;
        }

    }
    public Boolean checkPackagesTypes(List<String> packagesTypes) {

        for (String type : packagesTypes) {
            type = type.toLowerCase();
            switch (type) {
                case "lite":
                    try {
                        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(stcTVHome_elements.litePlan));
                    } catch (Exception e) {
                        System.out.println("Lite plan is not displayed");
                        return false;
                    }
                    break;


                case "classic":
                    try {
                        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(stcTVHome_elements.classicPlan));
                    }
                    catch (Exception e) {
                        System.out.println("Classic plan is not displayed");
                        return false;
                    }
                    break;

                case "premium":
                    try {
                        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(stcTVHome_elements.premiumPlan));
                    }
                    catch (Exception e) {
                        System.out.println("Premium plan is not displayed");
                        return false;
                    }
                    break;

                case "classicoffer":
                    try {
                        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(stcTVHome_elements.classicOffer));
                    }
                    catch (Exception e) {
                        System.out.println("Classic offer is not displayed");
                        return false;
                    }
                    break;
                default:
                    System.out.printf("\n%s doesn't exist", type);
                    Assert.fail();
                    break;
            }
        }
        return true;
    }

    public Boolean checkPackagesPrices(DataTable packagesPrices) {

        for (Map<String, String> data : packagesPrices.asMaps(String.class, String.class)) {
            String packageType = data.get("Package");
            String actualPlanPrice = "";
            String expectedPlanPrice = data.get("Price");
            packageType = packageType.toLowerCase();

            commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(stcTVHome_elements.litePlanPrice));
            switch (packageType) {
                case "lite":
                    actualPlanPrice = stcTVHome_elements.litePlanPrice.getText();
                    break;

                case "classic":
                    actualPlanPrice = stcTVHome_elements.classicPlanPrice.getText();
                    break;

                case "premium":
                    actualPlanPrice = stcTVHome_elements.premiumPlanPrice.getText();
                    break;

                case "classicoffer":
                    actualPlanPrice = stcTVHome_elements.classicOfferPrice.getText();
                    break;

                default:
                    System.out.printf("\n%s doesn't exist", packageType);
                    Assert.fail();
                    break;
            }
            if(!expectedPlanPrice.equals(actualPlanPrice))
            {
                System.out.printf("\nThe price of %s package is incorrect", packageType);
                System.out.printf("\nExpected price: %s but the actual price is: %s", expectedPlanPrice, actualPlanPrice);
                return false;
            }
        }
        return true;
    }
}
