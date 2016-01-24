package main.java;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblYourGroceryList;
	@SuppressWarnings("rawtypes")
	private JList list_recipe;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextField textField_Url;
	@SuppressWarnings("rawtypes")
	DefaultListModel recipeModel;
	private JButton btnPaste;
	private JLabel lblStatus;
	private JTextArea textAreaStatus;
	private JScrollPane scrollPaneList;
	private JTextArea txtrInstructionsEnterA;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HomeFrame(final ListManager recipeManager) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 180, 180, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 50, 0, 0, -19, 69, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblYourGroceryList = new JLabel("Your Grocery List:");
		GridBagConstraints gbc_lblYourGroceryList = new GridBagConstraints();
		gbc_lblYourGroceryList.gridwidth = 2;
		gbc_lblYourGroceryList.insets = new Insets(0, 0, 5, 0);
		gbc_lblYourGroceryList.gridx = 1;
		gbc_lblYourGroceryList.gridy = 0;
		contentPane.add(lblYourGroceryList, gbc_lblYourGroceryList);

		recipeModel = recipeManager.getListModel();
		list_recipe = new JList(recipeModel);
		list_recipe.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_recipe.setLayoutOrientation(JList.VERTICAL);
		
		scrollPaneList = new JScrollPane();
		scrollPaneList.setViewportView(list_recipe);
		scrollPaneList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneList = new GridBagConstraints();
		gbc_scrollPaneList.gridheight = 6;
		gbc_scrollPaneList.gridwidth = 2;
		gbc_scrollPaneList.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneList.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneList.gridx = 1;
		gbc_scrollPaneList.gridy = 1;
		contentPane.add(scrollPaneList, gbc_scrollPaneList);
		
		
		txtrInstructionsEnterA = new JTextArea();
		txtrInstructionsEnterA.setBackground(SystemColor.window);
		txtrInstructionsEnterA.setText("Instructions: Enter a valid URL in \nthe box below and press 'Enter'");
		txtrInstructionsEnterA.setEditable(false);
		txtrInstructionsEnterA.setLineWrap(true);
		GridBagConstraints gbc_txtrInstructionsEnterA = new GridBagConstraints();
		gbc_txtrInstructionsEnterA.insets = new Insets(0, 0, 5, 5);
		gbc_txtrInstructionsEnterA.fill = GridBagConstraints.BOTH;
		gbc_txtrInstructionsEnterA.gridx = 0;
		gbc_txtrInstructionsEnterA.gridy = 2;
		contentPane.add(txtrInstructionsEnterA, gbc_txtrInstructionsEnterA);

		textField_Url = new JTextField();
		GridBagConstraints gbc_textField_Url = new GridBagConstraints();
		gbc_textField_Url.anchor = GridBagConstraints.NORTH;
		gbc_textField_Url.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Url.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Url.gridx = 0;
		gbc_textField_Url.gridy = 3;
		contentPane.add(textField_Url, gbc_textField_Url);

		lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 5;
		contentPane.add(lblStatus, gbc_lblStatus);

		textAreaStatus = new JTextArea();
		textAreaStatus.setEditable(false);
		GridBagConstraints gbc_textAreaStatus = new GridBagConstraints();
		gbc_textAreaStatus.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaStatus.fill = GridBagConstraints.BOTH;
		gbc_textAreaStatus.gridx = 0;
		gbc_textAreaStatus.gridy = 6;
		contentPane.add(textAreaStatus, gbc_textAreaStatus);

		btnPaste = new JButton("Paste");
		GridBagConstraints gbc_btnPaste = new GridBagConstraints();
		gbc_btnPaste.insets = new Insets(0, 0, 0, 5);
		gbc_btnPaste.gridx = 0;
		gbc_btnPaste.gridy = 7;
		contentPane.add(btnPaste, gbc_btnPaste);

		btnEdit = new JButton("Edit...");
		btnEdit.setEnabled(false);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 7;
		contentPane.add(btnEdit, gbc_btnEdit);

		btnDelete = new JButton("Delete...");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 7;
		contentPane.add(btnDelete, gbc_btnDelete);

		/**************************************************************
		 * LISTENERS
		 **************************************************************/

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditItemDialog dialog = new EditItemDialog();
							dialog.setVisible(true);

							if(dialog.getName() == null){
								textAreaStatus.setText("Closed Dialog Box.");
								return;
							}
							String name = ((Item)recipeModel.getElementAt(list_recipe.getSelectedIndex())).getItemName();
							String unit = ((Item)recipeModel.getElementAt(list_recipe.getSelectedIndex())).getUnit().getName();
							double price = ((Item)recipeModel.getElementAt(list_recipe.getSelectedIndex())).getPrice();
							Item newItem = new Item(name, dialog.getQuantity(), unit, dialog.getQuantity()*price);
							newItem.updateDisplayName(dialog.getName());
							int index = list_recipe.getSelectedIndex();
							recipeModel.add(index,newItem);
							recipeModel.remove(index+1);
							list_recipe.setSelectedIndex(index);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list_recipe.getSelectedIndex();
				recipeModel.remove(index);

				int size = recipeModel.getSize();

				if (size == 0){ 
					btnDelete.setEnabled(false);
				}
				else{
					if (index == size) { index--;}
				}
				list_recipe.setSelectedIndex(index);
			}
		});
		
		list_recipe.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					if (list_recipe.getSelectedIndex() == -1) {
						btnDelete.setEnabled(false);
						btnEdit.setEnabled(false);
					} else {
						btnDelete.setEnabled(true);
						btnEdit.setEnabled(true);
					}
				}
			}
		});
		
		final Clipboard clipboard = this.getToolkit().getSystemClipboard();
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Transferable clipData = clipboard.getContents(clipboard);
				if (clipData != null) {
					try {
						if 
						(clipData.isDataFlavorSupported
								(DataFlavor.stringFlavor)) {
							String s = (String)(clipData.getTransferData(
									DataFlavor.stringFlavor));
							textField_Url.replaceSelection(s);
						}
					} catch (UnsupportedFlavorException ufe) {
						System.err.println("Flavor unsupported: " + ufe);
					} catch (IOException ioe) {
						System.err.println("Data not available: " + ioe);
					}
				}
			}
		});

	
		class EnterListener implements KeyListener{
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}  
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(textField_Url.getText().length() <= 10){
						textAreaStatus.setText("Entered too short of a url...");
						textField_Url.setText("");
					}else{
						textAreaStatus.setText("Adding URL... This may take a moment...");
						int returned = recipeManager.addUrl(textField_Url.getText());
						if(returned == 0) {textAreaStatus.setText("Added!");}
						else{ textAreaStatus.setText("The entered URL was not valid");}
						textField_Url.setText(null);
						textField_Url.setCaretPosition(0);
					}
				}else{
					textAreaStatus.setText("Press Enter to Submit!");
				}
			} 
		}
		textField_Url.addKeyListener(new EnterListener());
	}

}
