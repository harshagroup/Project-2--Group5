package invoice.database;

import invoice.beans.ApproveHours;
import invoice.beans.Client;
import invoice.beans.Company;
import invoice.beans.Employee;
import invoice.beans.Invoice;
import invoice.beans.Project;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import au.com.bytecode.opencsv.CSVReader;

public class MyDatabaseHelper {
	
	public static Connection getNonPooledConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String host = "jdbc:mysql://localhost/invoice";
            String uName = "root";
            String uPass= "harsha";
            conn =DriverManager.getConnection(host,uName,uPass);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (conn);
	}
	
	public Company getcompanydata(){
		Connection sqlconnection=null;
		Statement sqlstatement=null;
		Company company=null;
		try{
			sqlconnection =getNonPooledConnection();
			if(sqlconnection!=null){
				sqlstatement = sqlconnection.createStatement();
				String sql="select * from company";
	            ResultSet rs = sqlstatement.executeQuery(sql);
	    		if(rs!=null){
	    			company=new Company();
	    			while(rs.next()){
	    				company.setName(rs.getString("name"));
	    				company.setAddress1(rs.getString("addressline1"));
	    				company.setAddress2(rs.getString("addressline2"));
	    				company.setCity(rs.getString("city"));
	    				company.setState(rs.getString("state"));
	    				company.setZip(""+rs.getInt("zip"));
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }
        return company;
    }
	
	public void editCompanyData(String name,String addressline1,String addressline2,String city,String state,String zip) throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update company set name='"+name+"',addressline1='"+addressline1+"',addressline2='"+addressline2+"',city='"+city+"',state='"+state+"',zip='"+zip+"'";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
	}
	
	public ArrayList getClients(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList clientList=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from clients where active_status_flag='Y'");
	    		if(rs!=null){
	    			clientList=new ArrayList();
	    			while(rs.next()){
	    				Client client=new Client();
	    				client.setNumber(rs.getInt("client_number"));
	    				client.setName(rs.getString("client_name"));
	    				client.setAddressline1(rs.getString("address_line1"));
	    				client.setAddressline2(rs.getString("address_line2"));
	    				client.setCity(rs.getString("city"));
	    				client.setState(rs.getString("state"));
	    				client.setZip(""+rs.getInt("zip"));
	    				client.setEmail(rs.getString("email"));
	    				client.setContact(rs.getString("contact_person"));
	    				client.setInvoiceFreq(rs.getString("invoice_frequency"));
	    				client.setBillingTerms(rs.getString("billing_terms"));
	    				client.setInvoiceGrouping(rs.getString("invoice_grouping"));
	    				clientList.add(client);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return clientList;
    }
	
	public Client getClientByNumber(String clientNumber){
		Connection conn=null;
		Statement stmt=null;
		Client client=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from clients where client_number="+clientNumber+" and active_status_flag='Y'");
	    		if(rs!=null){
	    			while(rs.next()){
	    				client=new Client();
	    				client.setNumber(rs.getInt("client_number"));
	    				client.setName(rs.getString("client_name"));
	    				client.setAddressline1(rs.getString("address_line1"));
	    				client.setAddressline2(rs.getString("address_line2"));
	    				client.setCity(rs.getString("city"));
	    				client.setState(rs.getString("state"));
	    				client.setZip(""+rs.getInt("zip"));
	    				client.setEmail(rs.getString("email"));
	    				client.setContact(rs.getString("contact_person"));
	    				client.setInvoiceFreq(rs.getString("invoice_frequency"));
	    				client.setBillingTerms(rs.getString("billing_terms"));
	    				client.setInvoiceGrouping(rs.getString("invoice_grouping"));
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return client;
    }
	
	public ArrayList getProjects(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList projectList=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from projects where active_status_flag='Y'");
	    		if(rs!=null){
	    			projectList=new ArrayList();
	    			while(rs.next()){
	    				Project project=new Project();
	    				project.setClient(""+rs.getInt("client_number"));
	    				project.setProjectName(rs.getString("project_name"));
	    				project.setProjectNumber(rs.getInt("project_number"));
	    				project.setProjectManager(rs.getString("project_manager_name"));
	    				project.setStateDate(rs.getString("start_date"));
	    				project.setEndDate(rs.getString("end_date"));
	    				project.setStatus(rs.getString("status"));
	    				project.setClientContact(rs.getString("client_contact_name"));	    				
	    				project.setBudget(rs.getDouble("budget"));
	    				projectList.add(project);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return projectList;
    }
	
	public Project getProjectsByNumbers(String clientnumber,String projectnumber){
		Connection conn=null;
		Statement stmt=null;
		Project project=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from projects where client_number="+clientnumber+" and project_number="+projectnumber+" and active_status_flag='Y'");
	    		if(rs!=null){
	    			while(rs.next()){
	    				project=new Project();
	    				project.setClient(""+rs.getInt("client_number"));
	    				project.setProjectName(rs.getString("project_name"));
	    				project.setProjectNumber(rs.getInt("project_number"));
	    				project.setProjectManager(rs.getString("project_manager_name"));
	    				project.setStateDate(rs.getString("start_date"));
	    				project.setEndDate(rs.getString("end_date"));
	    				project.setStatus(rs.getString("status"));
	    				project.setClientContact(rs.getString("client_contact_name"));	    				
	    				project.setBudget(rs.getDouble("budget"));
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return project;
    }
	
	public ArrayList getProjects(String developername){
		Connection conn=null;
		Statement stmt=null;
		ArrayList projectList=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select p.client_number,p.project_name,p.project_number,p.project_manager_name,p.start_date,p.end_date,p.status,p.client_contact_name,p.budget from projects p, assigndevelopertoprojects adp where p.client_number=adp.client_number and p.project_number=adp.project_number and adp.developer_name='"+developername+"' and p.active_status_flag='Y'");
	    		if(rs!=null){
	    			projectList=new ArrayList();
	    			while(rs.next()){
	    				Project project=new Project();
	    				project.setClient(""+rs.getInt("client_number"));
	    				project.setProjectName(rs.getString("project_name"));
	    				project.setProjectNumber(rs.getInt("project_number"));
	    				project.setProjectManager(rs.getString("project_manager_name"));
	    				project.setStateDate(rs.getString("start_date"));
	    				project.setEndDate(rs.getString("end_date"));
	    				project.setStatus(rs.getString("status"));
	    				project.setClientContact(rs.getString("client_contact_name"));	    				
	    				project.setBudget(rs.getDouble("budget"));
	    				projectList.add(project);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return projectList;
    }
	
	public ArrayList getEmployees(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList employeeList=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from employees where employee_role!='Accountant' and active_status_flag='Y'");
	    		if(rs!=null){
	    			employeeList=new ArrayList();
	    			while(rs.next()){
	    				Employee employee=new Employee();
	    				employee.setId(""+rs.getInt("employee_id"));
	    				employee.setName(rs.getString("user_name"));
	    				employee.setTitle(rs.getString("title"));
	    				employee.setRole(rs.getString("employee_role"));
	    				employee.setBillrate(rs.getInt("bill_rate"));
	    				employeeList.add(employee);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return employeeList;
    }
	
	public ArrayList getEmployeesReport(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList employeeList=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select adp.client_number,adp.project_number,e.user_name,e.bill_rate from employees e,assigndevelopertoprojects adp where adp.developer_name=e.user_name");
	    		if(rs!=null){
	    			employeeList=new ArrayList();
	    			while(rs.next()){
	    				Employee employee=new Employee();
	    				employee.setName(rs.getString("user_name"));
	    				employee.setTitle(rs.getString("client_number"));
	    				employee.setRole(rs.getString("project_number"));
	    				employee.setBillrate(rs.getInt("bill_rate"));
	    				employeeList.add(employee);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return employeeList;
    }
	
	public Employee getEmployeeByUsername(String username){
		Connection conn=null;
		Statement stmt=null;
		Employee employee=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from employees where user_name='"+username+"'");
	    		if(rs!=null){
	    			while(rs.next()){
	    				employee=new Employee();
	    				employee.setName(rs.getString("user_name"));
	    				employee.setTitle(rs.getString("title"));
	    				employee.setRole(rs.getString("employee_role"));
	    				employee.setBillrate(rs.getInt("bill_rate"));
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return employee;
    }
	
	public ArrayList getAllApproveProjects(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList approvelist=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from developerhours where approve_status='Not Approved'");
	    		if(rs!=null){
	    			approvelist=new ArrayList();
	    			while(rs.next()){
	    				ApproveHours approve=new ApproveHours();
	    				approve.setDeveloperhoursid(rs.getInt("developer_hours_number"));
	    				approve.setProjectnumber(rs.getInt("project_number"));
	    				approve.setDevelopername(rs.getString("developer_name"));
	    				approve.setWorkdate(rs.getString("work_date"));
	    				approve.setWorkhours(rs.getInt("worked_hours"));
	    				approve.setApprovestatus(rs.getString("approve_status"));
	    				approvelist.add(approve);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return approvelist;
    }
	
	public ArrayList getEmployeeReport(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList approvelist=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from developerhours");
	    		if(rs!=null){
	    			approvelist=new ArrayList();
	    			while(rs.next()){
	    				ApproveHours approve=new ApproveHours();
	    				approve.setDeveloperhoursid(rs.getInt("developer_hours_number"));
	    				approve.setProjectnumber(rs.getInt("project_number"));
	    				approve.setDevelopername(rs.getString("developer_name"));
	    				approve.setWorkdate(rs.getString("work_date"));
	    				approve.setWorkhours(rs.getInt("worked_hours"));
	    				approve.setApprovestatus(rs.getString("approve_status"));
	    				approvelist.add(approve);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return approvelist;
    }
	
	public ArrayList getInvoiceReport(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList approvelist=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from client_invoices");
	    		if(rs!=null){
	    			approvelist=new ArrayList();
	    			while(rs.next()){
	    				Invoice invoice=new Invoice();
	    				invoice.setClientnumber(rs.getString("client_number"));
	    				invoice.setProjectnumber(rs.getString("project_number"));
	    				invoice.setInvoicenumber(rs.getString("invoice_number"));
	    				invoice.setInvoicedate(rs.getString("invoice_generate_date"));
	    				invoice.setAmount(rs.getString("total_amount"));
	    				approvelist.add(invoice);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return approvelist;
    }
	
	public ArrayList generateInvoicedevelopers(String clientnumber,String projectnumber){
		Connection conn=null;
		Statement stmt=null;
		ArrayList invoicelist=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from developerhours where client_number="+clientnumber+" and project_number="+projectnumber+" and approve_status='APPROVED'");
	            if(rs!=null){
	            	invoicelist=new ArrayList();
	    			while(rs.next()){
	    				String[] invoice_developer_data=new String[7];
	    				invoice_developer_data[0]=rs.getString("client_number");
	    				invoice_developer_data[1]=rs.getString("project_number");
	    				invoice_developer_data[2]=rs.getString("developer_name");
	    				invoice_developer_data[3]=""+rs.getInt("worked_hours");
	    				invoice_developer_data[4]=rs.getString("work_date");
	    				invoice_developer_data[5]=rs.getString("work_date");
	    				invoice_developer_data[6]=""+rs.getInt("billrate");
	    				invoicelist.add(invoice_developer_data);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return invoicelist;
    }
	
	public ArrayList generateInvoices(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList invoicelist=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select client_number,project_number,sum(worked_hours*billrate) from developerhours where approve_status='APPROVED' group by client_number,project_number");
	    		if(rs!=null){
	    			invoicelist=new ArrayList();
	    			while(rs.next()){
	    				Invoice invoice=new Invoice();
	    				invoice.setClientnumber(rs.getString("client_number"));
	    				invoice.setProjectnumber(rs.getString("project_number"));
	    				invoice.setAmount(rs.getString("sum(worked_hours*billrate)"));
	    				invoicelist.add(invoice);
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}
        return invoicelist;
    }
	
	public void insertClient(String clientnumber,String clientname,String addressline1,String addressline2,String city,String state,String zip,String email,String contactperson,String invoicefrequency,String billingterms,String invoicegrouping){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into clients (client_number,client_name,address_line1,address_line2,city,state,zip,email,contact_person,invoice_frequency,billing_terms,invoice_grouping,active_status_flag) values ("+clientnumber+",'"+clientname+"','"+addressline1+"','"+addressline2+"','"+city+"','"+state+"',"+zip+",'"+email+"','"+contactperson+"','"+invoicefrequency+"','"+billingterms+"','"+invoicegrouping+"','Y')";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public String getMaximumId(String clientname){
		Connection conn=null;
		Statement stmt=null;
		String maxNumber="";
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement();
	            String sql="";
	            if(clientname.equalsIgnoreCase("Client")){
	            	sql = "select max(client_number) from clients";
	            }
	            if(clientname.equalsIgnoreCase("Project")){
	            	sql = "select max(project_number) from projects";
	            }
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery(sql);
	    		if(rs!=null){
	    			while(rs.next()){
	    				maxNumber=""+(rs.getInt(1));
	    			}
	    		}
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}	
        return maxNumber;
    }
	
	public void addClient(String clientname,String addressline1,String addressline2,String city,String state,String zip,String email,String contactperson,String invoicefrequency,String billingterms,String invoicegrouping){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            int clientnumber=0;
	            String sql = "insert into clients (client_number,client_name,address_line1,address_line2,city,state,zip,email,contact_person,invoice_frequency,billing_terms,invoice_grouping,active_status_flag) values ("+(new Integer(getMaximumId("Client")).intValue()+1)+",'"+clientname+"','"+addressline1+"','"+addressline2+"','"+city+"','"+state+"',"+zip+",'"+email+"','"+contactperson+"','"+invoicefrequency+"','"+billingterms+"','"+invoicegrouping+"','Y')";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void updateClient(String clientnumber,String clientname,String addressline1,String addressline2,String city,String state,String zip,String email,String contactperson,String invoicefrequency,String billingterms,String invoicegrouping){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update clients set client_name='"+clientname+"',address_line1='"+addressline1+"',address_line2='"+addressline2+"',city='"+city+"',state='"+state+"',zip="+zip+",email='"+email+"',contact_person='"+contactperson+"',invoice_frequency='"+invoicefrequency+"',billing_terms='"+billingterms+"',invoice_grouping='"+invoicegrouping+"' where client_number="+clientnumber;
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void editAndApprove(int approveid,String hours){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update developerhours set worked_hours="+new Integer(hours).intValue()+",approve_status='Approved' where developer_hours_number="+approveid;
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void inactiveClient(int clientnumber){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update clients set active_status_flag='N' where client_number="+clientnumber;
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void insertProject(String clientnumber,String projectnumber,String projectname,String startdate,String enddate,String status,String projectmanagername,String clientcontactname,String budget){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into projects (project_number,client_number,project_name,start_date,end_date,status,project_manager_name,client_contact_name,budget) values ("+projectnumber+","+clientnumber+",'"+projectname+"','"+startdate+"','"+enddate+"','"+status+"','"+projectmanagername+"','"+clientcontactname+"',"+budget+")";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	
	
	public void assignEmployee(String projectnumber,String developername,String clientnumber){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into assigndevelopertoprojects (project_number,developer_name,client_number) values ("+projectnumber+",'"+developername+"',"+clientnumber+")";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void addProject(String clientnumber,String projectname,String startdate,String enddate,String status,String projectmanagername,String clientcontactname,String budget){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into projects (project_number,client_number,project_name,start_date,end_date,status,project_manager_name,client_contact_name,budget,active_status_flag) values ("+(new Integer(getMaximumId("Project"))+1)+","+clientnumber+",'"+projectname+"','"+startdate+"','"+enddate+"','"+status+"','"+projectmanagername+"','"+clientcontactname+"',"+budget+",'Y')";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void updateProject(String projectnumber, String clientnumber,String projectname,String startdate,String enddate,String status,String projectmanagername,String clientcontactname,String budget){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update projects set client_number="+clientnumber+",project_name='"+projectname+"',start_date='"+startdate+"',end_date='"+enddate+"',status='"+status+"',project_manager_name='"+projectmanagername+"',client_contact_name='"+clientcontactname+"',budget="+budget+" where project_number="+projectnumber;
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void inactiveProject(int projectnumber){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update projects set active_status_flag='N' where project_number="+projectnumber;
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void insertEmployee(String name,String title,String role,String billrate){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into employees (user_name,title,employee_role,bill_rate,active_status_flag) values ('"+name+"','"+title+"','"+role+"',"+billrate+",'Y')";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void updateEmployee(String id,String name,String title,String role,String billrate){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update employees set user_name='"+name+"',title='"+title+"',employee_role='"+role+"',bill_rate="+billrate+" where employee_id="+id;
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void inactiveEmployee(String id){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "update employees set active_status_flag='N' where employee_id="+id;
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void insertDeveloperHours(String name,String projectname,String date,String hours,String clientnumber,int billrate){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into developerhours (project_number,developer_name,work_date,worked_hours,approve_status,client_number,billrate) values ("+projectname+",'"+name+"','"+date+"',"+hours+",'Not Approved',"+clientnumber+","+billrate+")";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void insertClientInvoices(String clientnumber,String projectnumber,String totalamount){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
				String date=simpleDateFormat.format(new Date());
	            stmt = conn.createStatement( );
	            String sql = "insert into client_invoices (client_number,project_number,invoice_number,invoice_generate_date,total_amount) values ("+clientnumber+","+projectnumber+","+(100000+new Random().nextInt(6))+",'"+date+"',"+totalamount+")";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void assignDeveloperToProject(String projectnumber,String developername){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into assigndevelopertoprojects (project_number,developer_name) values ("+projectnumber+",'"+developername+"')";
	            stmt.executeUpdate(sql);
			}
        }catch(SQLException err){
        	err.printStackTrace();
        }finally{
		     try{
		    	 if(stmt!=null){
			    	 stmt.close();
			     }
		         if(conn!=null)
		            conn.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		}		
    }
	
	public void getInitializeData(){
		try{
			CSVReader clientsinputdata = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\invoice\\database\\client_data.csv"));
			List<String[]> allclientsdata=clientsinputdata.readAll();
			if(allclientsdata!=null && allclientsdata.size()!=0){
				int pointer=0;
				for(String[] client : allclientsdata){
					if(pointer!=0){
						insertClient(client[0],client[1],client[2],client[3],client[4],client[5],client[6],client[7],client[8],client[9],client[10],client[11]);
					}
					pointer++;
				}
			}
			
			CSVReader projectsinputdata = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\invoice\\database\\project_data.csv"));
			List<String[]> allprojectsdata=projectsinputdata.readAll();
			if(allprojectsdata!=null && allprojectsdata.size()!=0){
				int pointer=0;
				for(String[] project : allprojectsdata){
					if(pointer!=0){
						insertProject(project[0],project[1],project[2],project[3],project[4],project[5],project[6],project[7],project[8]);
					}
					pointer++;
				}
			}
			
			CSVReader employeesinputdata = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\invoice\\database\\people_data.csv"));
			List<String[]> allemployeesdata=employeesinputdata.readAll();
			if(allemployeesdata!=null && allemployeesdata.size()!=0){
				int pointer=0;
				for(String[] employee : allemployeesdata){
					if(pointer!=0){
						insertEmployee(employee[0],employee[1],employee[3],employee[2]);
					}
					pointer++;
				}
			}			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
