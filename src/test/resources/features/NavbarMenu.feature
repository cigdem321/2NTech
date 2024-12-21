@navbar
Feature: Kullanıici butun navbar elementlerine tiklayabilmeli

  Scenario: Navbar menusundeki linkler tıklanarak doğru sayfaya yönlendirilmeli
    Given Web Sitesine git
     When Navbar menusundeki linklere tıkla
     Then Acilan sayfalari dogrula