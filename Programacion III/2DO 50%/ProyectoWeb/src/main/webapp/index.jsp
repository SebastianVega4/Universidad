<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilos.css">
    <title>Club Deportivo</title>
</head>
<body>
<div class="container">
    <h1 class="text-center my-4">Formulario de Afiliados</h1>
    <form id="myForm">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="idAfiliado" class="form-label">ID</label>
                    <input type="number" value="0" class="form-control" id="idAfiliado" name="idAfiliado">
                    <small id="idAfiliadoBack" class="text-mut">Si vas a agregar un evento a algún Afiliado existente,
                        solo digita el ID de afiliado y del evento (con el puesto ocupado).</small>
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
                    <input type="number" value="0" class="form-control" id="idDisciplina" name="idDisciplina">
                    <small id="idDisciplinaback" class="text-mut">Si ya existe, solo digita el ID</small>
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
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="idEvento" class="form-label">ID evento</label>
                    <input type="number" value="0" class="form-control" id="idEvento" name="idEvento">
                </div>
                <div class="form-group">
                    <label for="nombreEvento" class="form-label">Nombre del evento</label>
                    <input type="text" class="form-control" id="nombreEvento" name="nombreEvento">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="resultadoEvento" class="form-label ">Puesto Obtenido</label>
                    <select id="resultadoEvento" name="resultadoEvento" class="form-select form-control"
                            aria-label="Disabled select example">
                        <option selected></option>
                        <option value="Primer lugar">Primer lugar</option>
                        <option value="Segundo lugar">Segundo lugar</option>
                        <option value="Tercer lugar">Tercer lugar</option>
                        <option value="Campeon">Campeon</option>
                        <option value="Subcampeon">Subcampeon</option>
                    </select>
                </div>
            </div>
        </div>
    </form>
    <button type="submit" id="guardar" class="btn btn-primary btn-block">Guardar</button>
    <br>
    <a href="consul.jsp">
        <button type="submit" id="irConsul" class="btn btn-primary btn-block">Colsultas</button>
    </a>
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
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="js/script.js"></script>
</body>
</html>