Feature: executeUpdate Testleri

  Background: Database ile baglanti olusturur.
    * Database baglantisi olusturulur.

  # "users" tablosunda sondan bir önceki harfi e olan
  # "usernamelerin" "mobile" numarasını update ediniz

    @usersUpdate
    Scenario:
    * (users) SQL Querys'si hazirlanir ve calistirilir.
    * (users) Sonuclar islenir.
    * Database baglantisi sonlandirilir.




      # Database üzerinde "device_tokens" tablosuna istenen veriyi
      # tek sorguda ekleyiniz.

      @deviceTokensInsert
      Scenario: device_tokens tablosuna veri ekleme testi.
        * (device_tokens) insert sorgusu hazirlanir ve calistirilir.
        * (device_tokens) sonuclari islenir.
        * Database baglantisi sonlandirilir.















