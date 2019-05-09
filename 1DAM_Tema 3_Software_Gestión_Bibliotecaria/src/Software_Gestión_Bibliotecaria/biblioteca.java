package Software_Gestión_Bibliotecaria;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


/***
 * Programa: Software de gestión de una biblioteca
 *  
 *  Programa que permitirá añadir y gestiónar el prestamo de libros en una base de datos 
 * 
 *           
 * Autor: Pedro Daniel Pérez Sánchez
 *
 * Fecha: 21/12/2018
 *
 * Materia: Programción
 *
 * Curso: 1ºDAM
 *
 ***/ 


public class biblioteca {

	//###### Atributos Globales #####
	public static long cont_num = 0;
	//Vector de objetos que simula el archivo (Base de datos)
	static libro Ejemplar[] = new libro[1000];
	
	
	//###### Metodos de Utilidad #####
	
	
	//Metodo: pedirle datos al usuario
	public static String getDato(String text,int parametro) {
		/*
		 * Parametro 1: Metodo devuelve un numero dado por el usuario
		 * en el rango [0-4], lo uso para la opción del menu
		 * 
		 * Parametro 2: Devuelve la siguiente palabra introducida por el usuario
		 * 
		 * Parametro 3: Devuelve un DNI valido
		 * 
		 * Parametro 4: Devuelve varias palabras en un String
		 * 
		 * Parametro 5: Devuelve un valor numerico dado por el usuario en un string
		 * 
		 * El metodo muestra por pantalla el texto que le pasemos 
		 * devuelve un string con la salida validada según el parametro pasado
		 * 
		 * */
		
		
		//Variables locales del metodo
		String auxs = "-"; //Variable auxiliar que almacena un strings
		int aux = 0; //Variable auxiliar que almacena un valor entero
		double auxd = 0; //Variable auxiliar que almacena un valor de tipo long
		boolean v = false; //Flag que marca si el valor es valido o no
		
		//Declaro el objeto Scanner
		Scanner t = new Scanner(System.in);
		
		switch(parametro) {
		case 1: //Valor a solicitar: Entero positivo del 1 al 5
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.print(text);
					//Pido un numero entero
					aux = t.nextInt();
					
					//Si el rango no es correcto, repetimos el while
					if(aux<0||aux>5) {
						System.out.println("Debes introducir un numero en el rango [0-4]");
						v=false;
					}
				}
				catch(Exception e){
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			auxs = Integer.toString(aux);
			break;
		case 2: //Valor a solicitar: Palabra introducida por el usuario
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<3||auxs.length()>15) {
						System.out.println("Debes introducir una palabra entre 3 y 15 caracteres");
						v=false;
					}
					//Si hay un numero, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
							i=auxs.length();
							System.out.println("Debes introducir una palabra entre 3 y 15 caracteres, no numeros");
							v=false;
							
						}
					}
					
					
				}
				catch(Exception e){
					System.out.println("¡La palabra introducida no es valida!");
					t.next();
					v=false;
				}
			}while(!v);
			
			break;
		case 3: //Devuelve un DNI en String 
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<8||auxs.length()>9) {
						System.out.println("Debes introducir un DNI(Sin letra) de 8 Numeros enteros");
						v=false;
					}
					//Si hay un caracter, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
							v=true;
							//Numero correcto
							
						}else { //Hay un caracter
							System.out.println("Debes introducir un DNI(Sin letra) de 8 Numeros enteros");
							i=auxs.length();
							v=false;							
							
						}
					}
					
				}
				catch(Exception e){
					System.out.println("¡El numero introducido no es valido!!");
					t.next();
					v=false;
				}
			}while(!v);
			break;
		case 4: //Parametro 4: Devuelve varias palabras en un String 
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Guardo la siguiente linea completa
					auxs = t.nextLine();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<4) {
						System.out.println("Debes introducir un minimo de 4 caracteres para este elemento");
						v=false;
					}
					
				}
				catch(Exception e){
					System.out.println("¡El texto introducida no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			break;
			
		case 5: //Parametro 5: Devuelve un valor numerico dado por el usuario en un string
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Guardo la siguiente linea completa
					aux = t.nextInt();
					
					//Si el rango no es correcto, repetimos el while
					if(aux<=-1) {
						System.out.println("Debes introducir un valor positivo");
						v=false;
					}
					
				}
				catch(Exception e){
					System.out.println("¡El valor introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			auxs = Integer.toString(aux);
			
			break;
		
		}
		
		
		
		//Devuelvo un String
		return auxs;
	}
	
	//Metodo que rellena con "0" a la isquierda
	public static String formaCuenta(long ndecuenta) {
		
		/*
		 * El Numero de la cuenta debe tener 3 digitos, por lo 
		 * que si tiene 2 digitos, le añado un "0" a la isquierda
		 * 
		 * */
		
		String auxs="000";
		
		switch(Long.toString(ndecuenta).length()) {
		case 1: //Si Long solo tiene un digito, entonces le añado 2 "0"
			auxs = "00"+Long.toString(ndecuenta);
			break;			
		case 2: //Si Long tiene 2 digitos, entonces le añado un "0"
			auxs = "0"+Long.toString(ndecuenta);
			break;
		default:
			auxs = "000";
			break;
		}
		
		return auxs;
	}
	
	//Metodo: genera un numero aleatorio entre un maximo y un minimo
	public static int getAleatorio(int min, int max) {
		/*
		 * Metodo que devuelve un valor aleatorio
		 * entre el min y el max que le pasemos
		 * 
		 * */
		
		
		//Variables Locales
		int num = 0; //Array que contendrá los numeros a devolver
		
		num=(int)Math.floor(Math.random()*(max-min+1)+min);
		
		return num;
	}
			
	
	//####### Metodos Especificos del programa ######
	
	/* Prestar Libros */
	//Metodo que Permite prestar un libro con su codigo
	public static void prestarLibro_Cod() {
		
		//Variable que uso para guardar el codigo del ejemplar a prestar
		String cod_a_modificar = "0";
		
		//Posición del ejemplar correcto
		int peb = 0;
		
		//Pido el codigo del ejemplar
		cod_a_modificar = getDato("Introduce el codigo exacto del ejemplar a prestar",4);
		
		int i = 0;
		
		
		for ( i = 0 ; i <= (int) cont_num; i++) {
			
			try {
				//Si getCodigo es igual a el codigo dado por el usuario entonces:
				if(Ejemplar[i].getCodigo().contentEquals(cod_a_modificar)) {
					//Guardo la posición del objeto que coincide
					peb = i;
					//Ahorro ciclos del programa
					i = (int) cont_num;
				}
			}
			catch(Exception e) {}	
		}
		
		
		if(peb==0) {
			System.out.println();
			System.out.println("No se ha podido encontrar el codigo en la base de datos.");
			System.out.println("Compruebe el codigo y vuelvalo a intentar.");
		}else if(Ejemplar[peb].getEstado().contentEquals("En Colección")==false) {
			
			System.out.println();
			System.out.println("El Ejemplar "+Ejemplar[peb].getTitulo()+" con codigo: "+Ejemplar[peb].getCodigo());
			System.out.println("Se encuentra "+Ejemplar[peb].getEstado());
			
			//Creo un Simple Date Formart para formatear mi fecha
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
			
			System.out.println("Desde el día: "+sdf.format(Ejemplar[peb].getFecha_prestado()));
			
			
		}else{
			System.out.println();
			System.out.println("** Se ha encontrado una Coincidencia!: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("*. Titulo del libro: "+Ejemplar[peb].getTitulo());
			System.out.println("*. SubTitulo del libro: "+Ejemplar[peb].getSubtitulo());
			System.out.println("*. Autor Principal: "+Ejemplar[peb].getAutor_principal());
			System.out.println("*. Otros Autores: "+Ejemplar[peb].getAutores());
			System.out.println("*. Editorial: "+Ejemplar[peb].getEditorial());
			System.out.println("*. Año de publicación: "+Ejemplar[peb].getAño());
			System.out.println("*. ISBN: "+Ejemplar[peb].getISBN());
			System.out.println("*. Categoria: "+Ejemplar[peb].getCategoria());
			System.out.println("*. Idioma: "+Ejemplar[peb].getIdioma());
			System.out.println("*. Codigo: "+Ejemplar[peb].getCodigo());
			System.out.println("*. Estado: "+Ejemplar[peb].getEstado());			
			System.out.println("-------------------------------------------------------");
			System.out.println();
			
			String opc =getDato("Introduzca un 1 para Prestar o un 0 para Cancelar",5);
			
			if(Integer.parseInt(opc)==1) {
				try {
					Ejemplar[peb].setEstado("Prestado a "+getDato("Introduzca el nombre de la persona a la que se le va a prestar",4));
					
					//Date FP = new Date();Ejemplar[peb].setFecha_prestado(FP);
					//Creo un objeto Gregorian Calendar y le paso al objeto la captura del momento
					Calendar c = GregorianCalendar.getInstance();
					Ejemplar[peb].setFecha_prestado(c.getTime());
					
				}
				catch(Exception e){
					System.out.println("No se ha podido realizar el prestamo. Codigo de Error: "+e);
				}
			}else {
				System.out.println("Se ha cancelado el prestamo del ejemplar");
				System.out.println();
			}
			
		}

		
		
	}
	
	//Metodo que comprueba la fecha a la que fue prestado un libro
	public static void comprobarF_Prestamo() {
		
		//Variable que uso para guardar el codigo del ejemplar
		String cod_a_modificar = "0";
		
		//Posición del ejemplar correcto
		int peb = 0;
		
		//Pido el codigo del ejemplar
		cod_a_modificar = getDato("Introduce el codigo exacto del ejemplar a consultar el estado del prestamo",4);
		
		int i = 0;
		
		for ( i = 0 ; i <= (int) cont_num; i++) {
			
			try {
				//Si getCodigo es igual a el codigo dado por el usuario entonces:
				if(Ejemplar[i].getCodigo().contentEquals(cod_a_modificar)) {
					//Guardo la posición del objeto que coincide
					peb = i;
					//Ahorro ciclos del programa
					i = (int) cont_num;
				}
			}
			catch(Exception e) {}	
		}
		
		
		if(peb==0) {
			System.out.println();
			System.out.println("No se ha podido encontrar el codigo en la base de datos.");
			System.out.println("Compruebe el codigo y vuelvalo a intentar.");
		}else {
			
			//Si el libro no esta prestado se lo digo al usuario
			if(Ejemplar[peb].getEstado().contentEquals("En Colección")) {
				System.out.println("El Ejemplar "+Ejemplar[peb].getTitulo()+" con codigo: "+Ejemplar[peb].getCodigo());
				System.out.println("No se encuentra en un estado de prestamo, actualmente esta guardado en la biblioteca");
				System.out.println();
			}else { //Si el libro esta prestado, entonces doy la información
				
				//Creo un Simple Date Formart para formatear mi fecha
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
				
				System.out.println("El Ejemplar "+Ejemplar[peb].getTitulo()+" con codigo: "+Ejemplar[peb].getCodigo());
				System.out.print("Se presto el dia ");
				System.out.println(sdf.format(Ejemplar[peb].getFecha_prestado()));
				
				
			}
			
			
			
			System.out.println();
			System.out.println("** Se ha encontrado una Coincidencia: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("*. Titulo del libro: "+Ejemplar[peb].getTitulo());
			System.out.println("*. SubTitulo del libro: "+Ejemplar[peb].getSubtitulo());
			System.out.println("*. Autor Principal: "+Ejemplar[peb].getAutor_principal());
			System.out.println("*. Otros Autores: "+Ejemplar[peb].getAutores());
			System.out.println("*. Editorial: "+Ejemplar[peb].getEditorial());
			System.out.println("*. Año de publicación: "+Ejemplar[peb].getAño());
			System.out.println("*. ISBN: "+Ejemplar[peb].getISBN());
			System.out.println("*. Categoria: "+Ejemplar[peb].getCategoria());
			System.out.println("*. Idioma: "+Ejemplar[peb].getIdioma());
			System.out.println("*. Codigo: "+Ejemplar[peb].getCodigo());
			System.out.println("*. Estado: "+Ejemplar[peb].getEstado());			
			System.out.println("-------------------------------------------------------");
			System.out.println();
			
		}
	}
	
	//Metodo que nos permite devolver un libro
	public static void devolverLibro_Cod() {
		
		//Variable que uso para guardar el codigo del ejemplar a prestar
		String cod_a_devolver = "0";
		
		//Posición del ejemplar correcto
		int peb = 0;
		
		//Pido el codigo del ejemplar
		cod_a_devolver = getDato("Introduce el codigo exacto del ejemplar a devolver",4);
		
		
		int i = 0;
		
		
		for ( i = 0 ; i <= (int) cont_num; i++) {
			
			try {
				//Si getCodigo es igual a el codigo dado por el usuario entonces:
				if(Ejemplar[i].getCodigo().contentEquals(cod_a_devolver)) {
					//Guardo la posición del objeto que coincide
					peb = i;
					//Ahorro ciclos del programa
					i = (int) cont_num;
				}
			}
			catch(Exception e) {}	
		}
		
		
		if(peb==0) {
			System.out.println();
			System.out.println("No se ha podido encontrar el codigo en la base de datos.");
			System.out.println("Compruebe el codigo y vuelvalo a intentar.");
		}else if(Ejemplar[peb].getEstado().contentEquals("En Colección")) {
			
			System.out.println();
			System.out.println("El Ejemplar "+Ejemplar[peb].getTitulo()+" con codigo: "+Ejemplar[peb].getCodigo());
			System.out.println("Se encuentra "+Ejemplar[peb].getEstado());
					
		}else{
			System.out.println();
			System.out.println("** Se ha encontrado una Coincidencia!: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("*. Titulo del libro: "+Ejemplar[peb].getTitulo());
			System.out.println("*. SubTitulo del libro: "+Ejemplar[peb].getSubtitulo());
			System.out.println("*. Autor Principal: "+Ejemplar[peb].getAutor_principal());
			System.out.println("*. Otros Autores: "+Ejemplar[peb].getAutores());
			System.out.println("*. Editorial: "+Ejemplar[peb].getEditorial());
			System.out.println("*. Año de publicación: "+Ejemplar[peb].getAño());
			System.out.println("*. ISBN: "+Ejemplar[peb].getISBN());
			System.out.println("*. Categoria: "+Ejemplar[peb].getCategoria());
			System.out.println("*. Idioma: "+Ejemplar[peb].getIdioma());
			System.out.println("*. Codigo: "+Ejemplar[peb].getCodigo());
			System.out.println("*. Estado: "+Ejemplar[peb].getEstado());			
			System.out.println("-------------------------------------------------------");
			System.out.println();
			
			String opc =getDato("Introduzca un 1 para Devolver o un 0 para Cancelar",5);
			
			if(Integer.parseInt(opc)==1) {
				try {
					//Pongo el ejemplar en estado de colección
					Ejemplar[peb].setEstado("En Colección");
					
					System.out.println();
					System.out.println("El ejemplar se ha devuelto correctamente");
					
				}
				catch(Exception e){
					System.out.println("No se ha podido realizar el prestamo. Codigo de Error: "+e);
				}
			}else {
				System.out.println("Se ha cancelado el prestamo del ejemplar");
				System.out.println();
			}
			
		}
		
		
	}
	
	
	/* Eliminar Libros */

	//Metodo que elimina ejemplares de la coleción
	public static void deleteEjemplar() {
		
		//Variable que uso para guardar el codigo del ejemplar a prestar
				String cod_a_devolver = "0";
				
				//Posición del ejemplar correcto
				int peb = 0;
				
				//Pido el codigo del ejemplar
				cod_a_devolver = getDato("Introduce el codigo exacto del ejemplar a Eliminar",4);
				
				
				int i = 0;
				
				
				for ( i = 0 ; i <= (int) cont_num; i++) {
					
					try {
						//Si getCodigo es igual a el codigo dado por el usuario entonces:
						if(Ejemplar[i].getCodigo().contentEquals(cod_a_devolver)) {
							//Guardo la posición del objeto que coincide
							peb = i;
							//Ahorro ciclos del programa
							i = (int) cont_num;
						}
					}
					catch(Exception e) {}	
				}
				
				
				if(peb==0) {
					System.out.println();
					System.out.println("No se ha podido encontrar el codigo en la base de datos.");
					System.out.println("Compruebe el codigo y vuelvalo a intentar.");
				}else if(Ejemplar[peb].getEstado().contentEquals("Eliminado")) {
					
					System.out.println();
					System.out.println("Este ejemplar ya ha sido eliminado");
							
				}else{
					System.out.println();
					System.out.println("** Se ha encontrado una Coincidencia!: ");
					System.out.println("-------------------------------------------------------");
					System.out.println("*. Titulo del libro: "+Ejemplar[peb].getTitulo());
					System.out.println("*. SubTitulo del libro: "+Ejemplar[peb].getSubtitulo());
					System.out.println("*. Autor Principal: "+Ejemplar[peb].getAutor_principal());
					System.out.println("*. Otros Autores: "+Ejemplar[peb].getAutores());
					System.out.println("*. Editorial: "+Ejemplar[peb].getEditorial());
					System.out.println("*. Año de publicación: "+Ejemplar[peb].getAño());
					System.out.println("*. ISBN: "+Ejemplar[peb].getISBN());
					System.out.println("*. Categoria: "+Ejemplar[peb].getCategoria());
					System.out.println("*. Idioma: "+Ejemplar[peb].getIdioma());
					System.out.println("*. Codigo: "+Ejemplar[peb].getCodigo());
					System.out.println("*. Estado: "+Ejemplar[peb].getEstado());			
					System.out.println("-------------------------------------------------------");
					System.out.println();
					
					System.out.println("¡¡¿Está seguro de que desea eliminar este ejemplar?!!");
					String opc =getDato("Introduzca un 1 para Eliminar o un 0 para Cancelar",5);
					
					if(Integer.parseInt(opc)==1) {
						try {
							//Pongo el ejemplar en estado "Eliminado"
							Ejemplar[peb].setEstado("En Colección");
							
							//Borro todos los datos del objeto
							Ejemplar[peb] = null;
							
							System.out.println();
							System.out.println("El ejemplar ha sido eliminado correctamente");
							
						}
						catch(Exception e){
							System.out.println("No se ha podido realizar el borrado. Codigo de Error: "+e);
						}
					}else {
						System.out.println("Se ha cancelado el borrado del ejemplar");
						System.out.println();
					}
					
				}
		
		
	}
	
	//---------------------------------------------------
	/* Añadir libros */
	
	//Metodo que añade Ejemplares de libros a la colección 
	public static void addEjemplar() {
		
		//crear objeto
		libro Ejemplar_Temp = new libro();
		
		Ejemplar_Temp.setTitulo(getDato("Introduce el Título exacto del libro.",4));
		Ejemplar_Temp.setSubtitulo(getDato("Introduce un Subtitulo",4));
		Ejemplar_Temp.setAutor_principal(getDato("Introduce el Nombre Completo del Autor Principal",4));
		Ejemplar_Temp.setAutores(getDato("Introduce el nombre de los otros autores, separados por comas",4));
		Ejemplar_Temp.setEditorial(getDato("Introduce el nombre de la editorial",4));
		Ejemplar_Temp.setAño(getDato("Introduce el año del libro en formato numerico, ejemplo: 2018",5));
		Ejemplar_Temp.setISBN(getDato("Introduce el ISBN",4));
		Ejemplar_Temp.setCategoria(getDato("Introduce la categoria principal del ejemplar",2));
		Ejemplar_Temp.setIdioma(getDato("Introduce el idioma",2));
		
		//####### Generamos el codigo
		
		//Creando el codigo del Ejemplar
		
		char[] v_codigo = new char[9];
		
		//CATEGORIA
		v_codigo[0] = Ejemplar_Temp.getCategoria().toUpperCase().charAt(0);
		v_codigo[1] = Ejemplar_Temp.getCategoria().toUpperCase().charAt(1);
		v_codigo[2] = Ejemplar_Temp.getCategoria().toUpperCase().charAt(2);
		
		//AUTOR
		v_codigo[3] = Ejemplar_Temp.getAutor_principal().toLowerCase().charAt(0);
		v_codigo[4] = Ejemplar_Temp.getAutor_principal().toLowerCase().charAt(1);
		v_codigo[5] = Ejemplar_Temp.getAutor_principal().toLowerCase().charAt(2);
		
		//Aumentamos el contador de libros
		cont_num++;
		
		//CODIGO NUMERICO
		//Dependiendo de la cantidad de libros guardados, le doy forma al cod numerico 
		String cod = "000";
		switch(Long.toString(cont_num).length()) {
		case 1: 
			cod = "00"+Long.toString(cont_num);
			break;
		case 2: 
			cod = "0"+Long.toString(cont_num);
			break;
		default: 
			System.out.println("La versión de prueba ha llegado a su limite de libros");
			break;
		}
		
		v_codigo[6] = cod.charAt(0);
		v_codigo[7] = cod.charAt(1);
		v_codigo[8] = cod.charAt(2);
		
		//Paso el contenido del vector de chars a una variable string
		String code = new String(v_codigo);
		
		Ejemplar_Temp.setCodigo(code);
		
		System.out.println();
		System.out.println("¿Desea dar de alta un nuevo libro con la siguiente información?");
		System.out.println("-------------------------------------------------------");
		System.out.println("Titulo del libro: "+Ejemplar_Temp.getTitulo());
		System.out.println("SubTitulo del libro: "+Ejemplar_Temp.getSubtitulo());
		System.out.println("Autor Principal: "+Ejemplar_Temp.getAutor_principal());
		System.out.println("Otros Autores: "+Ejemplar_Temp.getAutores());
		System.out.println("Editorial: "+Ejemplar_Temp.getEditorial());
		System.out.println("Año de publicación: "+Ejemplar_Temp.getAño());
		System.out.println("ISBN: "+Ejemplar_Temp.getISBN());
		System.out.println("Categoria: "+Ejemplar_Temp.getCategoria());
		System.out.println("Idioma: "+Ejemplar_Temp.getIdioma());
		System.out.println("Codigo: "+Ejemplar_Temp.getCodigo());
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		String opc = getDato("Escriba 1 para confirmar o escriba 2 para cancelar: ",1);
		
		if(Integer.parseInt(opc)==1) {
			Ejemplar[(int) cont_num] = new libro(Ejemplar_Temp);
			System.out.println("- Se ha registrado el nuevo ejemplar :D");
		}else {
			System.out.println("Se ha cancelado el alta del nuevo ejemplar");
			cont_num--;
		}
		
	}
	
	//Metodo que nos permite modificar un ejemplar
	public static void changeEjemplar() {
		
		//Variable que uso para guardar el codigo del ejemplar a modificar
		String cod_a_modificar = "0";
		
		//Posición del ejemplar correcto
		int peb = 0;
		
		//Pido el codigo del ejemplar
		cod_a_modificar = getDato("Introduce el codigo exacto del ejemplar a modificar",4);
		
		int i = 0;
		
		
		for ( i = 0 ; i <= (int) cont_num; i++) {
			
			try {
				//Si getCodigo es igual a el codigo dado por el usuario entonces:
				if(Ejemplar[i].getCodigo().contentEquals(cod_a_modificar)) {
					//Guardo la posición del objeto que coincide
					peb = i;
					//Ahorro ciclos del programa
					i = (int) cont_num;
				}
			}
			catch(Exception e) {}	
		}
		
		
		if(peb==0) {
			System.out.println();
			System.out.println("No se ha podido encontrar el codigo en la base de datos.");
			System.out.println("Compruebe el codigo y vuelvalo a intentar.");
		}else {
			System.out.println();
			System.out.println("** Se ha encontrado una Coincidencia: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("1. Titulo del libro: "+Ejemplar[peb].getTitulo());
			System.out.println("2. SubTitulo del libro: "+Ejemplar[peb].getSubtitulo());
			System.out.println("3. Autor Principal: "+Ejemplar[peb].getAutor_principal());
			System.out.println("4. Otros Autores: "+Ejemplar[peb].getAutores());
			System.out.println("5. Editorial: "+Ejemplar[peb].getEditorial());
			System.out.println("6. Año de publicación: "+Ejemplar[peb].getAño());
			System.out.println("7. ISBN: "+Ejemplar[peb].getISBN());
			System.out.println("8. Categoria: "+Ejemplar[peb].getCategoria());
			System.out.println("9. Idioma: "+Ejemplar[peb].getIdioma());
			System.out.println("   Codigo: "+Ejemplar[peb].getCodigo());
			System.out.println("-------------------------------------------------------");
			System.out.println();
			
			System.out.println("Escriba el numero del valor que desee modificar: ");
			String opc =getDato("Introduzca un 0 para si no desea modificar ningún valor",5);
			
			switch(opc) {
			case "0":
				System.out.println();
				System.out.println("La modificación ha sido cancelada");
				System.out.println();
				break;
			case "1":
				System.out.println();
				try{
					Ejemplar[peb].setTitulo(getDato("Introduzca un nuevo Titulo",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "2":
				System.out.println();
				try{
					Ejemplar[peb].setSubtitulo(getDato("Introduzca un nuevo Subtitulo",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "3":
				System.out.println();
				try{
					Ejemplar[peb].setAutor_principal(getDato("Introduzca un nuevo Autor Principal",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "4":
				System.out.println();
				try{
					Ejemplar[peb].setAutores(getDato("Introduzca nuevos Autores",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "5":
				System.out.println();
				try{
					Ejemplar[peb].setEditorial(getDato("Introduzca una nueva Editorial",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "6":
				System.out.println();
				try{
					Ejemplar[peb].setAño(getDato("Introduzca un nuevo Año de publicación",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "7":
				System.out.println();
				try{
					Ejemplar[peb].setISBN(getDato("Introduzca un nuevo ISBN",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "8":
				System.out.println();
				try{
					Ejemplar[peb].setCategoria(getDato("Introduzca una nueva Categoria",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			case "9":
				System.out.println();
				try{
					Ejemplar[peb].setIdioma(getDato("Introduzca un nuevo Idioma",4));
					System.out.println();
					System.out.println();
					System.out.println("Los cambios fueron realizados con éxito");
				}catch(Exception e){};
				System.out.println();
				break;
			default:
				System.out.println();
				System.out.println("La modificación ha sido cancelada");
				break;
			}
		}
		
	}
	
	//Metodo que muestra los ultimos 5 ejemplares añadidos
	public static void showLast_five_Ejemplar(){
		
		long cont_local = cont_num;//cont_num;
		//Ejemplares a mostrar
		int em = 5;
		
		
		if(cont_local==0) {
			
			System.out.println("-----------------------------");
			System.out.println("No hay ejemplares que mostrar");
			System.out.println("-----------------------------");
			
		}else {
		
			System.out.println("+--------------------------------------------------------------+");
			System.out.println("| 1: Codigo | 2: Titulo | 3: Estado | 4: Año | 5: Autor        |");
			System.out.println("+--------------------------------------------------------------+");
			
			for (int i = (int) (cont_local); i > cont_local-em; i--) {
				
				try {
					System.out.println("| 1: "+Ejemplar[i].getCodigo()+" | 2: "+Ejemplar[i].getTitulo()+" | 3: "+Ejemplar[i].getEstado()+" | 4: "+Ejemplar[i].getAño()+" | 5: "+Ejemplar[i].getAutor_principal()+" |");
				}
				catch(Exception e){
					
				}
			}
			System.out.println("----------------------------------------------------------------");
			System.out.println("Estos son los ultimos 5 ejemplares añadidos");
			
		}
		
	}
	
	//Metodo que nos muestra todos los ejemplares de la colección
	public static void showAllEjemplar() {
		
		if (cont_num==0) {
				System.out.println("-----------------------------");
				System.out.println("No hay ejemplares que mostrar");
				System.out.println("-----------------------------");
		
		}else {
			
			System.out.println("+--------------------------------------------------------------+");
			System.out.println("| 1: Codigo | 2: Titulo | 3: Autor | 4: Año | 5: Estado        |");
			System.out.println("+--------------------------------------------------------------+");
			
		
			for (int i = 1; i <=(int) cont_num; i++) {
				
				try {
					System.out.println("| 1: "+Ejemplar[i].getCodigo()+" | 2: "+Ejemplar[i].getTitulo()+" | 3: "+Ejemplar[i].getAutor_principal()+" | 4: "+Ejemplar[i].getAño()+" | 5: "+Ejemplar[i].getEstado()+" |");
				}
				catch(Exception e){
					
				}
			}
			
			System.out.println("----------------------------------------------------------------");
			System.out.println("Estos son todos los ejemplares registrados en la colección");
		
		
		}
		
	}
	
	//---------------------------------------------------
	
	/*Metodos de Testeo*/
	//Metodo que introduce 10 libros en la base de datos
	public static void metodoTesteo() {
		
		//Creando el codigo del Ejemplar
		char[] v_codigo = new char[9];
		
		int i = 1;
			
		//Introduzco un libro de prueba, 10 veces
		for (int j = 1; j <= 10; j++) {
			
			//Aumento el contador de libros ya que estoy creando uno nuevo
			cont_num++;
			//System.out.println(cont_num);
			
			//creo un objeto en esa ubicación del indice
			Ejemplar[j] = new libro();
			
			
			Ejemplar[j].setTitulo("Libro de Prueba Nº"+i);
			Ejemplar[j].setSubtitulo("Subtitulo de Prueba Nº"+i);
			Ejemplar[j].setAutor_principal("Autor de prueba Nº"+i);
			Ejemplar[j].setAutores("No hay");
			Ejemplar[j].setEditorial("Editorial de prueba Nº"+i);
			Ejemplar[j].setAño("2000");
			Ejemplar[j].setISBN("9788474648769");
			Ejemplar[j].setCategoria("Aventura");
			Ejemplar[j].setIdioma("Español");
			
			//####### Generamos el codigo
			
			//CATEGORIA
			v_codigo[0] = Ejemplar[j].getCategoria().toUpperCase().charAt(0);
			v_codigo[1] = Ejemplar[j].getCategoria().toUpperCase().charAt(1);
			v_codigo[2] = Ejemplar[j].getCategoria().toUpperCase().charAt(2);
			
			//AUTOR
			v_codigo[3] = Ejemplar[j].getAutor_principal().toLowerCase().charAt(0);
			v_codigo[4] = Ejemplar[j].getAutor_principal().toLowerCase().charAt(1);
			v_codigo[5] = Ejemplar[j].getAutor_principal().toLowerCase().charAt(2);
			
			//CODIGO NUMERICO
			//Dependiendo de la cantidad de libros guardados, le doy forma al cod numerico 
			String cod = "000";
			switch(Long.toString(cont_num).length()) {
			case 1: 
				cod = "00"+Long.toString(cont_num);
				break;
			case 2: 
				cod = "0"+Long.toString(cont_num);
				break;
			default: 
				System.out.println("La versión de prueba ha llegado a su limite de libros");
				break;
			}
			
			v_codigo[6] = cod.charAt(0);
			v_codigo[7] = cod.charAt(1);
			v_codigo[8] = cod.charAt(2);
			
			//Paso el contenido del vector de chars a una variable string
			String code = new String(v_codigo);
			//Establezco en el objeto el valor del codigo
			Ejemplar[j].setCodigo(code);
			
			i++;
			
			
		}
		
		//Genero un numero aleatorio entre 100 y 300 para simular esa cantidad de libros en la dB
		int a =  getAleatorio(300, 100); //300 = Max , 100 = min
		
		cont_num += Integer.toUnsignedLong(a);
		
		
		
		
	}
	
	//Metodo que muestra los libros introducidos en el metodo testeo
	public static void mostrarTesteo() {
		
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("| 1: Codigo | 2: Titulo | 3: Estado | 4: Año | 5: Autor        |");
		System.out.println("+--------------------------------------------------------------+");
		
		for (int i = 1; i <= 10; i++) {
			
			try {
				System.out.println("| 1: "+Ejemplar[i].getCodigo()+" | 2: "+Ejemplar[i].getTitulo()+" | 3: "+Ejemplar[i].getEstado()+" | 4: "+Ejemplar[i].getAño()+" | 5: "+Ejemplar[i].getAutor_principal()+" |");
			}
			catch(Exception e){
				
			}
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("Estos son los 10 ejemplares añadidos por el metodo testeo");
		
	}
	
	
	//Metodo Principal a Ejecutar
	public static void main(String[] args) {
		/*
		 *  MÉTODO PRINCIPAL A EJECUTAR 
		 *  
		 *  Contiene el flujo Global del programa
		 *  
		 *  */
		
		
		// DECLARACIÓN DE VARIABLES DE CABECERA 
		int aux = 0; //Variable local que almacena posición del menu
		String auxs; //Variable local que almacena un Strins
		
		
		// CABECERA DEL PROGRAMA 
		System.out.println("+--------------------------------------+");
		System.out.println("|                                      |");
		System.out.println("|   Software Gestión Bibliotecaria     |");
		System.out.println("|                                      |");
		System.out.println("|  17/02/2019            By Zoroboak   |");
		System.out.println("+--------------------------------------+");
				
		
		String dB = getDato("Introduzca ruta a la base de datos",4);

		//Metodo auxiliar para introducir libros que serán la prueba de testeo
		metodoTesteo();
		
		System.out.println("Bienvenido al programa de gestión bibliotecaria");
		System.out.println("Actualmente hay "+cont_num+" ejemplares registrados");
		System.out.println();
		
		
		do {
			
			System.out.println();				
			System.out.println("+-----------------------------------------------------+");
			System.out.println("+#####################################################+");
			System.out.println("+-----------------------------------------------------+");
			System.out.println("| <>  Gestión de Biblioteca Municipal                 |");
			System.out.println("+-----------------------------------------------------+");
			System.out.println("| 0.- Salir                                           |");
			System.out.println("| 1.- Prestar: Realiza el préstamo de un libro.       |");
			System.out.println("| 2.- Devolver: Realiza la devolución de un libro.    |");
			System.out.println("| 3.- Añadir: Añade un libro a la base de datos.      |");
			System.out.println("| 4.- Eliminar: Elimina un libro de la base de datos. |");
			System.out.println("+-----------------------------------------------------+");
			
			//Le paso al metodo getDato un String, el parametro que indica lo que 
			//tiene que hacer con el dato, y un array de Strings que no usaremos en este caso
			auxs = getDato("Escoge opción del menu: ",1);
			//Paso el String a entero para trabajar con el
			aux = Integer.parseInt(auxs);
			
			switch(aux) {
			case 0: //0. - SALIR DEL PROGRAMA
				System.out.println();
				System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
			case 1: //1.- Prestar: Realiza el préstamo de un libro.
				
				do {
					
					System.out.println();
					System.out.println("+-----------------------------------------------------+");
					System.out.println("|  >  Menu: Préstamo de libro.                        |");
					System.out.println("+-----------------------------------------------------+");
					System.out.println("| 0.- Volver al menu 'Gestión'                        |");
					System.out.println("| 1.- Prestar usando el Codigo del Libro.             |");
					System.out.println("| 2.- Comprobar Fecha de Prestamo de un libro         |");
					System.out.println("| 3.- Mostrar los ultimos 5 libros añadidos.          |");
					System.out.println("| 4.- Mostrar todos los libros disponibles.           |");
					System.out.println("+-----------------------------------------------------+");
					
					/*Le paso al metodo getDato un String, el parametro que indica lo que 
					tiene que hacer con el dato, y un array de Strings que no usaremos en este caso*/
					auxs = getDato("Escoge opción del menu: ",1);
					//Paso el String a entero para trabajar con el
					aux = Integer.parseInt(auxs);
					
					switch(aux) {
					case 0: //0. - Volver al menu 'Gestión' 
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Volviendo al menu 'Gestión' ");
						break;
					case 1: //1.- Prestar usando el Codigo del Libro. 
						
						//Metodo que presta libro usando el codigo del libro
						prestarLibro_Cod();
						
						break;
					case 2: //Comprobar Fecha de Prestamo de un libro 

						//Metodo que Comprueba la fecha que fue prestado un libro
						comprobarF_Prestamo();
						
						break;
					case 3: //Mostrar los ultimos 5 libros añadidos.
						
						//Metodo que muestra los ultimos 5 libros añadidos. 
						showLast_five_Ejemplar();
						
						break;
					case 4: //Mostrar todos los libros disponibles. 
						
						//Metodo que muestra todos los libros disponibles. 
						showAllEjemplar();
						
						break;
					}
				}while(aux!=0);
				
				aux = 5;
				
				
				//------------------------------------------------------------#
				break;
			case 2: //2.- Devolver: Realiza la devolución de un libro. 
				
				do {
					
					System.out.println();
					System.out.println("+-----------------------------------------------------+");
					System.out.println("|  >  Menu: Devolver Libro                            |");
					System.out.println("+-----------------------------------------------------+");
					System.out.println("| 0.- Volver al menu 'Gestión'                        |");
					System.out.println("| 1.- Devolver usando el Codigo del Libro.            |");
					System.out.println("| 2.- Comprobar Fecha de Prestamo de un libro         |");
					System.out.println("| 3.- Mostrar los ultimos 5 libros añadidos.          |");
					System.out.println("| 4.- Mostrar todos los libros Prestados.             |");
					System.out.println("+-----------------------------------------------------+");
					
					/*Le paso al metodo getDato un String, el parametro que indica lo que 
					tiene que hacer con el dato, y un array de Strings que no usaremos en este caso*/
					auxs = getDato("Escoge opción del menu: ",1);
					//Paso el String a entero para trabajar con el
					aux = Integer.parseInt(auxs);
					
					switch(aux) {
					case 0: //0. - Volver al menu 'Gestión' 
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Volviendo al menu 'Gestión' ");
						break;
					case 1: //1.- Prestar usando el Codigo del Libro. 
						
						//Metodo que presta libro usando el codigo del libro
						devolverLibro_Cod();
						
						break;
					case 2: //Comprobar Fecha de Prestamo de un libro 

						//Metodo que Comprueba la fecha que fue prestado un libro
						comprobarF_Prestamo();
						
						break;
					case 3: //Mostrar los ultimos 5 libros añadidos.
						
						//Metodo que muestra los ultimos 5 libros añadidos. 
						showLast_five_Ejemplar();
						
						break;
					case 4: //Mostrar todos los libros disponibles. 
						
						//Metodo que muestra todos los libros disponibles. 
						showAllEjemplar();
						
						break;
					default: //0. - Volver al menu 'Gestión' 
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Volviendo al menu 'Gestión' ");
						break;
					}
				}while(aux!=0);
				
				aux = 5;
				
				
				//------------------------------------------------------------#
				break;
			case 3: //3.- Añadir: Añade un libro a la base de datos
				
				do {
					
					System.out.println();
					System.out.println("+-----------------------------------------------------+");
					System.out.println("|  >  Menu: Añadir Ejemplar a la Colección            |");
					System.out.println("+-----------------------------------------------------+");
					System.out.println("| 0.- Volver al menu 'Gestión'                        |");
					System.out.println("| 1.- Añadir Ejemplar.                                |");
					System.out.println("| 2.- Modificar Ejemplar.                             |");
					System.out.println("| 3.- Mostrar los ultimos 5 ejemplares añadidos.      |");
					System.out.println("| 4.- Mostrar todos los ejemplares de la colección.   |");
					System.out.println("+-----------------------------------------------------+");
					
					/*Le paso al metodo getDato un String, el parametro que indica lo que 
					tiene que hacer con el dato, y un array de Strings que no usaremos en este caso*/
					auxs = getDato("Escoge opción del menu: ",1);
					//Paso el String a entero para trabajar con el
					aux = Integer.parseInt(auxs);
					
					switch(aux) {
					case 0: //0. - Volver al menu 'Gestión' 
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Volviendo al menu 'Gestión' ");
						break;
					case 1: //1. - Añadir Ejemplar.
						
						//Metodo que añade Ejemplares de libros a la colección
						addEjemplar();
						
						break;
					case 2: //2. - Modificar Ejemplar
						
						//Metodo que modifica un ejemplar si tienes el codigo
						changeEjemplar();
						
						break;
					case 3: //3. - Mostrar ejemplares por Autor.
						
						//Metodo que muestra los ultimos 5 ejemplares registrados 
						showLast_five_Ejemplar();
						
						break;
					case 4: //4. - Mostrar todos los ejemplares de la colección.
						
						//Metodo que nos muestra todos los ejemplares de la colección
						showAllEjemplar();
						
						break;
					}
				}while(aux!=0);
				
				aux = 5;
				
				
				//------------------------------------------------------------#
				break;
			case 4: //4.- Eliminar: Elimina un libro de la base de datos
				
				do {
					
					System.out.println();
					System.out.println("+-----------------------------------------------------+");
					System.out.println("|  >  Menu: Eliminar ejemplar a la Colección          |");
					System.out.println("+-----------------------------------------------------+");
					System.out.println("| 0.- Volver al menu 'Gestión'                        |");
					System.out.println("| 1.- Eliminar ejemplar por Codigo.                   |");
					System.out.println("| 2.- Modificar Ejemplar.                             |");
					System.out.println("| 3.- Mostrar los ultimos 5 ejemplares añadidos.      |");
					System.out.println("| 4.- Mostrar todos los ejemplares de la colección.   |");
					System.out.println("+-----------------------------------------------------+");
					
					/*Le paso al metodo getDato un String, el parametro que indica lo que 
					tiene que hacer con el dato, y un array de Strings que no usaremos en este caso*/
					auxs = getDato("Escoge opción del menu: ",1);
					//Paso el String a entero para trabajar con el
					aux = Integer.parseInt(auxs);
					
					switch(aux) {
					case 0: //0. - Volver al menu 'Gestión' 
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Volviendo al menu 'Gestión' ");
						break;
					case 1: //1. - Añadir Ejemplar.
						
						//Metodo que elimina Ejemplares de libros de la colección
						deleteEjemplar();
						
						break;
					case 2: //2. - Modificar Ejemplar
						
						//Metodo que modifica un ejemplar si tienes el codigo
						changeEjemplar();
						
						break;
					case 3: //3. - Mostrar ejemplares por Autor.
						
						//Metodo que muestra los ultimos 5 ejemplares registrados 
						showLast_five_Ejemplar();
						
						break;
					case 4: //4. - Mostrar todos los ejemplares de la colección.
						
						//Metodo que nos muestra todos los ejemplares de la colección
						showAllEjemplar();
						
						break;
					}
				}while(aux!=0);
				
				aux = 5;
				
				
				//------------------------------------------------------------#
				break;
			case 5://Menu oculto
				
				//Metodo que muestra los libros añadidos para testear
				mostrarTesteo();
				
				break; 
			}
			
		}while(aux!=0);
	}

}
