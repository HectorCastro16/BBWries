<%@ include file="mp_admin_1.jsp"%>

<section class="content">

	<!-- general form elements disabled -->
	<div class="box box-warning">
		<div class="box-header">
			<h3 class="box-title" style="font-family: cursive; color: blue;">ENVIAR CORREO</h3>
		</div>

		<div class="box-body">
			<s:actionmessage theme="jquery" />
			<s:actionerror theme="jquery" /><br/>
			
			<form role="form" action="EnvioCorreoXML" method="post"
				enctype="multipart/form-data">


				<div class="form-group">
					<label>Para : </label>
					
					<a href="ListadoUsuariosXML"><img title="Cambiar Destinatario" alt="" style="width: 30px; height: 30px"
										src="images/fotos/<s:property value="%{usuario.Persona.PersonaImagen}" ></s:property>" ></a>
										
										
					<s:textfield name="para"  value="%{usuario.UsuarioCorreo}" class="form-control"
						placeholder="Ingrese destinatario ..."></s:textfield>

				</div>

				<div class="form-group">
					<label>Asunto : </label><img src="images/mail.png"  style="width: 30px; height: 30px" />
					<s:textfield name="asunto" rows="10" class="form-control"
						placeholder="Ingrese asunto ..." ></s:textfield>
				</div>


				<div class="form-group">
					<label>Mensaje</label>
					<s:textarea name="mensaje" class="form-control"
						placeholder="Ingrese mensaje ..."></s:textarea>
				</div>

				<div class="form-group">
					<label>Archivo enviar </label> <br />

					<div class="dropzone" id="dropzone_correo"></div>
				</div>

				<div class="form-group">
					<label>Nombre de Archivo</label> <input id="nom_archivo_correo"
						name="archivoMail" value="" type="text" class="form-control"
						placeholder="Nombre de archivo...">
				</div>


				<div class="form-group">
					<input type="submit"
						class="btn btn-block btn-info redimencion-boton"
						value="Enviar e-Mail" />
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