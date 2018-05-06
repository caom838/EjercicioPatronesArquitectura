
import java.util.Vector;

//Cambio Jmoreno - clase que implementa los tipos de visitadores para liquidar el total de la orden
public class TotalOrderVisitor implements VisitorInterface{

	private double orderTotal;

	public void visit(NonCaliforniaOrder inp_order) {
		orderTotal = orderTotal + inp_order.getOrderAmount();
	}

	public void visit(CaliforniaOrder inp_order) {
		orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalTax();
	}

	public void visit(OverseasOrder inp_order) {
		orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
	}

	public double getOrderTotal() {
		return orderTotal;
	}
}
