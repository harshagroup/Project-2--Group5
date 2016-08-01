package invoice.main;

import invoice.database.MyDatabaseHelper;
import invoice.screens.HomePanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIFrames extends JFrame {
	
	private JFrame currentGUIFrame;
	private JPanel contentPane;
	public GUIFrames(){
		currentGUIFrame = this;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,700,600);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper();
		//myDatabaseHelper.getInitializeData();
		getContentPane().removeAll();
		getContentPane().add(new LoginHome(currentGUIFrame));		
	}	
	public static void run(){
		try{
			JFrame frame = new GUIFrames();
			frame.setVisible(true);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
