Feature: ExecuteQuery Testleri


  # Database içindeki "deposits" toblosunda
  # "amount" değeri 100$ ile 500$ arasında olan
  # user_id’leri doğrulayınız.

  @deposits
  Scenario: Deposits tablosundan amount degerine gore user_id dogrulama.

    * Database ile baglanti kurulur.
    * SQL Querysi hazirlanir ve calistirilir.
    * Databaseden gelen sonuclar dogrulanir.
    * Database baglantisi kapatilir.













