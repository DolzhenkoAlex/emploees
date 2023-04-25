package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ConnectionProperty;
import dao.EmpConnBuilder;
import domain.Role;

/**
 * Servlet implementation class DeleteRoleServlet
 */
@WebServlet("/deleterole")
public class DeleteRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionProperty prop;
	String select_all_role = "SELECT id, rolename FROM roles ORDER BY id";
	String select_role_ById = "SELECT id, rolename FROM roles WHERE id = ?";
	String delete_role = "DELETE FROM roles WHERE id = ?";
	ArrayList<Role> roles = new ArrayList<Role>();
	ArrayList<Role> deleteroles = new ArrayList<Role>();
	String userPath;
       
    /**
     * @throws IOException 
     * @throws FileNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoleServlet() throws FileNotFoundException, IOException {
        super();
        prop = new ConnectionProperty();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		EmpConnBuilder builder = new EmpConnBuilder();

		// Загрузка всех должностей
		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to deleterole succesfull!");

			String strId = request.getParameter("id");
			Long id = null;
			if (strId != null) {
				id = Long.parseLong(strId);
			}
			System.out.println("Code deleting role: " + id);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_all_role);
			if (rs != null) {
				roles.clear();
				while (rs.next()) {
					roles.add(new Role(rs.getLong("id"), rs.getString("rolename")));
				}
				rs.close();
				System.out.println("Load deleting role succesfull!");
				request.setAttribute("roles", roles);
			} else {
				System.out.println("Ошибка загрузки role");
			}

			System.out.println("Edit roleId = " + id);

			try (PreparedStatement preparedStatement = conn.prepareStatement(select_role_ById)) {
				preparedStatement.setLong(1, id);
				rs = preparedStatement.executeQuery();
				if (rs != null) {
					deleteroles.clear();
					while (rs.next()) {
						deleteroles.add(new Role(rs.getLong("id"), rs.getString("rolename")));
					}
					rs.close();
					System.out.println("Load deleterole succesfull!");
					request.setAttribute("rolesDelete", deleteroles);
				} else {
					System.out.println("Ошибка загрузки role");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		userPath = request.getServletPath();
		if ("/deleterole".equals(userPath)) {
			request.getRequestDispatcher("/views/deleterole.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		EmpConnBuilder builder = new EmpConnBuilder();

		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to delperson succesfull!");
			Long id = Long.parseLong(request.getParameter("id"));
			
			System.out.println("Del roleId = " + id);

			try (PreparedStatement preparedStatement = conn.prepareStatement(delete_role)) {
				preparedStatement.setLong(1, id);
				int result = preparedStatement.executeUpdate();
				System.out.println("Deleting row: "+result);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);

			getServletContext().getRequestDispatcher("/views/roles.jsp").forward(request, response);
		}
		doGet(request, response);
	}
}
