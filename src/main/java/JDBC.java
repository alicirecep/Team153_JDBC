import java.sql.*;

public class JDBC {

	/*
		type					jdbc:mysql
		host/ip					195.35.59.18
		port					3306
		database_name			u201212290_qaloantec
		username				u201212290_qaloanuser
		password				HPo?+7r$

	Database Administrator'dan alinan ham veriler URL'e donusturulmeli.

	URL= "jdbc:mysql://195.35.59.18/u201212290_qaloantec"
	USERNAME= "u201212290_qaloanuser"
	PASSWORD= "HPo?+7r$"

 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. ADIM: JDBC Sürücüsünü Yükleme

		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2.ADIM: Veritabanı Bağlantısı Kurma

		String URL= "jdbc:mysql://195.35.59.18/u201212290_qaloantec";
		String USERNAME= "u201212290_qaloanuser";
		String PASSWORD= "HPo?+7r$";

		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		// 3.ADIM: SQL Sorguları Oluşturma

		String Query = "SELECT * FROM users";

		// 4. ADIM: SQL Sorguları Çalıştırma

		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery(Query);

		// 5. ADIM: Sonuçları İşleme

		// Database'den gelen sonuclar resultSet icerisine kaydedildi.
		// ResultSet icerisinde "itarator" ile dolasabilirim.


		resultSet.next();
		// System.out.println(resultSet.getString("firstname"));
		System.out.println(resultSet.getString(2));
		// Elf

		resultSet.next();
		System.out.println(resultSet.getString("email"));
		/*
		   Elf
		   test@gmail.com
		 */


		resultSet.next();
		resultSet.next();
		System.out.println(resultSet.getString("mobile"));
		/*
		   Elf
		   test@gmail.com
		   85462
		 */

		resultSet.absolute(10);
		System.out.println(resultSet.getString("country_code"));

		/*
		   Elf
		   test@gmail.com
		   85462
		   BJ
		 */

		resultSet.previous();
		System.out.println(resultSet.getString(3));
		/*
		   Elf
		   test@gmail.com
		   85462
		   BJ
		   EZO
		 */


		resultSet.first();
		System.out.println(resultSet.getString(4));
		System.out.println(resultSet.getString(6));
		/*
		   Elf
		   test@gmail.com
		   85462
		   BJ
		   EZO
		   acenk
		   elff931@gmail.com
		 */

		resultSet.beforeFirst();
		resultSet.isBeforeFirst();
		resultSet.afterLast();
		resultSet.isAfterLast();



	}
}
