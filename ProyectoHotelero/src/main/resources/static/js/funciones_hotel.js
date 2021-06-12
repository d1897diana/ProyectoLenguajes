function buscarHotel() {
	var busqueda = document.getElementById("busqueda").value;
	var contenedor = document.getElementById("contenedor");
	
	if (busqueda != "") { 
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/hotel/buscar/"+busqueda, true);
	    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhttp.send(null);
	    
	    xhttp.onreadystatechange = function () {
        	if (this.readyState === 4 && this.status === 200) {
            	contenedor.innerHTML = this.responseText;
        	}
    	};
	}else{
		var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/hotel/buscarT", true);
	    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhttp.send(null);
	    
	    xhttp.onreadystatechange = function () {
        	if (this.readyState === 4 && this.status === 200) {
            	contenedor.innerHTML = this.responseText;
        	}
    	};
	}
}

// 2) crear una funcion que permita ejecutar el cambio dinamico
function cambia_pais(){
	//1) Definir Las Variables Correspondintes
	var opt_1 = new Array ("San jose", "Alajuela", "Heredia", "Cartago", "Puntarenas", "Limon");
	
	var opt_2 = new Array ("Distrito Federal", "Baja California", "Baja California Sur", "Campeche",
	 "Chiapas", "Chihuahua", "Coahuila", "Colima", "Hidalgo", "Michoacán", "Morelos", "Aguascalientes", "Durango", "Estado de México",
	 "Guerrero", "Jalisco", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora",
	 "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz","Yucatán", "Zacatecas");
	
	var opt_3 = new Array ("Bocas del Toro", "Coclé", "Colón", "Chiriquí", "Darién",
	"Herrera","Los Santos","Panamá","Veraguas", "Panamá Oeste");
	
	var opt_4 = new Array ("Santiago", "La Serena", "Cuyo", "Chillán", "Concepción",
	"Cañete","Angol","Imperial","Villarrica","Valdivia","Osorno","Chiloé");
	
	var pais;
	
	//Se toma el vamor de la "cosa seleccionada"
	pais = document.formulario.pais[document.formulario.pais.selectedIndex].value;
	switch(pais){
		case "0":
			//si no habia ninguna opt seleccionada, elimino las cosas del select
			document.formulario.provincia.length = 1;
			//ponemos un guion en la unica opt que he dejado
			document.formulario.provincia.options[0].value="0";
			document.formulario.provincia.options[0].text="Elija una provincia";
		break;
		case "Costa rica":
			var pais_int = 1;
			mis_opts = eval("opt_" + pais_int);
			num_opts = mis_opts.length;
			document.formulario.provincia.length = num_opts;
			for(i=0; i<num_opts; i++){
				document.formulario.provincia.options[i].value=opt_1[i];
				document.formulario.provincia.options[i].text=opt_1[i];
			}
		break;
		case "Mexico":
			var pais_int = 2;
			mis_opts = eval("opt_" + pais_int);
			num_opts = mis_opts.length;
			document.formulario.provincia.length = num_opts;
			for(i=0; i<num_opts; i++){
				document.formulario.provincia.options[i].value=mis_opts[i];
				document.formulario.provincia.options[i].text=mis_opts[i];
			}
		break;
		case "Panama":
			var pais_int = 3;
			mis_opts = eval("opt_" + pais_int);
			num_opts = mis_opts.length;
			document.formulario.provincia.length = num_opts;
			for(i=0; i<num_opts; i++){
				document.formulario.provincia.options[i].value=mis_opts[i];
				document.formulario.provincia.options[i].text=mis_opts[i];
			}
		break;
		case "Chile":
			var pais_int = 4;
			mis_opts = eval("opt_" + pais_int);
			num_opts = mis_opts.length;
			document.formulario.provincia.length = num_opts;
			for(i=0; i<num_opts; i++){
				document.formulario.provincia.options[i].value=mis_opts[i];
				document.formulario.provincia.options[i].text=mis_opts[i];
			}
		break;
	}
	document.formulario.provincia.options.selected = true;		
}