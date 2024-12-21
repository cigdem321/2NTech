package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@title='2N Haber'][2]")
    public WebElement logo;
    @FindBy(xpath = "//h1[@class='entry-title cmsmasters-widget-title__heading ']")
    public WebElement baslikElementi;
    private By menuLinks = By.xpath("//ul[@id='menu-1-5dc673f1']/li/a[not(ancestor::ul[@id='footer-menu'])]");
    public By getMenuLinks() {
        return menuLinks;
    }

}
