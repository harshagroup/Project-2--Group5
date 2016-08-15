package invoice.screens;

import invoice.beans.Company;
import invoice.database.MyDatabaseHelper;
import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompanyPanel extends JPanel {
	private JButton logout;
	private JButton company,clients,projects,employees,invoices,reports,addNewProfessor,editButton,deleteButton,help;
	private String selectedIndex;
	public CompanyPanel(final JFrame currentGUIFrame,final SessionManager sessionManager){
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
		
		lblNewLabel = new JLabel("Company Information");
		lblNewLabel.setBounds(250, 140, 200, 30);
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
		
		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+"/src/invoice/main/logo.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(275, 160, 150, 100);
		currentGUIFrame.add(label);
		
		final MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
		final Company company=myDatabaseHelper.getcompanydata();
		
		lblNewLabel = new JLabel(company.getName());
		lblNewLabel.setBounds(250, 280, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		lblNewLabel = new JLabel("Address : "+company.getAddress1()+" "+company.getAddress2());
		lblNewLabel.setBounds(250, 310, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		lblNewLabel = new JLabel(company.getCity()+", "+company.getState());
		lblNewLabel.setBounds(250, 340, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		lblNewLabel = new JLabel(company.getZip());
		lblNewLabel.setBounds(250, 370, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new EditCompanyPanel(currentGUIFrame,company,sessionManager));
				currentGUIFrame.getContentPane().repaint();
			}
		});
		editButton.setBounds(250, 500, 100, 30);
		currentGUIFrame.add(editButton);
	}
}
