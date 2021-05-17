import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DBConnection {
	String userName[];
	String password[];
	int iterator = 0;
	int count = 0;
	public void sqlQuery() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/NYA_G181210092";
		String user = "postgres";
		String pass = "2259092";

		
		try {
			Connection conn = null;
			conn = DriverManager.getConnection(url, user, pass);
			if(conn != null) {
				
				System.out.println("Database Connection Success! \n");
			}
			else {
				System.out.println("Database Connection Failed! Try Again! \n");
			}
			
			String query = "SELECT \"username\", \"password\" FROM users";		

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			conn.close();
			
			String users = null;
			String pw = null;
			
			userName = new String[100];
			password = new String[100];
			
			while(resultSet.next()) {
				users = resultSet.getString("username");
				pw = resultSet.getString("password");
				
				userName[iterator] = users;
				password[iterator] = pw;
				iterator++;
			}
			resultSet.close();
			statement.close();
		}
        catch (Exception e) {
            e.printStackTrace();
        }		
	}
	
	public void comparison(String x, String y) {
		for(int j = 0; j < iterator; j++){
			if(x.equals(userName[j]) && y.equals(password[j])) {
				count++;
			}
		}
		if(count == 1)
			System.out.println("Login Succesful! \n");
		
		if(count == 0) {
			System.out.println("Login Failed! Program closing! \n");
			System.exit(0);
		}
	}
}
