package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import utilities.JDBCReusableMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static org.testng.Assert.*;

public class StepDefinition {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	QueryManage queryManage = new QueryManage();
	String Query;
	PreparedStatement preparedStatement;
	int row;
	int insertID;

	@Given("Database ile baglanti kurulur.")
	public void database_ile_baglanti_kurulur() throws SQLException {

		String URL= "jdbc:mysql://195.35.59.18/u201212290_qaloantec";
		String USERNAME= "u201212290_qaloanuser";
		String PASSWORD= "HPo?+7r$";

		connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

	}
	@Given("SQL Querysi hazirlanir ve calistirilir.")
	public void sql_querysi_hazirlanir_ve_calistirilir() throws SQLException {

	String Query = "SELECT DISTINCT user_id FROM deposits WHERE amount BETWEEN 100 AND 500";
	statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	resultSet = statement.executeQuery(Query);

	}
	@Given("Databaseden gelen sonuclar dogrulanir.")
	public void databaseden_gelen_sonuclar_dogrulanir() throws SQLException {

		// 1
		// 9
		// 10
		// 12
		// 64

		List<Integer> expectedResultList = new ArrayList<>();
		expectedResultList.add(1);
		expectedResultList.add(9);
		expectedResultList.add(10);
		expectedResultList.add(12);
		expectedResultList.add(64);


		List<Integer> actualResultList = new ArrayList<>();

		while(resultSet.next()){
			actualResultList.add(resultSet.getInt(1));
		}

		assertEqualsNoOrder(actualResultList, expectedResultList);


	}
	@Given("Database baglantisi kapatilir.")
	public void database_baglantisi_kapatilir() throws SQLException {
		resultSet.close();
		statement.close();
		connection.close();
	}



	@Given("Cron_schedules SQL Querysi hazirlanir ve calistirilir.")
	public void cron_schedules_sql_querysi_hazirlanir_ve_calistirilir() {

		resultSet = JDBCReusableMethods.executeQuery(queryManage.getCroneSchedulesQuery());

	}
	@Given("Cron_schedules'den gelen sonuclar dogrulanir.")
	public void cron_schedules_den_gelen_sonuclar_dogrulanir() throws SQLException {


		List<String> expectedResultList = new ArrayList<>();
		expectedResultList.add("5 Minutes");
		expectedResultList.add("10 Minutes");

		List<String> actualResultList = new ArrayList<>();

		while(resultSet.next()){
			actualResultList.add(resultSet.getString("name"));

		}

		assertEqualsNoOrder(actualResultList, expectedResultList);

	}


// *********************************************************************

	@Given("Database baglantisi olusturulur.")
	public void database_baglantisi_olusturulur() {
		JDBCReusableMethods.createConnection();
	}
	@Given("\\(users) SQL Querys'si hazirlanir ve calistirilir.")
	public void users_sql_querys_si_hazirlanir_ve_calistirilir() throws SQLException {

		Query = queryManage.getUsersUpdateQuery();
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(Query);

		// UPDATE users SET mobile = ? WHERE username like ?

		preparedStatement.setString(1, "77777");
		preparedStatement.setString(2, "%e_");

		row = preparedStatement.executeUpdate();
	}
	@Given("\\(users) Sonuclar islenir.")
	public void users_sonuclar_islenir() {

		System.out.println("etkilenen satir sayisi: " + row);
		assertEquals(row,5);

	}
	@Given("Database baglantisi sonlandirilir.")
	public void database_baglantisi_sonlandirilir() {

		JDBCReusableMethods.closeConnection();

	}


	@Given("\\(device_tokens) insert sorgusu hazirlanir ve calistirilir.")
	public void device_tokens_insert_sorgusu_hazirlanir_ve_calistirilir() throws SQLException {

	 Query = queryManage.getDeviceTokensInsertQuery();
	 preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(Query);
	 // insert into device_tokens (id, user_id, is_app, token)values (?,?,?,?)

		insertID = 864;
		preparedStatement.setInt(1,insertID);
		preparedStatement.setInt(2,677);
		preparedStatement.setInt(3,1);
		preparedStatement.setString(4,"Team177");

		row = preparedStatement.executeUpdate();

		Query = queryManage.getDeviceTokensInsertDogrulama();
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(Query);
		preparedStatement.setInt(1,insertID);
		resultSet = preparedStatement.executeQuery();

		resultSet.next();
		System.out.println(resultSet.getString("id"));
		assertEquals(resultSet.getInt("id"), insertID);

	}
	@Given("\\(device_tokens) sonuclari islenir.")
	public void device_tokens_sonuclari_islenir() {

		assertEquals(row,1);

	}








}
