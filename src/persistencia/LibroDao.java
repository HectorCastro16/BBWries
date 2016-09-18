package persistencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
















import model.Libro;
import model.Tipolibro;
import service.LibroInterfaz;

import java.sql.CallableStatement;

public class LibroDao implements LibroInterfaz {
	/*LISTAS*/
	@Override
	public List listaLibroDao() throws Exception {
		// TODO Auto-generated method stub
		List listadoLibro = new ArrayList();
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			con = conexion.getConnection();
			String sql = "CALL spListarLibros()";
			cstm = con.prepareCall(sql);
			rs = cstm.executeQuery();
			while (rs.next()) {
				Libro libro= new Libro();
				libro.setLibroID(rs.getInt(1));
				libro.setLibroNombre(rs.getString(2));
				libro.setLibroAutor(rs.getString(3));
				Tipolibro tipoLibro = new Tipolibro();
				tipoLibro.setTipoLibroNombre(rs.getString(4));
				libro.setLibroImagen(rs.getString(5));
				libro.setTipolibro(tipoLibro);
				
				listadoLibro.add(libro);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{rs.close();cstm.close();con.close();}
		return listadoLibro;
	}
	@Override
	public List listaLibroTotalDao() throws Exception {
		// TODO Auto-generated method stub
		List listadoTotalLibro = new ArrayList();
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			con = conexion.getConnection();
			String sql = "CALL spListarLibrosCompleto()";
			cstm = con.prepareCall(sql);
			rs = cstm.executeQuery();
			while (rs.next()) {
				Libro libro= new Libro();
				libro.setLibroID(rs.getInt(1));
				libro.setLibroCodigo(rs.getString(2));
				libro.setLibroNombre(rs.getString(3));
				libro.setLibroDescripcion(rs.getString(4));
				libro.setLibroCantidad(rs.getInt(5));
				libro.setLibroAutor(rs.getString(6));
				libro.setLibroImagen(rs.getString(7));
				listadoTotalLibro.add(libro);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{rs.close();cstm.close();con.close();}
			return listadoTotalLibro;
	}
	
	/*INGRESOS*/
	@Override
	public boolean ingresoLibroDao(Libro libro) throws Exception {
		// TODO Auto-generated method stub
		com.mysql.jdbc.Connection con =null;
		CallableStatement cstm = null;
		try {
			con = (com.mysql.jdbc.Connection) conexion.getConnection();
			String sql = "CALL IngresoNuevosLibros(?,?,?,?,?,?,?)";
			cstm =con.prepareCall(sql);
					
			cstm.setString(1, libro.getLibroNombre());
			cstm.setString(2, libro.getLibroDescripcion());
			cstm.setInt(3, libro.getLibroCantidad());
			cstm.setString(4,libro.getLibroAutor());
			cstm.setInt(5, libro.getTipolibro().getTipoLibroID());
			cstm.setString(6, libro.getLibroImagen());
			cstm.setString(7, libro.getLibroArchivoPdf());
			
			cstm.execute();
			System.out.print("Exito consulta IngresoLibroDao");
			return true;
		} catch (Exception e) {
			System.out.print("Error consulta IngresoLibroDao");
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}finally {
			cstm.close();
			con.close();
		}
	}
	@Override
	public List listadoLibrosDestacadosDao() throws Exception {
		
		List listadoLibrosDestacados=new ArrayList();
		Connection con=null;
		CallableStatement csmt= null;
		ResultSet rs=null;
		
		try{
			con = conexion.getConnection();
			String sql="call spListaLibrosDestacados()";
			csmt=con.prepareCall(sql);
			
			rs=csmt.executeQuery();
			
			while(rs.next()){
				Libro libro=new Libro();
				libro.setLibroID(rs.getInt(1));
				libro.setLibroCodigo(rs.getString(2));
				libro.setLibroNombre(rs.getString(3));
				libro.setLibroDescripcion(rs.getString(4));
				libro.setLibroCantidad(rs.getInt(5));
				libro.setLibroAutor(rs.getString(6));
				libro.setLibroFechaRegistro(rs.getDate(7));
				libro.setLibroActivo(rs.getString(8));
				
				Tipolibro tipo=new Tipolibro();
				tipo.setTipoLibroID(rs.getInt(9));
				tipo.setTipoLibroNombre(rs.getString(10));
				
				libro.setTipolibro(tipo);
				
				libro.setLibroImagen(rs.getString(11));
				libro.setLibroArchivoPdf(rs.getString(12));
				
				listadoLibrosDestacados.add(libro);
			}
			System.out.println("Exito listadoLibrosDestacadosDao");
		}catch(Exception e){
			System.out.println("Error listadoLibrosDestacadosDao "+e.getMessage());
			e.printStackTrace();		
			
		}finally{
			rs.close();
			csmt.close();
			con.close();
		}
		return listadoLibrosDestacados;
	}
	
	@Override
	public Libro BuscaLibroIdObjetoDao(int id) throws Exception {
		Libro libro = new Libro();
		Connection  con = null;
		CallableStatement csmt=null;
		ResultSet rs=null;
		try {
			con=conexion.getConnection();
			String sql="call spBuscaLibroObjeto(?)";
			csmt=con.prepareCall(sql);
			csmt.setInt(1,id);
			rs=csmt.executeQuery();
			while(rs.next()){
				
				libro.setLibroID(rs.getInt(1));
				libro.setLibroCodigo(rs.getString(2));
				libro.setLibroNombre(rs.getString(3));
				libro.setLibroDescripcion(rs.getString(4));
				libro.setLibroCantidad(rs.getInt(5));
				libro.setLibroAutor(rs.getString(6));
				libro.setLibroFechaRegistro(rs.getDate(7));
				libro.setLibroActivo(rs.getString(8));
				
				Tipolibro tipo=new Tipolibro();
				tipo.setTipoLibroID(rs.getInt(9));
				
				
				libro.setLibroImagen(rs.getString(10));
				libro.setLibroArchivoPdf(rs.getString(11));
				
				tipo.setTipoLibroNombre(rs.getString(12));
				libro.setTipolibro(tipo);
			}
			System.out.println("Exito BuscaLibroIdObjetoDao");
		} catch (Exception e) {
			System.out.println("Error BuscaLibroIdObjetoDao"+e.getMessage());
			e.printStackTrace();
		}finally{
			rs.close();
			csmt.close();
			con.close();
		}
		return libro;
	}
	@Override
	public boolean ActualizarLibroDao(Libro libro) throws Exception {
		Connection con=null;
		CallableStatement  csmt= null;
		
		try {
			con=conexion.getConnection();
			String sql="CALL spActualizaLibro(?,?,?,?,?,?)";
			csmt=con.prepareCall(sql);
			
			csmt.setInt(1, libro.getLibroID());
			
			csmt.setString(2, libro.getLibroNombre());
			csmt.setInt(3, libro.getTipolibro().getTipoLibroID());
			csmt.setString(4,libro.getLibroAutor());
			csmt.setInt(5, libro.getLibroCantidad());
			csmt.setString(6,libro.getLibroDescripcion());
			csmt.execute();
			System.out.println("Exito ActualizarLibroDao");
			
			return true;
		} catch (Exception e) {
			System.out.println("Error ActualizarLibroDao"+e.getMessage());
			e.printStackTrace();
			return false;
		}finally{
			csmt.close();
			con.close();
		}
		
		
	}
	@Override
	public boolean EliminadoLogicoLibroDao(int id) throws Exception {
		Connection con=null;
		CallableStatement csmt=null;
		try {
			con=conexion.getConnection();
			String sql="call spEliminarLogicoLibro(?)";
			csmt=con.prepareCall(sql);
			csmt.setInt(1,id);
			csmt.execute();
			System.out.println("Exito EliminadoLogicoLibro");
			return true;
		} catch (Exception e) {
			System.out.println("Error EliminadoLogicoLibro"+e.getMessage());
			e.printStackTrace();
			return false;
		}finally{
			csmt.close();
			con.close();
		}
		
	}
	
	@Override
	public List BuscaLibroIdDao(int id) throws Exception {
		List listadoLibroBusquedaId =new ArrayList();
		Connection conn=null;
		CallableStatement csmt=null;
		ResultSet rs=null;
		try {
			conn=conexion.getConnection();
			String sql="call spBuscaLibroObjeto(?)";
			csmt=conn.prepareCall(sql);
			csmt.setInt(1, id);
			rs=csmt.executeQuery();
			while(rs.next()){
				Libro libro=new Libro();
				libro.setLibroID(rs.getInt(1));
				libro.setLibroCodigo(rs.getString(2));
				libro.setLibroNombre(rs.getString(3));
				libro.setLibroDescripcion(rs.getString(4));
				libro.setLibroCantidad(rs.getInt(5));
				libro.setLibroAutor(rs.getString(6));
				libro.setLibroFechaRegistro(rs.getDate(7));
				libro.setLibroActivo(rs.getString(8));
				
				Tipolibro tipo=new Tipolibro();
				tipo.setTipoLibroID(rs.getInt(9));
				
				
				libro.setLibroImagen(rs.getString(10));
				libro.setLibroArchivoPdf(rs.getString(11));
				
				tipo.setTipoLibroNombre(rs.getString(12));
				libro.setTipolibro(tipo);
				listadoLibroBusquedaId.add(libro);
			}
			
			System.out.println("Exito BuscaLibroIdDao");
		} catch (Exception e) {
			System.out.println("Error BuscaLibroIdDao"+e.getMessage());
			e.printStackTrace();
		}finally{
			rs.close();
			csmt.close();
			conn.close();
		}
		return listadoLibroBusquedaId;
	}

}
