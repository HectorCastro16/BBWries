<%@ include file="mp_admin_1.jsp"%>


<section class="content">

	<div class="box">
	<s:form action="BusquedaUsuarioID">
		<div class="box-header">
			<h3 class="box-title">LISTADO GENERAL DE USARIOS REGISTRADOS</h3>
			<div class="box-tools">
				<div class="input-group">
				
					<input type="text" name="idBusqueda"
						class="form-control input-sm pull-right" style="width: 150px;"
						placeholder="Buscar usuario...">
					<div class="input-group-btn">
						<button class="btn btn-sm btn-default">
							<i class="fa fa-search"></i>
						</button>
					</div>
					
				</div>
			</div>
		</div>
	</s:form>
		<!-- /.box-header -->
		<a  href="ListadoUsuariosXML" style="float: right; font-size: 13px" >Mostrar Todos los Usuarios</a>
		<s:actionmessage theme="jquery" /> 
		<br />
		<div class="box-body table-responsive no-padding">
			<table class="table table-hover">
				<tbody>
					<tr class="success">
						<th>ID Usuario</th>
						<th>Nombres</th>
						<th>Apellidos</th>
						<th>DNI</th>
						<th>Foto</th>
						<th>UserName</th>
						<th>Password</th>
						<th>Estado</th>
						<th>Tipo Usuario</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					<s:iterator value="listadoUsuarios">

						<tr>
							<td><s:property value="UsuarioID" /></td>
							<td><s:property value="Persona.PersonaNombre" /></td>
							<td><s:property value="Persona.PersonaApellidos" /></td>
							<td><s:property value="Persona.PersonaDni" /></td>
							<td><img
								src='images/fotos/<s:property value="Persona.PersonaImagen"></s:property>'
								style="width: 50px; height: 50px" alt="User Image" /></td>
							<td><s:property value="UsuarioNombre" /></td>
							<td><s:property value="UsuarioPassw" /></td>
							<td><span class="label label-success">Approved</span></td>
							<td><s:property value="TipoUsuario.TipoUsuarioNombre" /></td>

							<td><s:url id="url1" action="BuscaUsuarioObjetoXML">
									<s:param name="idBusqueda">
										<s:property value="UsuarioID"></s:property>
									</s:param>
								</s:url> <s:a href="%{url1}">
									<img title="Actualizar" alt=""
										style="width: 30px; height: 30px" src="images/refresh_user.png" />
								</s:a></td>

							<td><s:url id="url2" action="EliminadoLogicoUsuarioXML">
									<s:param name="idBusqueda">
										<s:property value="UsuarioID"></s:property>
									</s:param>
								</s:url>
								<s:a href="%{url2}">
									<img title="Eliminar" alt="" style="width: 30px; height:30px"
										src="images/delete_user.png">
								</s:a></td>
								
							<td><s:url id="url3" action="BuscaUsuarioCorreoXML">
									<s:param name="idBusqueda">
										<s:property value="UsuarioID"></s:property>
									</s:param>
								</s:url>
								<s:a href="%{url3}">
									<img title="Enviar Correo" alt="" style="width: 30px; height:30px"
										src="images/mail.png">
								</s:a></td>

						</tr>
				
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>




</section>


<%@ include file="mp_admin_2.jsp"%>