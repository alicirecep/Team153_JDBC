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



