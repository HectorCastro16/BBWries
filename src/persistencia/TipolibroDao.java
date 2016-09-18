package persistencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Tipolibro;
import service.TipoLibroInterfaz;

public class TipolibroDao implements TipoLibroInterfaz{

	@Override
	public List listaTipoLibroDao() throws Exception {
		// TODO Auto-generated method stub
		List listadoTipoLibro = new ArrayList();
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			con = conexion.getConnection();
			String sql ="CALL spListaTipoLibro()";
			cstm = con.prepareCall(sql);
			rs = cstm.executeQuery();
			while (rs.next()) {
				Tipolibro tipolibro = new Tipolibro();
				tipolibro.setTipoLibroID(rs.getInt(1));
				tipolibro.setTipoLibroNombre(rs.getString(2));
				
				listadoTipoLibro.add(tipolibro);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{rs.close();cstm.close();con.close();}
		return listadoTipoLibro;
	}

}
