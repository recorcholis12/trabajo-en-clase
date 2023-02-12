package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

/**
 * clase para manejar el CRUD de un usuario o candidato
 * @author luisa rincon
 *
 */
public class UsuarioDAO {
	/**
	 *  clase Archivo
	 */
	private Archivo archivo;
	/**
	 * metodo constructor
	 * @param archivo en el que se tiene la informacion
	 */
	public UsuarioDAO(Archivo archivo) {
		this.archivo = archivo;
	}

	//CRUD
	/**
	 * metodo para mostrar todos los candidatos del archivo
	 * <b>pre</b> la lista no este vacia
	 * <b>pos</b> se pase la informacion a una matriz 
	 * @param lista donde se encuentra los usuarios
	 * @return String[][] matriz con la informacion
	 */
	public String[][] listarCandidatos(ArrayList<Usuario> lista){

		String informacion[][] = new String[lista.size()][5];
		for( int i =0;i<informacion.length;i++) {
			informacion[i][0] = lista.get(i).getNombre();
			informacion[i][1] = lista.get(i).getApellido();
			informacion[i][2] = String.valueOf(lista.get(i).getCedula());
			informacion[i][3] = String.valueOf(lista.get(i).getEdad());
			informacion[i][4] = lista.get(i).getCargo();

		}
		return informacion;
	}
	/**
	 * metodo para buscar un usuario
	 * <b>pre</b> la lista no este vacia y la cedula sea valida
	 * <b>pos</b> se encuentre el ususario 
	 * @param lista donde se encuentra los usuarios
	 * @param cedula para compararla con las de los usuarios de la lista
	 * @return Usuario. devuelve un objeto de tipo usuario
	 */
	public Usuario BuscarCandidato(int cedula, ArrayList<Usuario>lista) {
		Usuario encontrado = null;
		if (!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getCedula()== cedula) {
					encontrado = lista.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}
	/**
	 * metodo para buscar un usuario
	 * <b>pre</b> la lista no este vacia, el archivo exista y los parametros sean validos 
	 * <b>pos</b> se agregue el ususario 
	 * @param lista donde se encuentra los usuarios
	 * @param file. archivo donde se va a guardar el usuario
	 * @param nombre nombre!=null
	 * @param  apellido apellido!= null
	 * @param cedula  cedula>10000
	 * @param edad    edad>=18
	 * @param cargo   cargo!=null
	 * @return boolean. para verificar si se agrega o no un usuario
	 */
	public boolean agregarCandidato (String nombre, String apellido, int cedula, int edad, String cargo, ArrayList<Usuario>lista, File file) {
		
		if(BuscarCandidato(cedula, lista)== null) {
			Usuario nuevo = new Usuario (nombre,apellido,cedula,edad,cargo);
			lista.add(nuevo);
			archivo.escribirEnArchivo(lista, file);
			return true;	
		}else {
			return false;
		}
	}
	/**
	 * metodo para buscar un usuario
	 * <b>pre</b> la lista no este vacia y el archivo exista
	 * <b>pos</b> se elimine el ususario 
	 * @param lista donde se encuentra los usuarios
	 * @param cedula para compararla con las de los usuarios de la lista
	 * @param file archivo de donde se va a eliminar el usuario
	 * @return boolean para saber si se elimina o no el usuario
	 */
	public boolean eliminarCandidato(int cedula, ArrayList<Usuario> lista, File file) {
		try {
			Usuario e = BuscarCandidato(cedula, lista);
			if(e!= null) {
			lista.remove(e);
			file.delete();
			file.createNewFile();
			archivo.escribirEnArchivo(lista, file);
			return true;
			}else {
				return false;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
}
