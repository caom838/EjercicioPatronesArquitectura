/**
 * Clase que implementa las funciones de Director de builder
 * @author CAOM
 *
 */
public class UIDirector {

	 private UIBuilder builder;

	 public UIDirector(UIBuilder bldr) {
	    builder = bldr;
	 }
	 
	 public void build() {
	    builder.addUIControls();
	    builder.initialize();
	 }
	 
	 
	  
}
