<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="." oninput="range_control_value.value = range_control.valueAsNumber">
<p>
Nombre: <input type="text" name="name_control" autofocus required />
<br />
Correo Electrónico: <input type="email" name="email_control" required />
<br />
URL: <input type="url" name="url_control" placeholder="Escripe la URL de tu página web personal" />
<br />
Fecha: <input type="date" name="date_control" />
<br />
Tiempo: <input type="time" name="time_control" />
<br />
Fecha y hora de nacimiento: <input type="datetime" name="datetime_control" />
<br />
Mes: <input type="month" name="month_control" />
<br />
Semana: <input type="week" name="week_control" />
<br />
Número (min -10, max 10): <input type="number" name="number_control" min="-10" max="10" value="0" />
<br />
Intervalo (min 0, max 10): <input type="range" name="range_control" min="0" max="10" value="0" /> <output for="range_control" name="range_control_value" >0</output>
<br />
Teléfono: <input type="tel" name="tel_control" />
<br />
Término de búsqueda: <input type="search" name="search_control" />
<br />
Color Favorito: <input type="color" name="color_control" />
<br />
<input type="submit" value="Submit!" />
</p>
</form>

</body>
</html>