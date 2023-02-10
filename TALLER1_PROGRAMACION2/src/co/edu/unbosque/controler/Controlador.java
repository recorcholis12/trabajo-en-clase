package co.edu.unbosque.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.VentanaPrincipal;
/**
 * esta clase contiene atributos y metodos que ayudan a cumplir la funcion
 * logica del programa
 * 
 * @author luisa rincon
 *
 */
public class Controlador implements ActionListener{

	/**
	 * clase del Jframe del programa
	 */
	private VentanaPrincipal ventanaprincipal;
	/**
	 * lista de candidatos
	 */
	private ArrayList<Usuario> lista;
	/**
	 * clase para leer y escribir en el archivo .dat
	 */
	private Archivo archivo;
	/**
	 * DAO de la clase usuario
	 */
	private UsuarioDAO userdao;
	/**
	 * archivo donde se serializa
	 */
	private File datos = new File("data/serializacion.dat");

	/**
	 * metodo constructor de la clase 
	 * <b>pos</b> se instancien las clases e inicialicen los atributos 
	 */
	public Controlador() {
		ventanaprincipal = new VentanaPrincipal();
		asignarOyentes ();
		lista = new ArrayList<Usuario>();
		archivo= new Archivo(datos);
		userdao = new UsuarioDAO(archivo);
		lista = archivo.leerArchivo(datos);
	}
	/**
	 * metodo para asignar los ayentes de los componentes que se les va a relacionar
	 * con un evento
	 *  <b>pos</b> Se  asigne los oyentes en la clase
	 */
	public void asignarOyentes() {
		ventanaprincipal.getPp().getAgregar().addActionListener(this);
		ventanaprincipal.getPp().getEliminar().addActionListener(this);
		ventanaprincipal.getPp().getModificar().addActionListener(this);
		ventanaprincipal.getPp().getBuscar().addActionListener(this);
		ventanaprincipal.getPp().getListar().addActionListener(this);
		ventanaprincipal.getPp().getEdad().addActionListener(this);

	}

	/**
	 * Este metodo se encarga de identificar acciones sobre un elemento del programa
	 * y manejar el evento
	 * <b>pos</b> se realize el evento al que corresponde un elemento
	 * @param e Evento que escucho la clase
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		if(comando.equals("AGREGAR")) {
			agregar();
			ventanaprincipal.getPp().getNom().setText("");
			ventanaprincipal.getPp().getApe().setText("");
			ventanaprincipal.getPp().getCedula().setText("");
			ventanaprincipal.getPp().getCargo().setText("");
		}
		if(comando.equals("BUSCAR")) {
			buscar();
		}
		if(comando.equals("LISTA")) {
			String [][] datos = userdao.listarCandidatos(lista);
			ventanaprincipal.getPp().getPi().llenartabla(datos);
		}
		if(comando.equals("ELIMINAR")) {
			eliminar();
		}
		if(comando.equals("MODIFICAR")) {
			modificar();
		}
	}
	/**
	 * metodo para agregar un candidato 
	 * <b>pos</b> se agregue el candidato correctamente
	 */
	public void agregar() {
		String nombre = ventanaprincipal.getPp().getNom().getText();
		String apellido = ventanaprincipal.getPp().getApe().getText();
		String cedula = ventanaprincipal.getPp().getCedula().getText();
		String edad = ventanaprincipal.getPp().getEdad().getItemAt(ventanaprincipal.getPp().getEdad().getSelectedIndex());
		String cargo = ventanaprincipal.getPp().getCargo().getText();

		if(!nombre.isEmpty()&&nombre!=""&&nombre!=null&&
				!apellido.isEmpty()&&apellido!=""&&apellido!=null&&
				!cedula.isEmpty()&&cedula!=""&&cedula!=null&&
				!cargo.isEmpty()&&cargo!=""&&cargo!=null) {

			if(nombre.toUpperCase().matches("([A-Z]+[ ]?){1,3}")&&apellido.toUpperCase().matches("([A-Z]+[ ]?){2}")&&cargo.toUpperCase().matches("([A-Z]+[ ]?){1,}")) {
				if(cedula.matches("\\d{5,10}")) {
					int cedul = Integer.valueOf(cedula);
					int ed = Integer.valueOf(edad);
					if(	userdao.agregarCandidato(nombre, apellido,cedul,ed,cargo,lista,datos)) {
						JOptionPane.showMessageDialog(ventanaprincipal,"SE AGREGO EL CANDIDATO CORRECTAMENTE");

					}else {
						JOptionPane.showMessageDialog(ventanaprincipal,"NO SE PUEDE AGREGAR EL CANDIDATO. YA EXISTE", null, JOptionPane.ERROR_MESSAGE);
					}	
				}else {
					JOptionPane.showMessageDialog(ventanaprincipal,"LA CEDULA SOLO CONTIENE NUMEROS", null, JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(ventanaprincipal,"NO SE ADMITEN CARACTERES ESPECIALES EN NOMBRE, APELLIDO Y CARGO", null, JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(ventanaprincipal,"COMPLETE TODOS LOS CAMPOS", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * metodo para buscar un candidato 
	 * <b>pos</b> se encuentre el candidato
	 */
	public void buscar() {
		String cedula = JOptionPane.showInputDialog(null, "INGRESE EL NUMERO DE CEDULA");
		if(!cedula.isEmpty()&&cedula!=""&&cedula!=null) {
			if(cedula.matches("\\d{5,10}")) {
				int cedul = Integer.valueOf(cedula);
				Usuario encontrado = userdao.BuscarCandidato(cedul, lista);
				if(encontrado!=null) {
					ArrayList<Usuario> tem = new ArrayList<Usuario>();
					tem.add(encontrado);
					String [][]datos = userdao.listarCandidatos(tem);
					ventanaprincipal.getPp().getPi().llenartabla(datos);
				}else {
					JOptionPane.showMessageDialog(ventanaprincipal,"EL CANDIDATO NO EXISTE", null, JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(ventanaprincipal,"LA CEDULA SOLO DEBE CONTIENE NUMEROS", null, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	/**
	 * metodo para eliminar un candidato 
	 * <b>pos</b> se elimine el candidato
	 */
	public void eliminar() {
		String cedula = JOptionPane.showInputDialog(null, "INGRESE EL NUMERO DE CEDULA");
		if(!cedula.isEmpty()&&cedula!=""&&cedula!=null) {
			if(cedula.matches("\\d{5,10}")) {
				int cedul = Integer.valueOf(cedula);
				Usuario encontrado = userdao.BuscarCandidato(cedul, lista);
				if(encontrado!=null) {
					userdao.eliminarCandidato(cedul, lista, datos);
					JOptionPane.showMessageDialog(null, "SE ELIMINO EL CANDIDATO CORRECTAMENTE");
				}else {
					JOptionPane.showMessageDialog(ventanaprincipal,"EL CANDIDATO NO EXISTE", null, JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(ventanaprincipal,"LA CEDULA SOLO DEBE CONTIENE NUMEROS", null, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	/**
	 * metodo para modificar un candidato 
	 * <b>pos</b> se modifique el candidato
	 */
	public void modificar() {
		String cedula = JOptionPane.showInputDialog(null, "INGRESE EL NUMERO DE CEDULA DEL CANDIDATO QUE DESEA MODIFICAR");
		if(!cedula.isEmpty()&&cedula!=""&&cedula!=null) {
			if(cedula.matches("\\d{5,10}")) {
				int cedul = Integer.valueOf(cedula);
				Usuario encontrado = userdao.BuscarCandidato(cedul, lista);
				if(encontrado!=null) {
					String opcion = JOptionPane.showInputDialog(null, "SELECCIONE UNA OPCION\n"+"1. MODIFICAR NOMBRE\n"+"2. MODIFICAR APELLIDO\n"+"3. MODIFICAR CEDULA\n"
				                                                       +"4. MODIFICAR EDAD\n"+ "5. MODIFICAR CARGO\n");
					
					if(!opcion.isEmpty()&&opcion!=""&&opcion!=null&&opcion.matches("\\d{1}")) {
						int x = Integer.valueOf(opcion);
						if(x==1) {
							String nombre = JOptionPane.showInputDialog(null, "INGRESE EL NOMBRE ");
							encontrado.setNombre(nombre);
						}else if(x==2) {
							String apellido = JOptionPane.showInputDialog(null, "INGRESE EL APELLIDO");
							encontrado.setApellido(apellido);
						}else if(x==3) {
							String cedu = JOptionPane.showInputDialog(null, "INGRESE LA CEDULA");
							encontrado.setCedula(Integer.valueOf(cedu));;
						}else if(x==4) {
							String edad = JOptionPane.showInputDialog(null, "INGRESE LA EDAD");
							encontrado.setEdad(Integer.valueOf(edad));
						}else if(x==5) {
							String cargo = JOptionPane.showInputDialog(null, "INGRESE EL CARGO");
							encontrado.setCargo(cargo);;
						}
						ArrayList<Usuario> tem = new ArrayList<Usuario>();
						tem.add(encontrado);
						String [][]datos = userdao.listarCandidatos(tem);
						ventanaprincipal.getPp().getPi().llenartabla(datos);
						JOptionPane.showMessageDialog(null, "SE MODIFICO EL CANDIDATO CORRECTAMENTE");
					}else {
						JOptionPane.showMessageDialog(ventanaprincipal,"EL DATO INGRESADO NO ES UNA OPCION", null, JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(ventanaprincipal,"EL CANDIDATO NO EXISTE", null, JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(ventanaprincipal,"LA CEDULA SOLO DEBE CONTIENE NUMEROS", null, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
