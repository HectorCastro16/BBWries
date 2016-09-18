package service;
import java.util.List;


import model.Usuario;
public interface UsuarioInterfaz {
	public Usuario validaUsuarioDao(String usuarioI,String passwI) throws Exception;
	
	public boolean InsertarUsuarios (Usuario usuario)throws Exception;
	
	public boolean InsertaAdminUsuarioDao (Usuario usuario)throws Exception;
	/*Lista Usuarios*/
	public List ListaUsuariosDao() throws Exception;
	
	// busca usuario objeto 
	public Usuario BuscaUsuarioIdObjetoDao(String id) throws Exception;
	// para actualizar usuario
	public boolean ActualizarUsuarioDao(Usuario usuario) throws Exception;
	// para eliminar usuario
	public boolean EliminadoLogicoUsuarioDao(String id) throws Exception;
	
	// para buscar por id
	public List BuscaUsuarioIdDao(String id) throws Exception;
}
