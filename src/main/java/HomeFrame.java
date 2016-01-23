package main.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblYourGroceryList;
	private JList list;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 180, 180, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblInstructions = new JLabel("Instructions:");
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstructions.gridx = 0;
		gbc_lblInstructions.gridy = 0;
		contentPane.add(lblInstructions, gbc_lblInstructions);
		
		lblYourGroceryList = new JLabel("Your Grocery List:");
		GridBagConstraints gbc_lblYourGroceryList = new GridBagConstraints();
		gbc_lblYourGroceryList.gridwidth = 2;
		gbc_lblYourGroceryList.insets = new Insets(0, 0, 5, 0);
		gbc_lblYourGroceryList.gridx = 1;
		gbc_lblYourGroceryList.gridy = 0;
		contentPane.add(lblYourGroceryList, gbc_lblYourGroceryList);
		
		JLabel lblPasteUrlsInto = new JLabel("Paste URLs into the box below");
		GridBagConstraints gbc_lblPasteUrlsInto = new GridBagConstraints();
		gbc_lblPasteUrlsInto.anchor = GridBagConstraints.WEST;
		gbc_lblPasteUrlsInto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasteUrlsInto.gridx = 0;
		gbc_lblPasteUrlsInto.gridy = 1;
		contentPane.add(lblPasteUrlsInto, gbc_lblPasteUrlsInto);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridheight = 2;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		contentPane.add(list, gbc_list);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 2;
		contentPane.add(textArea, gbc_textArea);
		
		btnEdit = new JButton("Edit...");
		btnEdit.setEnabled(false);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 3;
		contentPane.add(btnEdit, gbc_btnEdit);
		
		btnDelete = new JButton("Delete...");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 3;
		contentPane.add(btnDelete, gbc_btnDelete);
		
		
		UrlListener urlListener = new UrlListener();
	}

}
