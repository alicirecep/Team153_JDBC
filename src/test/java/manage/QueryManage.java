package manage;

public class QueryManage {


	private String croneSchedulesQuery = "SELECT name FROM cron_schedules LIMIT 2";
	private String usersUpdateQuery = "UPDATE users SET mobile = ? WHERE username like ?";
	private String deviceTokensInsertQuery = "insert into device_tokens (id, user_id, is_app, token)values (?,?,?,?)";
	private String deviceTokensInsertDogrulama = "SELECT * FROM device_tokens WHERE id = ?";


	public String getDeviceTokensInsertDogrulama() {
		return deviceTokensInsertDogrulama;
	}

	public String getDeviceTokensInsertQuery() {
		return deviceTokensInsertQuery;
	}

	public String getUsersUpdateQuery() {
		return usersUpdateQuery;
	}

	public String getCroneSchedulesQuery() {
		return croneSchedulesQuery;


	}

}
