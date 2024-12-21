@form
Feature: Kullanıcı Formu eksiksiz doldurdugunda basarili bir sekilde gondermeli

  Scenario: Form eksiksiz doldurulmali
    Given Web Sitesıne git
     When Ad Soyad alanına "Cigdem Ciftci" gir
      And Doğum Tarihi alanına "01-01-1990" gir
      And T.C. Kimlik Numarası alanına "12345678912" gir
      And Cep Telefonu alanına "05459011492" gir
      And Mail Adresi alanına "cgdmkc89@gmail.com" gir
      And CV alanına bir veri gir
      And Eğitim Bilgileri alanına bir veri gir
      And İleri butonuna tıkla
      And Test Engineer pozisyonunu seç
      And Gönder butonuna tıkla
     Then Formun başarılı bir şekilde gönderildiği doğrulanmalı
