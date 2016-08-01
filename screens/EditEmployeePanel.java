package invoice.screens;

import invoice.database.MyDatabaseHelper;
import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditEmployeePanel  extends JPanel {
	private JButton logout;
	private JButton company,clients,projects,employees,invoices,reports,addNewCourse,back,exitButton,help;
	public EditEmployeePanel(final JFrame currentGUIFrame,final String seletedIndex,final SessionManager sessionManager) {
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
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new LoginHome(currentGUIFrame));
				currentGUIFrame.getContentPane().repaint();	
			}
		});
		logout.setBounds(525, 7, 75, 30);
		currentGUIFrame.add(logout);
		lblNewLabel = new JLabel("Edit Course");
		lblNewLabel.setBounds(250, 90, 200, 20);
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
			company.setBounds(75, 100, 100, 30);
			currentGUIFrame.add(company);
			
			clients = new JButton("Clients");
			clients.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ClientsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			clients.setBounds(185, 100, 90, 30);
			currentGUIFrame.add(clients);
			
			projects = new JButton("Projects");
			projects.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ProjectsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			projects.setBounds(285, 100, 90, 30);
			currentGUIFrame.add(projects);
			
			employees = new JButton("Employees");
			employees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			employees.setBounds(385, 100, 90, 30);
			currentGUIFrame.add(employees);
			
			invoices = new JButton("Invoice");
			invoices.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new InvoicesPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			invoices.setBounds(485, 100, 100, 30);
			currentGUIFrame.add(invoices);
			
			reports = new JButton("Reports");
			reports.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new ReportsPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			reports.setBounds(185, 150, 85, 30);
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
			employees = new JButton("TimeSheet");
			employees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new TimeSheetPanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			employees.setBounds(250, 100, 125, 30);
			currentGUIFrame.add(employees);
		}
		
		
		lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setBounds(100, 120, 110, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField courseName = new JTextField();
		courseName.setBounds(250, 118, 175, 25);
		currentGUIFrame.add(courseName);	
		
		lblNewLabel = new JLabel("Course Hours");
		lblNewLabel.setBounds(100, 150, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField courseHours= new JTextField();
		courseHours.setBounds(250, 148, 175, 25);		
		currentGUIFrame.add(courseHours);
		
		lblNewLabel = new JLabel("Course Capacity");
		lblNewLabel.setBounds(100, 180, 115, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField courseCapacity= new JTextField();
		courseCapacity.setBounds(250, 178, 175, 25);
		currentGUIFrame.add(courseCapacity);
		
		lblNewLabel = new JLabel("Prequisite");
		lblNewLabel.setBounds(100, 210, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField prereq= new JTextField();
		prereq.setBounds(250, 208, 175, 25);
		currentGUIFrame.add(prereq);
		
		lblNewLabel = new JLabel("Course Semester");
		lblNewLabel.setBounds(100, 240, 115, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField courseSem= new JTextField();
		courseSem.setBounds(250, 238, 175, 25);
		currentGUIFrame.add(courseSem);
		
		lblNewLabel = new JLabel("Faculty");
		lblNewLabel.setBounds(100, 270, 115, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField courseFaculty= new JTextField();
		courseFaculty.setBounds(250, 268, 175, 25);
		currentGUIFrame.add(courseFaculty);
		
		
		addNewCourse = new JButton("Update");
		addNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(courseName!=null && courseName.getText().trim().length()!=0 && courseHours!=null && courseHours.getText().trim().length()!=0
						&& courseCapacity!=null && courseCapacity.getText().trim().length()!=0 && prereq!=null && prereq.getText().trim().length()!=0){
					try{
						currentGUIFrame.getContentPane().removeAll();
						currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
						currentGUIFrame.getContentPane().repaint();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(addNewCourse, "Please enter all correct details");
				}
			}
		});
		addNewCourse.setBounds(270, 295, 125, 30);
		currentGUIFrame.add(addNewCourse);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
				currentGUIFrame.getContentPane().repaint();
			}
		});
		back.setBounds(100, 295, 125, 30);
		currentGUIFrame.add(back);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		exitButton.setBounds(450, 295, 125, 30);
		currentGUIFrame.add(exitButton);
	}

}
