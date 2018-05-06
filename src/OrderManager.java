import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase cliente de ordenes
 * @author CAOM
 *
 */
public class OrderManager extends JFrame{

	//definimos variables/atributos de clase
	//atributos de texto para interfaz
	public static final String newline = "\n";
	public static final String GET_TOTAL = "Get Total";
	public static final String CREATE_ORDER = "Create Order";
	public static final String EXIT = "Exit";
	public static final String CA_ORDER = "California Order";
	public static final String NON_CA_ORDER ="Non-California Order";
	public static final String OVERSEAS_ORDER = "Overseas Order";
	 public static final String BLANK = "";
	 
	//atributos para interfaz gráfica
	private JComboBox cmbOrderType;
	private JPanel pFormCriteria;
	private JLabel lblOrderType;
	private JLabel lblTotal, lblTotalValue;
  
	//atributos 
	private OrderVisitor objVisitor;
	private TotalOrderVisitor objTotalVisitor;
	
	
	//constructor
	public OrderManager() throws HeadlessException {
		super("Ejercicio de Patrones");
		
		//1.  creamos una ejemplificación de visitador
	    objVisitor = new OrderVisitor();
	    objTotalVisitor = new TotalOrderVisitor();
	    
	    //2. creamos los objetos de GUI
	    //2.1.1 creamos combobox para seleccionar los tipos de ordenes
	    cmbOrderType = new JComboBox();
	    cmbOrderType.addItem(OrderManager.BLANK);
	    cmbOrderType.addItem(OrderManager.CA_ORDER);
	    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
	    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
	    //label
	    lblOrderType = new JLabel("Order Type:");
	    lblTotal = new JLabel("Result:");
	    lblTotalValue = new JLabel("Click Create or GetTotal Button");
	    
	    //2.1.2 Creamos botones
	    //boton liquidar
	    JButton getTotalButton = new JButton(OrderManager.GET_TOTAL);
	    getTotalButton.setMnemonic(KeyEvent.VK_G);
	    getTotalButton.setMnemonic(KeyEvent.VK_C);
	    //boton crear
	    JButton createOrderButton = new JButton(OrderManager.CREATE_ORDER);
	    JButton exitButton = new JButton(OrderManager.EXIT);
	    exitButton.setMnemonic(KeyEvent.VK_X);
	    
	    
	    //2.2 creamos paneles para distribuir los controles
	    //2.2.1 - panel principal
	    JPanel cbPanel = new JPanel();
	    GridBagLayout gridbag = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets.top = 5;
	    gbc.insets.bottom = 5;
	    gbc.insets.left = 5;
	    gbc.insets.right = 5;
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gridbag.setConstraints(cmbOrderType, gbc);
	    cbPanel.setLayout(gridbag);
	    //
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gridbag.setConstraints(lblOrderType, gbc);
	    
	    //2.2.1.1 se agrega el combobox
	    cbPanel.add(cmbOrderType);
	    cbPanel.add(lblOrderType);
	    cbPanel.add(lblTotal);
	    cbPanel.add(lblTotalValue);
	    
	    //2.2.2 se agregan los botones
	    JPanel buttonPanel = new JPanel();
	    GridBagLayout gridbag2 = new GridBagLayout();
	    buttonPanel.setLayout(gridbag2);
	    GridBagConstraints gbc2 = new GridBagConstraints();
	    buttonPanel.add(getTotalButton);
	    buttonPanel.add(createOrderButton);
	    buttonPanel.add(exitButton);
	    //
	    gbc2.anchor = GridBagConstraints.WEST;
	    gbc2.gridx = 0;
	    gbc2.gridy = 0;
	    gridbag2.setConstraints(createOrderButton, gbc2);
	    gbc2.gridx = 1;
	    gbc2.gridy = 0;
	    gridbag2.setConstraints(getTotalButton, gbc2);
	    gbc2.anchor = GridBagConstraints.WEST;
	    gbc2.gridx = 2;
	    gbc2.gridy = 0;
	    gridbag2.setConstraints(exitButton, gbc2);
	    
	    //
	    pFormCriteria = new JPanel();
	    cbPanel.add(pFormCriteria);
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gridbag.setConstraints(pFormCriteria, gbc);
	    
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gridbag.setConstraints(lblTotal, gbc);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gridbag.setConstraints(lblTotalValue, gbc);
	    
	    
	    //3
	    //acciones 
	    ButtonHandler objButtonHandler = new ButtonHandler(this);
	    getTotalButton.addActionListener(objButtonHandler);
	    createOrderButton.addActionListener(objButtonHandler);
	    exitButton.addActionListener(objButtonHandler);
	    cmbOrderType.addActionListener(objButtonHandler);
	    
	    //4 agregar los paneles
	    Container contentPane = getContentPane();
	    contentPane.add(cbPanel, BorderLayout.NORTH);
	    contentPane.add(buttonPanel, BorderLayout.CENTER);

	}

	//getters
	public OrderVisitor getOrderVisitor() {
	    return objVisitor;
	} 	
	//Modificacion Jmoreno - se agrega get del visitador del total de la orden
	public TotalOrderVisitor getTotalOrderVisitor() {
	    return objTotalVisitor;
	}
	
	public String getOrderType() {
		    return (String) cmbOrderType.getSelectedItem();
	 }
	 public JComboBox getOrderTypeCtrl() {
		    return cmbOrderType;
	 }
	 public void setTotalValue(String msg) {
		    lblTotalValue.setText(msg);
	 }
	
	//método main
	public static void main(String[] args) {
		//a ejemplificar ordermanager quien define la interfaz grafica de la ventana
		JFrame frame = new OrderManager();
		
		//b crea un listener
		frame.addWindowListener(new WindowAdapter() {
	          public void windowClosing(WindowEvent e) {
	            System.exit(0);
	          }
	        }
	     );
		
		//c definimos parametros a la ventana
		frame.setSize(500, 400);
	    frame.setVisible(true);
	}
	
	 public void displayNewUI(JPanel panel) {
		 pFormCriteria.removeAll();
		 if(panel != null)
		 pFormCriteria.add(panel);
		 pFormCriteria.validate();
		 validate();
	 }

}

//clase que implementa accion escuchador
class ButtonHandler implements ActionListener {
	  //objeto jframe y manejador de orden
	  OrderManager objOrderManager;
	  //objeto de constructor de gui
	  UIBuilder builder;
	  
	  //constructores
	  public ButtonHandler() {
	  }
	  public ButtonHandler(OrderManager inObjOrderManager) {
	    objOrderManager = inObjOrderManager;
	  }
	  //
	  public void actionPerformed(ActionEvent e) {
	    String totalResult = null;

	    //valida si el evento es exit
	    if (e.getActionCommand().equals(OrderManager.EXIT)) {
	      System.exit(1);
	    }
	    //valida si el evento es del boton crear orden
	    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
	    	
	    	
	    	String orderType = objOrderManager.getOrderType();
	    	
	    	//Falta terminar esta validacion
	    	if(orderType.equals("")) {
	    		totalResult = "Debe Seleccionar una opcion de pedido";
	    	}
	    	else{
	        
		        //Create the order
		        Order order = createOrder(orderType);
		        //Get the Visitor
		        OrderVisitor visitor = objOrderManager.getOrderVisitor();
		        // accept the visitor instance
		        order.accept(visitor);
		        
		        //Modificaciones Jmoreno - Se acepta la ejemplificacion del visitador del total de la orden 
		        TotalOrderVisitor visitorTotal = objOrderManager.getTotalOrderVisitor();
		        order.accept(visitorTotal);
		        
		        totalResult = " Order Created Successfully";
	    	}
	    	
	    	objOrderManager.setTotalValue(totalResult);
	    }
	    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
	        //Modificación Jmoreno - Get the Visitor Total
	    	TotalOrderVisitor visitorTotal = objOrderManager.getTotalOrderVisitor();
	  	      totalResult = new Double(visitorTotal.getOrderTotal()).toString();
	  	      totalResult = " Orders Total = " + totalResult;
	  	      objOrderManager.setTotalValue(totalResult);
	   }
	    
	    //valida si el evento es del combobox
	    if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {
	    	String selection = objOrderManager.getOrderType();
	    	
	    	if (selection.equals("") == false) {
	    		 BuilderFactory factory = new BuilderFactory();
	    		 //crea una ejemplificación de builder
	    	     builder = factory.getUIBuilder(selection);
	    	     //configure the director with the builder
	    	     UIDirector director = new UIDirector(builder);
	    	     //director invokes different builder
	    	     // methods
	    	     director.build();
	    	     //get the final build object
	    	     JPanel UIObj = builder.getFormGUI();
	    	     objOrderManager.displayNewUI(UIObj);
	    	}
	    }
	    
	  }
	  
	  public Order createOrder(String orderType,double orderAmount, double tax, double SH) {
		  	//validar el tipo de orden seleccionado
		    if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
		      return new CaliforniaOrder(orderAmount, tax);
		    }
		    if (orderType.equalsIgnoreCase(
		      OrderManager.NON_CA_ORDER)) {
		      return new NonCaliforniaOrder(orderAmount);
		    }
		    if (orderType.equalsIgnoreCase(
		          OrderManager.OVERSEAS_ORDER)) {
		      return new OverseasOrder(orderAmount, SH);
		    }
		    return null;
	  }
	  
	  public Order createOrder(String strOrderType) {
		  
		  	//1. declaración de variables
		  	String strOrderAmount="0.0";
	        String strTax="0.0";
	        String strSH="0.0";
		  	double dblOrderAmount = 0.0;
	        double dblTax = 0.0;
	        double dblSH = 0.0;
	        
	        try{
		        //2. obtener el valor del monto total
		        strOrderAmount = builder.getOrderAmount();
				
		        //3. convierte string el valor comun que es el valor de la orden 
		        if(strOrderAmount != null & strOrderAmount.isEmpty() == false & Utils.isNumeric(strOrderAmount)){
		        	dblOrderAmount = new Double(strOrderAmount).doubleValue();
		        }
		         
			  	//4. validar el tipo de orden seleccionado
			    if (strOrderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
			    	
			    	//
			    	strTax = ((CaliforniaUI)builder).getTax();
			    	if(strTax != null & strTax.isEmpty() == false & Utils.isNumeric(strTax)){
			        	dblTax = new Double(strTax).doubleValue();
			        }
			    	//obtiene la orden
			    	return new CaliforniaOrder(dblOrderAmount, dblTax);
			    }
			    if (strOrderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
			      
			    	return new NonCaliforniaOrder(dblOrderAmount);
			    }
			    if (strOrderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)) {
			    	
			    	strSH = ((OverseasUI)builder).getSH();
			    	if(strSH != null & strSH.isEmpty() == false & Utils.isNumeric(strSH)){
			        	dblSH = new Double(strSH).doubleValue();
			        }
			    	 
			      return new OverseasOrder(dblOrderAmount, dblSH);
			    }
	        }
		    catch(Exception e)
		    {
		    	System.out.println("Error en la generación de la orden ");
		    }
		    return null;
	  }
}

//clase fabrica de gui 
class BuilderFactory{
	public UIBuilder getUIBuilder(String str) {
		    UIBuilder builder = null;
		    
		    if (str.equals(OrderManager.CA_ORDER)) {
		      builder = new CaliforniaUI() ;
		    } else if (str.equals(OrderManager.NON_CA_ORDER)) {
		      builder = new NonCaliforniaUI();
		    } else if (str.equals(OrderManager.OVERSEAS_ORDER)) {
		    	builder = new OverseasUI();
		    }
		    return builder;
	}
}


