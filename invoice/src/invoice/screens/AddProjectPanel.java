package invoice.screens;

import invoice.beans.Client;
import invoice.database.MyDatabaseHelper;
import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
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



public class AddProjectPanel extends JPanel {
	private JButton logout;
	private JButton company,clients,projects,employees,invoices,reports,addnewproject,back,help;
	public AddProjectPanel(final JFrame currentGUIFrame,final SessionManager sessionManager) {
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
		lblNewLabel = new JLabel("Add New Project");
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
		
		final MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
		final ArrayList clientList=myDatabaseHelper.getClients();
		currentGUIFrame.setBounds(100,100,705,605);
		
		lblNewLabel = new JLabel("Select Client");
		lblNewLabel.setBounds(175, 180, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final DefaultComboBoxModel clientbox = new DefaultComboBoxModel();
		if(clientList!=null && clientList.size()!=0){			
			for(int count=0;count<clientList.size();count++){
				Client client=(Client)clientList.get(count);
				clientbox.addElement(""+client.getNumber());
			}
		}				
		final JComboBox clientboxCombo = new JComboBox(clientbox);    
		JScrollPane clientboxComboScrollPane = new JScrollPane(clientboxCombo);
		clientboxComboScrollPane.setBounds(275, 178, 175, 25);
		currentGUIFrame.add(clientboxComboScrollPane);
		
		lblNewLabel = new JLabel("Project Name");
		lblNewLabel.setBounds(175, 210, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField projectname= new JTextField();
		projectname.setBounds(275, 208, 175, 25);
		currentGUIFrame.add(projectname);
		
		lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setBounds(175, 240, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField startdate= new JTextField();
		startdate.setBounds(275, 238, 175, 25);
		currentGUIFrame.add(startdate);
		
		lblNewLabel = new JLabel("End Date");
		lblNewLabel.setBounds(175, 270, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField enddate= new JTextField();
		enddate.setBounds(275, 268, 175, 25);
		currentGUIFrame.add(enddate);
		
		lblNewLabel = new JLabel("Status");
		lblNewLabel.setBounds(175, 300, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField status= new JTextField();
		status.setBounds(275, 298, 175, 25);
		currentGUIFrame.add(status);
		
		lblNewLabel = new JLabel("Project Manager");
		lblNewLabel.setBounds(175, 330, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField projectmanager= new JTextField();
		projectmanager.setBounds(275, 328, 175, 25);
		currentGUIFrame.add(projectmanager);
		
		lblNewLabel = new JLabel("Client Contact");
		lblNewLabel.setBounds(175, 360, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField clientcontact= new JTextField();
		clientcontact.setBounds(275, 358, 175, 25);
		currentGUIFrame.add(clientcontact);
		
		lblNewLabel = new JLabel("Budget");
		lblNewLabel.setBounds(175, 390, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField budget= new JTextField();
		budget.setBounds(275, 388, 175, 25);
		currentGUIFrame.add(budget);
		
		addnewproject = new JButton("Save");
		addnewproject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clientboxCombo.getItemAt(clientboxCombo.getSelectedIndex())!=null && (clientboxCombo.getItemAt(clientboxCombo.getSelectedIndex())).toString().trim().length()!=0 && projectname!=null && projectname.getText().trim().length()!=0
						&& startdate!=null && startdate.getText().trim().length()!=0 && enddate!=null && enddate.getText().trim().length()!=0 
						&& status!=null && status.getText().trim().length()!=0 && projectmanager!=null && projectmanager.getText().trim().length()!=0 
						&& clientcontact!=null && clientcontact.getText().trim().length()!=0 && budget!=null && budget.getText().trim().length()!=0){
					try{
						MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
						myDatabaseHelper.addProject((clientboxCombo.getItemAt(clientboxCombo.getSelectedIndex())).toString().trim(), projectname.getText().trim(), startdate.getText().trim(), enddate.getText().trim(), status.getText().trim(), projectmanager.getText().trim(), clientcontact.getText().trim(), budget.getText().trim());
						currentGUIFrame.getContentPane().removeAll();
						currentGUIFrame.getContentPane().add(new ProjectsPanel(currentGUIFrame,sessionManager));
						currentGUIFrame.getContentPane().repaint();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addnewproject, "Please enter all correct details");
				}
			}
		});
		addnewproject.setBounds(270, 500, 125, 30);
		currentGUIFrame.add(addnewproject);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new ProjectsPanel(currentGUIFrame,sessionManager));
				currentGUIFrame.getContentPane().repaint();
			}
		});
		back.setBounds(100, 500, 125, 30);
		currentGUIFrame.add(back);
	}
}
