
import java.util.Iterator;

//Cambio Jmoreno - clase que implementa los tipos de visitadores para liquidar el total de la orden
public class TotalOrderVisitor implements VisitorInterface{

	private AllOrders allOrder;
	private double total;

	public TotalOrderVisitor(AllOrders coll) {
		allOrder = coll;
		total = 0.0;
	}

	public void visit(NonCaliforniaOrder inp_order) {
		total += inp_order.getOrderAmount();
	}

	public void visit(CaliforniaOrder inp_order) {
		total += (inp_order.getOrderAmount() + inp_order.getAdditionalTax());
		//colocar mas funcionalidad aqui
	}

	public void visit(OverseasOrder inp_order) {
		total +=  (inp_order.getOrderAmount() + inp_order.getAdditionalSH());
		//colocar mas funcionalidad
	}

	/**
	 * Metodo para obtener total de todas las ordenes - metodo general
	 * @return
	 */
	public double getOrderTotal() {
		return total;
	}
	
	/**
	 * Metodo generico para obtener el total de las ordenes sin usar los visitadores
	 * @return
	 */
	public double getOrderTotalGeneric() {
		Iterator<OrderIterator> oI = allOrder.getOrderIterator();
		Double total = 0.0;
		while (oI.hasNext()) {
			Order o = (Order)oI.next();
			total += o.getTotalAmount();
		}
		return total;
	}
	
	
}
