package org.khit.myapp.unittest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j  //�α�(���)�� ����ϴ� ���̺귯����
public class JdbcTest {
	
	@Test  //main �޼��� ó�� �����
	public void testConnection() {
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jwebdb?serverTime=Asia/Seoul";
		String username="jweb"; 
		String password="pwjweb";
		
		try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url, username, password);
			//System.out.println("db ���� ��ü ����: " + con);
			log.info("db ���� ��ü ����: " + con);
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
