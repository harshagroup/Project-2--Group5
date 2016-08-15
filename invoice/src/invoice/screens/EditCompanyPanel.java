package invoice.screens;

import invoice.beans.Company;
import invoice.database.MyDatabaseHelper;
import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditCompanyPanel extends JPanel {
	private JButton logout;
	private JButton company,clients,projects,employees,invoices,reports,updatecompany,back,help;
	public EditCompanyPanel(final JFrame currentGUIFrame,Company companydata,final SessionManager sessionManager) {
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
		lblNewLabel = new JLabel("Edit Company Information");
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
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(175, 170, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField name = new JTextField();
		name.setText(companydata.getName());
		name.setBounds(300, 168, 200, 25);
		currentGUIFrame.add(name);
		
		lblNewLabel = new JLabel("Address Line1");
		lblNewLabel.setBounds(175, 200, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField addressline1 = new JTextField();
		addressline1.setText(companydata.getAddress1());
		addressline1.setBounds(300, 198, 200, 25);
		currentGUIFrame.add(addressline1);
		
		lblNewLabel = new JLabel("Address Line2");
		lblNewLabel.setBounds(175, 230, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField addressline2= new JTextField();
		addressline2.setText(companydata.getAddress2());
		addressline2.setBounds(300, 228, 200, 25);		
		currentGUIFrame.add(addressline2);
		
		lblNewLabel = new JLabel("City");
		lblNewLabel.setBounds(175, 260, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField city= new JTextField();
		city.setText(companydata.getCity());
		city.setBounds(300, 258, 200, 25);		
		currentGUIFrame.add(city);
		
		lblNewLabel = new JLabel("State");
		lblNewLabel.setBounds(175, 290, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField state= new JTextField();
		state.setText(companydata.getState());
		state.setBounds(300, 288, 200, 25);		
		currentGUIFrame.add(state);
		
		lblNewLabel = new JLabel("Zip");
		lblNewLabel.setBounds(175, 320, 100, 20);
		currentGUIFrame.add(lblNewLabel);
		
		final JTextField zip= new JTextField();
		zip.setText(companydata.getZip());
		zip.setBounds(300, 318, 200, 25);		
		currentGUIFrame.add(zip);		
		
		updatecompany = new JButton("Update");
		updatecompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name!=null && name.getText().trim().length()!=0 && addressline1!=null && addressline1.getText().trim().length()!=0
						&& city!=null && city.getText().trim().length()!=0 && state.getText()!=null && state.getText().trim().length()!=0 
						&& zip.getText()!=null && zip.getText().trim().length()!=0){
					try{
						MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
						myDatabaseHelper.editCompanyData(name.getText().trim(), addressline1.getText().trim(), addressline2.getText().trim(), city.getText().trim(), state.getText().trim(), zip.getText().trim());
						currentGUIFrame.getContentPane().removeAll();
						currentGUIFrame.getContentPane().add(new CompanyPanel(currentGUIFrame,sessionManager));
						currentGUIFrame.getContentPane().repaint();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(updatecompany, "Please enter all correct details");
				}
			}
		});
		updatecompany.setBounds(270, 440, 125, 30);
		currentGUIFrame.add(updatecompany);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentGUIFrame.getContentPane().removeAll();
				currentGUIFrame.getContentPane().add(new CompanyPanel(currentGUIFrame,sessionManager));
				currentGUIFrame.getContentPane().repaint();
			}
		});
		back.setBounds(100, 440, 125, 30);
		currentGUIFrame.add(back);
	}
	
}
