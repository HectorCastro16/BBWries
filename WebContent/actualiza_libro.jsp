<%@ include file="mp_admin_1.jsp"%>

<section class="content">

	<div class="box box-warning">
		<div class="box-header">
			<h3 class="box-title">ACTUALIZACIÓN DE LIBROS</h3>
		</div>

		<div class="box-body">
			<s:actionmessage theme="jquery" />
			<s:actionerror />
			<br />
			<form role="form" action="ActualizaLibroXML"
				enctype="multipart/form-dat" method="post">
				<div class="form-group">
					<img
						src='images/portadas/<s:property value="%{libro.LibroImagen}" ></s:property>'
						style="width: 150px; height: 200px" alt="User Image" />

				</div>

				<s:hidden name="id" value="%{libro.LibroID}"></s:hidden>

				<div class="form-group">
					<label>Codigo del Libro</label>
					<s:label name="codigo" value="%{libro.LibroCodigo}"
						class="form-control"></s:label>
				</div>

				<div class="form-group">
					<label>Titulo del Libro</label>
					<s:textfield name="nom" value="%{libro.LibroNombre}"
						class="form-control"></s:textfield>
				</div>



				<div class="form-group">
					<label>Tipo de Libro</label>

					<s:select class="form-control" name="tip"
						list="%{listadoTipoLibro}" listKey="%{TipoLibroID}"
						listValue="%{TipoLibroNombre}"></s:select>

				</div>

				<div class="form-group">
					<label>Autor</label>
					<s:textfield name="aut" value="%{libro.LibroAutor}"
						class="form-control"></s:textfield>
				</div>

				<div class="form-group">
					<label>Cantidad</label>
					<s:textfield name="can" value="%{libro.LibroCantidad}"
						class="form-control"></s:textfield>

				</div>
				<div class="form-group">
					<label>Descripción</label>
					<s:textarea name="des" class="form-control" rows="5"
						value="%{libro.LibroDescripcion}"></s:textarea>
				</div>

				<div class="form-group">
					<input type="submit"
						class="btn btn-block btn-info redimencion-boton"
						value="Actualizar" />
				</div>

			</form>
			<div class="form-group">
				<a href="ListaLibrosTotalesXML"><input type="submit"
					class="btn btn-block btn-info redimencion-boton" value="Cancelar" /></a>
			</div>
		</div>
		<!-- /.box-body -->
	</div>

</section>







<%@ include file="mp_admin_2.jsp"%>