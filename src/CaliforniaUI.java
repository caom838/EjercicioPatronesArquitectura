import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaliforniaUI extends UIBuilder {

	
	private JTextField txtOrderAmount = new JTextField(10);
	private JTextField txtAdditionalTax = new JTextField(10);
	private JLabel lblAdditionalTax =new JLabel("Additional Tax(CA Orders Only):");
	private JLabel lblOrderAmount = new JLabel("Order Amount:");
	
	@Override
	public void addUIControls() {
		formGUI = new JPanel();
		
		GridBagLayout gridbag = new GridBagLayout();
		formGUI.setLayout(gridbag);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    
	    formGUI.add(lblAdditionalTax);
	    formGUI.add(lblOrderAmount);
	    formGUI.add(txtAdditionalTax);
	    formGUI.add(txtOrderAmount);
	    
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gridbag.setConstraints(lblOrderAmount, gbc);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gridbag.setConstraints(txtOrderAmount, gbc);
	    
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gridbag.setConstraints(lblAdditionalTax, gbc);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gridbag.setConstraints(txtAdditionalTax, gbc);
	    
	}

	@Override
	public void initialize() {
		
		txtOrderAmount.setText("");
		txtAdditionalTax.setText("");
	}

	@Override
	public String getOrderAmount() {
		return txtOrderAmount.getText();
	}

	
	/** metodos propios de california*/
	public String getTax() {
		return txtAdditionalTax.getText();
	}

}
