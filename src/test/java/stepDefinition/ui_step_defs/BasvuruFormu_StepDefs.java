package stepDefinition.ui_step_defs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasvuruFormuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class BasvuruFormu_StepDefs {

    ReusableMethods reusableMethods=new ReusableMethods();
    BasvuruFormuPage basvuruFormuPage=new BasvuruFormuPage();
    String dosyaYolu;

    @Given("Web Sitesıne git")
    public void webSitesıneGit() {
        Driver.getDriver().get(ConfigReader.getProperty("url-hr"));
        reusableMethods.waitForSecond(1);
    }

    @When("Ad Soyad alanına {string} gir")
    public void adSoyadAlanınaGir(String nameSurname) {
        basvuruFormuPage.nameSurname.sendKeys(nameSurname);
    }
    @And("Doğum Tarihi alanına {string} gir")
    public void doğumTarihiAlanınaGir(String dateOfBirth) {
        basvuruFormuPage.dateOfBirth.sendKeys(dateOfBirth);
    }

    @And("T.C. Kimlik Numarası alanına {string} gir")
    public void tCKimlikNumarasıAlanınaGir(String TcKimlikNo) {
        basvuruFormuPage.TcKimlikNo.sendKeys(TcKimlikNo);
    }

    @And("Cep Telefonu alanına {string} gir")
    public void cepTelefonuAlanınaGir(String phoneNumber) {
        basvuruFormuPage.phoneNumber.sendKeys(phoneNumber);
    }

    @And("Mail Adresi alanına {string} gir")
    public void mailAdresiAlanınaGir(String email) {
        basvuruFormuPage.email.sendKeys(email);
    }

    @And("CV alanına bir veri gir")
    public void cvAlanınaBirVeriGir() {
        reusableMethods.waitForSecond(1);
        dosyaYolu=ConfigReader.getProperty("cv");

        basvuruFormuPage.cv.sendKeys(dosyaYolu);
    }

    @And("Eğitim Bilgileri alanına bir veri gir")
    public void eğitimBilgileriAlanınaBirVeriGir() {
        basvuruFormuPage.egitimButton.click();
    }

    @And("İleri butonuna tıkla")
    public void ileriButonunaTıkla() {
        basvuruFormuPage.ileriButton.click();
    }

    @And("Test Engineer pozisyonunu seç")
    public void testEngineerPozisyonunuSeç() {
        basvuruFormuPage.pozisyon.click();
    }

    @And("Gönder butonuna tıkla")
    public void gönderButonunaTıkla() {
        basvuruFormuPage.gonderButton.click();
    }

    @Then("Formun başarılı bir şekilde gönderildiği doğrulanmalı")
    public void formunBaşarılıBirŞekildeGönderildiğiDoğrulanmalı() throws Exception {

        ReusableMethods.validateEmail(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"), "Başvurunuz Alındı");
    }
}
