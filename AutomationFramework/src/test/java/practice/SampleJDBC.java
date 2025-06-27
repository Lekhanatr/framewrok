package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC {

	@Test
	public void selectQueryExecute() throws SQLException {
		Driver ref = new Driver();

		// step1: Register driver
		DriverManager.registerDriver(ref);

		// step2:Get connection with driver/database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "Lekhana@16");

		// step3:Issue create statement
		Statement statement = con.createStatement();

		// step4:Execute a query
		ResultSet result = statement.executeQuery("select * from customerInfo");
		while (result.next()) {
			System.out.println(result.getString(1));
		}

		// step5:close database
		con.close();

	}

	@Test
	public void nonSelectQueryExecute() throws SQLException {
		Driver ref = new Driver();

		// step1: Register driver
		DriverManager.registerDriver(ref);

		// step2:Get connection with driver/database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "Lekhana@16");

		// step3:Issue create statement
		Statement statement = con.createStatement();

		// step4:Execute a query
		int result = statement.executeUpdate("insert into customerInfo values('Shobha', 35, 'Kodaganur');");
		if (result==1) {
			System.out.println("data added");
		}

		// step5:close database
		con.close();
	}
}
