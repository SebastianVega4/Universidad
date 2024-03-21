<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <title>Club Deportivo</title>
</head>
<body>
<div class="container">
    <h1 class="text-center my-4">Consultas de Afiliados</h1>
    <form id="myForm">
        <hr>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label class="form-label " for="consulPor">Consultar Por:</label>
                    <select aria-label="Disabled select example" class="form-select form-control" id="consulPor"
                            name="consulPor">
                        <option selected></option>
                        <option value="MostrarTodos">Mostrar Todos</option>
                        <option value="Nombre">Nombre</option>
                        <option value="Apellido">Apellido</option>
                        <option value="IdDisciplina">ID Disciplina</option>
                        <option value="Disciplina">Disciplina</option>
                        <option value="IdEvento">ID Evento</option>
                        <option value="Evento">Evento</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <br>
                    <input class="form-control" id="queConsulta" name="queConsulta" type="text">
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <button class="btn btn-primary btn-block" id="consul" type="submit">Consultar</button>
            </div>
        </div>
    </form>
    <br>
    <a href="index.jsp">
        <button id="irIndex" class="btn btn-primary btn-block" type="button">Agregar otro afiliado</button>
    </a>
    <br>
    <div class="input-group">
        <span class="input-group-text" id="addon-wrapping">ID</span>
        <input type="text" class="form-control" id="idUserShearch" name="idUserShearch" placeholder=" 12345" aria-label="Recipient's username with two button addons">
        <button class="btn btn-outline-secondary" id="btModificar" type="button" name="btModificar">Modificar</button>
        <button class="btn btn-outline-secondary" type="submit" id="btEliminar" name="btEliminar">Eliminar</button>
    </div>
    <h1 class="my-4">Afiliados</h1>
    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover">
            <thead>
            <tr>
                <th>ID Afililiado</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Disciplinas</th>
                <th>Eventos</th>
                <th>Puestos</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<script crossorigin="anonymous" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="js/consulJs.js"></script>
</body>
</html>