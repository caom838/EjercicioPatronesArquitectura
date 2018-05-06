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
		//orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalTax();
	}

	public void visit(OverseasOrder inp_order) {
		allOrder.addOrder(inp_order);
		//orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
	}

	/**
	 * Metodo para obtener total de todas las ordenes
	 * @return
	 */
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

