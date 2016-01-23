package main.java;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UrlListener implements DocumentListener{
		public void changedUpdate(DocumentEvent e){check();}
		public void removeUpdate(DocumentEvent e) {check();}
		public void insertUpdate(DocumentEvent e) {check();}
		private void check(){
			/*if(instructorNameValue.getText().trim().equals("") || courseNameValue.getText().trim().equals("")){
				btnSubmit.setEnabled(false);
			}else{
				btnSubmit.setEnabled(true);
			}*/
		}
}

