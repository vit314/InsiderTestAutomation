package pages;

import base.Base;
import base.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

public class QualityAssuranceJobsPage extends Base {

    Util util = new Util();

    public QualityAssuranceJobsPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }


    @FindBy(xpath = "//select[@id='filter-by-location']")
    WebElement filterByLocation;

    @FindBy(xpath = "//select[@id='filter-by-department']")
    WebElement filterByDepartment;

    @FindBy(xpath = "//h3[contains(text(),'Browse')]")
    WebElement browseOpenPositions;

    @FindBy(xpath = "//div[@data-location='istanbul-turkey']")
    List<WebElement> openPositionsForIstanbul;

    @FindBy(xpath = "//p[contains(@class,'position-title')][contains(text(),'Quality Assurance') or contains(text(),'QA')]")
    List<WebElement> positionsContainQa;

    @FindBy(xpath = "//span[contains(@class,'position-department')][contains(text(),'Quality Assurance')]")
    List<WebElement> departmentsContainQa;

    @FindBy(xpath = "//div[contains(@class,'position-location')][contains(text(),'Istanbul, Turkey')]")
    List<WebElement> locationContain;

    @FindBy(xpath = "//div[@class='jobs-pagination']")
    WebElement arrowsPagination;

    @FindBy(xpath = "(//a[text()='Apply Now'])[1]")
    WebElement applyNowButton;

    @FindBy(xpath = "//a[text()='Apply Now']")
    List<WebElement> applyNowButtonList;


    public void verifyQualityAssuranceJobsPage(String expectedUrl, String expectedTitle) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Url is not correct");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title is not correct");
        Assert.assertTrue(browseOpenPositions.isDisplayed(), "See all QA jobs button is not displayed");
        System.out.println("QA Jobs page is displayed correctly");
    }

    public void clickOnApplyNow() throws InterruptedException {
        util.scrollTo(driver, browseOpenPositions);
        util.clickByJs(driver,applyNowButton);
    }

    public void checkJobsPositions() {
        Assert.assertTrue(openPositionsForIstanbul.size() != 0, "There is no jobs for Istanbul present");
        System.out.println("Jobs for Istanbul are displayed");
    }

    public void checkPositionsContainQualityAssurance() {
        Assert.assertTrue(positionsContainQa.size() != 0, "There are no positions for Quality Assurance displayed");
        System.out.println("There are positions for Quality Assurance displayed");
    }

    public void checkDepartmentsContainQualityAssurance() {
        Assert.assertTrue(departmentsContainQa.size() != 0, "There is no departments of Quality Assurance displayed");
        System.out.println("There are departments of Quality Assurance displayed");
    }

    public void checkLocationsContainIstanbul() {
        Assert.assertTrue(locationContain.size() != 0, "There are no locations of Istanbul displayed");
        System.out.println("There are locations of Istanbul displayed");
    }

    public void checkApplyNowButtons() {
        Assert.assertTrue(applyNowButtonList.size() != 0, "There is no Apply Now buttons displayed");
        System.out.println("There are Apply Now buttons displayed");
    }

    public void selectLocation(String value) {
        util.selectUsingVisibleText(filterByLocation, value);
    }

    public void selectDepartment(String value) {
        util.selectUsingVisibleText(filterByDepartment, value);
    }
}