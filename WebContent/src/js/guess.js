/**
 * 
 */

function mostrarSolucion(){
	var solucion = document.getElementById("solucion");
	var cheSol = document.getElementById("checkSol");
	if(cheSol.checked == true){
		solucion.classList.remove("hideSol");
		solucion.classList.add("showSol");
	} else {
		solucion.classList.add("hideSol");
		solucion.classList.remove("showSol");
	}
}


function mostrarPista(){
	var pista = document.getElementById("pista");
	var chePis = document.getElementById("checkPista");
	if(chePis.checked == true){
		pista.classList.remove("hideSol");
		pista.classList.add("showSol");
	} else {
		pista.classList.add("hideSol");
		pista.classList.remove("showSol");
	}
}