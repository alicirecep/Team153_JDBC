package manage;

public class QueryManage {


	private String croneSchedulesQuery = "SELECT name FROM cron_schedules LIMIT 2";
	private String usersUpdateQuery = "UPDATE users SET mobile = ? WHERE username like ?";




	public String getUsersUpdateQuery() {
		return usersUpdateQuery;
	}

	public String getCroneSchedulesQuery() {
		return croneSchedulesQuery;


	}

}
