package utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import java.util.Properties;

public class ReusableMethods {

    //HARD WAIT METHOD
    public static void waitForSecond(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }



    // E-posta doğrulama metodu
    public static String validateEmail(String username, String password, String searchSubject) throws Exception {
        // IMAP bağlantısı için gerekli özellikler
        String host = "imap.gmail.com";
        Properties properties = new Properties();
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");

        // Bağlantı oluşturma
        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore("imap");
        store.connect(username, password);

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        // Başlıkta arama yapma
        SearchTerm searchTerm = new SubjectTerm(searchSubject);
        Message[] messages = folder.search(searchTerm);

        String emailContent = "";
        if (messages.length > 0) {

            Message message = messages[messages.length - 1];
            String subject = message.getSubject();
            emailContent = (String) message.getContent();
        } else {
            emailContent = "Doğrulama e-postası bulunamadı.";
        }

        // Bağlantıyı kapatma
        folder.close(false);
        store.close();

        return emailContent;
    }



}
