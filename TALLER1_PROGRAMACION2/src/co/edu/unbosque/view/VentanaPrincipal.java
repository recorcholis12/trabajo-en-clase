package co.edu.unbosque.view;

import javax.swing.JFrame;
/**
 * clase para crear la ventana con la que el usuario interactua con los componentes
 * @author luisa rincon
 *
 */
public class VentanaPrincipal extends JFrame{
	/**
	 * Panel que contiene todos los componentes
	 */
	private PanelPrincipal Pp;
	/**
	 * metodo constructor 
	 * <b>pos</b> se cree la ventana con las caracteristicas indicadas
	 */
	public VentanaPrincipal() {

		Pp = new PanelPrincipal();
		setTitle("PROGRAMACION 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(920,550);
		setLocationRelativeTo(null);
		setResizable(false);	
		setVisible(true);

		add(Pp);
	}
	/**
	 * metodo getter del panel principal
	 * @return PanelPrincipal
	 */
	public PanelPrincipal getPp() {
		return Pp;
	}
	/**
	 * metodo setter del panel principal
	 * @param pp panel 
	 */
	public void setPp(PanelPrincipal pp) {
		Pp = pp;
	}


}
