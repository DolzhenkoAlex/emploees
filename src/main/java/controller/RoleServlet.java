package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ConnectionProperty;
import dao.EmpConnBuilder;
import domain.Role;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/roles")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionProperty prop;
	String select_all = "SELECT * FROM roles";
	ArrayList<Role> roles = new ArrayList<Role>();
	String userPath;
	
    public RoleServlet() throws FileNotFoundException, IOException {
    	prop = new ConnectionProperty();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		EmpConnBuilder builder = new EmpConnBuilder();

		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to role succesfull!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_all);
			roles.clear();
			while (rs.next()) {
				roles.add(new Role(rs.getLong("id"), rs.getString(2)));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		System.out.println("Load role succesfull!");
		request.setAttribute("roles", roles);
	
		userPath = request.getServletPath();
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
