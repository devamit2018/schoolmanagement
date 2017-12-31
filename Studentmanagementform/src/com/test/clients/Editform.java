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
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class Editform extends JFrame {

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
	private JLabel lblphoto;
	private JButton btnNewButton;
	private JLabel lblPhoto;
	private JButton btnUpdate;
	private JButton btnBack;
	private int uid = 0;
	private File file;

	/**
	 * Launch the application.
	 */
	private byte[] ConvertFile(String filename)
	{
	FileInputStream fi = null;
	File file = new File(filename);
	byte[] bfile = new byte[(int) file.length()];

	try
	{

	fi = new FileInputStream(file);
	fi.read(bfile);
	fi.close();
	}

	catch(Exception e)
	{
	bfile = null;
	}
	return bfile;
	}
	

	/**
	 * Create the frame.
	 */
	public Editform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 393);
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
		contentPane.add(getLblphoto());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblPhoto());
		contentPane.add(getBtnUpdate());
		contentPane.add(getBtnBack());
		setVisible(true);
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblName.setBounds(10, 26, 46, 14);
		}
		return lblName;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setBounds(90, 24, 86, 20);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddress.setBounds(10, 64, 58, 14);
		}
		return lblAddress;
	}
	private JTextField getAdtxt() {
		if (adtxt == null) {
			adtxt = new JTextField();
			adtxt.setColumns(10);
			adtxt.setBounds(90, 62, 86, 20);
		}
		return adtxt;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPhone.setBounds(10, 105, 58, 14);
		}
		return lblPhone;
	}
	private JTextField getPhntxt() {
		if (phntxt == null) {
			phntxt = new JTextField();
			phntxt.setColumns(10);
			phntxt.setBounds(90, 103, 86, 20);
		}
		return phntxt;
	}
	private JLabel getLblSex() {
		if (lblSex == null) {
			lblSex = new JLabel("Sex");
			lblSex.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblSex.setBounds(10, 149, 58, 14);
		}
		return lblSex;
	}
	private JTextField getSextxt() {
		if (sextxt == null) {
			sextxt = new JTextField();
			sextxt.setColumns(10);
			sextxt.setBounds(90, 147, 86, 20);
		}
		return sextxt;
	}
	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblFaculty.setBounds(10, 198, 58, 14);
		}
		return lblFaculty;
	}
	private JTextField getFactxt() {
		if (factxt == null) {
			factxt = new JTextField();
			factxt.setColumns(10);
			factxt.setBounds(90, 196, 86, 20);
		}
		return factxt;
	}
	private JLabel getLblDob() {
		if (lblDob == null) {
			lblDob = new JLabel("DOB");
			lblDob.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDob.setBounds(10, 251, 58, 14);
		}
		return lblDob;
	}
	private JTextField getDobtxt() {
		if (dobtxt == null) {
			dobtxt = new JTextField();
			dobtxt.setColumns(10);
			dobtxt.setBounds(90, 249, 86, 20);
		}
		return dobtxt;
	}
	private JLabel getLblphoto() {
		if (lblphoto == null) {
			lblphoto = new JLabel("New label");
			lblphoto.setBounds(226, 26, 105, 105);
		}
		return lblphoto;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Browse");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					JFileChooser jfile = new JFileChooser();
					jfile.setDialogTitle("please select photo");
					jfile.setFileFilter(new Filter(".jpg", "JPG")) ;
					jfile.setFileFilter(new Filter(".gif", "GIF")) ;
					jfile.setFileFilter(new Filter(".png", "PNG")) ;
					
					jfile.setMultiSelectionEnabled(false);
					
					int result = jfile.showOpenDialog(null);
					
					if(result == JFileChooser.APPROVE_OPTION)
					{
						file = jfile.getSelectedFile();
					lblphoto.setIcon(new ImageIcon(file.getAbsolutePath()));
					}
					
					
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBounds(236, 145, 89, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("Photo");
			lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPhoto.setBounds(261, 179, 46, 14);
		}
		return lblPhoto;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

					Student s = new Student();
				s.setID(uid);
				s.setName(namtxt.getText());
				s.setAddress(adtxt.getText());
				s.setPhone(phntxt.getText());
				s.setSex(sextxt.getText());
				s.setFaculty(factxt.getText());
				s.setDOB(dobtxt.getText());
				s.setPhoto(ConvertFile(file.getAbsolutePath()));
				
				Studentservices ss = new Studentservicesimpl();
				
				if(ss.updateStudent(s))
				{
					JOptionPane.showMessageDialog(null, "updated successfully");
					new Signupform();
					dispose();
				}
					
				else
				{
					JOptionPane.showMessageDialog(null, "error in updating");
				}
					
					
					
				}
			});
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnUpdate.setBounds(178, 294, 89, 23);
		}
		return btnUpdate;
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
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBack.setBounds(0, 296, 89, 23);
		}
		return btnBack;
	}
	
	
	public void displaydata(int id)

	{
		uid = id;
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
	
}
