package invoice.main;

import invoice.beans.Employee;
import invoice.database.MyDatabaseHelper;
import invoice.screens.HomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginHome extends JPanel {
	private JTextField textField;
	private JPasswordField password;
	private JButton submit;
	public LoginHome(final JFrame currentGUIFrame) {
		setLayout(null);		
		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+"/src/invoice/main/logo.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(275, 10, 150, 100);
		currentGUIFrame.add(label);
		JLabel lblNewLabel = new JLabel("User Name *");
		lblNewLabel.setBounds(175, 160, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		lblNewLabel = new JLabel("EAGLES CONSULTING COMPANY");
		lblNewLabel.setBounds(250, 125, 200, 20);
		currentGUIFrame.add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(275, 158, 225, 25);
		currentGUIFrame.add(textField);	
		lblNewLabel = new JLabel("Password *");
		lblNewLabel.setBounds(175, 210, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		password= new JPasswordField();
		password.setBounds(275, 208, 225, 25);		
		currentGUIFrame.add(password);
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyDatabaseHelper databaseHelper=new MyDatabaseHelper();
				if(textField.getText()==null || textField.getText().trim().length()==0){
					JOptionPane.showMessageDialog(submit, "Please enter user name");
				}else if(password.getText()==null || password.getText().trim().length()==0){
					JOptionPane.showMessageDialog(submit, "Please enter password");
				}
				MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
				Employee employee=myDatabaseHelper.getEmployeeByUsername(textField.getText().trim());
				if((employee!=null && password.getText().trim().equalsIgnoreCase("password"))){
					SessionManager sessionManager=new SessionManager();
					sessionManager.setUserRole(employee.getRole());
					sessionManager.setUserName(employee.getName());
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new HomePanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();					
				}else{
					JOptionPane.showMessageDialog(submit, "Please enter correct User name and password");
				}
			}
		});
		submit.setBounds(250, 250, 75, 30);
		currentGUIFrame.add(submit);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancel.setBounds(350, 250, 75, 30);
		currentGUIFrame.add(cancel);
	}
}
