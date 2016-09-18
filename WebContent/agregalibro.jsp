
<%@ include file="mp_admin_1.jsp"%>

<section class="content">

	<!-- general form elements disabled -->
	<div class="box box-warning">
		<div class="box-header">
			<h3 class="box-title">INGRESO NUEVO LIBRO</h3>
		</div>
		<div class="box-body">
			<s:actionmessage theme="jquery" />
			<form role="form" action="IngresoLibroXML" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label>Archivo PDF de Libro </label> <br />
					<a>(arrastrar y soltar archivo .pdf)</a>
					<div class="dropzone" id="dropzone_archivo"></div>
				</div>
				<div class="form-group">
					<label>Portada de Libro </label> <br />
					<a>(arrastrar y soltar archivo de imagen)</a>
					<div class="dropzone" id="dropzone_portada"></div>
				</div>
				<div class="form-group">
					<label>Titulo del Libro</label>
					<s:textfield name="LibroNombreI" class="form-control"
						placeholder="Titulo Libro ..."></s:textfield>
				</div>
				<div class="form-group">
					<label>Tipo de Libro</label>
					<s:select name="idtipo" class="form-control" label="Tipo Usuario"
						list="%{lisTipolibros}" listKey="%{TipoLibroID}"
						listValue="%{TipoLibroNombre}">
					</s:select>
				</div>

				<div class="form-group">
					<label>Autor</label>
					<s:textfield name="Libroautor" class="form-control"
						placeholder="Ingrese el autor ..."></s:textfield>
				</div>

				<div class="form-group">
					<label>Cantidad</label>
					<s:textfield name="LibroCantidadI" class="form-control"
						placeholder="Ingrese la cantidad ..."></s:textfield>

				</div>
				<div class="form-group">
					<label>Descripción</label>
					<s:textarea name="LibroDescripcionI" class="form-control" rows="4"
						placeholder="Ingresar descripción del libro..."></s:textarea>
				</div>

				<div class="form-group">
					<label>Nombre de Portada</label> <input id="nom_portada"
						name="LibroImagenI" value="" type="text" class="form-control"
						placeholder="Nombre de portada...">
				</div>
				<div class="form-group">
					<label>Nombre de Archivo PDF</label> <input id="nom_archivo"
						name="LibroArchivoPdfI" value="" type="text" class="form-control"
						placeholder="Nombre de archivo pdf...">
				</div>
				<div class="form-group">
					<input type="submit"
						class="btn btn-block btn-info redimencion-boton" value="Ingresar"
						onclick="opener.location.reload()" />
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
<!-- /.content -->


<%@ include file="mp_admin_2.jsp"%>