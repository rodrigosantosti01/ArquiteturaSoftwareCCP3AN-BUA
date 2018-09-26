package br.usjt.arqsw18.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	public Usuario logar(Usuario usuario) throws IOException {
		String sql = "SELECT usuario.id, usuario.email, usuario.password from Usuario where email = ? and password = ?";
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
				pst.setString(1,usuario.getEmail());		
				pst.setString(2,usuario.getSenha());	
				try (ResultSet rs = pst.executeQuery();) {
					if(rs.next()) {
						usuario.setId(rs.getInt("usuario.id"));
						usuario.setEmail(rs.getString("usuario.email"));
						usuario.setSenha(rs.getString("usuario.password"));
					}else {
						usuario = null;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		return usuario;
	}
}
