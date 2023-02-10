package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
/**
 * clase para mostrar los botones y la tabla
 * @author luisa rincon
 *
 */
public class PanelPrincipal extends JPanel{

	/**
	 * campos de texto para completar la info de un usuario
	 */
	private JTextField nom, ape, cedula, cargo;
	/**
	 * lista desplegable para seleccionar la edad
	 */
	private JComboBox<String>edad;
	/**
	 * botones para realizar las funciones del CRUD
	 */
	private JButton buscar, eliminar, modificar, listar, agregar;
	/**
	 * panel info para mostrar la tabla
	 */
	private PanelInfo pi;

	/**
	 * metodo constructor de la clase
	 */
	public PanelPrincipal() {
		setLayout(null);
		inicializarcomponentes();

	}
	/**
	 * metodo para iniciar los componentes
	 * <b>pos</b> se inicializen los componentes y se agreguen al panel
	 */
	public void inicializarcomponentes() {
		pi = new PanelInfo();
		pi.setBounds(300,280,550,200 );
		pi.setBackground(Color.BLUE);

		JLabel nombre = new JLabel("PROGRAMACION 2");
		nombre.setFont(new Font("Italic",3, 60));
		nombre.setForeground(new Color(255,82,82));
		nombre.setBounds(150,50,600,100);

		nom = new JTextField ();
		ape = new JTextField ();
		cedula = new JTextField ();
		cargo = new JTextField ();

		nom.setBounds(50, 200, 150, 30);
		JLabel l1 = new JLabel("NOMBRE");
		l1.setBounds(50,190,150,100);

		ape.setBounds(200, 200, 150, 30);
		JLabel l2 = new JLabel("APELLIDO");
		l2.setBounds(205,190,150,100);

		cedula.setBounds(350, 200, 180, 30);
		JLabel l3 = new JLabel("CEDULA DE CIUDADANIA");
		l3.setBounds(355,190,150,100);

		cargo.setBounds(611, 200, 250, 30);
		JLabel l4 = new JLabel("CARGO");
		l4.setBounds(616,190,150,100);

		edad = new JComboBox<String>();
		edad.setActionCommand("EDAD");
		for (int i = 18; i < 120; i++) {
			edad.addItem(String.valueOf(i));
		}
		edad.setBounds(530,200,80,30);
		JLabel l5 = new JLabel("EDAD");
		l5.setBounds(535,190,150,100);

		agregar = new JButton("AGREGAR");
		agregar.setActionCommand("AGREGAR");
		agregar.setBounds(50,290,150,30);

		buscar = new JButton("BUSCAR");
		buscar.setActionCommand("BUSCAR");
		buscar.setBounds(50,330,150,30);

		modificar = new JButton("MODIFICAR");
		modificar.setActionCommand("MODIFICAR");
		modificar.setBounds(50,370,150,30);

		eliminar = new JButton("ELIMINAR");
		eliminar.setActionCommand("ELIMINAR");
		eliminar.setBounds(50,410,150,30);

		listar = new JButton("LISTAR");
		listar.setActionCommand("LISTA");
		listar.setBounds(50,450,150,30);



		add(nom);
		add(ape);
		add(cedula);
		add(edad);
		add(cargo);
		add(agregar);
		add(listar);
		add(pi);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(nombre);
		add(buscar);
		add(modificar);
		add(eliminar);


	}

	/**
	 * metodo getter del atributo nom
	 * @return the nom
	 */
	public JTextField getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	/**
	 * metodo getter del atributo ape
	 * @return the ape
	 */
	public JTextField getApe() {
		return ape;
	}

	/**
	 * @param ape the ape to set
	 */
	public void setApe(JTextField ape) {
		this.ape = ape;
	}

	/**
	 * metodo getter del atributo cedula
	 * @return the cedula
	 */
	public JTextField getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	/**
	 * metodo getter del atributo cargo
	 * @return the cargo
	 */
	public JTextField getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(JTextField cargo) {
		this.cargo = cargo;
	}

	/**
	 * metodo getter del atributo edad
	 * @return the edad
	 */
	public JComboBox<String> getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(JComboBox<String> edad) {
		this.edad = edad;
	}

	/**
	 * metodo getter del boton buscar
	 * @return the buscar
	 */
	public JButton getBuscar() {
		return buscar;
	}

	/**
	 * @param buscar the buscar to set
	 */
	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	/**
	 * metodo getter del boton eliminar
	 * @return the eliminar
	 */
	public JButton getEliminar() {
		return eliminar;
	}

	/**
	 * @param eliminar the eliminar to set
	 */
	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	/**
	 * metodo getter del boton modificar
	 * @return the modificar
	 */
	public JButton getModificar() {
		return modificar;
	}

	/**
	 * @param modificar the modificar to set
	 */
	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}

	/**
	 * metodo getter del boton listar
	 * @return the listar
	 */
	public JButton getListar() {
		return listar;
	}

	/**
	 * @param listar the listar to set
	 */
	public void setListar(JButton listar) {
		this.listar = listar;
	}

	/**
	 * metodo getter del boton agregar
	 * @return the agregar
	 */
	public JButton getAgregar() {
		return agregar;
	}

	/**
	 * @param agregar the agregar to set
	 */
	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}

	/**
	 * metodo getter del panelinfo
	 * @return the pi
	 */
	public PanelInfo getPi() {
		return pi;
	}

	/**
	 * @param pi the pi to set
	 */
	public void setPi(PanelInfo pi) {
		this.pi = pi;
	}


}
