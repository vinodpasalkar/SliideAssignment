package test.java.news.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.java.news.pageObjects.LoginPage;

import java.io.IOException;

public class LoginStepDefs extends BaseClass {

    private final LoginPage loginPage = new LoginPage(null);

    //--------------------------------- GIVEN STEPS ----------------------------------

    @Given("User opens the app")
    public void userOpensTheApp() throws IOException {
        setUp();
        loginPage.isAppLoaded();
    }

    @Given("the user opens app for the first time")
    public void theUserOpensAppForTheFirstTime() {
        loginPage.isAppLoaded();
    }

    @Given("the user is already logged in the app")
    public void theUserIsAlreadyLoggedInTheApp() {
        loginPage.provideRightCredentials();
        loginPage.clickLoginButton();
        loginPage.verifyHomeScreen();
    }

    @Given("the user provided wrong user name and password")
    public void theUserProvidedWrongUserNameAndPassword() {
        loginPage.provideWrongCredentials();
        loginPage.clickLoginButton();
    }

    @Given("the user provided right user name and password")
    public void theUserProvidedRightUserNameAndPassword() {
        loginPage.provideRightCredentials();
    }

    //--------------------------------- WHEN STEPS ----------------------------------

    @When("login button is clicked")
    public void loginButtonIsClicked() {
        loginPage.clickLoginButton();
    }

    @When("the user opens app next time")
    public void theUserOpensAppNextTime() {
        loginPage.relaunchTheApp();
    }

    //--------------------------------- THEN STEPS ----------------------------------


    @Then("error markers are displayed by user name and password entries")
    public void errorMarkersAreDisplayedByUserNameAndPasswordEntries() {
        loginPage.verifyErrorMarker();
    }

    @Then("login screen with user name and password and login button is displayed")
    public void loginScreenWithUserNameAndPasswordAndLoginButtonIsDisplayed() {
        loginPage.isLoginScreenVisible();
    }

    //---------------------------------- AFTER STEP ----------------------------------
    @After
    public void after()
    {
        tearDown();
    }

}