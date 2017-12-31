package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Student;
import com.test.services.Studentservices;
import com.test.services.Studentservicesimpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Searchform extends JFrame {

	private JPanel contentPane;
	private JLabel lblId;
	private JTextField idtxt;
	private JLabel lblName;
	private JTextField namtxt;
	private JLabel lblphoto;
	private JButton btnSearch;
	private JButton btnBack;
	private int uid = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchform frame = new Searchform();
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
	public Searchform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblId());
		contentPane.add(getIdtxt());
		contentPane.add(getLblName());
		contentPane.add(getNamtxt());
		contentPane.add(getLblphoto());
		contentPane.add(getBtnSearch());
		contentPane.add(getBtnBack());
	setVisible(true);
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblId.setBounds(20, 11, 35, 14);
		}
		return lblId;
	}
	private JTextField getIdtxt() {
		if (idtxt == null) {
			idtxt = new JTextField();
			idtxt.setBounds(70, 9, 86, 20);
			idtxt.setColumns(10);
		}
		return idtxt;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblName.setBounds(20, 56, 35, 14);
		}
		return lblName;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setBounds(70, 54, 86, 20);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblphoto() {
		if (lblphoto == null) {
			lblphoto = new JLabel("New label");
			lblphoto.setBounds(218, 11, 100, 100);
		}
		return lblphoto;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						
						Studentservices ss = new Studentservicesimpl();
						Student s = ss.getbyid(Integer.parseInt(idtxt.getText()));
					
						
						
						if(s==null)
						{
							JOptionPane.showMessageDialog(null, "cant enter");
						}
						else
						{
							namtxt.setText(s.getName());
							lblphoto.setIcon(new ImageIcon(s.getPhoto()));
						}
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, "no photo");
						}
						
					
					
					
					
					
				}
			});
			btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSearch.setBounds(119, 100, 89, 23);
		}
		return btnSearch;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Signupform();
					dispose();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBack.setBounds(0, 160, 89, 23);
		}
		return btnBack;
	}
	
	
	public void displaydata(int id)
	{
		
		uid =id;
		Studentservices ss = new Studentservicesimpl();
		Student s= ss.getbyid(id);
		namtxt.setText(s.getName());
	
	
	
	
	
}	
}
