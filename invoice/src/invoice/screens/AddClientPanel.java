package invoice.screens;

import invoice.database.MyDatabaseHelper;
import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class AddClientPanel extends JPanel {
	private JButton logout;
	private JButton company,clients,projects,employees,invoices,reports,addnewclient,back,help;
	public AddClientPanel(final JFrame currentGUIFrame,final SessionManager sessionManager) {
		setLayout(null);		
		JLabel lblNewLabel = new JLabel("Welcome "+sessionManager.getUserName());
		lblNewLabel.setBounds(350, 10, 150, 20);
		currentGUIFrame.add(lblNewLabel);
		
		help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		help.setBounds(610, 7, 75, 30);
		currentGUIFrame.add(help);
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.setBounds(100,100,700,600);
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new LoginHome(currentGUIFrame));
				currentGUIFrame.getContentPane().repaint();	
			}
		});
		logout.setBounds(525, 7, 75, 30);
		currentGUIFrame.add(logout);
		lblNewLabel = new JLabel("Add New Client");
		lblNewLabel.setBounds(300, 140, 200, 20);
		currentGUIFrame.add(lblNewLabel);
		
		if(sessionManager.getUserRole()!=null && sessionManager.getUserRole().equalsIgnoreCase("ACCOUNTANT")){
			company = new JButton("Company");
			company.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new CompanyPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			company.setBounds(45, 100, 100, 30);
			currentGUIFrame.add(company);
			
			clients = new JButton("Clients");
			clients.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ClientsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			clients.setBounds(150, 100, 100, 30);
			currentGUIFrame.add(clients);
			
			projects = new JButton("Projects");
			projects.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ProjectsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			projects.setBounds(255, 100, 100, 30);
			currentGUIFrame.add(projects);
			
			employees = new JButton("Employees");
			employees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			employees.setBounds(360, 100, 100, 30);
			currentGUIFrame.add(employees);
			
			invoices = new JButton("Invoice");
			invoices.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new InvoicesPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			invoices.setBounds(465, 100, 100, 30);
			currentGUIFrame.add(invoices);
			
			reports = new JButton("Reports");
			reports.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ReportsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			reports.setBounds(570, 100, 85, 30);
			currentGUIFrame.add(reports);
		}
		if(sessionManager.getUserRole()!=null && sessionManager.getUserRole().equalsIgnoreCase("PROJECT MANAGER")){
			projects = new JButton("Projects");
			projects.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ProjectsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			projects.setBounds(75, 100, 90, 30);
			currentGUIFrame.add(projects);
			
			employees = new JButton("Developers");
			employees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			employees.setBounds(185, 100, 100, 30);
			currentGUIFrame.add(employees);
			
			invoices = new JButton("Approve Hours");
			invoices.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ApprovedHours(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			invoices.setBounds(295, 100, 125, 30);
			currentGUIFrame.add(invoices);
			
			reports = new JButton("Report");
			reports.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ReportsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			reports.setBounds(430, 100, 100, 30);
			currentGUIFrame.add(reports);
			
			employees = new JButton("TimeSheet");
			employees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new TimeSheetPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			employees.setBounds(535, 100, 125, 30);
			currentGUIFrame.add(employees);
		}
		
		if(sessionManager.getUserRole()!=null && sessionManager.getUserRole().equalsIgnoreCase("DEVELOPER")){
			projects = new JButton("Projects");
			projects.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ProjectsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			projects.setBounds(75, 100, 90, 30);
			currentGUIFrame.add(projects);
			
			employees = new JButton("TimeSheet");
			employees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new TimeSheetPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			employees.setBounds(185, 100, 125, 30);
			currentGUIFrame.add(employees);
		}
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(175, 180, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField name= new JTextField();
		name.setBounds(275, 178, 175, 25);		
		currentGUIFrame.add(name);
		
		lblNewLabel = new JLabel("Addresss Line1");
		lblNewLabel.setBounds(175, 210, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField addressline1= new JTextField();
		addressline1.setBounds(275, 208, 175, 25);
		currentGUIFrame.add(addressline1);
		
		lblNewLabel = new JLabel("Addresss Line2");
		lblNewLabel.setBounds(175, 240, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField addressline2= new JTextField();
		addressline2.setBounds(275, 238, 175, 25);
		currentGUIFrame.add(addressline2);
		
		lblNewLabel = new JLabel("City");
		lblNewLabel.setBounds(175, 270, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField city= new JTextField();
		city.setBounds(275, 268, 175, 25);
		currentGUIFrame.add(city);
		
		lblNewLabel = new JLabel("State");
		lblNewLabel.setBounds(175, 300, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField state= new JTextField();
		state.setBounds(275, 298, 175, 25);
		currentGUIFrame.add(state);
		
		lblNewLabel = new JLabel("Zip");
		lblNewLabel.setBounds(175, 330, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField zip= new JTextField();
		zip.setBounds(275, 328, 175, 25);
		currentGUIFrame.add(zip);
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(175, 360, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField email= new JTextField();
		email.setBounds(275, 358, 175, 25);
		currentGUIFrame.add(email);
		
		lblNewLabel = new JLabel("Contact");
		lblNewLabel.setBounds(175, 390, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField contact= new JTextField();
		contact.setBounds(275, 388, 175, 25);
		currentGUIFrame.add(contact);
		
		currentGUIFrame.setBounds(100,100,705,605);
		
		lblNewLabel = new JLabel("Invoice Freq");
		lblNewLabel.setBounds(175, 420, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final DefaultComboBoxModel invoicefreqbox = new DefaultComboBoxModel();
		invoicefreqbox.addElement("Weekly");
		invoicefreqbox.addElement("BiWeekly");
		final JComboBox invoicefreqCombo = new JComboBox(invoicefreqbox);    
		JScrollPane invoicefreqComboScrollPane = new JScrollPane(invoicefreqCombo);
		invoicefreqComboScrollPane.setBounds(275, 418, 200, 25);
		currentGUIFrame.add(invoicefreqComboScrollPane);
		
		lblNewLabel = new JLabel("Billing Terms");
		lblNewLabel.setBounds(175, 450, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final DefaultComboBoxModel billingbox = new DefaultComboBoxModel();
		billingbox.addElement("Due on Recipt");
		billingbox.addElement("Net 10 Days");
		billingbox.addElement("Net 20 Days");
		billingbox.addElement("Net 30 Days");
		billingbox.addElement("Net 60 Days");
		final JComboBox billingCombo = new JComboBox(billingbox);    
		JScrollPane fbillingComboScrollPane = new JScrollPane(billingCombo);
		fbillingComboScrollPane.setBounds(275, 448, 200, 25);
		currentGUIFrame.add(fbillingComboScrollPane);
		
		lblNewLabel = new JLabel("Invoice Grouping");
		lblNewLabel.setBounds(175, 480, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final DefaultComboBoxModel groupname = new DefaultComboBoxModel();
		groupname.addElement("Project");
		groupname.addElement("Invoice");
		final JComboBox groupCombo = new JComboBox(groupname);    
		JScrollPane groupScrollPane = new JScrollPane(groupCombo);
		groupScrollPane.setBounds(275, 478, 200, 25);
		currentGUIFrame.add(groupScrollPane);
		
		addnewclient = new JButton("Save");
		addnewclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name!=null && name.getText().trim().length()!=0 && addressline1!=null && addressline1.getText().trim().length()!=0
						&& city!=null && city.getText().trim().length()!=0 && state!=null && state.getText().trim().length()!=0 && zip!=null && zip.getText().trim().length()!=0
						&& email!=null && email.getText().trim().length()!=0 && contact!=null && contact.getText().trim().length()!=0 && invoicefreqCombo.getItemAt(invoicefreqCombo.getSelectedIndex())!=null && (invoicefreqCombo.getItemAt(invoicefreqCombo.getSelectedIndex())).toString().trim().length()!=0
						&& billingCombo.getItemAt(billingCombo.getSelectedIndex())!=null && (billingCombo.getItemAt(billingCombo.getSelectedIndex())).toString().trim().length()!=0 && groupCombo.getItemAt(invoicefreqCombo.getSelectedIndex())!=null && (groupCombo.getItemAt(groupCombo.getSelectedIndex())).toString().trim().length()!=0){
					try{
						MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
						myDatabaseHelper.addClient(name.getText().trim(), addressline1.getText().trim(), addressline2.getText().trim(), city.getText().trim(), state.getText().trim(), zip.getText().trim(), email.getText().trim(), contact.getText().trim(), (invoicefreqCombo.getItemAt(invoicefreqCombo.getSelectedIndex())).toString(), (billingCombo.getItemAt(billingCombo.getSelectedIndex())).toString().trim(), (groupCombo.getItemAt(groupCombo.getSelectedIndex())).toString().trim());
						currentGUIFrame.getContentPane().removeAll();
						currentGUIFrame.getContentPane().add(new ClientsPanel(currentGUIFrame,sessionManager));
						currentGUIFrame.getContentPane().repaint();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addnewclient, "Please enter all correct details");
				}
			}
		});
		addnewclient.setBounds(270, 525, 125, 30);
		currentGUIFrame.add(addnewclient);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new ClientsPanel(currentGUIFrame,sessionManager));
				currentGUIFrame.getContentPane().repaint();
			}
		});
		back.setBounds(100, 525, 125, 30);
		currentGUIFrame.add(back);
	}
}
