package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.util.Properties;

import business.RoleManager;
import config.ConfigDb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import dao.ConnectionBuilderFactory;
import dao.ConnectionProperty;
import dao.EmpConnBuilder;
import dao.SimpleConnectionBuilder;
import dao.ConnectionBuilder;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionProperty prop;
	String url, username, password;
	String[] props;
	String select_all = "SELECT * FROM roles";
       
    public TestServlet() throws FileNotFoundException, IOException {
        super();
        prop = new ConnectionProperty();
    	props = prop.GetConProperties();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		EmpConnBuilder builder = new EmpConnBuilder();

		try (Connection conn = builder.getConnection()) {
			System.out.println("Connection to persons succesfull!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_all);
			while (rs.next()) {
				String str = rs.getString("id") + ":  " + rs.getString(2);
				writer.println("Должность:  " + str);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
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
