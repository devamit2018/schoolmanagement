package com.test.clients;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Student;
import com.test.services.Studentservices;
import com.test.services.Studentservicesimpl;

import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewform extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField namtxt;
	private JLabel lblAddress;
	private JTextField adtxt;
	private JLabel lblPhone;
	private JTextField phntxt;
	private JLabel lblSex;
	private JTextField sextxt;
	private JLabel lblFaculty;
	private JTextField factxt;
	private JLabel lblDob;
	private JTextField dobtxt;
	private JLabel phototxt;
	private JButton btnBack;
	private JLabel lblphoto;
	

public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewform frame = new Viewform();
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
	public Viewform() {
		setTitle("Viewform");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getNamtxt());
		contentPane.add(getLblAddress());
		contentPane.add(getAdtxt());
		contentPane.add(getLblPhone());
		contentPane.add(getPhntxt());
		contentPane.add(getLblSex());
		contentPane.add(getSextxt());
		contentPane.add(getLblFaculty());
		contentPane.add(getFactxt());
		contentPane.add(getLblDob());
		contentPane.add(getDobtxt());
		contentPane.add(getPhototxt());
		contentPane.add(getBtnBack());
		contentPane.add(getLblphoto());
		setVisible(true);
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblName.setBounds(10, 28, 46, 14);
		}
		return lblName;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setEditable(false);
			namtxt.setBounds(92, 22, 86, 20);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddress.setBounds(10, 65, 59, 14);
		}
		return lblAddress;
	}
	private JTextField getAdtxt() {
		if (adtxt == null) {
			adtxt = new JTextField();
			adtxt.setEditable(false);
			adtxt.setColumns(10);
			adtxt.setBounds(92, 63, 86, 20);
		}
		return adtxt;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPhone.setBounds(10, 96, 46, 14);
		}
		return lblPhone;
	}
	private JTextField getPhntxt() {
		if (phntxt == null) {
			phntxt = new JTextField();
			phntxt.setEditable(false);
			phntxt.setColumns(10);
			phntxt.setBounds(92, 94, 86, 20);
		}
		return phntxt;
	}
	private JLabel getLblSex() {
		if (lblSex == null) {
			lblSex = new JLabel("Sex");
			lblSex.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblSex.setBounds(10, 138, 46, 14);
		}
		return lblSex;
	}
	private JTextField getSextxt() {
		if (sextxt == null) {
			sextxt = new JTextField();
			sextxt.setEditable(false);
			sextxt.setColumns(10);
			sextxt.setBounds(92, 136, 86, 20);
		}
		return sextxt;
	}
	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblFaculty.setBounds(10, 181, 46, 14);
		}
		return lblFaculty;
	}
	private JTextField getFactxt() {
		if (factxt == null) {
			factxt = new JTextField();
			factxt.setEditable(false);
			factxt.setColumns(10);
			factxt.setBounds(92, 179, 86, 20);
		}
		return factxt;
	}
	private JLabel getLblDob() {
		if (lblDob == null) {
			lblDob = new JLabel("DOB");
			lblDob.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDob.setBounds(10, 224, 46, 14);
		}
		return lblDob;
	}
	private JTextField getDobtxt() {
		if (dobtxt == null) {
			dobtxt = new JTextField();
			dobtxt.setEditable(false);
			dobtxt.setColumns(10);
			dobtxt.setBounds(92, 222, 86, 20);
		}
		return dobtxt;
	}
	private JLabel getPhototxt() {
		if (phototxt == null) {
			phototxt = new JLabel("Photo");
			phototxt.setFont(new Font("Tahoma", Font.BOLD, 12));
			phototxt.setBounds(232, 294, 46, 14);
		}
		return phototxt;
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
			btnBack.setBounds(10, 290, 89, 23);
		}
		return btnBack;
	}
	
	public void displaydata(int id)
	{
		
	Studentservices ss = new Studentservicesimpl();
	
	Student s = ss.getbyid(id);
	lblphoto.setIcon(new ImageIcon(s.getPhoto()));
namtxt.setText(s.getName());
	adtxt.setText(s.getAddress());
	phntxt.setText(s.getPhone());
	sextxt.setText(s.getSex());
	factxt.setText(s.getFaculty());
	dobtxt.setText(s.getDOB());
	

	
	
	}
	private JLabel getLblphoto() {
		if (lblphoto == null) {
			lblphoto = new JLabel("");
			lblphoto.setBounds(202, 181, 100, 100);
		}
		return lblphoto;
	}
}
