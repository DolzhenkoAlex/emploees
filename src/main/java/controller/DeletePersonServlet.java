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
import domain.Person;

/**
 * Servlet implementation class DeletePersonServlet
 */
@WebServlet("/deleteperson")
public class DeletePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionProperty prop;
	String select_all_person = "SELECT id, firstName, lastname, "
			+ "email, phone, roleid FROM persons ORDER BY lastname ASC";
	String select_all_role = "SELECT id, rolename FROM roles";
	
	String select_person_ById = "SELECT id, roleid, firstname, lastname, phone, email "
			+ "FROM persons WHERE id = ?";
	String delete_person = "DELETE FROM persons WHERE id = ?";
	ArrayList<Role> roles = new ArrayList<Role>();
	ArrayList<Person> persons = new ArrayList<Person>();
 	ArrayList<Person> deletepersons = new ArrayList<Person>();
	String userPath;
       
    /**
     * @throws IOException 
     * @throws FileNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonServlet() throws FileNotFoundException, IOException {
        super();
        // TODO Auto-generated constructor stub
        prop = new ConnectionProperty();
    }
    
 // Поиск должности по id
    private Role FindById(Long id, ArrayList<Role> roles) {
    	if(roles != null) {
    		for(Role r: roles) {
     			if((r.getId()).equals(id)) {
    				return r;
    			}
    		}
    	}
    	else {
    		return null;
    	}
    	return null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		EmpConnBuilder builder = new EmpConnBuilder();

		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to persons succesfull!");
			
			String strId = request.getParameter("id");
			Long idPersonSelected = null;
			if(strId != null) {
				idPersonSelected = Long.parseLong(strId);
			}
			
			// Загрузка всех должностей
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_all_role);
			if(rs != null) {
				roles.clear();
				while (rs.next()) {
					roles.add(new Role(rs.getLong("id"), rs.getString("rolename")));
					}
				rs.close();
				System.out.println("Load role succesfull!");
				request.setAttribute("roles", roles); // передача параметра roles в deletepersons.jsp
				}
			else
			{
				System.out.println("Ошибка загрузки role");
			}

			// Загрузка всех сотрудников
			stmt = conn.createStatement();
			Long roleid;
			rs = stmt.executeQuery(select_all_person);
			if(rs != null) {
				persons.clear();
				while (rs.next()) {
					roleid = rs.getLong("roleid");
					
					persons.add(new 
							Person(rs.getLong("id"),
								    rs.getString("firstName"),
								    rs.getString("lastName"),
								    rs.getString("email"),
								    rs.getString("phone"),
								    roleid,
								    FindById(roleid, roles)
								));
				}
				rs.close();
				System.out.println("Load person succesfull!");
				request.setAttribute("persons", persons); // передача параметра persons в deletepersons.jsp
			}
			else
			{
				System.out.println("Ошибка загрузки person");
			}
			
			System.out.println("Delete personId = " + idPersonSelected);

			try (PreparedStatement preparedStatement = conn.prepareStatement(select_person_ById)) {
				preparedStatement.setLong(1, idPersonSelected);
				rs = preparedStatement.executeQuery();
				if(rs != null) {
					deletepersons.clear();
					Long idrole = null;
					while (rs.next()) {
						idrole = rs.getLong("roleid");
						deletepersons.add(new Person(
								rs.getLong("id"), 
								rs.getString("firstname"),
								rs.getString("lastname"),
								rs.getString("phone"),
								rs.getString("email"),
								idrole,
								FindById(idrole, roles)
								));
					}
					rs.close();
					System.out.println("Load editrole succesfull!");
					request.setAttribute("personsDelete", deletepersons);
				}
				else
				{
					System.out.println("Ошибка загрузки role");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		} 

		String userPath = request.getServletPath();
		if("/deleteperson".equals(userPath)){
			request.getRequestDispatcher("/views/deleteperson.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		EmpConnBuilder builder = new EmpConnBuilder();
		
		try (Connection conn = builder.getConnection()){
			
			System.out.println("Connection to deleteperson succesfull!");

			String strId = request.getParameter("id");
			Long id = null;
			if(strId != null) {
				id = Long.parseLong(strId);
			}
			
			try (PreparedStatement preparedStatement = conn.prepareStatement(delete_person)) {
				preparedStatement.setLong(1, id);
				int result = preparedStatement.executeUpdate();
				System.out.println("Deleting row: "+result);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		doGet(request, response);
	}
}
