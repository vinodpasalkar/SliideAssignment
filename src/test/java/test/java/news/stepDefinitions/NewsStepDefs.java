package test.java.news.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.java.news.pageObjects.LoginPage;
import test.java.news.pageObjects.NewsPage;

import java.io.IOException;

public class NewsStepDefs extends BaseClass {

    private final LoginPage loginPage = new LoginPage(null);
    private final NewsPage newsPage = new NewsPage(null);


    //--------------------------------- GIVEN STEPS ----------------------------------

    @Given("the news images are successfully loaded on the screen")
    public void theNewsImagesAreSuccessfullyLoadedOnTheScreen() {
        newsPage.verifyNewsImages();
    }

    //--------------------------------- WHEN STEPS ----------------------------------

    @When("there is internet connection")
    public void thereIsInternetConnection() throws IOException {
        hasActiveInternetConnection();
    }

    @When("there is no internet connection")
    public void thereIsNoInternetConnection() throws IOException {
        newsPage.hasNoActiveInternetConnection();
    }

    @When("the user clicks one of the image")
    public void theUserClicksOneOfTheImage() {
        newsPage.clickNewsImage();
    }

    //--------------------------------- THEN STEPS ----------------------------------

    @Then("user is navigated to the external browser with clicked image loaded")
    public void userIsNavigatedToTheExternalBrowserWithClickedImageLoaded() throws InterruptedException {

        newsPage.verifyNewsBrowserRedirection();
    }

    @Then("user is taken to the news screen")
    public void userIsTakenToTheNewsScreen() {
        newsPage.verifyNewsScreen();
    }

    @Then("user is taken straight to the news screen")
    public void userIsTakenStraightToTheNewsScreen() {
        newsPage.verifyNewsScreen();
    }

    @Then("images are displayed in the rows on the list")
    public void imagesAreDisplayedInTheRowsOnTheList() {
        newsPage.verifyNewsScreen();
    }

    @Then("failed to load news error message is displayed and Retry button")
    public void failedToLoadNewsErrorMessageIsDisplayedAndRetryButton() {
        newsPage.verifyNewsScreenError();
    }

    @Given("the user is already logged in the app with no internet connection")
    public void theUserIsAlreadyLoggedInTheAppWithNoInternetConnection() throws IOException {
        hasNoActiveInternetConnection();
        loginPage.provideRightCredentials();
        loginPage.clickLoginButton();

    }

}