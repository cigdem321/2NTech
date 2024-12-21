package stepDefinition.ui_step_defs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.List;
import pages.HomePage;

public class Home_StepDefs {

    HomePage homePage = new HomePage();
    List<WebElement> links;
    String linkText;
    WebElement baslikElementi;
    String baslik;

    @Given("Web Sitesine git")
    public void WebSitesineGit() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("Sayfa Logosuna tikla")
    public void sayfaLogosunaTikla() {
        homePage.logo.click();
    }


    @Then("Ana Sayfanin acildigini dogrula")
    public void AnaSayfaninAcildiginiDogrula() {
        String currentUrl = Driver.getDriver().getCurrentUrl(); //gidilen sayfanın url'ini verir
        Assert.assertEquals(ConfigReader.getProperty("url"), currentUrl); // Gidilen sayfa ana sayfa olduğu için
                                                                          // ConfigeReader dosyasındaki url'i karşılaştırarak doğrulama yapılmıştır.
    }

    @When("Navbar menusundeki linklere tıkla")
    public void navbarMenusundekiLinklereTıkla() {

        links = Driver.getDriver().findElements(homePage.getMenuLinks());

            for (int i = 0; i < links.size(); i++) {
                WebElement link = links.get(i);
                linkText = link.getText();
                link.click();

                // Sayfa başlığı (h1) dinamik olarak alınıyor
                baslikElementi = homePage.baslikElementi;
                baslik = baslikElementi.getText().toUpperCase();

                // Sayfa başlığının linkin metni ile eşleşip eşleşmediğini kontrol ediyor
                Assert.assertEquals(baslik, linkText);

                // Yeniden bağlantıları almak için
                links = Driver.getDriver().findElements(homePage.getMenuLinks());
        }
    }

    @Then("Acilan sayfalari dogrula")
    public void acilanSayfalariDogrula() {
        //doğrulama işlemi döngü içerisinde yapılmıştır
    }
}
