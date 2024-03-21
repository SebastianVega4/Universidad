$(document).ready(function () {
    obtenerAfiliadosInicio();

    $("#idUserShearch").keypress(function (event){
        if(/[^0-9]/.test(event.key)){
            event.preventDefault()
        }
    })

    $("#btModificar").click(function (event){
        var idUsuario = $("#idUserShearch").val();

        if (!idUsuario) {
            alert("Ingrese el ID del usuario.");
            return;
        }
        $.ajax({
            type: "POST",
            url: "consulServlet",
            data: { idAfiliado: idUsuario },
            success: function(response) {
                if (!response) {
                    alert("Usuario no encontrado.");
                } else {
                    var urlModificar = "http://localhost:8080/ProyectoWeb_war/updateUser.jsp?id="+ idUsuario;
                    window.location.href = urlModificar;
                }
            },
            error: function(xhr, status, error) {
                console.log("Error al verificar la existencia del usuario");
                console.log(xhr.status);
                console.log(xhr.responseText);
                let errorMessage = JSON.parse(xhr.responseText).error;
                alert("Error: " + errorMessage);
            }
        });

    })

    $("#btEliminar").click(function (event){
        var idUsuario = $("#idUserShearch").val();

        if (!idUsuario) {
            alert("Ingrese el ID del usuario.");
            return;
        }
        $.ajax({
            type: "POST",
            url: "ajaxServlet",
            data: { modificar: "2", idAfiliado: idUsuario },
            success: function(response) {
                if (!response) {
                    alert("Usuario no encontrado.");
                } else {
                    alert("Usuario eliminado con exito\n" + response.toString());
                    obtenerAfiliadosInicio();
                }
            },
            error: function(xhr, status, error) {
                console.log("Error al verificar la existencia del usuario");
                console.log(xhr.status);
                console.log(xhr.responseText);
                let errorMessage = JSON.parse(xhr.responseText).error;
                alert("Error: " + errorMessage);
            }
        });

    })

    $("#consul").click(function (event) {
        event.preventDefault();
        const url = "consulServlet";
        const data = {
            consulPor: $("#consulPor").val(),
            queConsulta: $("#queConsulta").val(),
        };

        $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function (response) {
                console.log("Datos enviados correctamente");
                console.log(response);
                obtenerAfiliados($("#consulPor").val(), $("#queConsulta").val());
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

function obtenerAfiliados(consulPor, queConsulta) {
    const url = "consulServlet";
    const data = {
        consulPor: consulPor,
        queConsulta: queConsulta
    };

    $.ajax({
        type: "POST",
        url: url,
        data: data,
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
        tr.append(`<td colspan="5">No hay afiliados con ese filtro</td>`);
        tbody.append(tr);
    }
}

function obtenerAfiliadosInicio() {
    const url = "consulServlet";
    const data = {
        consulPor: "",
        queConsulta: ""
    };

    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType: "json",
        success: function (response) {
            console.log("Afiliados obtenidos correctamente");
            console.log("scripp   " + response);
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