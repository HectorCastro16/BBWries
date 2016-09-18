package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.TipoUsuario;
import service.TipoUsuarioInterfaz;

public class TipoUsuarioDao implements TipoUsuarioInterfaz{

	@Override
	public List ListadoTipoUsuarioSelectDao() throws Exception {

		List listadoTipoUsuarioSelect = new ArrayList();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.getConnection();
	    	String sql="call spListaTipoUsuario()";
	    	cstm =cn.prepareCall(sql);
	    	rs = cstm.executeQuery();
	    	
	    	while(rs.next()){
	    		TipoUsuario tipoUsuario=new TipoUsuario();
	    		tipoUsuario.setTipoUsuarioID(rs.getInt(1));
	    		tipoUsuario.setTipoUsuarioNombre(rs.getString(2));
	    		listadoTipoUsuarioSelect.add(tipoUsuario);
	    	}
	    	
	    	System.out.print("Exito consulta ListadoTipoUsuarioSelectDao ");
		} catch (Exception e) {
			System.out.print("Error consulta ListadoTipoUsuarioSelectDao"+e.getMessage());
		}finally{
	    	rs.close();
			cstm.close();
			cn.close();	
	    }
		
		return listadoTipoUsuarioSelect;
	}

}
