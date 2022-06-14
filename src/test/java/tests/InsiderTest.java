package tests;

import base.Base;
import base.Util;
import data.UserData;
import org.testng.annotations.Test;
import pages.*;

public class InsiderTest extends Base {

    Util util = new Util();

    @Test
    public void insiderTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);
        QualityAssurancePage qualityAssurancePage = new QualityAssurancePage(driver);
        QualityAssuranceJobsPage qualityAssuranceJobsPage = new QualityAssuranceJobsPage(driver);
        JobPositionPage jobPositionPage = new JobPositionPage(driver);

        //1
        util.openPage(UserData.homePageUrl);

        homePage.verifyHomePage(UserData.homePageUrl, UserData.homePageTitle);

        //2
        homePage.clickOnMoreMenu();

        homePage.clickOnCareers();

        careersPage.verifyCareersPage(UserData.careerPageUrl, UserData.careersPageTitle);

        careersPage.checkLocations();

        careersPage.checkJobsTitles();

        careersPage.checkLifeAtInsiderText();

        //3
        careersPage.clickOnSeeAllTeams();

        careersPage.clickOnQualityAssurance();

        qualityAssurancePage.verifyQualityAssurancePage(UserData.qualityAssurancePageUrl, UserData.qualityAssurancePageTitle);

        qualityAssurancePage.clickOnSeeAllQaJobs();

        qualityAssuranceJobsPage.verifyQualityAssuranceJobsPage(UserData.qualityAssuranceJobsPageUrl, UserData.qualityAssuranceJobsPageTitle);

        qualityAssuranceJobsPage.selectLocation(UserData.locationOfQaJobs);

        qualityAssuranceJobsPage.selectDepartment(UserData.department);

        qualityAssuranceJobsPage.checkJobsPositions();

        //4
        qualityAssuranceJobsPage.checkPositionsContainQualityAssurance();

        qualityAssuranceJobsPage.checkDepartmentsContainQualityAssurance();

        qualityAssuranceJobsPage.checkLocationsContainIstanbul();

        qualityAssuranceJobsPage.checkApplyNowButtons();

        //5
        qualityAssuranceJobsPage.clickOnApplyNow();

        jobPositionPage.verifyJobPositionPage();
    }
}