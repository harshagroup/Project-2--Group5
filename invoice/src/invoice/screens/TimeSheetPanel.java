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
import javax.swing.JTextField;

public class TimeSheetPanel extends JPanel {
	private JButton logout;
	private JButton company,clients,projects,employees,invoices,reports,addButton,help;
	private String selectedproject;
	public TimeSheetPanel(final JFrame currentGUIFrame,final SessionManager sessionManager){
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
		
		lblNewLabel = new JLabel(sessionManager.getUserRole()+" Work Time Sheet");
		lblNewLabel.setBounds(250, 140, 200, 20);
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
		
		final MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
		ArrayList assignedProjectList=null;
		if(sessionManager.getUserRole().equalsIgnoreCase("Project Manager")){
			assignedProjectList=myDatabaseHelper.getProjectManagerProjects(sessionManager.getUserName());
		}else{
			assignedProjectList=myDatabaseHelper.getProjects(sessionManager.getUserName());
		}
		final ArrayList projectList=assignedProjectList;
		lblNewLabel = new JLabel("Select Project");
		lblNewLabel.setBounds(175, 180, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final DefaultComboBoxModel projectbox = new DefaultComboBoxModel();
		if(projectList!=null && projectList.size()!=0){			
			for(int count=0;count<projectList.size();count++){
				Project project=(Project)projectList.get(count);
				projectbox.addElement(""+project.getProjectNumber());
			}
		}
		final JComboBox projectCombo = new JComboBox(projectbox);    
		projectCombo.setSelectedIndex(0);
		JScrollPane fbillingComboScrollPane = new JScrollPane(projectCombo);
		fbillingComboScrollPane.setBounds(275, 178, 175, 25);
		currentGUIFrame.add(fbillingComboScrollPane);
		
		lblNewLabel = new JLabel("Monday");
		lblNewLabel.setBounds(100, 210, 60, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField date= new JTextField();
		date.setBounds(100, 240, 75, 25);		
		currentGUIFrame.add(date);	
		
		lblNewLabel = new JLabel("Enter Hours");
		lblNewLabel.setBounds(100, 280, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField hours= new JTextField();
		hours.setBounds(100, 310, 75, 25);		
		currentGUIFrame.add(hours);
		
		lblNewLabel = new JLabel("Tuesday");
		lblNewLabel.setBounds(190, 210, 60, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField date1= new JTextField();
		date1.setBounds(190, 240, 75, 25);		
		currentGUIFrame.add(date1);
		
		lblNewLabel = new JLabel("Enter Hours");
		lblNewLabel.setBounds(190, 280, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField hours1= new JTextField();
		hours1.setBounds(190, 310, 75, 25);		
		currentGUIFrame.add(hours1);
		
		lblNewLabel = new JLabel("Wednesday");
		lblNewLabel.setBounds(280, 210, 80, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField date2= new JTextField();
		date2.setBounds(280, 240, 75, 25);		
		currentGUIFrame.add(date2);
		
		lblNewLabel = new JLabel("Enter Hours");
		lblNewLabel.setBounds(280, 280, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField hours2= new JTextField();
		hours2.setBounds(280, 310, 75, 25);		
		currentGUIFrame.add(hours2);
		
		lblNewLabel = new JLabel("Thursday");
		lblNewLabel.setBounds(370, 210, 60, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField date3= new JTextField();
		date3.setBounds(370, 240, 75, 25);		
		currentGUIFrame.add(date3);
		
		lblNewLabel = new JLabel("Enter Hours");
		lblNewLabel.setBounds(370, 280, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField hours3= new JTextField();
		hours3.setBounds(370, 310, 75, 25);		
		currentGUIFrame.add(hours3);
		
		lblNewLabel = new JLabel("Friday");
		lblNewLabel.setBounds(460, 210, 60, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField date4= new JTextField();
		date4.setBounds(460, 240, 75, 25);		
		currentGUIFrame.add(date4);
		
		lblNewLabel = new JLabel("Enter Hours");
		lblNewLabel.setBounds(460, 280, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField hours4= new JTextField();
		hours4.setBounds(460, 310, 75, 25);		
		currentGUIFrame.add(hours4);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(projectCombo.getItemAt(projectCombo.getSelectedIndex())!=null && (projectCombo.getItemAt(projectCombo.getSelectedIndex())).toString().trim().length()!=0 
						&& ((date!=null && date.getText().trim().length()!=0 && hours!=null && hours.getText().trim().length()!=0) 
						|| (date1!=null && date1.getText().trim().length()!=0 && hours1!=null && hours1.getText().trim().length()!=0) 
						|| (date2!=null && date2.getText().trim().length()!=0 && hours2!=null && hours2.getText().trim().length()!=0)
						|| (date3!=null && date3.getText().trim().length()!=0 && hours3!=null && hours3.getText().trim().length()!=0)
						|| (date4!=null && date4.getText().trim().length()!=0 && hours4!=null && hours4.getText().trim().length()!=0))){
					MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
					Project project=(Project) projectList.get(projectCombo.getSelectedIndex());
					Employee employee=myDatabaseHelper.getEmployeeByUsername(sessionManager.getUserName());
					if(date!=null && date.getText().trim().length()!=0 && hours!=null && hours.getText().trim().length()!=0){
						myDatabaseHelper.insertDeveloperHours(sessionManager.getUserName(), (projectCombo.getItemAt(projectCombo.getSelectedIndex())).toString().trim(), date.getText().trim(), hours.getText().trim(),project.getClient(),employee.getBillrate());
					}
					if(date1!=null && date1.getText().trim().length()!=0 && hours1!=null && hours1.getText().trim().length()!=0){
						myDatabaseHelper.insertDeveloperHours(sessionManager.getUserName(), (projectCombo.getItemAt(projectCombo.getSelectedIndex())).toString().trim(), date1.getText().trim(), hours1.getText().trim(),project.getClient(),employee.getBillrate());
					}
					if(date2!=null && date2.getText().trim().length()!=0 && hours2!=null && hours2.getText().trim().length()!=0){
						myDatabaseHelper.insertDeveloperHours(sessionManager.getUserName(), (projectCombo.getItemAt(projectCombo.getSelectedIndex())).toString().trim(), date2.getText().trim(), hours2.getText().trim(),project.getClient(),employee.getBillrate());
					}
					if(date3!=null && date3.getText().trim().length()!=0 && hours3!=null && hours3.getText().trim().length()!=0){
						myDatabaseHelper.insertDeveloperHours(sessionManager.getUserName(), (projectCombo.getItemAt(projectCombo.getSelectedIndex())).toString().trim(), date3.getText().trim(), hours3.getText().trim(),project.getClient(),employee.getBillrate());
					}
					if(date4!=null && date4.getText().trim().length()!=0 && hours4!=null && hours4.getText().trim().length()!=0){
						myDatabaseHelper.insertDeveloperHours(sessionManager.getUserName(), (projectCombo.getItemAt(projectCombo.getSelectedIndex())).toString().trim(), date4.getText().trim(), hours4.getText().trim(),project.getClient(),employee.getBillrate());
					}
					JOptionPane.showMessageDialog(addButton, "Succeesssfully save worked hours");
					date.setText("");date1.setText("");date2.setText("");date3.setText("");date4.setText("");
					hours.setText("");hours1.setText("");hours2.setText("");hours3.setText("");hours4.setText("");
				}else{
					JOptionPane.showMessageDialog(addButton, "Please enter atleast sindle date and hours");
				}
			}
		});
		addButton.setBounds(250, 400, 100, 30);
		currentGUIFrame.add(addButton);		
	}
}