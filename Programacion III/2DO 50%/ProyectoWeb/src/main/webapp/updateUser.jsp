<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 16/03/2024
  Time: 7:36 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <title>Club Deportivo</title>
</head>
<body>
<div class="container">
    <h1 class="text-center my-4">Modificar afiliado</h1>
    <form id="myForm">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="idAfiliado" class="form-label">ID</label>
                    <input class="form-control" id="idAfiliado" name="idAfiliado">
                </div>
                <div class="form-group">
                    <label for="nombreAfiliado" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombreAfiliado" name="nombreAfiliado">
                </div>
                <div class="form-group">
                    <label for="apellidoAfiliado" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellidoAfiliado" name="apellidoAfiliado">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="idDisciplina" class="form-label">ID Disciplina</label>
                    <input type="number" value="0" class="form-control" id="idDisciplina" name="idDisciplina" min="0">
                </div>
                <div class="form-group">
                    <label for="nombreDisciplina" class="form-label">Nombre de la disciplina</label>
                    <input type="text" class="form-control" id="nombreDisciplina" name="nombreDisciplina">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="esIndividual" name="esIndividual">
                    <label class="form-check-label form-label" for="esIndividual">Individual</label>
                </div>
            </div>
        </div>
        <hr>
        <div class="row" id="eventosAfiliado">

        </div>
    </form>
    <br>
    <button type="button" id="btactualizar" class="btn btn-primary btn-block">Actualizar</button>
    <br>
    <a href="consul.jsp">
        <button type="button" id="btCancelar" class="btn btn-primary btn-block">Cancelar</button>
    </a>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="js/updateJs.js"></script>
</body>
</html>
