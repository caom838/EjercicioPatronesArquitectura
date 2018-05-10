import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OverseasUI extends UIBuilder {

	private JTextField txtOrderAmount = new JTextField(10);
	private JLabel lblOrderAmount = new JLabel("Order Amount:");
	private JTextField  txtAdditionalSH = new JTextField(10);
	private JLabel lblAdditionalSH = new JLabel("Additional S & H(Overseas Orders Only):");
	
	@Override
	public void addUIControls() {

        formGUI = new JPanel();
		
		GridBagLayout gridbag = new GridBagLayout();
		formGUI.setLayout(gridbag);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
		
	    formGUI.add(lblOrderAmount);
	    formGUI.add(txtOrderAmount);
	    formGUI.add(lblAdditionalSH);
	    formGUI.add(txtAdditionalSH);
	    
	    
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
	    gridbag.setConstraints(lblAdditionalSH, gbc);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gridbag.setConstraints(txtAdditionalSH, gbc);
	    
	}

	@Override
	public void initialize() {
		txtOrderAmount.setText("");
		txtAdditionalSH.setText("");
	}

	@Override
	public String getOrderAmount() {
		return txtOrderAmount.getText();
	}

	/** metodos propios de overseas**/
	public String getSH() {
		return txtAdditionalSH.getText();
	}

}
