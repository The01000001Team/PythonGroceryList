package main.java;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class EditItemDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Quantity;
	private JTextField textField_Name;
	
	private String name;
	private double quantity;

	public EditItemDialog() {
		name = null;
		setModalityType(EditItemDialog.DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 307, 130);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		JLabel lblQuantity = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 0;
		contentPanel.add(lblQuantity, gbc_lblQuantity);

		textField_Quantity = new JTextField();
		GridBagConstraints gbc_textField_Quantity = new GridBagConstraints();
		gbc_textField_Quantity.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Quantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Quantity.gridx = 1;
		gbc_textField_Quantity.gridy = 0;
		contentPanel.add(textField_Quantity, gbc_textField_Quantity);
		textField_Quantity.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		contentPanel.add(lblName, gbc_lblName);

		textField_Name = new JTextField();
		GridBagConstraints gbc_textField_Name = new GridBagConstraints();
		gbc_textField_Name.gridwidth = 2;
		gbc_textField_Name.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Name.gridx = 1;
		gbc_textField_Name.gridy = 1;
		contentPanel.add(textField_Name, gbc_textField_Name);
		textField_Name.setColumns(10);

		final JButton btnSubmit = new JButton("Submit");
		btnSubmit.setEnabled(false);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.anchor = GridBagConstraints.EAST;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 2;
		contentPanel.add(btnSubmit, gbc_btnSubmit);
		
		class EntryListener implements DocumentListener{
			public void changedUpdate(DocumentEvent e){check();}
			public void removeUpdate(DocumentEvent e) {check();}
			public void insertUpdate(DocumentEvent e) {check();}
			private void check(){
				try {
					Double.parseDouble(textField_Quantity.getText());
					if(textField_Name.getText().trim().equals("")){ 
						btnSubmit.setEnabled(false);
					}else{
						btnSubmit.setEnabled(true);
					}
				}
				catch (NumberFormatException e1) {
					btnSubmit.setEnabled(false);
				}
			}
		}
		EntryListener entryListener = new EntryListener();
		textField_Quantity.getDocument().addDocumentListener(entryListener);
		textField_Name.getDocument().addDocumentListener(entryListener);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textField_Name.getText().trim();
				quantity = Double.parseDouble(textField_Quantity.getText());
				EditItemDialog.this.dispose();
			}
		});
	}
	
	public String getName(){
		return name;
	}
	
	public double getQuantity(){
		return quantity;
	}

}
