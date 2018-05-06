import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class AllOrders {

	//vector para almacenar todos los elementos
	private Vector<Order> data;
	
	//constructor para ejemplificar la clase 
	  public AllOrders() {
	  }
	  
	  /**
	   * Metodo para obtener todos las ordenes almacenadas
	   * @return
	   */
	  public Enumeration<Order> getAllOrders() {
		    return data.elements();
	  }
	  
	  /**
	   * Metodo para agregar una nueva orden a la coleccion de ordenes 
	   * @param newOrder
	   */
	  public void addOrder(Order newOrder)
	  {
		  data.add(newOrder);
	  }
	  
	  /**
	   * Metodo para obtener el iterador permitido para iterar la coleccion de allorders
	   * @return
	   */
	  public Iterator getOrderIterator()
	  {
		  return new OrderIterator(this);
	  }
		
}
