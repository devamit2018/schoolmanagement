package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.test.database.DBconnection;
import com.test.models.Student;
import com.test.services.Studentservices;
import com.test.services.Studentservicesimpl;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Signupform extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel namelbl;
	private JTextField namtxt;
	private JLabel lblAddress;
	private JTextField adtxt;
	private JLabel lblPhone;
	private JTextField phntxt;
	private JPanel panel_1;
	private JRadioButton malrbt;
	private JRadioButton femrbt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblFaculty;
	private JComboBox faccmb;
	private JLabel lblDateOfBirth;
	private JComboBox yearcmb;
	private JComboBox moncmb;
	private JComboBox daycmb;
	private JLabel lblphoto;
	private JLabel lblPhoto;
	private JButton browsebtn;
	private JButton btnSave;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnView;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnBack;
	private JButton btnSearch;
	private File file;
	private JLabel lblNewLabel;
	private JButton btnNew;
	private JTextField searchtxt;
	

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
	
	Connection con = null;
	private JComboBox cmbselectsearch;
	
	

	/**
	 * Create the frame.
	 */
	public Signupform() {
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setTitle("Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnView());
		contentPane.add(getBtnEdit());
		contentPane.add(getBtnDelete());
		contentPane.add(getBtnBack());
		contentPane.add(getBtnSearch());
		contentPane.add(getBtnNew());
		contentPane.add(getSearchtxt());
		contentPane.add(getCmbselectsearch());
		Populatedata();
		setVisible(true);
		
		con= DBconnection.getdbconnnection();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "input", TitledBorder.LEFT, TitledBorder.TOP, null, null));
			panel.setBounds(0, 0, 815, 169);
			panel.setLayout(null);
			panel.add(getNamelbl());
			panel.add(getNamtxt());
			panel.add(getLblAddress());
			panel.add(getAdtxt());
			panel.add(getLblPhone());
			panel.add(getPhntxt());
			panel.add(getPanel_1());
			panel.add(getLblFaculty());
			panel.add(getFaccmb());
			panel.add(getLblDateOfBirth());
			panel.add(getYearcmb());
			panel.add(getMoncmb());
			panel.add(getDaycmb());
			panel.add(getLblphoto());
			panel.add(getLblPhoto());
			panel.add(getBrowsebtn());
			panel.add(getBtnSave());
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLabel getNamelbl() {
		if (namelbl == null) {
			namelbl = new JLabel("Name");
			namelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
			namelbl.setBounds(10, 22, 46, 14);
		}
		return namelbl;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setBounds(66, 20, 106, 20);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddress.setBounds(182, 24, 62, 14);
		}
		return lblAddress;
	}
	private JTextField getAdtxt() {
		if (adtxt == null) {
			adtxt = new JTextField();
			adtxt.setColumns(10);
			adtxt.setBounds(254, 20, 106, 20);
		}
		return adtxt;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPhone.setBounds(375, 24, 46, 14);
		}
		return lblPhone;
	}
	private JTextField getPhntxt() {
		if (phntxt == null) {
			phntxt = new JTextField();
			phntxt.setColumns(10);
			phntxt.setBounds(431, 22, 106, 20);
		}
		return phntxt;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "sex", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 64, 162, 50);
			panel_1.setLayout(null);
			panel_1.add(getMalrbt());
			panel_1.add(getFemrbt());
		}
		return panel_1;
	}
	private JRadioButton getMalrbt() {
		if (malrbt == null) {
			malrbt = new JRadioButton("Male");
			buttonGroup.add(malrbt);
			malrbt.setFont(new Font("Tahoma", Font.BOLD, 12));
			malrbt.setBounds(6, 20, 63, 23);
		}
		return malrbt;
	}
	private JRadioButton getFemrbt() {
		if (femrbt == null) {
			femrbt = new JRadioButton("Female");
			buttonGroup.add(femrbt);
			femrbt.setFont(new Font("Tahoma", Font.BOLD, 12));
			femrbt.setBounds(78, 21, 78, 23);
		}
		return femrbt;
	}
	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblFaculty.setBounds(182, 89, 62, 14);
		}
		return lblFaculty;
	}
	private JComboBox getFaccmb() {
		if (faccmb == null) {
			faccmb = new JComboBox();
			faccmb.setFont(new Font("Tahoma", Font.BOLD, 12));
			faccmb.setModel(new DefaultComboBoxModel(new String[] {"Select","Science", "Arts", "Medical", "Law", "Education"}));
			faccmb.setBounds(251, 87, 106, 20);
		}
		return faccmb;
	}
	private JLabel getLblDateOfBirth() {
		if (lblDateOfBirth == null) {
			lblDateOfBirth = new JLabel("Date of birth");
			lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDateOfBirth.setBounds(375, 90, 86, 14);
		}
		return lblDateOfBirth;
	}
	private JComboBox getYearcmb() {
		if (yearcmb == null) {
			yearcmb = new JComboBox();
			yearcmb.setModel(new DefaultComboBoxModel(new String[] {"Year"}));
			for (int i = 1970; i <= 2018; i++) {
				yearcmb.addItem(i);
			}
			yearcmb.setFont(new Font("Tahoma", Font.BOLD, 12));
			yearcmb.setBounds(469, 64, 68, 20);
		}
		return yearcmb;
	}
	private JComboBox getMoncmb() {
		if (moncmb == null) {
			moncmb = new JComboBox();
			moncmb.setFont(new Font("Tahoma", Font.BOLD, 12));
			moncmb.setModel(new DefaultComboBoxModel(new String[] {"Month"}));
			for (int i = 1; i <= 12; i++) {
				moncmb.addItem(i);
			}
			moncmb.setBounds(469, 87, 68, 20);
		}
		return moncmb;
	}
	private JComboBox getDaycmb() {
		if (daycmb == null) {
			daycmb = new JComboBox();
			daycmb.setModel(new DefaultComboBoxModel(new String[] {"Day"}));
			for (int i = 1; i <= 32; i++) {
				daycmb.addItem(i);
			}
			daycmb.setFont(new Font("Tahoma", Font.BOLD, 12));
			daycmb.setBounds(469, 110, 68, 20);
		}
		return daycmb;
	}
	private JLabel getLblphoto() {
		if (lblphoto == null) {
			lblphoto = new JLabel("");
			lblphoto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblphoto.setBounds(705, 11, 100, 100);
		}
		return lblphoto;
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("Photo");
			lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPhoto.setBounds(547, 89, 55, 14);
		}
		return lblPhoto;
	}
	private JButton getBrowsebtn() {
		if (browsebtn == null) {
			browsebtn = new JButton("Browse");
			browsebtn.addActionListener(new ActionListener() {
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
			browsebtn.setFont(new Font("Tahoma", Font.BOLD, 12));
			browsebtn.setBounds(606, 85, 89, 23);
		}
		return browsebtn;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Student s =new Student();
				s.setName(namtxt.getText());
				s.setAddress(adtxt.getText());
				s.setPhone(phntxt.getText());
				if(malrbt.isSelected())
				{
					s.setSex("Male");
				}
				else
				{
					s.setSex("Female");
				}
					
				
				s.setFaculty(faccmb.getSelectedItem().toString());
				
				String Year = yearcmb.getSelectedItem().toString();
				String Month = moncmb.getSelectedItem().toString();
				String Day = daycmb.getSelectedItem().toString();
				
				String DOB =Year.concat("-").concat(Month).concat("-").concat(Day).concat("-");
				s.setDOB(DOB);
				
				s.setPhoto(ConvertFile(file.getAbsolutePath()));
				
				Studentservices ss = new Studentservicesimpl();
			boolean result =	ss.addstudent(s);
			
			if(result == true)
			{
				JOptionPane.showMessageDialog(null, "Inserted successfully");
				Populatedata();
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "signup error");
			}
			
			namtxt.setText("");
			adtxt.setText("");
			phntxt.setText("");
			buttonGroup.clearSelection();
		faccmb.setSelectedIndex(0);
		
		yearcmb.setSelectedIndex(0);
	moncmb.setSelectedIndex(0);
		daycmb.setSelectedIndex(0);
		lblphoto.setIcon(null);
		
		Component[] compList = panel.getComponents();

		for (Component c : compList) {
			c.setEnabled(false);
		}
malrbt.setEnabled(false);
		femrbt.setEnabled(false);
		
		
				
				}
			});
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSave.setBounds(715, 128, 89, 23);
		}
		return btnSave;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 208, 815, 189);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBackground(new Color(124, 252, 0));
			table.setFont(new Font("Tahoma", Font.BOLD, 12));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "Name", "Address", "Phone", "Sex", "Faculty", "DOB"
				}
			));
		}
		return table;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("View");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null,
								"please, select any row!!");
						return;
					}

					int row = table.getSelectedRow();
					int id= (int) table.getModel().getValueAt(row, 0);
					
					
					
					new Viewform().displaydata(id);
					dispose();
				}
			});
			btnView.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnView.setBounds(10, 408, 89, 23);
		}
		return btnView;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("Edit");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null,
								"please, select any row!!");
						return;
					}

					int row = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(row, 0);

					new Editform().displaydata(id);
					dispose();
					
					
					
				}
			});
			btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEdit.setBounds(103, 408, 89, 23);
		}
		return btnEdit;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null,
								"Please select any row!!");
						return;
					}

					int row = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(row, 0);
					Studentservices ss = new Studentservicesimpl();
					boolean result = ss.deletestudent(id);

					if (result == true) {
						JOptionPane.showMessageDialog(null,
								"deleted successfully!!");
						Populatedata();
					}
				}
			});
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnDelete.setBounds(202, 408, 89, 23);
		}
		return btnDelete;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Loginform();
					dispose();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBack.setBounds(301, 408, 89, 23);
		}
		return btnBack;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Exit");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSearch.setBounds(716, 408, 89, 23);
		}
		return btnSearch;
	}
	
	
	private void Populatedata()
	{
		Studentservices ss = new Studentservicesimpl();
		List<Student> sList = ss.getstudents();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Student s : sList) {
			model.addRow(new Object[] { s.getID(),s.getName(),s.getAddress(),s.getPhone(),s.getSex(),s.getFaculty(),s.getDOB()
					 });
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DEV\\Downloads\\Compressed\\background-images\\background-imager\\Elegant_Background-15.jpg"));
			lblNewLabel.setBounds(10, 11, 795, 147);
		}
		return lblNewLabel;
	}
	private JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton("New");
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Component[] compList = panel.getComponents();
					for (Component c : compList) {
						c.setEnabled(true);
					}

					malrbt.setEnabled(true);
					femrbt.setEnabled(true);
					
				}
			});
			btnNew.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNew.setBounds(417, 409, 89, 23);
		}
		return btnNew;
	}
	private JTextField getSearchtxt() {
		if (searchtxt == null) {
			searchtxt = new JTextField();
			searchtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e)
				{
					
					
					try {
						
						String selection = (String) cmbselectsearch.getSelectedItem();
						
						String sql= "select * from school where "+selection+" =?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, searchtxt.getText());
						
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
					
				}
			});
			searchtxt.setBounds(689, 177, 126, 20);
			searchtxt.setColumns(10);
		}
		return searchtxt;
	}
	private JComboBox getCmbselectsearch() {
		if (cmbselectsearch == null) {
			cmbselectsearch = new JComboBox();
			cmbselectsearch.setModel(new DefaultComboBoxModel(new String[] {"Select", "id", "Name", "Sex", "Faculty"}));
			cmbselectsearch.setFont(new Font("Tahoma", Font.BOLD, 12));
			cmbselectsearch.setBounds(572, 177, 112, 20);
		}
		return cmbselectsearch;
	}
	}
	
	
	
	

