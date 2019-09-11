package com.automation.capacitacion.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Operaciones {

	public Map<String, String> ejecutarSP(int idUser) {
		Map<String, String> credencialesUsuario = new HashMap<String, String>();
		MySQLConnection mysqlConnect = new MySQLConnection();
		Connection con = mysqlConnect.getConnection();
		CallableStatement cstm;
		ResultSet rs = null;
		try {
			cstm = con.prepareCall("{ call obtenerUsuarios(?) }");
			cstm.setInt(1, idUser);
			rs = cstm.executeQuery();
			if (rs.next()) {
				credencialesUsuario.put("usuario", rs.getString("usuario"));
				System.out.println(rs.getString(2));
				credencialesUsuario.put("password", rs.getString("password"));
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credencialesUsuario;
	}
	
	public Map<String, String> ejecutarConsulta(int idUser) {
		Map<String, String> credencialesUsuario = new HashMap<String, String>();
		MySQLConnection mysqlConnect = new MySQLConnection();
		Connection con = mysqlConnect.getConnection();
		PreparedStatement pstm;
		ResultSet rs = null;
		try {
			//String testSqlServer = "exec sp_name ?,?";//Cadena en SQL Server
			pstm = con.prepareStatement("select * from usuarios where Id_usuario=?");
			pstm.setInt(1, idUser);
			rs = pstm.executeQuery();
			if (rs.next()) {
				credencialesUsuario.put("usuario", rs.getString("usuario"));
				credencialesUsuario.put("password", rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credencialesUsuario;
	}
	
}
