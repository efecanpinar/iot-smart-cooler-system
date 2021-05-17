import java.sql.SQLException;
import java.util.Scanner;

public class CentralProcessingUnit {

	public static void main(String[] args) throws SQLException {
		int choice = 0;
		String password, username;
        TemperatureSensor temperature = new TemperatureSensor();
        Actuator actuator = new Actuator();	
		DBConnection dbConnection = new DBConnection();
		
		Scanner UN = new Scanner(System.in);
		Scanner PW = new Scanner(System.in);
		
		System.out.println("Username: ");
		username = UN.next();
		System.out.println("Password: ");
		password = PW.next();
		
		dbConnection.sqlQuery();
		dbConnection.comparison(username, password);	
		
        while (choice != 4){
	        System.out.println("Select the Operation...");
	        System.out.println("1 => Show Temperature");
	        System.out.println("2 => Turn Off the Cooler");
	        System.out.println("3 => Turn On the Cooler");
	        System.out.println("4 => Close the Program \n");
	        
	        Scanner login = new Scanner(System.in);
	        choice = login.nextInt();
	        
	        switch(choice) {
	        case 1:
	        	temperature.temperatureValue();
	        	break;
	        case 2:
	        	actuator.coolerOff();
	        	break;
	        case 3:
	        	actuator.coolerOn();
	        	break;
	        case 4:
	        	System.out.println("Closing the Program! \n");
	        	System.exit(0);
	        	break;
	        default:
	        	System.out.println("Wrong choice! Please select 1, 2, 3 or 4 \n");
	        	break;
	        }
        }
	}

}
