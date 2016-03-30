/**
 * 
 */
package es.upm.dit.isst.tfg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Clara
 *
 */
@Entity
public class TFG implements Serializable {

	private static final long serialVersionUID = 01L;
	
	@Id
	private String autor;
	private String titulo;
	private String resumen;
	private String tutor;
	private String secretario;
	private String fichero;
	private int estado;
	
	/**
	 * 
	 */
	public TFG(String autor, String titulo, String resumen, String tutor, String secretario, String fichero, int estado) {
		// TODO Auto-generated constructor stub
		this.autor = autor;
		this.titulo = titulo;
		this.resumen = resumen;
		this.tutor = tutor;
		this.secretario = secretario;
		this.fichero = fichero;
		this.estado = estado;
	}
	
	public void setAutor(String autor){
		this.autor = autor;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public void setResumen(String resumen){
		this.resumen = resumen;
	}
	
	public void setTutor(String tutor){
		this.tutor = tutor;
	}
	
	public void setSecretario(String secretario){
		this.secretario = secretario;
	}
	
	public void setFichero(String fichero){
		this.fichero = fichero;
	}
	
	public void setEstado(int estado){
		this.estado = estado;
	}
	
	public String getAutor(){
		return this.autor;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public String getResumen(){
		return this.resumen;
	}
	
	public String getTutor(){
		return this.tutor;
	}
	
	public String getSecretario(){
		return this.secretario;
	}
	
	public String getFichero(){
		return this.fichero;
	}
	
	public int getEstado(){
		return this.estado;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Autor: "+getAutor()+" | Título: "+getTitulo()+" | Resumen: "+getResumen()+" | Tutor: "+getTutor() +" | Secretario: "+getSecretario() +" | Fichero: "+getFichero() +" | Estado: "+getEstado();
	}

}
