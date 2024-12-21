package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='elementor-widget-cmsmasters-search__popup-trigger-inner-icon']")
    public WebElement searchButton;
    @FindBy(xpath = "//input[@placeholder='Keşfet...']")
    public WebElement searchInput;
    @FindBy(xpath = "//h1[@class='entry-title cmsmasters-widget-title__heading ']")
    public WebElement haberBasligi;

    private By haberListesi = By.xpath("//h3//a");
    public By gethaberListesi() {
        return haberListesi;
    }


}




