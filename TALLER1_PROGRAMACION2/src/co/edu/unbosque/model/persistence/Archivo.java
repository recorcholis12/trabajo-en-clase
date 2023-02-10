package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
/**
 * clase encargada de escribir y leer objetos en un archivo serializable .dat
 * 
 * @author luisa rincon
 *
 */
public class Archivo {

	/**
	 * atributo para leer el archivo 
	 */
	private ObjectInputStream entrada;
	/**
	 * atributo para escribir en el archivo
	 */
	private ObjectOutputStream salida;

	/**
	 * metodo constructor de la clase 
	 * <b>pos</b>  se verifique que haya un archivo
	 * @param archivo que se va a leer o en el que se va a escribir 
	 */
	public Archivo(File archivo) {
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * metodo para escribir en el archivo serializable
	 * <b>pos</b> se serialize
	 * @param  lista que se va a escribir en el archivo
	 * @param  archivo en el que se va a escribir
	 */
	public void escribirEnArchivo(ArrayList<Usuario>lista, File archivo) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(lista);
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * metodo para escribir en el archivo serializable
	 * <b>pre</b> exista el archivo
	 * <b>pos</b> se deserialize
	 * @param archivo que se va a leer 
	 * @return ArrayList devuelve en una lista los objetos serializados
	 */
	public ArrayList<Usuario> leerArchivo(File archivo){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		if(archivo.length()!=0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(archivo));
				lista = (ArrayList<Usuario>) entrada.readObject();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}
	/**
	 * metodo getter de entrada
	 * @return ObjectInputStream
	 */
	public ObjectInputStream getEntrada() {
		return entrada;
	}
	/**
	 * metodo setter de entrada
	 * @param entrada lectura
	 */
	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}
	/**
	 * metodo getter de salida
	 * @return ObjectOutputStream
	 */
	public ObjectOutputStream getSalida() {
		return salida;
	}
	/**
	 * metodo setter de salida
	 * @param salida escritura
	 */
	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}
	
	
}
