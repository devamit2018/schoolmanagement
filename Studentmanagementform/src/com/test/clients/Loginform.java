package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginform extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblUsername;
	private JTextField usertxt;
	private JLabel lblPassword;
	private JPasswordField passtxt;
	private JButton btnLogin;
	private JButton btnAreYouA;
	private JButton loginbtn;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginform frame = new Loginform();
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
	public Loginform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogin());
		contentPane.add(getLblUsername());
		contentPane.add(getUsertxt());
		contentPane.add(getLblPassword());
		contentPane.add(getPasstxt());
		//contentPane.add(getBtnLogin());
		contentPane.add(getBtnAreYouA());
		contentPane.add(getLoginbtn());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login");
			lblLogin.setFont(new Font("Algerian", Font.BOLD, 16));
			lblLogin.setBounds(110, 21, 81, 22);
		}
		return lblLogin;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsername.setBounds(39, 82, 65, 14);
		}
		return lblUsername;
	}
	private JTextField getUsertxt() {
		if (usertxt == null) {
			usertxt = new JTextField();
			usertxt.setBounds(123, 80, 106, 20);
			usertxt.setColumns(10);
		}
		return usertxt;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(39, 135, 65, 14);
		}
		return lblPassword;
	}
	private JPasswordField getPasstxt() {
		if (passtxt == null) {
			passtxt = new JPasswordField();
			passtxt.setBounds(123, 133, 106, 20);
		}
		return passtxt;
	}
	
		private JButton getBtnAreYouA() {
		if (btnAreYouA == null) {
			btnAreYouA = new JButton("Are you a new user?create an account");
			btnAreYouA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Signupform();
					dispose();
					
				}
			});
			btnAreYouA.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAreYouA.setBounds(10, 224, 271, 23);
		}
		return btnAreYouA;
	}
	private JButton getLoginbtn() {
		if (loginbtn == null) {
			loginbtn = new JButton("Login");
			loginbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					String username= usertxt.getText();
					String password =passtxt.getText();
					
					if(username.equals("admin") && password.equals("admin"))
					{
						JOptionPane.showMessageDialog(null, "login success");
						new Collegeform();
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "enter login details");
					}
					
				}
			});
			loginbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
			loginbtn.setIcon(null);
			loginbtn.setBounds(140, 175, 81, 22);
		}
		return loginbtn;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DEV\\Desktop\\abstract_smooth_wave_background_vector_grapihic_art_569579.jpg"));
			lblNewLabel.setBounds(0, 0, 288, 294);
		}
		return lblNewLabel;
	}
}
