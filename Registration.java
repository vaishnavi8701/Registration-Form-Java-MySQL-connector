package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JToggleButton;
import java.sql.*;

public class registration extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField age;
	private JTextField address;
	private JTextField email;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
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
	public registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		user = new JTextField();
		user.setBounds(221, 100, 211, 37);
		contentPane.add(user);
		user.setColumns(10);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(221, 195, 211, 37);
		contentPane.add(age);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(221, 242, 211, 37);
		contentPane.add(address);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(149, 104, 184, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(149, 151, 184, 27);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(149, 246, 184, 27);
		contentPane.add(lblNewLabel_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Submit");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					PreparedStatement ps=conn.prepareStatement("insert into user(user_name,user_email,user_age,user_address,user_contact)values(?,?,?,?,?);");
					ps.setString(1, user.getText());
					ps.setString(2, email.getText());
					ps.setString(3, age.getText());
					ps.setString(4, address.getText());
					ps.setString(5, contact.getText());
					int x=ps.executeUpdate();
					if(x>0) {
						System.out.println("Registration Successful");
					}
					else {
						System.out.println("Registration failed..");
					}
							
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}

			
		});
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		tglbtnNewToggleButton.setBounds(232, 349, 127, 27);
		contentPane.add(tglbtnNewToggleButton);
		
		email = new JTextField();
		email.setBounds(221, 147, 211, 38);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(149, 199, 184, 27);
		contentPane.add(lblNewLabel_1_1);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(221, 289, 211, 37);
		contentPane.add(contact);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact No");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(149, 289, 184, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblRegistrationForm = new JLabel("REGISTRATION FORM");
		lblRegistrationForm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistrationForm.setBounds(221, 39, 211, 27);
		contentPane.add(lblRegistrationForm);
	}
}
