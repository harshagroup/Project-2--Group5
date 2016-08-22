package invoice.screens;

import invoice.beans.Invoice;
import invoice.database.MyDatabaseHelper;
import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class InvoiceReportPanel extends JPanel {
	private JButton logout;
	private JButton help,company,clients,projects,employees,invoices,reports,download,studentReport,facultyReport,exitButton,degreePlanReport;
	public InvoiceReportPanel(final JFrame currentGUIFrame,final SessionManager sessionManager) {
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
		
		lblNewLabel = new JLabel("Invoice Report");
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
		
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4", "Row1-Column5"},
							   { "Row2-Column1", "Row2-Column2", "Row2-Column3", "Row1-Column4", "Row1-Column5"} };
		Object columnNames[] = { "Client Number", "Project Number", "Invoice Number", "Amount", "Date"};
		
		final MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
		final ArrayList approveList=myDatabaseHelper.getInvoiceReport();
		if(approveList!=null &&  approveList.size()!=0){			
		rowData=new String[ approveList.size()][5];
		for(int count=0;count< approveList.size();count++){
			Invoice invoice=(Invoice) approveList.get(count);
			int increment=0;
			if(invoice!=null){
				rowData[count][increment]=invoice.getClientnumber();
				increment=increment+1;
				rowData[count][increment]=invoice.getProjectnumber();
				increment=increment+1;
				rowData[count][increment]=invoice.getInvoicenumber();
				increment=increment+1;
				rowData[count][increment]=invoice.getInvoicedate();
				increment=increment+1;
				rowData[count][increment]=invoice.getAmount();
			}				
		}
		}
		
		final JTable table = new JTable(rowData, columnNames);
		table.setRowSelectionAllowed(true);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 200, 600, 275);
		currentGUIFrame.add(scroll);
	}
	
}
