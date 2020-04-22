/*
 * Tipo: Libreria de funciones
 * Descripción: Detalle de las funciones mas importantes.
 * Fecha: 02/8/2016
 * Version:  1.1.1706.0016    
 * Autor: Bararcelo E.
 * Modificación: 20/02/2020. 
 * Tipo de Modificación: Cambio de clase GregorianCalendar 
 *                       por el uso del LocalDate y LocalTime (2do C. 2019)
 * 						 Modificación del metodo de calcular Antiguedad por meses y años.
 *                       sE agregaron 3 funciones al final para edades, tiempo neto y fechaQuery.
 */

package funciones;

import java.time.*;
import java.util.Objects;
//------------------------ 

public class Funciones {

// metodo sonFechaIguales -------- LISTO -----------
	public static int sonFechasIguales(LocalDate fecha1, LocalDate fecha2) {
		int resul = 1;
		resul = fecha1.compareTo(fecha2);
		return resul;
	}

//----------------------------------------------------
//metodo entrFechas -------------- LISTO -----------
	public static boolean entreFechas(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaReal) {
		boolean resultado = false;
		if ((fechaInicio.minusDays(1).isBefore(fechaReal)) && (fechaFin.plusDays(1).isAfter(fechaReal))) {
			resultado = true;
		}
		return resultado;
	}

//------------------------------------------------------		
//metodo traerFechaCorta para la fecha de Hoy --> formato dd/mm/aa  ------- LISTO -----------
	public static String traerFechaCorta() {
		LocalDate fechaCorta = LocalDate.now();
		String fechaCortaHoy = fechaCorta.getDayOfMonth() + "/" + fechaCorta.getMonthValue() + "/"
				+ fechaCorta.getYear();
		return fechaCortaHoy;
	}

	// con parametros ----------- LISTO -----------
	public static String traerFechaCorta(LocalDate fecha) {
		String fechaCortaHoy = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear(); // formato
																											// dd/mm/aa
		return fechaCortaHoy;
	}

//------------------------------------------------------
//metodo traerFechaLarga  --> formato dd/mm/aa  ------- LISTO -----------
	public static String traerFechaLarga() {
		LocalDate fechaHoy = LocalDate.now();
		String mesFecha = funciones.Funciones.traerMesLetras(fechaHoy);
		String fechaActual = fechaHoy.getDayOfMonth() + " de " + mesFecha + " del " + fechaHoy.getYear();
		return fechaActual;
	}

	// con parametros -------- LISTO -----------
	public static String traerFechaLarga(LocalDate fecha) {
		String mesFecha = funciones.Funciones.traerMesLetras(fecha);
		String fechaActual = fecha.getDayOfMonth() + " de " + mesFecha + " del " + fecha.getYear();
		return fechaActual;

	}

//-------------------------------------------------------------------------
//metodo traerMesLetras                                                            -------- LISTO -----------
	public static String traerMesLetras() {
		return traerMesLetras(LocalDate.now());
	}

	// con parametros -------- LISTO -----------
	public static String traerMesLetras(LocalDate fecha) {
		String meses[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		return (meses[fecha.getMonthValue() - 1]);
	}

//---------------------------------------------------------------------		
//metodo esFechaValida                                                                 -------- LISTO ----------- 
	public static boolean esFechaValida() {
		LocalDate fechaValida = LocalDate.now(); // para conseguir la fecha actual
		return esFechaValida(fechaValida);
		// return
		// esFechaValida(fechaValida.getYear(),fechaValida.getMonthValue(),fechaValida.getDayOfMonth());
	}

	// con parametros PONER UNA EXCEPCION POR MES=13 -------- LISTO -----------
	public static boolean esFechaValida(LocalDate fechaValida) {
		return ((fechaValida.getYear() > 1800)
				&& ((fechaValida.getMonthValue() > 0) && (fechaValida.getMonthValue() < 13))
				&& ((fechaValida.getDayOfMonth() > 0) && (fechaValida.getDayOfMonth() <= fechaValida.lengthOfMonth())));
	}

//---------------------------------------------------
//metodo traerAnio ------- LISTO -----------	
	public static int traerAnio() {
		int anioHoy = LocalDate.now().getYear();
		return anioHoy;
	}

	// con parametros -------- LISTO -----------
	public static int traerAnio(LocalDate fecha) {
		int anioHoy = fecha.getYear();
		return anioHoy;
	}

//---------------------------------------------------	
//metodo traerMes ------- LISTO -----------
	public static int traerMes() {
		int mesHoy = LocalDate.now().getMonthValue();
		return mesHoy; // traerMes(LocalDate.now());
	}

	// con parametros -------- LISTO -----------
	public static int traerMes(LocalDate fecha) {
		return fecha.getMonthValue();
	}

//---------------------------------------------------		
//metodo traerDia ------- LISTO -----------
	public static int traerDia() {
		int diaHoy = LocalDate.now().getDayOfMonth();
		return diaHoy; // traerMes(LocalDate.now();
	}

	// con parametros -------- LISTO -----------
	public static int traerDia(LocalDate fecha) {
		int diaHoy = LocalDate.now().getDayOfMonth();
		return diaHoy;
	}

//---------------------------------------------------			
//metodo esBisiesto                                                                    -------- LISTO -----------
	public static boolean esBisiesto() {
		return (LocalDate.now().isLeapYear());
	}

	// con parametros -------- LISTO -----------
	public static boolean esBisiesto(int anio) {
		return ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0));
	}

//---------------------------------------------------------------------		
//metodo traerCantDiasDeUnMes                                                         -------- LISTO ----------- 
	public static int traerCantDiasDeUnMes() {
		int fechaHoy = LocalDate.now().lengthOfMonth();
		return fechaHoy;
	}

	// con parametros -------- LISTO -----------
	public static int traerCantDiasDeUnMes(LocalDate diasDeUnMes) { // Poner una Fecha
		int totalDiaMes = diasDeUnMes.lengthOfMonth();
		return totalDiaMes;
	}

//---------------------------------------------------------------------	
// metodo convStrToFecha                                                              -------- LISTO -----------	
	public static LocalDate convStrToFecha(String fecha) {
		LocalDate StrToFecha = LocalDate.parse(fecha);
		return StrToFecha;
	}

//---------------------------------------------------------------------------------
//metodo FechaMenorAHoy		                                                       -------- LISTO -----------
	public static boolean fechaMenorAHoy(LocalDate fecha) {
		return (fecha.isBefore(LocalDate.now())); // La primera fecha es anterior a la segunda
	}

//---------------------------------------------------------------------		
//metodo esDiaHabil                                                                    -------- LISTO -----------
	public static boolean esDiaHabil(LocalDate fecha1) {
		boolean diaHabil = true;
		String diaHabilDeSemana = fecha1.getDayOfWeek().name();
		if ((diaHabilDeSemana == "SATURDAY") || (diaHabilDeSemana == "SUNDAY")) {
			diaHabil = false;
		}
		return diaHabil;
	}

	// no se como cambiarlos......

	// metodo traerPrimerDiaHabil
	public LocalDate traerPrimerDiaHabil(LocalDate f) {
		while (!esDiaHabil(f)) {
			f.plusDays(1);
		}

		return f;
	}

//---------------------------------------------------------------------		 
//metodo traerDiaDeLaSemanaLetras  -------- LISTO ----------- 
	public static String traerDiaDeLaSemana() {
		String diaSemana = LocalDate.now().getDayOfWeek().name();
		switch (diaSemana) {
		case "SUNDAY":
			diaSemana = "Domingo";
			break;
		case "MONDAY":
			diaSemana = "Lunes";
			break;
		case "TUESDAY":
			diaSemana = "Martes";
			break;
		case "WEDNESDAY":
			diaSemana = "Miércoless";
			break;
		case "THURSDAY":
			diaSemana = "Jueves";
			break;
		case "FRIDAY":
			diaSemana = "Viernes";
			break;
		case "SATURDAY":
			diaSemana = "Sábado";
			break;
		}
		return diaSemana;
	}

	// con parametros -------- LISTO -----------
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String diaSemana = fecha.getDayOfWeek().name();
		switch (diaSemana) {
		case "SUNDAY":
			diaSemana = "Domingo";
			break;
		case "MONDAY":
			diaSemana = "Lunes";
			break;
		case "TUESDAY":
			diaSemana = "Martes";
			break;
		case "WEDNESDAY":
			diaSemana = "Miércoless";
			break;
		case "THURSDAY":
			diaSemana = "Jueves";
			break;
		case "FRIDAY":
			diaSemana = "Viernes";
			break;
		case "SATURDAY":
			diaSemana = "Sábado";
			break;
		}
		return diaSemana;
	}

//------------------------- FUNCIONA OK -------------------
	// Validacion de CUIT
	public static boolean validarCuit(String cuit) {

		cuit = cuit.replaceAll("[^\\d]", ""); // Eliminamos todos los caracteres que no son números
												// Controlamos si son 11 números los que quedaron,
												// si no es el caso, ya devuelve falso
		if (cuit.length() != 11) {
			return false;
		}

		char[] cuitArray = cuit.toCharArray(); // Convertimos la cadena que quedó en una matriz de caracteres
		Integer[] serie = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 }; // Inicializamos una matriz por la cual se multiplicarán
															// cada uno de los dígitos

		Integer aux = 0; // Creamos una variable auxiliar donde guardaremos los resultados del cálculo
							// del número validador

		for (int i = 0; i < 10; i++) { // Recorremos las matrices de forma simultanea, sumando los productos de la
										// serie por el número en la misma posición

			aux += Character.getNumericValue(cuitArray[i]) * serie[i];
		}
		// Hacemos como se especifica: 11 menos el resto de de la división de la suma de
		// productos anterior por 11
		aux = 11 - (aux % 11);
		// Si el resultado anterior es 11 el código es 0
		if (aux == 11) {
			aux = 0;
		}
		// Si el resultado anterior es 10 el código no tiene que validar, cosa que de
		// todas formas pasa
		// en la siguiente comparación.
		// Devuelve verdadero si son iguales, falso si no lo son
		// (Esta forma esta dada para prevenir errores, en java 6 se puede usar: return
		// aux.equals(Character.getNumericValue(cuitArray[10]));)
		return Objects.equals(Character.getNumericValue(cuitArray[10]), aux);
	}

//------------------------- FUNCIONA OK -------------------
	public boolean verificarNroDeCuenta(String nroDeCuenta) throws Exception {

		boolean salida = false;

		if ((nroDeCuenta.length()) == 12) {
			String[] ncuenta = nroDeCuenta.split("/"); // separo el String de cuenta 123456/9
			// separo el string de cuenta en dos
			String cadena1 = ncuenta[0];
			String cadena2 = ncuenta[1];
			int suma = 0;
			int resultadoSuma = 0;
			int verificador = Integer.parseInt(cadena2);
			int i = 0;
			int[] numCuenta = new int[cadena1.length()]; // crea un array de enteros con el largo del nro de cuenta

			// lleno el arreglo
			for (i = 0; i < numCuenta.length; i++) {
				numCuenta[i] = Integer.parseInt(cadena1.substring(i, i + 1));// bucle para llenar el array de enteros
			}

			// recorro y sumo
			for (i = 0; i < numCuenta.length; i++) {
				int numero = numCuenta[i];

				if ((i + 1) % 2 != 0) { // verifico si la posicion es par o impar
					suma = suma + numero; // sumo si es impar
				} else {
					if (numero * 2 > 10) { // es para saber si el numero tiene dos digitos

						int digito1 = (numero * 2) / 10; // divido 18 (numero) y me quedo con la parte entera (1)
						int digito2 = (numero * 2) % 10; // saco el resto de la division por 10 (8)
						numero = digito1 + digito2;
						suma = suma + numero;
					} else {

						suma = suma + numero * 2; // si es par suma y multiplica el doble
					}
				}

			}
			resultadoSuma = suma * 9;

			if (verificador == resultadoSuma % 10) // % para obtener el ultimo digito---> 603 para obtener 3
				salida = true;
		}
		return salida;
	}

//------------------------- FUNCIONA OK -------------------
	public static int calcularAntiguedadEnMeses(LocalDate fechaInicio) {
		LocalDate actual = LocalDate.now();

		int anios = 0;
		int meses = 0;
		int factora = 0;
		int salida;

		if (actual.getMonthValue() < fechaInicio.getMonthValue()) {
			factora = -1;
		}

		if ((actual.getMonthValue() == fechaInicio.getMonthValue())
				&& (actual.getDayOfMonth() < fechaInicio.getDayOfMonth())) {
			factora = -1; // Aun no celebra su cumpleaÃ±os
		}

		if ((actual.getMonthValue() == fechaInicio.getMonthValue())
				&& (actual.getDayOfMonth() >= fechaInicio.getDayOfMonth())) {
			meses = 0;
		} else {
			meses = 11;
		}

		if (actual.getMonthValue() > fechaInicio.getMonthValue()) { // ya cumplió este año
			meses = actual.getMonthValue() - fechaInicio.getMonthValue();
		}

		if (actual.getMonthValue() < fechaInicio.getMonthValue()) {
			meses = actual.getMonthValue() + 12 - fechaInicio.getMonthValue();
		}

		anios = (actual.getYear()) - fechaInicio.getYear() + factora;
		salida = anios * 12 + meses;

		return salida;
	}

//------------------------- REVISARLAS -------------------	
	/* CALCULAR EDAD EN STRING
	public String calcularEdad(GregorianCalendar fechaActual){
		String edad = "";
		
		Funciones f = new Funciones();
		
		int diaActual = f.traerNumeroDiaMes(fechaActual);
		int mesActual = f.traerNumeroMes(fechaActual);
		int anioActual = f.traerNumeroAnio(fechaActual);
		
		int diaNacimiento = f.traerNumeroDiaMes(getFechaNacimiento());
		int mesNacimiento = f.traerNumeroMes(getFechaNacimiento());
		int anioNacimiento = f.traerNumeroAnio(getFechaNacimiento());
	
		int dia = 0;
		int mes = 0;
		int anio = 0;
			
		if 	((f.compararFechas(fechaActual,getFechaNacimiento())==-1)){
			System.out.println("ERROR en las fechas.");
		}else{
			anio = anioActual - anioNacimiento;
			
			if((mesActual - mesNacimiento) > 0){
				mes = (mesActual - mesNacimiento);
				if((diaActual - diaNacimiento) > 0){
					dia = diaActual - diaNacimiento;
				}else if (diaActual - diaNacimiento < 0){
					dia = f.cantidadDiasMes(mesActual-1,anioActual) + (diaActual - diaNacimiento);
					mes--;
				}else{
					dia = 0;
				};
				
			}else if((mesActual - mesNacimiento) < 0){
				mes = 12 - mesNacimiento + mesActual;
				anio --;
				if((diaActual - diaNacimiento) > 0){
					dia = diaActual - diaNacimiento;
				}else if (diaActual - diaNacimiento < 0){
					dia = f.cantidadDiasMes(mesActual-1,anioActual) + (diaActual - diaNacimiento);
					mes--;
				}else{
					dia = 0;
				};
				
			//((mesActual - mesNacimiento)==0)	
			}else{
				if ((diaActual - diaNacimiento) > 0){
					mes = 11;
					dia = diaActual - diaNacimiento; 
					if ((anioActual - anioNacimiento)>0){
						anio = (anioActual - anioNacimiento - 1);
					}else if ((anioActual-anioNacimiento==0)){
						mes = 0;
					}
				}
				else if( (diaActual - diaNacimiento) < 0){
					mes = 0;
					dia = diaNacimiento - diaActual;
				}else{
					dia = 0;
				}
			};
			
			//Si el año es bisiesto, sumo un dia
			if ((mesActual > 2) && f.esBisiesto(anioActual)){
				dia++;
			};
		}		
		
		edad = anio+" anios, "+mes+" meses,"+dia+" dias.";
		return edad;		
	}
	*/
	
//------------------------- REVISARLAS -------------------		
	/* CALCULAR EDAD CON INT
	public int calcularEdad (GregorianCalendar fechaActual){
		Funciones f = new Funciones();
		
		int diaActual = f.traerNumeroDiaMes(fechaActual);
		int mesActual = f.traerNumeroMes(fechaActual);
		int anioActual = f.traerNumeroAnio(fechaActual);
		
		int diaNacimiento = f.traerNumeroDiaMes(getFechaNacimiento());
		int mesNacimiento = f.traerNumeroMes(getFechaNacimiento());
		int anioNacimiento = f.traerNumeroAnio(getFechaNacimiento());
		
		int edad = anioActual - anioNacimiento;
				
		if((mesActual < mesNacimiento) || ((mesActual == mesNacimiento) && (diaActual < diaNacimiento))){
			edad = edad - 1;
		}
		
		return edad;
	}
	*/
	
//------------------------- REVISARLAS -------------------		
	/* CALCULAR TIEMPO NETO
		public String calcularTiempoNeto (){
		Funciones f = new Funciones();
		
		String resultado = "";
		int horaResultado;
		int minResultado;
		int segResultado;
		
		int segLlegada = f.traerSegundos(fechaLlegada);
		int minLlegada = f.traerMinutos(fechaLlegada);
		int horaLlegada = f.traerHoras(fechaLlegada);
		
		int segSalida = f.traerSegundos(fechaSalida);
		int minSalida = f.traerMinutos(fechaSalida);
		int horaSalida = f.traerHoras(fechaSalida);
		
		if 	((f.compararFechas(fechaLlegada,getFechaSalida())==-1)){
			System.out.println("ERROR en las fechas.");
			return resultado;
		}else{
			horaResultado = horaLlegada - horaSalida;
			
			if (minLlegada >= minSalida){
				minResultado = minLlegada - minSalida;
			} else {
				minResultado = 60 + minLlegada - minSalida;
				horaResultado = horaResultado - 1;
			}
			
			if (segLlegada >= segSalida){
				segResultado = segLlegada - segSalida;
			} else {
				segResultado = 60 + segLlegada - segSalida;
				minResultado = minResultado - 1;
			}
			
			resultado = horaResultado + ":" + minResultado + ":" + segResultado;
			return resultado;
		}
	}
	*/


//------------------------- REVISARLAS -------------------		
//	public static String traerFechaQuery(GregorianCalendar fecha){
//		
//		int anio = fecha.get(GregorianCalendar.YEAR);
//		
//		String mes = new String();
//		mes = mes.valueOf((fecha.get(GregorianCalendar.MONTH)+1));
//		
//		String dia = new String();
//		dia = String.valueOf(fecha.get(GregorianCalendar.DAY_OF_MONTH));
//		
//		if(mes.length() == 1){
//			mes = "0" + mes;
//		}
//		
//		if(dia.length() == 1){
//			dia = "0"+dia;
//		}
//		
//		return "'"+anio+"-"+mes+"-"+dia+"'";
//	
//	}





//---------------------
}// Fin Funciones

// System.out.println( 3.0/2 );
// System.out.print( "El resto de dividir 13 entre 4 es ");
// System.out.println( 13%4 );

// System.out.println("Pi is " + Math.PI);
// System.out.println("e is " + Math.E);

// Finally there's one Random method
// System.out.print( "Un n?mero al azar entre 0 y 1: ");
// System.out.println( Math.random() );
// System.out.print( "Un n?mero al azar entre 50 y 150: ");
// System.out.println( (int)(Math.random()*100+50) );
// System.out.print( "Una letra min?scula al azar: ");
// System.out.println( (char)(Math.random()*26+'a') );

// System.out.print( "Ra? cuadrada de 36: ");
// System.out.println( Math.sqrt(36) );

// System.out.print( "Cinco elevado al cubo: ");
// System.out.println( Math.pow(5.0,3.0) );

// Exponential and Logarithmic Methods
// exp(a) returns e (2.71828...) raised
// to the power of a.
// System.out.print( "Exponencial de 2: ");
// System.out.println( Math.exp(2) );
// System.out.println("exp(1.0) is " + Math.exp(1.0));
// System.out.println("exp(10.0) is " + Math.exp(10.0));
// System.out.println("exp(0.0) is " + Math.exp(0.0));

// log(a) returns the natural
// logarithm (base e) of a.
// System.out.print( "Logaritmo de 2,71828: ");
// System.out.println( Math.log(2.71828) );
// System.out.println("log(1.0) is " + Math.log(1.0));
// System.out.println("log(10.0) is " + Math.log(10.0));
// System.out.println("log(Math.E) is " + Math.log(Math.E));

// Funciones trigonom?ricas ----
// double angulo = 45.0 * Math.PI/180.0;
// System.out.println("cos(" + angulo + ") es " + Math.cos(angulo));
// System.out.println("sin(" + angulo + ") es " + Math.sin(angulo));
// System.out.println("tan(" + angulo + ") es " + Math.tan(angulo));
// System.out.print( "Coseno de PI radianes: ");
// System.out.println( Math.cos(Math.PI) );
// System.out.print( "Seno de 45 grados: ");
// System.out.println( Math.sin(Math.toRadians(45)) );

// Inverse Trigonometric methods ---
// All values are returned as radians
// double value = 0.707;
// System.out.println("acos(" + value + ") is " + Math.acos(value));
// System.out.println("asin(" + value + ") is " + Math.asin(value));
// System.out.println("atan(" + value + ") is " + Math.atan(value));
// System.out.print( "Arco cuya tangente es 1: ");
// System.out.println( Math.toDegrees(Math.atan(1)) );

// System.out.print( "Mayor valor entre 2 y 3: ");
// System.out.println( Math.max(2,3) );
// System.out.println("minimo valor entre (" + i + "," + j + ") es " +
// Math.min(i,j));

// System.out.print( "Valor absoluto de -4,5: ");
// System.out.println( Math.abs(-4.5) );

// System.out.print( "Menor entero m? cercano a -4,5: ");
// System.out.println( Math.floor(-4.5) );
// System.out.print( "Mayor entero m? cercano a -4,5: ");
// System.out.println( Math.ceil(-4.5) );

// System.out.print( "Redondeando -4,5 con ROUND: ");
// System.out.println( Math.round(-4.5) );
// System.out.print( "Redondeando 4,5 con ROUND: ");
// System.out.println( Math.round(4.5) );
// System.out.print( "Redondeando -4,6 con RINT: ");
// System.out.println( Math.rint(-4.6) );
// System.out.print( "Redondeando -4,5 con RINT: ");
// System.out.println( Math.rint(4.5) );
