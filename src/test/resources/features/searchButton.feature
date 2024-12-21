@search
Feature: Kullanıici search butonunda arama yapabilmeli

  Scenario: Kullanıcı "Search" inputuna veri girişi yaparak arama yapabilmeli
    Given Web Sitesine git
     When Search butonuna tikla
      And Search inputuna "İstanbul" gir
      And Acilan sayfadan 3 habere tikla
     Then Haber içeriginin acildigini dogrula
