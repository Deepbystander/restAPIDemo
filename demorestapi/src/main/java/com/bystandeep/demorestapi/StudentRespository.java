package com.bystandeep.demorestapi;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRespository {

	private Connection con = null;

	public StudentRespository() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/demorestapidb?user=root&password=root"); 
			//createDatabase();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Couldnt open mysql connection");
		}

	}
	/*
	 * 
	 * public void createDatabase() {
	 * 
	 * System.out.println("test"); String[] init_database_queries = new String[4];
	 * init_database_queries[0]="DROP DATABASE IF EXISTS demorestapidb;";
	 * init_database_queries[1]="CREATE DATABASE demorestapidb;";
	 * init_database_queries[2]="USE demorestapidb;"; init_database_queries[3]
	 * ="CREATE TABLE student(id INT PRIMARY KEY,name VARCHAR(50) NOT NULL,age INT NOT NULL);"
	 * ;
	 * 
	 * for (int i = 0; i < init_database_queries.length; i++) { try {
	 * PreparedStatement ps = con.prepareStatement(init_database_queries[i]);
	 * ps.executeUpdate(); } catch (Exception e) {
	 * 
	 * } }
	 * 
	 * 
	 * }
	 * 
	 * public void executeSqlQuery(String query) { PreparedStatement st; try { st =
	 * con.prepareStatement(query); System.out.print("sucess");
	 * 
	 * } catch (Exception E) { E.printStackTrace();
	 * System.out.println("Couldnt execute the statement"); } }
	 */
	 

	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAge(rs.getInt(3));
				

				students.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	public Student getStudent(int id) {

		String sql = "select * from student where id=" + id;
		Student s = new Student();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAge(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s;
	}

	public void create(Student s1) {
		String sql = "insert into student values (?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, s1.getId());
			st.setString(2, s1.getName());
			st.setInt(3, s1.getAge());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void update(Student s1) {
		String sql = "update student set name = ?,age = ? where id = ?;";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, s1.getName());
			st.setInt(2, s1.getAge());
			st.setInt(3, s1.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteStudent(int id) {
		String sql = "delete from student where id = ?;";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}
