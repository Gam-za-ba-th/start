import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class insertDAO {
public static void main(String[] args) {
	 
}
	 public static boolean create(DTO dto) throws Exception {

			boolean flag = false;
			Connection conn = null;
			Statement stmt = null; 
			String id = dto.getId(); 
			String passwd = dto.getPassword(); 
			String num = dto.getnum();
			String email = dto.getemail();

			String sql = "INSERT INTO guest(id, password, num, email) VALUES";

			try {
				
				sql += "('" + new String(id.getBytes(), "ISO-8859-1") + "','"  
						+ new String(passwd.getBytes(), "ISO-8859-1") + "','"
						+ new String(num.getBytes(), "ISO-8859-1") + "','"
						+ new String(email.getBytes(), "ISO-8859-1") + "')";

				
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/users", "root", "9661");
				stmt = (Statement) conn.createStatement();
				((java.sql.Statement) stmt).executeUpdate(sql);

				flag = true;
			} catch (Exception e) {
				System.out.println(e);
				flag = false;
			} finally {

				try {

					if (stmt != null)
						((Connection) stmt).close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			return flag;

		}
}