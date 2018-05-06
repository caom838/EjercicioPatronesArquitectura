import javax.swing.JPanel;

/**
 * Clase abstracta de Builder
 * @author CAOM
 *
 */
public abstract class UIBuilder {
	//atributo de clase
	protected JPanel formGUI;
	//métodos abstractos
	public abstract void addUIControls();
	public abstract void initialize();
	//
	public String getOrderAmount(){return null;};
//	public String getTax(){return null;};
//	public String getSH(){return null;};
	
	//método public implementado
	public JPanel getFormGUI(){
		return formGUI;
	}

}
