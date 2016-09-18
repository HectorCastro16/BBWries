<%@ include file="mp_admin_1.jsp"%>

<section class="content">

	<!-- general form elements disabled -->
	<div class="box box-warning">
		<div class="box-header">
			<h3 class="box-title">INGRESO NUEVO USUARIO</h3>
		</div>

		<div class="box-body">
			<s:actionmessage theme="jquery" />
			<s:actionerror theme="jquery" />
			<form role="form" action="IngresaAdminUsuariosXML" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label>Nombres</label>
					<s:textfield name="personaNom" class="form-control"
						placeholder="Ingrese Nombres ..."></s:textfield>
				</div>

				<div class="form-group">
					<label>Apellidos</label>
					<s:textfield name="personape" class="form-control"
						placeholder="Ingrese Apellidos ..."></s:textfield>
				</div>
				<div class="form-group">
					<label>Documento Nacional De Identidad</label>
					<s:textfield name="dni" class="form-control"
						placeholder="Ingrese DNI ..."></s:textfield>
				</div>

				<div class="form-group">
					<label>Tipo Usuario</label>

					<s:select name="tipousuario" class="form-control"
						label="Tipo Usuario" list="%{listadoTipoUsuarioSelect}"
						listKey="%{TipoUsuarioID}" listValue="%{TipoUsuarioNombre}">
					</s:select>
				</div>

				<div class="form-group">
					<label>Foto Usuario </label> <br /> <a>(arrastrar y soltar
						archivo de imagen)</a>
					<div class="dropzone" id="dropzone_foto"></div>
				</div>
				<div class="form-group">
					<label>Nombre de Foto</label> <input id="nom_foto"
						name="personafot" value="" type="text" class="form-control"
						placeholder="Nombre de foto...">
				</div>
				<div class="form-group">
					<label>Usuario de Sistema</label>
					<s:textfield name="usuarioI" class="form-control"
						placeholder="Ingresar Usuario de Sistema..."></s:textfield>
				</div>
				<div class="form-group">
					<label>Password</label>
					<s:textfield name="passwI" class="form-control"
						placeholder="Ingrese Password..."></s:textfield>
				</div>
				<div class="form-group">
					<label>Comentario</label>
					<s:textarea name="personacom" class="form-control" rows="4"
						placeholder="Ingresar Comentario..."></s:textarea>
				</div>
				<div class="form-group">
					<input type="submit"
						class="btn btn-block btn-info redimencion-boton" value="Ingresar" />
				</div>

				<div class="form-group">
					<input type="reset"
						class="btn btn-block btn-info redimencion-boton" value="Borrar" />
				</div>

			</form>
			<div class="form-group">
				<a href="padministracion.jsp"><input type="submit"
					class="btn btn-block btn-info redimencion-boton" value="Cancelar" /></a>
			</div>

		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->

</section>

<%@ include file="mp_admin_2.jsp"%>