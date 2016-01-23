package main.java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.python.PyInterpreter;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblYourGroceryList;
	private JList list_recipe;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextArea textArea_Url;
	DefaultListModel recipeModel;
	private JButton btnPaste;

	/**
	 * Create the frame.
	 */
	public HomeFrame(final ListManager recipeManager) {
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

		recipeModel = recipeManager.getListModel();
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

		btnPaste = new JButton("Paste");
		GridBagConstraints gbc_btnPaste = new GridBagConstraints();
		gbc_btnPaste.insets = new Insets(0, 0, 0, 5);
		gbc_btnPaste.gridx = 0;
		gbc_btnPaste.gridy = 3;
		contentPane.add(btnPaste, gbc_btnPaste);

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
							textArea_Url.replaceSelection(s);
						}
					} catch (UnsupportedFlavorException ufe) {
						System.err.println("Flavor unsupported: " + ufe);
					} catch (IOException ioe) {
						System.err.println("Data not available: " + ioe);
					}
				}
			}
		});

		class UrlListener implements DocumentListener{

			private boolean isRunning;

			public void changedUpdate(DocumentEvent e){check();}
			public void removeUpdate(DocumentEvent e) {check();}
			public void insertUpdate(DocumentEvent e) {check();}
			private void check(){
				if(isRunning){return;}

				isRunning = true;
				recipeManager.addUrl(textArea_Url.getText());
				

				SwingUtilities.invokeLater(new Runnable() 
				{
					public void run()
					{
						textArea_Url.setText("");
						reset();
					}
				});


			}
			protected void reset() {
				isRunning = false;

			}
		}

		UrlListener urlListener = new UrlListener();
		textArea_Url.getDocument().addDocumentListener(urlListener);

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
	}

}
