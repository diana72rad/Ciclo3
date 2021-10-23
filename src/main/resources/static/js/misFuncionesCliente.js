/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function traerInformacion(){
	$.ajax({    
    url : 'https://g33818ba451dd19-dbciclo3.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
	data: "{}",
    type : 'GET',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",
  
    success : function(respuesta) {
		console.log(respuesta);
		$("#resultado").empty();
        let miTabla = '<table>';
		for (i=0; i<respuesta.items.length; i++){
			miTabla += '<tr>';
	        miTabla += '<td>'+ respuesta.items[i].id+ '</td>'; 		
	        miTabla += '<td>'+ respuesta.items[i].name+ '</td>'; 
	        miTabla += '<td>'+ respuesta.items[i].email+ '</td>'; 
	        miTabla += '<td>'+ respuesta.items[i].age+ '</td>'; 			
            miTabla += '<td><button onclick="editarRegistro('+respuesta.items[i].id+' )">Editar</button>';	
            miTabla += '<td><button onclick="borrarRegistro('+respuesta.items[i].id+' )">Borrar</button>';				
			miTabla += '</tr>';
	
		}
        miTabla += '</table>';
	    $("#resultado").append(miTabla);    
	},
    error : function(xhr, status) {
        alert('ha sucedido un problema:'+ status + json);
    }
});
}

function guardarInformacion(){
	let misDatos = {
		id: $("#id").val(),
        name: $("#name").val(),
		email: $("#email").val(),
        age: $("#age").val()
	};
	let datosJson = JSON.stringify(misDatos); 
	$.ajax(    
    'https://g33818ba451dd19-dbciclo3.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
	{data: datosJson,
    type : 'POST',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",
  
    statusCode : {
		201 :  function() {
			alert("guardado!");
			$("#id").val("");
			$("#name").val("");
			$("#email").val("");
			$("#age").val("");
        	traerInformacion();	
			}
		}
	});
}

function editarRegistro (idClient){
	$.ajax({    
    url : 'https://g33818ba451dd19-dbciclo3.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client/'+idClient,
	data: "{}",
    type : 'GET',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",
  
    success : function(respuesta) {
		console.log(respuesta);
        let miTabla = '<table>';
		for (i=0; i<respuesta.items.length; i++){
			$("#id").val(respuesta.items[i].id);
			$("#name").val(respuesta.items[i].name);
			$("#email").val(respuesta.items[i].email);
			$("#age").val(respuesta.items[i].age);
			$("#id").attr("readonly", true); 
		}
	},
    error : function(xhr, status) {
        alert('ha sucedido un problema:'+ status + json);
    }
});
}
	
function actualizarInformacion(){
	let misDatos = {
		id: $("#id").val(),
        name: $("#name").val(),
		email: $("#email").val(),
		age: $("#age").val()
	};
	let datosJson = JSON.stringify(misDatos); 
	$.ajax(    
    'https://g33818ba451dd19-dbciclo3.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
	{data: datosJson,
    type : 'PUT',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",
  
    statusCode : {
		201 :  function() {
			alert("Actualizado!");
			$("#id").val("");
			$("#name").val("");
			$("#email").val("");
			$("#age").val("");
		    $("#id").attr("readonly", false); 
        	traerInformacion();	
			}
		}
	});
}

function borrarRegistro(idCliente){
	let misDatos = {
		id: idCliente
	};
	let datosJson = JSON.stringify(misDatos); 	
	$.ajax(    
    'https://g33818ba451dd19-dbciclo3.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
	{data: datosJson,
    type : 'DELETE',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",
  
    statusCode : {
		204 :  function() {
			alert("Borrado!");
        	traerInformacion();	
			}
		}
	});
}	

