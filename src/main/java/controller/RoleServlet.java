package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	String select_all_role = "SELECT id, rolename FROM roles ORDER BY rolename ASC";
	String insert_role = "INSERT INTO roles(rolename) VALUES(?)";
	String delete_role = "DELETE FROM roles WHERE id = ?";
	ArrayList<Role> roles = new ArrayList<Role>();
	String userPath;
	
    public RoleServlet() throws FileNotFoundException, IOException {
    	prop = new ConnectionProperty();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		EmpConnBuilder builder = new EmpConnBuilder();

		// Загрузка всех должностей
		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to newrole succesfull!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_all_role);
			if(rs != null) {
				roles.clear();
				while (rs.next()) {
					roles.add(new Role(rs.getLong("id"), rs.getString("rolename")));
				}
				rs.close();
				System.out.println("Load newrole succesfull!");
				request.setAttribute("roles", roles);
			}
			else
			{
				System.out.println("Ошибка загрузки role");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} 
			
		userPath = request.getServletPath();
		if("/roles".equals(userPath)){
			request.getRequestDispatcher("/views/roles.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmpConnBuilder builder = new EmpConnBuilder();

		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to newperson succesfull!");
		
			String name = request.getParameter("namerole");
			
			System.out.println("New role = " + name);
			
				Role newRole = new Role(name);

				try (PreparedStatement preparedStatement = conn.prepareStatement(insert_role)) {
					preparedStatement.setString(1, newRole.getNamerole());
					int result = preparedStatement.executeUpdate();
					System.out.println("Adding "+result+" row");
				} catch (Exception e) {
					System.out.println(e);
				}
		} catch (Exception e) {
			System.out.println(e);
			getServletContext().getRequestDispatcher("/views/roles.jsp").forward(request, response);
		}
		finally {
		doGet(request, response);}
	}
}
