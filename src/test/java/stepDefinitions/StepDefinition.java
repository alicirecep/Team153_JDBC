package stepDefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static org.testng.Assert.*;

public class StepDefinition {

	Connection connection;
	Statement statement;
	ResultSet resultSet;

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




}
