import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;

public class Log_Info extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;
	private JTextField info_fname;
	private JTextField info_lname;
	private JTextField info_mail;
	private JTextField info_add;
	private JTextField info_phn;
	private JTextField info_user;
	private JPanel infop;
	private JLabel info_error;
	private JLabel a_error;
	private JLabel s_error;
	private JLabel sm_error;
	private JLabel login_error;
	private JPanel user_search;
	private JPanel user_search_member;
	private JTextField a_fname;
	private JTextField a_lname;
	private JTextField a_email;
	private JTextField a_address;
	private JTextField a_phn;
	private JTextField a_role;
	private JTextField a_user;
	private JTextField s_user;
	private JTextField sm_user;
	private String loggedRole;
	private int val;
	MemberSystemQueryBuilder msqb = new MemberSystemQueryBuilder(); 
	private JTextField a_password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_Info frame = new Log_Info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log_Info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel loginp = new JPanel();
		loginp.setBackground(new Color(100, 149, 237));
		contentPane.add(loginp, "login");
		loginp.setLayout(null);
		
		
		JLabel label = new JLabel("Username");
		label.setBounds(121, 62, 71, 14);
		loginp.add(label);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(202, 59, 86, 20);
		loginp.add(username);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(121, 92, 71, 14);
		loginp.add(label_1);
		
		pass = new JPasswordField();
		pass.setBounds(202, 89, 86, 20);
		loginp.add(pass);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				@SuppressWarnings("deprecation")
				String Password = msqb.checkCred(username.getText(), pass.getText());
				if(Password.equals(pass.getText()))
				{
					String role = msqb.getRole(username.getText());
					if(role.equals("admin"))
					{
						loggedRole = "admin";
						contentPane.removeAll();
						contentPane.add(user_search, "user_search");
						contentPane.revalidate();
						user_search.repaint();
						
					}
					else
					{
						loggedRole = "member";
						contentPane.removeAll();
						contentPane.add(user_search_member, "user_search_member");
						contentPane.revalidate();
						user_search_member.repaint();
						
						//info_user.enable(false);
						/*String[] userValue = msqb.getValueDB(username.getText());
						contentPane.removeAll();
						contentPane.add(user_search_member , "user_search_member");
						info_user.setText(username.getText());
						info_fname.setText(userValue[1]);
						info_lname.setText(userValue[2]);
						info_add.setText(userValue[3]);
						info_phn.setText(userValue[4]);*/
					}
				}
				else{
					login_error.setVisible(true);
				}
					
					
				
			}
		});
		login.setBounds(180, 133, 86, 23);
		loginp.add(login);
		
		JLabel lblLogin = DefaultComponentFactory.getInstance().createTitle("Login");
		lblLogin.setBounds(10, 11, 88, 14);
		loginp.add(lblLogin);
		
		login_error = new JLabel("Invalid Username or Password");
		login_error.setBounds(148, 212, 174, 14);
		loginp.add(login_error);
		login_error.setVisible(false);
		
		/*infop = new JPanel();
		infop.setLayout(null);
		infop.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(infop, "info");
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setBounds(59, 64, 72, 14);
		infop.add(label_2);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setBounds(59, 91, 72, 14);
		infop.add(label_3);
		
		JLabel label_4 = new JLabel("Email ID");
		label_4.setBounds(59, 116, 59, 14);
		infop.add(label_4);
		
		JLabel label_5 = new JLabel("Address");
		label_5.setBounds(59, 141, 84, 14);
		infop.add(label_5);
		
		JLabel label_6 = new JLabel("Phone Number");
		label_6.setBounds(59, 166, 84, 14);
		infop.add(label_6);
		
		info_fname = new JTextField();
		info_fname.setColumns(10);
		info_fname.setBounds(169, 61, 86, 20);
		infop.add(info_fname);
		
		info_lname = new JTextField();
		info_lname.setColumns(10);
		info_lname.setBounds(169, 88, 86, 20);
		infop.add(info_lname);
		
		info_mail = new JTextField();
		info_mail.setColumns(10);
		info_mail.setBounds(169, 113, 86, 20);
		infop.add(info_mail);
		
		info_add = new JTextField();
		info_add.setColumns(10);
		info_add.setBounds(169, 138, 86, 20);
		infop.add(info_add);
		
		info_phn = new JTextField();
		info_phn.setColumns(10);
		info_phn.setBounds(169, 166, 86, 20);
		infop.add(info_phn);
		
		JButton add = new JButton("Update");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean bool = msqb.editValueDB(a_user.getText(), a_fname.getText(), a_lname.getText(),  a_address.getText(), parseInt(a_phn),a_role.getText(), a_password.getText(), a_email.getText());
				
				if(bool){
					info_error.setText("Information Edited");
				}
				else{
					info_error.setText("Error Occured");
				}
			}

			private int parseInt(JTextField a_phn) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		add.setBounds(169, 227, 89, 23);
		infop.add(add);
		
		JLabel label_8 = new JLabel("Username");
		label_8.setBounds(59, 39, 59, 14);
		infop.add(label_8);
		
		info_user = new JTextField();
		info_user.setColumns(10);
		info_user.setBounds(169, 36, 86, 20);
		infop.add(info_user);
		
		JLabel lblPersonalInformation = DefaultComponentFactory.getInstance().createTitle("Personal Information");
		lblPersonalInformation.setBounds(0, 0, 121, 14);
		infop.add(lblPersonalInformation);
		
		info_error = new JLabel("Error");
		info_error.setBounds(182, 261, 46, 14);
		infop.add(info_error);
		info_error.setVisible(false);
*/		
		
		JPanel admin = new JPanel();
		admin.setBackground(new Color(100, 149, 237));
		contentPane.add(admin, "admin");
		admin.setLayout(null);
		
		JLabel label_9 = new JLabel("First Name");
		label_9.setBounds(72, 54, 72, 14);
		admin.add(label_9);
		
		JLabel label_10 = new JLabel("Last Name");
		label_10.setBounds(72, 81, 72, 14);
		admin.add(label_10);
		
		JLabel label_11 = new JLabel("Email ID");
		label_11.setBounds(72, 106, 59, 14);
		admin.add(label_11);
		
		JLabel label_12 = new JLabel("Address");
		label_12.setBounds(72, 131, 84, 14);
		admin.add(label_12);
		
		JLabel label_13 = new JLabel("Phone Number");
		label_13.setBounds(72, 156, 84, 14);
		admin.add(label_13);
		
		JLabel label_16 = new JLabel("Role");
		label_16.setBounds(72, 207, 84, 14);
		admin.add(label_16);
		
		a_fname = new JTextField();
		a_fname.setColumns(10);
		a_fname.setBounds(166, 51, 86, 20);
		admin.add(a_fname);
		
		a_lname = new JTextField();
		a_lname.setColumns(10);
		a_lname.setBounds(166, 78, 86, 20);
		admin.add(a_lname);
		
		a_email = new JTextField();
		a_email.setColumns(10);
		a_email.setBounds(166, 103, 86, 20);
		admin.add(a_email);
		
		a_address = new JTextField();
		a_address.setColumns(10);
		a_address.setBounds(166, 128, 86, 20);
		admin.add(a_address);
		
		a_phn = new JTextField();
		a_phn.setColumns(10);
		a_phn.setBounds(166, 153, 86, 20);
		admin.add(a_phn);
		
		a_role = new JTextField();
		a_role.setColumns(10);
		a_role.setBounds(166, 204, 86, 20);
		admin.add(a_role);
		
		JButton btnUpdate = new JButton("Add User");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean bool = msqb.addValueDB(a_user.getText(), a_fname.getText(), a_lname.getText(),  a_address.getText(),Integer.parseInt(a_phn.getText()),a_role.getText(), a_password.getText(), a_email.getText());
				if(bool){
					a_error.setText("User Added");
				}
				else{
					a_error.setText("Error Occured");
				}
				
				contentPane.removeAll();				
				contentPane.add(user_search, "user_search");
				contentPane.revalidate();
				user_search.repaint();
			}

			private int parseInt(JTextField a_phn) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		btnUpdate.setBounds(61, 235, 89, 23);
		admin.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		/*if(loggedRole=="member"){
			btnDelete.setVisible(false);
		}*/
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean bool = msqb.remValueDB(a_user.getText());
				if(bool){
					a_error.setText("User Deleted");
				}
				else{
					a_error.setText("Error Occured");
				}
				
				contentPane.removeAll();				
				contentPane.add(user_search, "user_search");
				contentPane.revalidate();
				user_search.repaint();
			}
		});
		btnDelete.setBounds(297, 234, 89, 23);
		admin.add(btnDelete);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(72, 29, 72, 14);
		admin.add(lblUsername);
		
		a_user = new JTextField();
		a_user.setColumns(10);
		a_user.setBounds(166, 26, 86, 20);
		admin.add(a_user);
		
		JLabel lblAdmin = DefaultComponentFactory.getInstance().createTitle("Admin");
		lblAdmin.setBounds(10, 4, 88, 14);
		admin.add(lblAdmin);
		
		JLabel a_pass = new JLabel("Password");
		a_pass.setBounds(72, 182, 84, 14);
		admin.add(a_pass);
		
		a_password = new JTextField();
		a_password.setColumns(10);
		a_password.setBounds(166, 179, 86, 20);
		admin.add(a_password);
		
		a_error = new JLabel("a_error");
		a_error.setBounds(179, 267, 46, 14);
		admin.add(a_error);
		
		JButton a_update = new JButton("Update");
		a_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean bool = msqb.editValueDB(a_user.getText(), a_fname.getText(), a_lname.getText(),  a_address.getText(),Integer.parseInt(a_phn.getText()),a_role.getText(), a_password.getText(), a_email.getText());
				
				/*if(bool){
					info_error.setText("Information Edited");
				}
				else{
					info_error.setText("Error Occured");
				}*/
				contentPane.removeAll();
				if(loggedRole == "admin"){
					contentPane.add(user_search, "user_search");
					contentPane.revalidate();
					user_search.repaint();
				}
				else{
					contentPane.add(user_search_member, "user_search_member");
					contentPane.revalidate();
					user_search_member.repaint();
				}
				
			}

			private int parseInt(JTextField a_phn) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		a_update.setBounds(180, 234, 89, 23);
		admin.add(a_update);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String role = msqb.getRole(username.getText());
				if(loggedRole=="admin"){
					contentPane.removeAll();				
					contentPane.add(user_search, "user_search");
					contentPane.revalidate();
					user_search.repaint();
					s_error.setVisible(false);
				}
				else{
					contentPane.removeAll();				
					contentPane.add(user_search_member, "user_search_member");
					contentPane.revalidate();
					user_search_member.repaint();
					sm_error.setVisible(false);
					
				}
			}
		});
		btnBack.setBounds(314, 4, 72, 23);
		admin.add(btnBack);
		a_error.setVisible(false);
		
		
		//user search
		user_search = new JPanel();
		user_search.setBackground(new Color(100, 149, 237));
		user_search.setLayout(null);
		contentPane.add(user_search, "user_search");
				
				
		JLabel lblSearch = new JLabel("Search User");
		lblSearch.setBounds(104, 99, 87, 19);
		user_search.add(lblSearch);
		
		s_user = new JTextField();
		s_user.setBounds(248, 98, 86, 20);
		user_search.add(s_user);
		s_user.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val = 1;
				loggedRole = "admin";
				String[] userValue = msqb.getValueDB(s_user.getText());
				System.out.println(userValue[0]);
				String k = s_user.getText();
				if(userValue[0]!=null){
					if(userValue[0].equals(k)){
						contentPane.removeAll();
						contentPane.add(admin , "admin");
						contentPane.revalidate();
						admin.repaint();
						btnUpdate.setVisible(false);
						btnDelete.setVisible(true);
						a_update.setVisible(true);
						a_user.setText(userValue[0]);
						a_fname.setText(userValue[1]);
						a_lname.setText(userValue[2]);
						a_address.setText(userValue[3]);
						a_phn.setText(userValue[4]);
						a_role.setText(userValue[5]);
						a_email.setText(userValue[6]);
					}
					else{
						s_error.setVisible(true);
					}
				}
				else{
					s_error.setVisible(true);
				}				
			}
		});
		btnSearch.setBounds(104, 146, 89, 23);
		user_search.add(btnSearch);
		
		JButton btnNewButton = new JButton("Add New User");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				val = 1;
				loggedRole = "admin";
				contentPane.removeAll();
				contentPane.add(admin , "admin");
				contentPane.revalidate();
				admin.repaint();
				btnUpdate.setVisible(true);
				btnDelete.setVisible(false);
				a_update.setVisible(false);
				a_user.setText("");
				a_fname.setText("");
				a_lname.setText("");
				a_address.setText("");
				a_phn.setText("");
				a_role.setText("");
				a_email.setText("");
				a_password.setText("");
				
			}

			private int parseInt(JTextField a_phn) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		btnNewButton.setBounds(235, 146, 134, 23);
		user_search.add(btnNewButton);
		
		s_error = new JLabel("User does not exist");
		s_error.setBounds(141, 230, 113, 14);
		user_search.add(s_error);
		s_error.setVisible(false);
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(loginp , "loginp");
				contentPane.revalidate();
				loginp.repaint();
				username.setText("");
				pass.setText("");
				login_error.setVisible(false);
			}
		});
		logoutButton.setBounds(325, 29, 89, 23);
		user_search.add(logoutButton);
		
		JButton editbutton = new JButton("Edit Profile");
		editbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val = 1;
				loggedRole = "admin";
				btnDelete.setVisible(false);
				btnUpdate.setVisible(false);
				a_update.setVisible(true);
				contentPane.removeAll();
				contentPane.add(admin , "admin");
				contentPane.revalidate();
				admin.repaint();
				String[] userValue = msqb.getValueDB(username.getText());
				contentPane.removeAll();
				contentPane.add(admin , "admin");
				a_user.setText(username.getText());
				a_fname.setText(userValue[1]);
				a_lname.setText(userValue[2]);
				a_address.setText(userValue[3]);
				a_phn.setText(userValue[4]);
				a_role.setText(userValue[5]);
				a_email.setText(userValue[6]);
			}
		});
		editbutton.setBounds(165, 194, 106, 23);
		user_search.add(editbutton);
		
		//user search ends
		
	   user_search_member = new JPanel();
	   user_search_member.setBackground(new Color(100, 149, 237));
		user_search_member.setLayout(null);
		contentPane.add(user_search_member, "user_search_member");
		
		JLabel labelSearch = new JLabel("Search User");
		labelSearch.setBounds(104, 99, 87, 19);
		user_search_member.add(labelSearch);
		
		sm_user = new JTextField();
		sm_user.setBounds(228, 98, 86, 20);
		user_search_member.add(sm_user);
		sm_user.setColumns(10);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val = 0;
				loggedRole = "member";
				String[] userValue = msqb.getValueDB(sm_user.getText());
				System.out.println(userValue[0]);
				String k = sm_user.getText();
				if(userValue[0]!=null){
					if(userValue[0].equals(k)){
						btnDelete.setVisible(false);
						btnUpdate.setVisible(false);
						a_update.setVisible(false);
						contentPane.removeAll();
						contentPane.add(admin , "admin");
						contentPane.revalidate();
						admin.repaint();
						//String[] userValue = msqb.getValueDB(s_user.getText());
						//contentPane.removeAll();
						//contentPane.add(admin , "admin");
						a_user.setText(userValue[0]);
						a_fname.setText(userValue[1]);
						a_lname.setText(userValue[2]);
						a_address.setText(userValue[3]);
						a_phn.setText(userValue[4]);
						a_role.setText(userValue[5]);
						a_email.setText(userValue[6]);
					}
					else{
						sm_error.setVisible(true);
					}
				}
				else{
					sm_error.setVisible(true);
				}				
			}
		});
		buttonSearch.setBounds(102, 146, 89, 23);
		user_search_member.add(buttonSearch);
		

		
		sm_error = new JLabel("User does not exist");
		sm_error.setBounds(135, 230, 166, 14);
		user_search_member.add(sm_error);
		sm_error.setVisible(false);
		
		JLabel label_search = new JLabel("Search User");
		label_search.setBounds(104, 99, 68, 19);
		user_search_member.add(label_search);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val = 1;
				loggedRole = "member";
				btnDelete.setVisible(false);
				btnUpdate.setVisible(false);
				a_update.setVisible(true);
				contentPane.removeAll();
				contentPane.add(admin , "admin");
				contentPane.revalidate();
				admin.repaint();
				String[] userValue = msqb.getValueDB(username.getText());
				contentPane.removeAll();
				contentPane.add(admin , "admin");
				a_user.setText(username.getText());
				a_fname.setText(userValue[1]);
				a_lname.setText(userValue[2]);
				a_address.setText(userValue[3]);
				a_phn.setText(userValue[4]);
				a_role.setText(userValue[5]);
				a_email.setText(userValue[6]);
			}
		});
		btnEditProfile.setBounds(228, 146, 106, 23);
		user_search_member.add(btnEditProfile);
		
		JButton lgotButton = new JButton("Log Out");
		lgotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(loginp , "loginp");
				contentPane.revalidate();
				loginp.repaint();
				username.setText("");
				pass.setText("");
				login_error.setVisible(false);
			}
		});
		lgotButton.setBounds(325, 27, 89, 23);
		user_search_member.add(lgotButton);

	}
}
