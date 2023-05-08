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


@WebServlet("/persons")
public class PersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionProperty prop;
	String select_all_person = "SELECT id, firstName, lastname, "
			+ "email, phone, roleid FROM persons ORDER BY lastname ASC";
	String select_all_role = "SELECT id, rolename FROM roles";
	String insert_person = "INSERT INTO persons( roleid, firstname, lastname, phone, email)"
			+ "VALUES(?,?,?,?,?)";
	ArrayList<Role> roles = new ArrayList<Role>();
 	ArrayList<Person> persons = new ArrayList<Person>();
	String userPath;

    /**
     * Default constructor. 
     */ 
    public PersonsServlet() throws FileNotFoundException, IOException{
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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		EmpConnBuilder builder = new EmpConnBuilder();

		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to persons succesfull!");
			
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
				request.setAttribute("roles", roles); // передача параметра roles в persons.jsp
				}
			else
			{
				System.out.println("Ошибка загрузки role");
			}
			
			
			
			
			
			// Загрузка всех сотрудников
			long id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_all_person);
			if(rs != null) {
				persons.clear();
				while (rs.next()) {
					id = rs.getLong("roleid");
					persons.add(new 
							Person(rs.getLong("id"),
								    rs.getString("firstName"),
								    rs.getString("lastName"),
								    rs.getString("email"),
								    rs.getString("phone"),
								    id,
								    FindById(id, roles)
								));
				}
				rs.close();
				System.out.println("Load person succesfull!");
				request.setAttribute("persons", persons); // передача параметра persons в persons.jsp
			}
			else
			{
				System.out.println("Ошибка загрузки person");
			}
		} catch (Exception e) {
			System.out.println(e);
		} 

		String userPath = request.getServletPath();
		if("/persons".equals(userPath)){
			request.getRequestDispatcher("/views/persons.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpConnBuilder builder = new EmpConnBuilder();
		
		try (Connection conn = builder.getConnection()){
			
			System.out.println("Connection to newperson succesfull!");
			
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			String role =  request.getParameter("role");
			
			int index1 = role.indexOf('='); 
			int index2 = role.indexOf(","); 
			String r1 = role.substring(index1+1, index2);
			Long id = Long.parseLong(r1.trim());

			System.out.println("!!!New person role = "+ role);
			System.out.println("New person role = "+ r1+"   "+id);
			
			PreparedStatement preparedStatement = conn.prepareStatement(insert_person);
			preparedStatement.setLong(1, id );
			preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, email );
            
            int rows = preparedStatement.executeUpdate();
            
            System.out.printf("%d rows added", rows);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		doGet(request, response);
	}

}
