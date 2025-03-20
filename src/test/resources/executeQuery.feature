Feature: ExecuteQuery Testleri

  Background: Database baglantisi kurar.
    * Database ile baglanti kurulur.



  # Database içindeki "deposits" toblosunda
  # "amount" değeri 100$ ile 500$ arasında olan
  # user_id’leri doğrulayınız.

  @deposits
  Scenario: Deposits tablosundan amount degerine gore user_id dogrulama.

    * SQL Querysi hazirlanir ve calistirilir.
    * Databaseden gelen sonuclar dogrulanir.
    * Database baglantisi kapatilir.



    # Database içindeki "cron_schedules" tablosunda ilk 2 kaydın
    # "name" bilgisini doğrulayınız
    # 5 Minutes
    # 10 Minutes
  @cron_schedules
  Scenario: cron_schedules tablosundan name bilgisi dogrulama

    * Cron_schedules SQL Querysi hazirlanir ve calistirilir.
    * Cron_schedules'den gelen sonuclar dogrulanir.
   # * Database baglantisi kapatilir.














