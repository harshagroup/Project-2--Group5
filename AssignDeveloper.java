package invoice.screens;

import invoice.beans.Employee;
import invoice.beans.Project;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AssignDeveloper extends JPanel {
	private JButton logout;
	private JButton help,company,clients,projects,employees,invoices,reports,assignButton,back;
	private String selectedIndex;
	public AssignDeveloper(final JFrame currentGUIFrame,final SessionManager sessionManager) {
		setLayout(null);		
		JLabel lblNewLabel = new JLabel("Welcome "+sessionManager.getUserName());
		lblNewLabel.setBounds(350, 10, 150, 20);
		currentGUIFrame.add(lblNewLabel);
		
		currentGUIFrame.setBounds(100,100,705,605);
		
		help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		help.setBounds(610, 7, 75, 30);
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new LoginHome(currentGUIFrame));
				currentGUIFrame.getContentPane().repaint();	
			}
		});
		logout.setBounds(525, 7, 75, 30);
		currentGUIFrame.add(logout);
		lblNewLabel = new JLabel("Assign Developer to Project");
		lblNewLabel.setBounds(250, 140, 350, 20);
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
		final ArrayList projectList=myDatabaseHelper.getProjects();		
		final ArrayList employeeList=myDatabaseHelper.getEmployees();
		
		lblNewLabel = new JLabel("Project Number");
		lblNewLabel.setBounds(175, 180, 115, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final DefaultComboBoxModel projectbox = new DefaultComboBoxModel();
		if( projectList!=null &&  projectList.size()!=0){			
			for(int count=0;count< projectList.size();count++){
				Project project=(Project) projectList.get(count);
				projectbox.addElement(""+project.getProjectNumber());
			}
		}
		final JComboBox projectboxCombo = new JComboBox(projectbox);    
		JScrollPane projectboxComboScrollPane = new JScrollPane(projectboxCombo);
		projectboxComboScrollPane.setBounds(275, 178, 175, 25);
		currentGUIFrame.add(projectboxComboScrollPane);
		
		lblNewLabel = new JLabel("Developer Name");
		lblNewLabel.setBounds(175, 210, 100, 20);
		currentGUIFrame.add(lblNewLabel);		
		final DefaultComboBoxModel developerbox = new DefaultComboBoxModel();
		if( employeeList!=null &&  employeeList.size()!=0){			
			for(int count=0;count< employeeList.size();count++){
				Employee employee=(Employee) employeeList.get(count);
				if(employee.getRole().equalsIgnoreCase("Developer")){
					developerbox.addElement(employee.getName());
				}
			}
		}
		final JComboBox developerCombo = new JComboBox(developerbox);    
		JScrollPane developerComboScrollPane = new JScrollPane(developerCombo);
		developerComboScrollPane.setBounds(275, 208, 175, 25);
		currentGUIFrame.add(developerComboScrollPane);
		
		assignButton = new JButton("Save");
		assignButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(projectboxCombo.getItemAt(projectboxCombo.getSelectedIndex())!=null && (projectboxCombo.getItemAt(projectboxCombo.getSelectedIndex())).toString().trim().length()!=0
						 && developerCombo.getItemAt(developerCombo.getSelectedIndex())!=null && (developerCombo.getItemAt(developerCombo.getSelectedIndex())).toString().trim().length()!=0){
					try{
						MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
						myDatabaseHelper.assignEmployee((projectboxCombo.getItemAt(projectboxCombo.getSelectedIndex())).toString().trim(),(developerCombo.getItemAt(developerCombo.getSelectedIndex())).toString().trim());
						currentGUIFrame.getContentPane().removeAll();
						currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
						currentGUIFrame.getContentPane().repaint();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(assignButton, "Please enter all correct details");
				}
			}
		});
		assignButton.setBounds(270, 320, 125, 30);
		currentGUIFrame.add(assignButton);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
				currentGUIFrame.getContentPane().repaint();
			}
		});
		back.setBounds(100, 320, 125, 30);
		currentGUIFrame.add(back);
	}
}
