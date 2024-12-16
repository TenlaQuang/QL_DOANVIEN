import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class fix extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableM;
	private JMenuBar menuBar;
	private JMenu mnN;
	private JMenuItem mnt;
	private JMenuItem mntc;
	private JMenu mncs;
	private JMenuItem mnx;
	private JMenuItem mns;
	private JMenuItem mnrf;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				try {			
					fix frame = new fix();
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

	public void reset() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		
	}	
	private void showdulieu() {
		try {
			tableM.removeAll();
			String[] arr= {"Tên", "Chức vụ đoàn", "Ngày vào đoàn","Số điện thoại","cccd","Ngày sinh","Giới tính"};
			DefaultTableModel mode = new DefaultTableModel(arr, 0);
			String query="SELECT * FROM dbo.[DV]";
			Connection connection= Ketnoicsdl.KetNoiCSDL();
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector vector= new Vector();
				vector.add(rs.getString("Ten"));
				vector.add(rs.getString("CVD"));
				vector.add(rs.getString("NVD"));
				vector.add(rs.getString("SDT"));
				vector.add(rs.getString("CCCD"));
				vector.add(rs.getString("NS"));
				vector.add(rs.getString("GT"));
				mode.addRow(vector);
			}
			tableM.setModel(mode);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public fix() {
		setResizable(false);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showdulieu();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 70, 1130, 630);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GIGABYTE\\Downloads\\unnamed.png"));
		
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		mnN = new JMenu("tools");
		mnN.setHorizontalAlignment(SwingConstants.CENTER);
		mnN.setBackground(new Color(217, 217, 255));
		mnN.setForeground(new Color(0, 0, 0));
		mnN.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\2473944-200.png"));
        mnN.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mnN.setBorder(BorderFactory.createCompoundBorder());
				mnN.setSelected(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mnN.setBorder(BorderFactory.createEtchedBorder());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menuBar.add(mnN);
		
		mnt = new JMenuItem("Thêm");
		mnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Qldv frame = new Qldv();
							frame.setVisible(true);
							fix.this.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		mnN.add(mnt);
		
		mncs = new JMenu("Chỉnh sửa");
		mnN.add(mncs);
		
		mnx = new JMenuItem("Xóa");
		mnx.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent e) {
		        String cccd = JOptionPane.showInputDialog("Nhập CCCD người muốn xóa");

		        try {
		            String checkQuery = "SELECT COUNT(*) FROM dbo.[DV] WHERE CCCD=?";
		            Connection connection = Ketnoicsdl.KetNoiCSDL();
		            PreparedStatement checkPs = connection.prepareStatement(checkQuery);
		            checkPs.setString(1, cccd);
		            ResultSet checkResult = checkPs.executeQuery();
		            checkResult.next();
		            int count = checkResult.getInt(1);

		            if (count > 0) {
		                int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc không?");
		                if (result == 0) {
		                    String deleteQuery = "DELETE FROM dbo.[DV] WHERE CCCD=?";
		                    PreparedStatement deletePs = connection.prepareStatement(deleteQuery);
		                    deletePs.setString(1, cccd);
		                    deletePs.executeUpdate();
		                    JOptionPane.showMessageDialog(null, "Xóa thành công");
		                }
		            } else {

		                JOptionPane.showMessageDialog(null, "CCCD không tồn tại");
		            }

		        } catch (Exception e1) {

		        }
		    }
		});
		mncs.add(mnx);
		
		mns = new JMenuItem("Sửa");
		mncs.add(mns);
		
		mntc = new JMenuItem("< Trang chủ");
		mntc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							tieusu frame = new tieusu();
							frame.setVisible(true);
							fix.this.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		mnrf = new JMenuItem("Refresh");
		mnrf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {			
						try {			
							DLieu frame = new DLieu();
							frame.setVisible(true);
							fix.this.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnN.add(mnrf);
		mnN.add(mntc);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 627, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 617, 593);
		panel.add(scrollPane);
		
		tableM = new JTable();
		scrollPane.setViewportView(tableM);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên (*)");
		lblNewLabel_1_1.setBounds(637, 20, 71, 13);
		contentPane.add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		t1.setColumns(10);
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setBounds(637, 43, 466, 27);
		contentPane.add(t1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Chức vụ trong đoàn");
		lblNewLabel_2_1.setBounds(637, 80, 133, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JComboBox dv = new JComboBox();
		dv.setModel(new DefaultComboBoxModel(new String[] {"Đoàn viên", "Bí thư chi đoàn", "Phó bí thư chi đoàn", "UV Ban Chấp hành chi đoàn", "Bí thư chi đoàn cơ sở", "Phó bí thư chi đoàn cơ sở", "UV Ban Chấp hành chi đoàn cơ sở", "UV Ban Thường vụ chi đoàn cơ sở", "Bí thư thứ nhất", "Bí thư thường trực", "Bí thư Đoàn khối", "Bí thư Huyện đoàn", "Bí thư Đoàn cơ sở", "Bí thư Liên chi đoàn", "Bí thư Đoàn giao quyền cấp trên cơ sở", "Bí thư Đoàn bộ phận", "Phó Bí thư Tỉnh đoàn", "Phó Bí thư Huyện đoàn", "Phó Bí thư Đoàn cơ sở", "Phó Bí thư Liên chi đoàn", "Phó Bí thư Đoàn giao quyền cấp trên cơ sở", "Phó Bí thư Đoàn bộ phận", "UV Ban Chấp hành", "UV Ban Thường vụ", "UV Ủy ban Kiểm tra", "Chủ nhiêm Ủy ban Kiểm tra", "Phó chủ nhiêm Ủy ban Kiểm tra", "cán bộ đoàn chuyên trách"}));
		dv.setMaximumRowCount(5);
		dv.setBackground(Color.LIGHT_GRAY);
		dv.setBounds(637, 103, 349, 27);
		contentPane.add(dv);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ngày vào đoàn");
		lblNewLabel_3_1.setBounds(637, 140, 104, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("ex: 01/01/2024");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setBounds(747, 140, 123, 13);
		contentPane.add(lblNewLabel_4);
		
		t2 = new JTextField();
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t2.setColumns(10);
		t2.setBackground(Color.LIGHT_GRAY);
		t2.setBounds(637, 163, 466, 27);
		contentPane.add(t2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Số điện thoại");
		lblNewLabel_4_1.setBounds(637, 197, 104, 13);
		contentPane.add(lblNewLabel_4_1);
		
		t3 = new JTextField();
		t3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t3.setColumns(10);
		t3.setBackground(Color.LIGHT_GRAY);
		t3.setBounds(637, 220, 466, 27);
		contentPane.add(t3);
		
		JLabel lblNewLabel_5_1 = new JLabel("CCCD/CMND");
		lblNewLabel_5_1.setBounds(637, 257, 102, 13);
		contentPane.add(lblNewLabel_5_1);
		
		t4 = new JTextField();
		t4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t4.setColumns(10);
		t4.setBackground(Color.LIGHT_GRAY);
		t4.setBounds(637, 280, 466, 27);
		contentPane.add(t4);
		
		JLabel lblNewLabel_6_1 = new JLabel("Ngày sinh");
		lblNewLabel_6_1.setBounds(637, 317, 57, 13);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(700, 317, 45, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4_2 = new JLabel("ex: 01/01/2000");
		lblNewLabel_4_2.setForeground(Color.GRAY);
		lblNewLabel_4_2.setBounds(751, 317, 123, 13);
		contentPane.add(lblNewLabel_4_2);
		
		t5 = new JTextField();
		t5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t5.setColumns(10);
		t5.setBackground(Color.LIGHT_GRAY);
		t5.setBounds(637, 343, 466, 27);
		contentPane.add(t5);
		
		JButton btnu = new JButton("UPDATE");
		btnu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = tableM.getSelectedRow();				 
				String data= tableM.getModel().getValueAt(position, 4).toString();		
				System.out.println(data);
				if(t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền tên");
					t1.requestFocus();
					return;
				}else if(t2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền ngày vào đoàn");
					t2.requestFocus();
					return;
				}else if(t3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền số điện thoại");
					t3.requestFocus();
					return;
				}else if(t3.getText().matches("\\D+")) {
					JOptionPane.showMessageDialog(null, "số điện thoại không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
					t3.requestFocus();
					return;
				}else if(t3.getText().length()!=10) {
					JOptionPane.showMessageDialog(null, "sdt phải có 10 số");
					t3.requestFocus();
					return;
				}else if(t4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền cccd");
					t4.requestFocus();
					return;
				}else if(t4.getText().matches("\\D+")) {
					JOptionPane.showMessageDialog(null, "cccd không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
					t4.requestFocus();
					return;
				}else if(t5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền ngày sinh");
					t5.requestFocus();
					return;				 					
				}else if(t4.getText().length()!=12) {	
					JOptionPane.showMessageDialog(null, "cccd phải có 12 số");
					t4.requestFocus();
					return;			
				}else {	
					if(t2.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
						
					}else {
						JOptionPane.showMessageDialog(null, "ngày vào đoàn không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
						t2.requestFocus();
						return;
					}
					if(t5.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
						
					}else {
						JOptionPane.showMessageDialog(null, "ngày sinh không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
						t5.requestFocus();
						return;
						}
					try {
					    Connection connection = Ketnoicsdl.KetNoiCSDL();
					    String query = "UPDATE dbo.[DV] SET Ten=?, CVD=?, NVD=?, SDT=?, CCCD=?, NS=? WHERE CCCD=?";
					    PreparedStatement ps = connection.prepareStatement(query);
					    ps.setString(1, t1.getText());
					    ps.setString(2, (String) dv.getSelectedItem());
					    ps.setString(3, t2.getText());
					    ps.setString(4, t3.getText());
					    ps.setString(5, t4.getText());
					    ps.setString(6, t5.getText());
					    ps.setString(7, data);
					    ps.executeUpdate();
					    JOptionPane.showMessageDialog(null, "Thành công");
					} catch (Exception e1) {
					    e1.printStackTrace();
					}reset();			
			}
			}			
		});
		btnu.setBackground(new Color(192, 192, 192));
		btnu.setBounds(821, 406, 85, 21);
		btnu.setFocusable(false);
		contentPane.add(btnu);
		
		btnNewButton = new JButton("Chọn");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = tableM.getSelectedRow();	
				String ten = tableM.getModel().getValueAt(position, 0).toString();
				String cvd = tableM.getModel().getValueAt(position, 1).toString();
				String nvd = tableM.getModel().getValueAt(position, 2).toString();
				String sdt = tableM.getModel().getValueAt(position, 3).toString();
				String cccd = tableM.getModel().getValueAt(position, 4).toString();
				String ns = tableM.getModel().getValueAt(position, 5).toString();
				t1.setText(ten);
				dv.setSelectedItem(cvd);
				t2.setText(nvd);
				t3.setText(sdt);
				t4.setText(cccd);
				t5.setText(ns);
			}
		});
		btnNewButton.setBounds(700, 406, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
					EventQueue.invokeLater(new Runnable() {
						public void run() {			
							try {			
								DLieu frame = new DLieu();
								frame.setVisible(true);
								fix.this.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					}	
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(938, 406, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}