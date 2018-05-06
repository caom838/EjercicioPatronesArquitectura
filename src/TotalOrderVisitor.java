
import java.util.Iterator;
import java.util.Vector;

//Cambio Jmoreno - clase que implementa los tipos de visitadores para liquidar el total de la orden
public class TotalOrderVisitor implements VisitorInterface{

	private AllOrders allOrder;
	

	public TotalOrderVisitor() {
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

	public double getOrderTotal() {
		Iterator<OrderIterator> oI = allOrder.getOrderIterator();
		Double total = 0.0;
		
		while (oI.hasNext()) {
			Order o = (Order)oI.next();
			total += o.getTotalAmount();
		}
		
		return total;
	}
}
