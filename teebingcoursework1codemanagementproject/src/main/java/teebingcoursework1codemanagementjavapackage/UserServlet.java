package teebingcoursework1codemanagementjavapackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// start of import statement codes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
// end of import statement codes

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// enter database setting code here
	private String jdbcURL = "jdbc:mysql://localhost:3306/teebingcoursework1codemanagementschema";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO userdetails" + " (username, email, language) VALUES " + " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select username, password, email, language from userdetails where username = ?";
	private static final String SELECT_ALL_USERS = "select * from userdetails";
	private static final String DELETE_USERS_SQL = "delete from userdetails where username = ?;";
	private static final String UPDATE_USERS_SQL = "update userdetails set username = ?,password= ?, email = ?,language = ? where username = ?;";
	
	protected Connection getConnection() {
	Connection connection = null;
	
	try {	
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	
		return connection;
	}
	// end of database setting code
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// add in route controller codes
		String action = request.getServletPath();
			try {
				switch (action) {
				case "/new":
					break;
				case "/insert":
					break;
				case "/delete":
					break;
				case "/edit":
					break;
				case "/update":
					break;
				default:
					listUser(request, response);
					break;
				}
				
			} catch (SQLException ex) {
				throw new ServletException(ex);
		}
		// end of route controller codes
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// add in methods to be called codes
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
		{
			List < User > users = new ArrayList < > ();
			
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
						System.out.println(preparedStatement);
					
						// Step 3: Execute the query or update query
						ResultSet rs = preparedStatement.executeQuery();
						
						// Step 4: Process the ResultSet object.
						while (rs.next()) {
							String username = rs.getString("username");
							String password = rs.getString("password");
							String email = rs.getString("email");
							String language = rs.getString("language");
							
							users.add(new User(username, password, email, language));
							System.out.println(username);
						}
						
			} catch (SQLException e) {
				printSQLException(e);
			}
			
			// List < User > listUser = databaseOperations.selectAllUsers();
				System.out.println("total user is: " + users.size());
			
				request.setAttribute("listUser", users);
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("userManagement.jsp");
			
				dispatcher.forward(request, response);
			}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e: ex) {
		
			if (e instanceof SQLException) {
		
				e.printStackTrace(System.err);
		
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
		
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
		
				System.err.println("Message: " + e.getMessage());
		
				Throwable t = ex.getCause();
		
				while (t != null) {
		
					System.out.println("Cause: " + t);
		
					t = t.getCause();
				}
			}
		}
	}
}
