package Software_Gesti�n_Bibliotecaria;

import java.util.Date;


/***
 * Programa: Software de gesti�n de una biblioteca
 *  
 *  Programa que permitir� a�adir y gesti�nar el prestamo de libros en una base de datos 
 * 
 *           
 * Autor: Pedro Daniel P�rez S�nchez
 *
 * Fecha: 21/12/2018
 *
 * Materia: Programci�n
 *
 * Curso: 1�DAM
 *
 ***/ 


public class libro {
	
	private String titulo = "Campo Vacio";
	private String subtitulo = "Campo Vacio";
	private String autor_principal = "Campo Vacio";
	private String autores = "Campo Vacio";
	private String editorial = "Campo Vacio";
	private String a�o = "Campo Vacio";
	private String ISBN = "Campo Vacio";
	private String categoria = "Campo Vacio";
	private String idioma = "Campo Vacio";
	private String codigo = "Campo Vacio";
	private String estado = "En Colecci�n";
	private Date fecha_prestado = null;
	
	
	libro(){
		
	}
	
	libro(libro Ejemplar){
		
		//Tercer intento constructor copia
		titulo = Ejemplar.getTitulo();
		subtitulo = Ejemplar.getSubtitulo();
		autor_principal = Ejemplar.getAutor_principal();
		autores = Ejemplar.getAutores();
		editorial = Ejemplar.getEditorial();
		a�o = Ejemplar.getA�o();
		ISBN = Ejemplar.getISBN();
		categoria = Ejemplar.getCategoria();
		idioma = Ejemplar.getIdioma();
		codigo = Ejemplar.getCodigo();
		estado = Ejemplar.getEstado();
		fecha_prestado = Ejemplar.getFecha_prestado();
		
		
		
		
	}
	
	//##### Getters and settlers

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getSubtitulo() {
		return subtitulo;
	}


	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}


	public String getAutor_principal() {
		return autor_principal;
	}


	public void setAutor_principal(String autor_principal) {
		this.autor_principal = autor_principal;
	}


	public String getAutores() {
		return autores;
	}


	public void setAutores(String autores) {
		this.autores = autores;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public String getA�o() {
		return a�o;
	}


	public void setA�o(String a�o) {
		this.a�o = a�o;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFecha_prestado() {
		return fecha_prestado;
	}


	public void setFecha_prestado(Date fecha_prestado) {
		this.fecha_prestado = fecha_prestado;
	}
	
	
	
	

}
