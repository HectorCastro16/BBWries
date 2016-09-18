package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import model.Persona;
import model.TipoUsuario;
import service.UsuarioInterfaz;

import java.sql.CallableStatement;

public class UsuarioDao implements UsuarioInterfaz {

	@Override
	public Usuario validaUsuarioDao(String usuarioI, String passwI)
			throws Exception {
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();
		try {
			con = conexion.getConnection();
			String sql = "call spVerificaUsuario(?,?)";
			csmt = con.prepareCall(sql);
			csmt.setString(1, usuarioI);
			csmt.setString(2, passwI);
			rs = csmt.executeQuery();
			while (rs.next()) {
				Persona persona = new Persona();
				persona.setPersonaNombre(rs.getString(1));
				persona.setPersonaApellidos(rs.getString(2));
				persona.setPersonaDni(rs.getInt(3));

				TipoUsuario tipousuario = new TipoUsuario();
				tipousuario.setTipoUsuarioNombre(rs.getString(4));
				usuario.setTipoUsuario(tipousuario);
				
				usuario.setUsuarioNombre(rs.getString(5));
				usuario.setUsuarioPassw(rs.getString(6));
				persona.setPersonaImagen(rs.getString(7));
				usuario.setPersona(persona);
			}
			System.out.println("Exito valida UsuarioDao");
		} catch (Exception e) {
			System.out.println("Error Valida UsuarioDao " + e.getMessage());
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		return usuario;
	}

	@Override
	public boolean InsertarUsuarios(Usuario usuario) throws Exception {

		Connection cn = null;
		CallableStatement cstm = null;

		try {

			cn = conexion.getConnection();
			String sql = "call InsertarUsuarios(?,?,?,?,?)";
			cstm = cn.prepareCall(sql);

			cstm.setString(1, usuario.getPersona().getPersonaNombre());
			cstm.setString(2, usuario.getPersona().getPersonaApellidos());
			cstm.setInt(3, usuario.getPersona().getPersonaDni());
			cstm.setString(4, usuario.getUsuarioNombre());
			cstm.setString(5, usuario.getUsuarioPassw());

			cstm.execute();
			System.out.println("Usuario Ingresado");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al insertar usuario");
			return false;
		} finally {
			cstm.close();
			cn.close();
		}
	}

	@Override
	public boolean InsertaAdminUsuarioDao(Usuario usuario) throws Exception {
		Connection con = null;
		CallableStatement cstm = null;

		try {

			con = conexion.getConnection();
			String sql = "call spInsertarAdminUsuario(?,?,?,?,?,?,?,?)";
			cstm = con.prepareCall(sql);

			cstm.setString(1, usuario.getPersona().getPersonaNombre());
			cstm.setString(2, usuario.getPersona().getPersonaApellidos());
			cstm.setInt(3, usuario.getPersona().getPersonaDni());
			cstm.setString(4, usuario.getUsuarioNombre());
			cstm.setString(5, usuario.getUsuarioPassw());
			cstm.setInt(6, usuario.getTipoUsuario().getTipoUsuarioID());
			cstm.setString(7, usuario.getPersona().getPersonaImagen());
			cstm.setString(8, usuario.getPersona().getPersonaComentario());

			cstm.execute();
			System.out.println("Exito consulta InsertaAdminUsuarioDao");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error consulta InsertaAdminUsuarioDao");
			return false;
		} finally {
			cstm.close();
			con.close();
		}
	}

	@Override
	public List ListaUsuariosDao() throws Exception {

		List listadoUsuarios = new ArrayList();
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;

		try {
			con = conexion.getConnection();
			String sql = "call spListaUsuarios()";
			csmt = con.prepareCall(sql);

			rs = csmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuarioID(rs.getString(1));

				Persona persona = new Persona();
				persona.setPersonaNombre(rs.getString(2));
				persona.setPersonaApellidos(rs.getString(3));
				persona.setPersonaDni(rs.getInt(4));
				persona.setPersonaImagen(rs.getString(5));
				persona.setPersonaComentario(rs.getString(6));
				usuario.setPersona(persona);

				usuario.setUsuarioNombre(rs.getString(7));
				usuario.setUsuarioPassw(rs.getString(8));
				usuario.setUsuarioActivo(rs.getString(9));

				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setTipoUsuarioNombre(rs.getString(10));
				tipoUsuario.setTipoUsuarioID(rs.getInt(11));
				usuario.setTipoUsuario(tipoUsuario);

				listadoUsuarios.add(usuario);

			}
			System.out.println("Exito ListaUsuariosDao");
		} catch (Exception e) {
			System.out.println("Error ListaUsuariosDao " + e.getMessage());
			e.printStackTrace();
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}

		return listadoUsuarios;
	}

	@Override
	public Usuario BuscaUsuarioIdObjetoDao(String id) throws Exception {
		Usuario usuario = new Usuario();
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		try {
			con = conexion.getConnection();
			String sql = "call spBuscaUsuarioObjeto(?)";
			csmt = con.prepareCall(sql);
			csmt.setString(1, id);
			rs = csmt.executeQuery();
			while (rs.next()) {

				usuario.setUsuarioID(rs.getString(1));

				Persona persona = new Persona();
				persona.setPersonaNombre(rs.getString(2));
				persona.setPersonaApellidos(rs.getString(3));
				persona.setPersonaDni(rs.getInt(4));
				persona.setPersonaImagen(rs.getString(5));
				persona.setPersonaComentario(rs.getString(6));
				usuario.setPersona(persona);

				usuario.setUsuarioNombre(rs.getString(7));
				usuario.setUsuarioPassw(rs.getString(8));
				usuario.setUsuarioActivo(rs.getString(9));

				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setTipoUsuarioNombre(rs.getString(10));
				tipoUsuario.setTipoUsuarioID(rs.getInt(11));
				
				usuario.setUsuarioCorreo(rs.getString(12));
				
				usuario.setTipoUsuario(tipoUsuario);

			}

			System.out.println("Exito BuscaUsuarioIdObjetoDao");
		} catch (Exception e) {
			System.out
					.println("Error BuscaUsuarioIdObjetoDao" + e.getMessage());
			e.printStackTrace();
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		return usuario;
	}

	@Override
	public boolean ActualizarUsuarioDao(Usuario usuario) throws Exception {
		Connection con = null;
		CallableStatement csmt = null;
		try {
			con=conexion.getConnection();
			String sql="CALL spActualizaUsuario(?,?,?,?,?,?,?,?)";
			csmt=con.prepareCall(sql);
			
			csmt.setString(1,usuario.getUsuarioID());
			
			csmt.setString(2,usuario.getPersona().getPersonaNombre());
			csmt.setString(3, usuario.getPersona().getPersonaApellidos());
			csmt.setInt(4,usuario.getPersona().getPersonaDni());
			csmt.setString(5, usuario.getPersona().getPersonaComentario());
			
			csmt.setInt(6, usuario.getTipoUsuario().getTipoUsuarioID());
			csmt.setString(7, usuario.getUsuarioNombre());
			csmt.setString(8, usuario.getUsuarioPassw());
			
			csmt.execute();
			System.out.println("Exito ActualizarUsuarioDao");
			return true;
		} catch (Exception e) {
			System.out.println("Error ActualizarUsuarioDao" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			csmt.close();
			con.close();
		}

	}

	@Override
	public boolean EliminadoLogicoUsuarioDao(String id) throws Exception {
		Connection con=null;
		CallableStatement csmt=null;
		try {
			con=conexion.getConnection();
			String sql="call spEliminarLogicoUsuario(?)";
			csmt=con.prepareCall(sql);
			csmt.setString(1, id);
			csmt.execute();
			System.out.println("Exito EliminadoLogicoUsuarioDao");
			return true;
		} catch (Exception e) {
			System.out.println("Error EliminadoLogicoUsuarioDao"+e.getMessage());
			e.printStackTrace();
			return false;
		}finally{
			csmt.close();
			con.close();
		}
		
	}

	@Override
	public List BuscaUsuarioIdDao(String id) throws Exception {
		List listadoUsuarioBusquedaId =new ArrayList();
		Connection conn=null;
		CallableStatement csmt=null;
		ResultSet rs=null;
		try {
			conn=conexion.getConnection();
			String sql="call spBuscaUsuarioObjeto(?)";
			csmt=conn.prepareCall(sql);
			csmt.setString(1, id);
			rs=csmt.executeQuery();
			while(rs.next()){
				Usuario usuario=new Usuario();
				usuario.setUsuarioID(rs.getString(1));

				Persona persona = new Persona();
				persona.setPersonaNombre(rs.getString(2));
				persona.setPersonaApellidos(rs.getString(3));
				persona.setPersonaDni(rs.getInt(4));
				persona.setPersonaImagen(rs.getString(5));
				persona.setPersonaComentario(rs.getString(6));
				usuario.setPersona(persona);

				usuario.setUsuarioNombre(rs.getString(7));
				usuario.setUsuarioPassw(rs.getString(8));
				usuario.setUsuarioActivo(rs.getString(9));

				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setTipoUsuarioNombre(rs.getString(10));
				tipoUsuario.setTipoUsuarioID(rs.getInt(11));
				usuario.setTipoUsuario(tipoUsuario);
				listadoUsuarioBusquedaId.add(usuario);
				
			}
			System.out.println("Exito BuscaUsuarioIdDao");
		} catch (Exception e) {
			System.out.println("Error BuscaUsuarioIdDao"+e.getMessage());
			e.printStackTrace();
		}finally{
			rs.close();
			csmt.close();
			conn.close();
		}
		return listadoUsuarioBusquedaId;
	}
	
	

}
