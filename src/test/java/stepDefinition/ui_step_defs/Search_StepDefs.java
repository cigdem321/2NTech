package stepDefinition.ui_step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.SearchPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class Search_StepDefs {

    SearchPage searchPage = new SearchPage();
    ReusableMethods reusableMethods=new ReusableMethods();
    List<WebElement> haberListesi;
    String haberLinkiBasligi;
    WebElement sayfaHaberBasligi;


    @When("Search butonuna tikla")
    public void searchButonunaTikla() {
        reusableMethods.click(searchPage.searchButton);
    }

    @And("Search inputuna {string} gir")
    public void searchInputunaGir(String searchQuery) {
        reusableMethods.waitForSecond(1);
        searchPage.searchInput.sendKeys(searchQuery, Keys.ENTER);
    }

    @And("Acilan sayfadan {int} habere tikla")
    public void acilanSayfadanHabereTikla(int searchNumber) {
        haberListesi= Driver.getDriver().findElements(searchPage.gethaberListesi());
        haberLinkiBasligi= haberListesi.get(searchNumber-1).getText();

        reusableMethods.click(haberListesi.get(searchNumber-1));

        //doğrulama yapmak için istenilen haberin sayfa başlığını alır
        sayfaHaberBasligi = searchPage.haberBasligi;

    }

    @Then("Haber içeriginin acildigini dogrula")
    public void haberIçerigininAcildiginiDogrula() {
        Assert.assertEquals(haberLinkiBasligi,sayfaHaberBasligi.getText());
    }

}
