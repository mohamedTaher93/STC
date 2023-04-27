package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.StcTVHome_Page;
import java.util.List;

public class StcTVHome_steps {
    StcTVHome_Page stcTVHomePageHomePage;

    public StcTVHome_steps(StcTVHome_Page stcTVHomePageHomePage)
    {
        this.stcTVHomePageHomePage = stcTVHomePageHomePage;
    }
    @Given("I open jawwy tv website")
    public void IOpenJawwyTvWebsite() {
        System.out.println("I open jawwy tv website");
        stcTVHomePageHomePage.openJawwyTvWebsite();
    }
    @Given("I select {string}")
    public void ISelectCountry(String country) {
        System.out.println("I select country");
        stcTVHomePageHomePage.selectCountry(country);
    }

    @Then("^Verify the following packages types displayed correctly$")
    public void VerifyThePackagesTypesDisplayedCorrectly(DataTable packagesTypes)
    {
        System.out.println("Verify the packages types displayed correctly");
        List<String> packagesTypesList = packagesTypes.asList(String.class);
        Assert.assertTrue("Packages types are not displayed on the Home page", stcTVHomePageHomePage.checkPackagesTypes(packagesTypesList));
    }

    @Then("^Verify the following packages prices displayed correctly$")
    public void VerifyThePackagesPricesDisplayedCorrectly(DataTable packagesPrices) {
        System.out.println("Verify the packages prices displayed correctly");
        Assert.assertTrue("\nPackages prices are not displayed correctly on the Home page",stcTVHomePageHomePage.checkPackagesPrices(packagesPrices));
    }
}
