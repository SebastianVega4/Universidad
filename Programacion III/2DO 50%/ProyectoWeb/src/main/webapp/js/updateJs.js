$(document).ready(function (){
    const url = new URL(window.location.href);
    const idUsuario = url.searchParams.get('id');
    console.log(idUsuario)
    obtenerAfiliado(idUsuario)
    $("#btactualizar").click(function (event){
        event.preventDefault();

        if ($("#nombreAfiliado").val().trim() === "" ||
            $("#apellidoAfiliado").val().trim() === "" ||
            $("#idDisciplina").val().trim() === "" ||
            $("#nombreDisciplina").val().trim() === "") {
            alert("Debe diligenciar todos los espacios.");
            return; 
        }
        var eventosVacios = false;
        $("#eventosAfiliado > div").each(function () {
            var idEvento = $(this).find(".idEvento").val().trim();
            var nombreEvento = $(this).find(".nombreEvento").val().trim();
            var resultadoEvento = $(this).find(".resultadoEvento").val().trim();

            if (idEvento === "" || nombreEvento === "" || resultadoEvento === "") {
                eventosVacios = true;
                return false;
            }
        });

        if (eventosVacios) {
            alert("Debe diligenciar todos los espacios de eventos.");
            return;
        }
        const url = "ajaxServlet";
        const esIndividualValue = $("#esIndividual").prop("checked") ? "true" : "false";

        // Obtener todos los eventos
        var eventos = [];
        $("#eventosAfiliado > div").each(function() {
            var evento = {
                id: $(this).find(".idEvento").val(),
                nombre: $(this).find(".nombreEvento").val(),
                resultado: $(this).find(".resultadoEvento").val()
            };
            eventos.push(evento);
        });
        var jsonData = JSON.stringify(eventos);
        const data = {
            modificar: "1",
            idAfiliado: $("#idAfiliado").val(),
            nombre: $("#nombreAfiliado").val(),
            apellido: $("#apellidoAfiliado").val(),
            idDisciplina: $("#idDisciplina").val(),
            nombreDisciplina: $("#nombreDisciplina").val(),
            esIndividual: esIndividualValue,
            eventosAfiliado: jsonData
        };
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function (response) {
                alert("Datos actualizados")
                var urlModificar = "http://localhost:8080/ProyectoWeb_war/consul.jsp";
                window.location.href = urlModificar;
            },
            error: function (xhr, status, error) {
                if (xhr.status == 400) {
                    alert("Id de evento repetido\nNo se puede modificar la informacion");
                }else if(xhr.status == 400){
                    alert()
                }else{
                    console.log("Error al enviar los datos");
                    console.log(xhr.status);
                    console.log(xhr.responseText);
                    let errorMessage = JSON.parse(xhr.responseText).error;
                    alert("Error: " + errorMessage);
                }
            }
        });
    });
});

function obtenerAfiliado(idAfiliado){
    const url = "consulServlet";
    const data = {idAfiliado: idAfiliado};

    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType: "json",
        success: function (response){
            console.log("afiliado obtenido");
            showDataAfiliado(response);
        },
        error: function (xhr, status, error) {
            console.log("Error al obtener afiliado");
            console.log(xhr.status);
            console.log(xhr.responseText);
            let errorMessage = JSON.parse(xhr.responseText).error;
            alert("Error: " + errorMessage);
        }
    });
}
function showDataAfiliado(afiliado){
    if (afiliado != null) {
        $("#idAfiliado").prop("readonly", true);
        $("#idAfiliado").val(afiliado.id);
        $("#nombreAfiliado").val(afiliado.nombre);
        $("#apellidoAfiliado").val(afiliado.apellido);
        $("#idDisciplina").val(afiliado.disciplina.id);
        afiliado.disciplina.esIndividual ? $("#esIndividual").prop("checked", true) : $("#esIndividual").prop("checked", false);
        $("#nombreDisciplina").val(afiliado.disciplina.nombre);

        // Limpiar el contenedor de eventos antes de agregar nuevos
        $("#eventosAfiliado").empty();

        afiliado.eventos.forEach((evento) => {
            // Generar HTML para cada evento
            var eventoHTML = `
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="idEvento" class="form-label">ID evento</label>
                            <input type="number" min="1" value="${evento.id}" class="form-control idEvento" id="idEvento" name="idEvento">
                        </div>
                        <div class="form-group">
                            <label for="nombreEvento" class="form-label">Nombre del evento</label>
                            <input type="text" class="form-control nombreEvento" value="${evento.nombre}" id="nombreEvento" name="nombreEvento">
                        </div>
                        <div class="form-group">
                            <label for="resultadoEvento" class="form-label ">Puesto Obtenido</label>
                            <select id="resultadoEvento" name="resultadoEvento" class="form-select form-control resultadoEvento"
                                    aria-label="Disabled select example">
                                <option selected>${evento.resultado}</option>
                                <option value="Primer lugar">Primer lugar</option>
                                <option value="Segundo lugar">Segundo lugar</option>
                                <option value="Tercer lugar">Tercer lugar</option>
                                <option value="Campeon">Campeon</option>
                                <option value="Subcampeon">Subcampeon</option>
                            </select>
                        </div>
                    </div>
                
            `;
            $("#eventosAfiliado").append(eventoHTML);

        });
    } else {
        console.log("Error: La respuesta del servidor está vacía.");
    }
}
