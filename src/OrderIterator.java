import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderIterator implements Iterator<Order> {

	//Declaración de variables
	Order currentOrder;
	Enumeration<Order> enu;
	
	 public OrderIterator(AllOrders v) {
	        enu = v.getAllOrders();        
	 }
	 
	@Override
	public boolean hasNext() {
		return enu.hasMoreElements();
	}

	@Override
	public Order next() {
		
		while (enu.hasMoreElements()) {
		      Order tempObj = (Order)enu.nextElement();
		      currentOrder = tempObj;
		        break;
		 }
		if (currentOrder == null) {
		      throw new NoSuchElementException();
		    } else {
		      return currentOrder;
		  } 
	}

}
