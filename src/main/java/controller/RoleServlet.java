package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionProperty;
import dao.EmpConnBuilder;
import domain.Role;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/roles")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionProperty prop;
	String select_all = "SELECT * FROM roles";
	ArrayList<Role> roles = new ArrayList<Role>();
	Role[] arrayroles;
	
    public RoleServlet() throws FileNotFoundException, IOException {
    	prop = new ConnectionProperty();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");
		
		//PrintWriter writer = response.getWriter();
		//EmpConnBuilder builder = new EmpConnBuilder();
		//Role role;

		//try (Connection conn = builder.getConnection()) {
			//System.out.println("Connection to persons succesfull!");
			//Statement stmt = conn.createStatement();
			//ResultSet rs = stmt.executeQuery(select_all);
			//while (rs.next()) {
				//roles.add(new Role(rs.getLong("id"), rs.getString("namerole")));
		
				//String str = rs.getString("id") + ":  " + rs.getString(2);
				//writer.println("Должность:  " + str);
			//}
			//rs.close();
			//arrayroles = (Role[])roles.toArray();
		//} catch (Exception e) {
			//System.out.println(e);
		//} finally {
			//writer.close();
		//}
		
		//ServletContext selvletContext = getServletContext();
        //selvletContext.setAttribute("roles", arrayroles);
		
		String userPath = request.getServletPath();
		if("/roles".equals(userPath)){
			request.getRequestDispatcher("/views/roles.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
