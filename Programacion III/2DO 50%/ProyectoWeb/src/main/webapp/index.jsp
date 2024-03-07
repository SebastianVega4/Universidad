<%@ page import="co.edu.uptc.proyectoweb.Afiliado" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Afiliado afiliado = (Afiliado) request.getAttribute("afiliado");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<form id="disciplinaForm">
    <input type="hidden" id="idAfiliado" name="idAfiliado" value="<%= afiliado.getId() %>">
    <div class="form-group">
        <label for="nombreDisciplina">Nombre de la disciplina:</label>
        <input type="text" class="form-control" id="nombreDisciplina" name="nombreDisciplina">
    </div>
    <div class="form-group">
        <label for="esIndividual">Individual:</label>
        <input type="checkbox" id="esIndividual" name="esIndividual">
    </div>
    <button type="submit" class="btn btn-primary">Guardar</button>
</form>

<form id="eventoForm">
    <input type="hidden" id="idAfiliado" name="idAfiliado" value="<%= afiliado.getId() %>">
    <div class="form-group">
        <label for="nombreEvento">Nombre del evento:</label>
        <input type="text" class="form-control" id="nombreEvento" name="nombreEvento">
    </div>
    <div class="form-group">
        <label for="resultado">Resultado:</label>
        <input type="text" class="form-control" id="resultado" name="resultado">
    </div>
    <button type="submit" class="btn btn-primary">Guardar</button>
</form>
<script>
    $(document).ready(function() {
        $("#disciplinaForm").on("submit", function(e) {
            e.preventDefault();

            if ($("#nombreDisciplina").val() && $("#esIndividual").prop("checked") !== null) {
                $.ajax({
                    url: "ajaxEndpoint",
                    method: "POST",
                    data: {
                        accion: "agregarDisciplina",
                        idAfiliado: $("#idAfiliado").val(),
                        nombreDisciplina: $("#nombreDisciplina").val(),
                        esIndividual: $("#esIndividual").prop("checked")
                    },
                    success: function(response) {
                        // Manejar la respuesta del servidor
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        // Manejar errores
                    }
                });
            } else {
                // Manejar el caso de datos no válidos
            }
        });

        $("#eventoForm").on("submit", function(e) {
            e.preventDefault();

            if ($("#nombreEvento").val() && $("#resultado").val()) {
                $.ajax({
                    url: "ajaxEndpoint",
                    method: "POST",
                    data: {
                        accion: "agregarEvento",
                        idAfiliado: $("#idAfiliado").val(),
                        nombreEvento: $("#nombreEvento").val(),
                        resultado: $("#resultado").val()
                    },
                    success: function(response) {
                        // Manejar la respuesta del servidor
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        // Manejar errores
                    }
                });
            } else {
                // Manejar el caso de datos no válidos
            }
        });
    });
</script>
</body>
</html>