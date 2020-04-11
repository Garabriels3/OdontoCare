package br.com.odonto.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.odonto.model.LoginModel;
import br.com.odonto.util.ConnectionFactory;

public class LoginDAO {
	
	public boolean checkLogin(LoginModel user) throws Exception {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;
				
		try {
			stmt = con.prepareStatement("SELECT * FROM users WHERE login = ? and senha = ?");
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("USUARIO LOGADO");
				check = true;
			}else {
				System.out.println("USUARIO INVALIDO");
			}
		}catch (SQLException ex) {
			System.out.println(ex);
		}
		
		return check;
		
		
		
	}
}
