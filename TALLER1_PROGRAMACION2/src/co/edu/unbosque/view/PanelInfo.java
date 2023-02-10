package co.edu.unbosque.view;

import javax.swing.*;
/**
 * clase para mostrar la tabla con la info de un uasuario o todos los usuarios
 * @author luisa rincon
 *
 */
public class PanelInfo extends JPanel{
	/**
	 * barra para poder ver todos los datos de la tabla
	 */
	private JScrollPane barra;
	/**
	 * tabla para mostrar la info
	 */
	private JTable tabla;
	/**
	 * metodo constructor
	 */
	public PanelInfo() {
		inicializarcomponentes();
	}
	/**
	 * metodo para iniciar los componentes
	 * <b>pos</b> se inicializen los componentes
	 */
	public void inicializarcomponentes() {

		tabla = new JTable();
		barra = new JScrollPane();
	}
	/**
	 * metodo para completar la tabla
	 * <b>pre</b> la matriz no sea vacia ni null
	 * <b>pos</b> se complete la tabla
	 * @param datos que es la matriz que contiene la informacion a tabular
	 */
	public void llenartabla (String[][]datos) {
		String[] nombres = new String[5];

		nombres[0] ="NOMBRE";
		nombres[1] ="APELLIDO";
		nombres[2] ="CEDULA";
		nombres[3] ="EDAD";
		nombres[4] ="CARGO";

		tabla = new JTable(datos,nombres);
		tabla.setEnabled(false);
		barra.setViewportView(tabla);
		barra.setPreferredSize(new java.awt.Dimension(550, 200));
		add(barra );
	}


}
