package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: test").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String url = "jdbc:postgresql://localhost:5433/persons";
		String username = "postgres";
		String password = "rinh2021";
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver connected");
			try (Connection conn = DriverManager.getConnection(url, username, password)) {

				writer.println("Connection to persons succesfull!");
				Statement stmt = conn.createStatement();
				ResultSet rs =  stmt.executeQuery("SELECT * FROM roles");
				while (rs.next()) {
                    String str = rs.getString("id") + ":  " + rs.getString(2);
                    writer.println("Должность:  " + str);
                }
                rs.close();
   			}
		} catch (Exception ex) {
			writer.println("Connection failed...");
			writer.println(ex);
		} finally {
			writer.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
