import java.util.Iterator;

//clase que implementa los tipos de visitadores para cada tipo de orden
public class OrderVisitor implements VisitorInterface{
	//Objeto con la colección de ordenes
	private AllOrders allOrder;

	public OrderVisitor() {
		allOrder = new AllOrders();
	}

	public void visit(NonCaliforniaOrder inp_order) {
		allOrder.addOrder(inp_order);
	}

	public void visit(CaliforniaOrder inp_order) {
		allOrder.addOrder(inp_order);
	}

	public void visit(OverseasOrder inp_order) {
		allOrder.addOrder(inp_order);
	}
	
}

