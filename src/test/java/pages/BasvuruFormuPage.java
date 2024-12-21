package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasvuruFormuPage {

    public BasvuruFormuPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "name")
    public WebElement nameSurname;

    @FindBy(id = "birth")
    public WebElement dateOfBirth;
    @FindBy(id = "tcKimlik")
    public WebElement TcKimlikNo;
    @FindBy(id = "phone")
    public WebElement phoneNumber;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(xpath = "//button[@class='py-3 px-4 w-full rounded-md transition-all bg-[#F5F5F5] text-[#6E6E6E] hover:bg-[#DF1F29] hover:text-white']")
    public WebElement egitimButton;

    @FindBy(xpath = "//button[@class='w-8 h-8 flex justify-center items-center p-2 bg-[#DF1F29] rounded-full']")
    public WebElement ileriButton;

    @FindBy(xpath = "//div[@class='flex flex-col gap-2 group rounded-lg py-3 px-4 cursor-pointer transition-all bg-[#F5F5F5] hover:bg-[#DF1F29] hover:text-white'][2]")
    public WebElement pozisyon;

    @FindBy(xpath = "//div[@class='text-white flex justify-center items-center text-[14px] py-2 px-4 rounded-full bg-[#DF1F29] cursor-pointer']")
    public WebElement gonderButton;

    @FindBy(id = "cv_field")
    public WebElement cv;
}
