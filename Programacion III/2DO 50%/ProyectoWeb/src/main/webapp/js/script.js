$(document).ready(function () {
    obtenerAfiliados();

    $("#guardar").click(function (event) {
        event.preventDefault();
        const url = "ajaxServlet";
        const esIndividualValue = $("#esIndividual").prop("checked") ? "true" : "false";
        const data = {
            modificar: "0",
            idAfiliado: $("#idAfiliado").val(),
            nombre: $("#nombreAfiliado").val(),
            apellido: $("#apellidoAfiliado").val(),
            idDisciplina: $("#idDisciplina").val(),
            nombreDisciplina: $("#nombreDisciplina").val(),
            esIndividual: esIndividualValue,
            idEvento: $("#idEvento").val(),
            nombreEvento: $("#nombreEvento").val(),
            resultadoEvento: $("#resultadoEvento").val()
        };

        $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function (response) {
                console.log("Datos enviados correctamente");
                console.log(response);
                obtenerAfiliados();
            },
            error: function (xhr, status, error) {
                console.log("Error al enviar los datos");
                console.log(xhr.status);
                console.log(xhr.responseText);
                let errorMessage = JSON.parse(xhr.responseText).error;
                alert("Error: " + errorMessage);
            },
            complete: function (xhr, status) {
                if (xhr.status === 400) {
                    let errorMessage = JSON.parse(xhr.responseText).error;
                    alert("Error: " + errorMessage);
                }
            }
        });
    });
});

function obtenerAfiliados() {
    const url = "ajaxServlet";

    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (response) {
            console.log("Afiliados obtenidos correctamente");
            actualizarTablaAfiliados(response);
        },
        error: function (xhr, status, error) {
            console.log("Error al obtener los afiliados");
            console.log(xhr.status);
            console.log(xhr.responseText);
            let errorMessage = JSON.parse(xhr.responseText).error;
            alert("Error: " + errorMessage);
        }
    });
}

function actualizarTablaAfiliados(afiliados) {
    const tbody = $("tbody");
    tbody.empty();

    if (afiliados && afiliados.length > 0) {
        afiliados.forEach(afiliado => {
            const tr = $("<tr>");
            tr.append(`<td>${afiliado.id}</td>`);
            tr.append(`<td>${afiliado.nombre}</td>`);
            tr.append(`<td>${afiliado.apellido}</td>`);
            tr.append(`<td>${afiliado.disciplina.nombre} (${afiliado.disciplina.esIndividual ? "Individual" : "Grupo"})</td>`);

            // Crear una celda para la lista de eventos
            const eventCell = $("<td></td>");

            // Crear la lista no ordenada
            const eventList = $("<ul></ul>");

            afiliado.eventos.forEach(evento => {
                // Agregar cada evento como un elemento de lista
                const eventListItem = $(`<li>${evento.id}.${evento.nombre}</li>`);
                eventList.append(eventListItem);
            });

            // Agregar la lista de eventos a la celda
            eventCell.append(eventList);
            tr.append(eventCell);

            // Crear una celda para los resultados de los eventos
            const resultCell = $("<td></td>");

            // Agregar cada resultado a la celda de resultados
            afiliado.eventos.forEach(evento => {
                const resultListItem = $(`<li>${evento.resultado}</li>`);
                resultCell.append(resultListItem);
            });

            tr.append(resultCell);
            tbody.append(tr);
        });
    } else {
        const tr = $("<tr>");
        tr.append(`<td colspan="5">No hay afiliados</td>`);
        tbody.append(tr);
    }
}