package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * clase para crear el objeto usuario-candidato serializable
 * 
 * @author luisa rincon
 */
public class Usuario implements Serializable{

	/**
	 * atributo para serializar la clase
	 */
	private static final long serialversionUID = 1L;
	/**
	 * nombre del candidato
	 */
	private String nombre;
	/**
	 * apellido del candidato
	 */
	private String apellido;
	/**
	 * cedula del candidato
	 */
	private int cedula;
	/**
	 * edad del candidato
	 */
	private int edad;
	/**
	 * cargo del candidato 
	 */
	private String cargo;
	
	/**
	 * metodo constructor de la clase
	 * @param nombre nombre!=null
	 * @param  apellido apellido!= null
	 * @param cedula  cedula>10000
	 * @param edad    edad>=18
	 * @param cargo   cargo!=null
	 */
	public Usuario(String nombre, String apellido, int cedula, int edad, String cargo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.cargo = cargo;
	}

	/**
	 * metodo getter del atributo nombre
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * metodo setter del atributo nombre
	 * @param nombre atributo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * metodo getter del atributo apellido
	 * @return String
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * metodo setter del atributo apellido
	 * @param apellido atributo
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * metodo getter del atributo cedula
	 * @return int
	 */
	public int getCedula() {
		return cedula;
	}
	/**
	 * metodo setter del atributo cedula
	 * @param cedula atributo
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	/**
	 * metodo getter del atributo edad
	 * @return int
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * metodo setter del atributo edad
	 * @param edad atributo
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * metodo getter del atributo cargo
	 * @return String
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * metodo setter del atributo cargo
	 * @param cargo atributo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
}
