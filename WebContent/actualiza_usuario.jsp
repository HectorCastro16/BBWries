<%@ include file="mp_admin_1.jsp"%>

<section class="content">

	<!-- general form elements disabled -->
	<div class="box box-warning">
		<div class="box-header">
			<h3 class="box-title">ACTUALIZACIÓN DE USUARIO</h3>
		</div>

		<div class="box-body">
			<s:actionmessage theme="jquery" />
			<s:actionerror theme="jquery" />
			<br />
			<form role="form" action="ActualizaUsuarioXML" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<img
						src='images/fotos/<s:property value="%{usuario.Persona.PersonaImagen}" ></s:property>'
						style="width: 190px; height: 200px" alt="User Image" />

				</div>
				<s:hidden name="usuarioId" value="%{usuario.UsuarioID}"></s:hidden>
				<div class="form-group">
					<label>Nombres</label>
					<s:textfield name="personaNom" class="form-control"
						value="%{usuario.Persona.PersonaNombre}"></s:textfield>
				</div>

				<div class="form-group">
					<label>Apellidos</label>
					<s:textfield name="personape" class="form-control"
						value="%{usuario.Persona.PersonaApellidos}"></s:textfield>
				</div>
				<div class="form-group">
					<label>Documento Nacional De Identidad</label>
					<s:textfield name="dni" class="form-control"
						value="%{usuario.Persona.PersonaDni}"></s:textfield>
				</div>

				<div class="form-group">
					<label>Tipo Usuario</label>

					<s:select name="tipousuario" class="form-control"
						label="Tipo Usuario" list="%{listadoTipoUsuarioSelect}"
						listKey="%{TipoUsuarioID}" listValue="%{TipoUsuarioNombre}">
					</s:select>
				</div>
				<div class="form-group">
					<label>Usuario de Sistema</label>
					<s:textfield name="usuarioI" class="form-control"
						value="%{usuario.UsuarioNombre}"></s:textfield>
				</div>
				<div class="form-group">
					<label>Password</label>
					<s:textfield name="passwI" class="form-control"
						value="%{usuario.UsuarioPassw}"></s:textfield>
				</div>
				<div class="form-group">
					<label>Comentario</label>
					<s:textarea name="personacom" class="form-control" rows="4"
						value="%{usuario.Persona.PersonaComentario}"></s:textarea>
				</div>
				<div class="form-group">
					<input type="submit"
						class="btn btn-block btn-info redimencion-boton"
						value="Actualizar" />
				</div>

			</form>
			<div class="form-group">
				<a href="ListadoUsuariosXML"><input type="submit"
					class="btn btn-block btn-info redimencion-boton" value="Cancelar" /></a>
			</div>

		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->

</section>

<%@ include file="mp_admin_2.jsp"%>