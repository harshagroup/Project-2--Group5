package invoice.screens;

import invoice.beans.Client;
import invoice.beans.Employee;
import invoice.database.MyDatabaseHelper;
import invoice.main.LoginHome;
import invoice.main.SessionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EmployeesPanel extends JPanel {
	private JButton logout;
	private JButton help,company,clients,projects,employees,invoices,reports,addnewemployee,editButton,inactiveButton,assignButton;
	private String selectedIndex;
	public EmployeesPanel(final JFrame currentGUIFrame,final SessionManager sessionManager) {
		setLayout(null);		
		JLabel lblNewLabel = new JLabel("Welcome "+sessionManager.getUserName());
		lblNewLabel.setBounds(350, 10, 150, 20);
		currentGUIFrame.add(lblNewLabel);
		
		currentGUIFrame.setBounds(100,100,700,600);
		
		help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		help.setBounds(610, 7, 75, 30);
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
		lblNewLabel = new JLabel("View Employees");
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
		
		if(sessionManager.getUserRole()!=null && sessionManager.getUserRole().equalsIgnoreCase("ACCOUNTANT")){
			addnewemployee = new JButton("Add New Employee");
			addnewemployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new AddEmployeePanel(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();
				}
			});
			addnewemployee.setBounds(50, 160, 175, 30);
			currentGUIFrame.add(addnewemployee);
		}
		
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4"},
                { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4"} };
		Object columnNames[] = { "Name", "Title", "Bill Rate", "Role"};
		
		final MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
		final ArrayList employeeList=myDatabaseHelper.getEmployees();
		if( employeeList!=null &&  employeeList.size()!=0){			
			rowData=new String[ employeeList.size()][4];
			for(int count=0;count< employeeList.size();count++){
				Employee employee=(Employee) employeeList.get(count);
				int increment=0;
				if(employee!=null){
					rowData[count][increment]=employee.getName();
					increment=increment+1;
					rowData[count][increment]=employee.getTitle();
					increment=increment+1;
					rowData[count][increment]=""+employee.getBillrate();
					increment=increment+1;
					rowData[count][increment]=employee.getRole();
				}				
			}
		}
		
		final JTable table = new JTable(rowData, columnNames);
		table.setRowSelectionAllowed(true);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			String selectedData = null;
		 if(table.getSelectedRow() > -1){
		 	selectedIndex=""+table.getSelectedRow();		        	
		 }
		}
		});
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 200, 600, 275);
		currentGUIFrame.add(scroll);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedIndex!=null && selectedIndex.trim().length()!=0){
					Employee employee=(Employee)employeeList.get(new Integer(selectedIndex).intValue());
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new EditEmployeePanel(currentGUIFrame,employee,sessionManager));
					currentGUIFrame.getContentPane().repaint();
					selectedIndex="";
				}else{
					JOptionPane.showMessageDialog(editButton, "Please select one table row");
				}
			}
		});
		editButton.setBounds(50, 500, 100, 30);
		currentGUIFrame.add(editButton);
		
		inactiveButton = new JButton("InActive");
		inactiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedIndex!=null && selectedIndex.trim().length()!=0){
					try{
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int result=JOptionPane.showConfirmDialog (null, "Do you want to Inactive employee with a button YES","Alert",dialogButton);
		                if(result==0){
		                	Employee employee=(Employee)employeeList.get(new Integer(selectedIndex).intValue());
							myDatabaseHelper.inactiveEmployee(employee.getId());
							currentGUIFrame.getContentPane().removeAll();
							currentGUIFrame.getContentPane().add(new EmployeesPanel(currentGUIFrame,sessionManager));
							currentGUIFrame.getContentPane().repaint();
		                }						
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(editButton, "Please select one table row");
				}
			}
		});
		inactiveButton.setBounds(165, 500, 100, 30);
		currentGUIFrame.add(inactiveButton);
		
		if(sessionManager.getUserRole()!=null && sessionManager.getUserRole().equalsIgnoreCase("PROJECT MANAGER")){
			assignButton = new JButton("Assign Developer To Project");
			assignButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentGUIFrame.getContentPane().removeAll();
					currentGUIFrame.getContentPane().add(new AssignDeveloper(currentGUIFrame,sessionManager));
					currentGUIFrame.getContentPane().repaint();						
				}
			});
			assignButton.setBounds(300, 500, 350, 30);
			currentGUIFrame.add(assignButton);
		}
	}
}
