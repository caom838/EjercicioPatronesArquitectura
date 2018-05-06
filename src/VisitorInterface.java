
/**
 * Interface para definir los tipos de visitadores para cada clase a visitar
 * @author CAOM
 *
 */
public interface VisitorInterface {

	//visitador para la clase de orden no california
	public void visit(NonCaliforniaOrder nco);
	//visitador para la clase de orden california
	public void visit(CaliforniaOrder co);
	//visitador para la clase de orden fuera
	public void visit(OverseasOrder oo);
}
