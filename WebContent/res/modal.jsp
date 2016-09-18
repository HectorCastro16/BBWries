<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!--<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">-->
<link href="Estilos/jquery-ui.css" rel="stylesheet"  />



<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<script src="js/jquery-1.9.0.min.js"></script> 

 <!--<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
<script src="js/jquery-ui.js"></script>

<link href="Estilos/style.css" rel="stylesheet" type="text/css" media="all" />
  

<script>
  $(function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "explode",
        duration: 1000
      }
    });
 
    $( "#opener" ).click(function() {
      $( "#dialog" ).dialog( "open" );
    });
  });
  </script>
  
 <script>
  $(function() {
    $( document ).tooltip();
  });
  </script>
  
  <style>
  label {
    display: inline-block;
    width: 5em;
  }
  </style>
  
</head>
<body>

<div id="dialog" title="Basic dialog">
  <p>This is an animated dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
</div>
 
<button id="opener" title="Click para ver ventana modal." >Open Dialog</button>
</body>
</html>