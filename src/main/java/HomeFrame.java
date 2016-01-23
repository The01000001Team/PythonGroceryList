package main.java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblYourGroceryList;
	private JList list_recipe;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextArea textArea_Url;
	DefaultListModel recipeModel;

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
		
		recipeModel = new DefaultListModel();
		list_recipe = new JList(recipeModel);
		list_recipe.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_recipe.setLayoutOrientation(JList.VERTICAL);
		GridBagConstraints gbc_list_recipe = new GridBagConstraints();
		gbc_list_recipe.gridwidth = 2;
		gbc_list_recipe.insets = new Insets(0, 0, 5, 0);
		gbc_list_recipe.gridheight = 2;
		gbc_list_recipe.fill = GridBagConstraints.BOTH;
		gbc_list_recipe.gridx = 1;
		gbc_list_recipe.gridy = 1;
		contentPane.add(list_recipe, gbc_list_recipe);
		
		textArea_Url = new JTextArea();
		textArea_Url.setLineWrap(true);
		GridBagConstraints gbc_textArea_Url = new GridBagConstraints();
		gbc_textArea_Url.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_Url.fill = GridBagConstraints.BOTH;
		gbc_textArea_Url.gridx = 0;
		gbc_textArea_Url.gridy = 2;
		contentPane.add(textArea_Url, gbc_textArea_Url);
		
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
		textArea_Url.getDocument().addDocumentListener(urlListener);
	}

}
