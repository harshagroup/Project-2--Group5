package invoice.database;

import invoice.beans.Client;
import invoice.beans.Employee;
import invoice.beans.Project;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class MyDatabaseHelper {
	
	public static Connection getNonPooledConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String host = "jdbc:mysql://localhost/invoice";
            String uName = "root";
            String uPass= "unoscm2010";
            conn =DriverManager.getConnection(host,uName,uPass);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (conn);
	}
	
	public ArrayList getClients(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList clientList=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from clients");
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
	
	public ArrayList getProjects(){
		Connection conn=null;
		Statement stmt=null;
		ArrayList projectList=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            ResultSet rs = stmt.executeQuery("select * from projects");
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
	            ResultSet rs = stmt.executeQuery("select * from employees");
	    		if(rs!=null){
	    			employeeList=new ArrayList();
	    			while(rs.next()){
	    				Employee employee=new Employee();
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
	
	public void insertClient(String clientnumber,String clientname,String addressline1,String addressline2,String city,String state,String zip,String email,String contactperson,String invoicefrequency,String billingterms,String invoicegrouping){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into clients (client_number,client_name,address_line1,address_line2,city,state,zip,email,contact_person,invoice_frequency,billing_terms,invoice_grouping,active_status_flag) values ("+clientnumber+",'"+clientname+"','"+addressline1+"','"+addressline2+"','"+city+"','"+state+"',"+zip+",'"+email+"','"+contactperson+"','"+invoicefrequency+"','"+billingterms+"','"+invoicegrouping+"','N')";
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
	
	public void insertEmployee(String name,String title,String role,String billrate){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn =getNonPooledConnection();
			if(conn!=null){
	            stmt = conn.createStatement( );
	            String sql = "insert into employees (user_name,title,employee_role,bill_rate,active_status_flag) values ('"+name+"','"+title+"','"+role+"',"+billrate+",'N')";
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
