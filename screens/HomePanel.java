package invoice.screens;

import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	private JButton logout;
	private JButton company,clients,projects,employees,invoices,reports,help;
	public HomePanel(final JFrame currentGUIFrame,final SessionManager sessionManager) {
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
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int result=JOptionPane.showConfirmDialog (null, "Do you want to logout with a button YES","Alert",dialogButton);
                if(result==0){
                	sessionManager.setUserRole("");
                	currentGUIFrame.getContentPane().removeAll();
    				currentGUIFrame.getContentPane().add(new LoginHome(currentGUIFrame));
    				currentGUIFrame.getContentPane().repaint();
                }	
			}
		});
		logout.setBounds(525, 7, 75, 30);
		currentGUIFrame.add(logout);
		
		lblNewLabel = new JLabel("Welcome "+sessionManager.getUserRole());
		lblNewLabel.setBounds(250, 75, 200, 20);
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
		System.out.println(sessionManager.getUserRole()+"  asfsdafsfafdsfdf");
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
		
		
		
		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+"/src/invoice/main/logo.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(275, 160, 150, 100);
		currentGUIFrame.add(label);
		
		lblNewLabel = new JLabel("EAGLE CONSULTING COMPANY");
		lblNewLabel.setBounds(250, 280, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		lblNewLabel = new JLabel("Address : 2501 E Memorial Road");
		lblNewLabel.setBounds(250, 310, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		lblNewLabel = new JLabel("Edmond, OK");
		lblNewLabel.setBounds(250, 340, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		lblNewLabel = new JLabel("73013");
		lblNewLabel.setBounds(250, 370, 250, 30);
		currentGUIFrame.add(lblNewLabel);
		
		
//		database = new JButton("Clear Database");
//		database.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try{
//					File file = new File(System.getProperty("user.dir")+"\\src\\Database\\TestDataDegrees.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\TestDataCourses.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\TestDataDegreePlanReq.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\TestDataFaculty.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\TestDataSemesters.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\STC.DUMP.CSV");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\STU.DUMP.CSV");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\schedule.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\facultyreport.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//		            file = new File(System.getProperty("user.dir")+"\\src\\Database\\studentreport.csv");  
//		            if(file.delete()){
//		                file.createNewFile();
//		            }
//					JOptionPane.showMessageDialog(database, "Cleare the Database !!!");
//				}catch(Exception ex){
//					ex.printStackTrace();
//				}
//			}
//		});
//		database.setBounds(285, 150, 200, 30);
//		currentGUIFrame.add(database);
	}
}
