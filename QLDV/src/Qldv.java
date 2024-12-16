import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTree;


public class Qldv extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textten;
	private JTextField textngavaod;
	private JTextField textsdt;
	private JTextField textcccd;
	private JTextField textngaysinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qldv frame = new Qldv();
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
	private boolean check(){
		try {
			String query="SELECT * FROM dbo.[DV] WHERE CCCD=?";
			Connection connection= Ketnoicsdl.KetNoiCSDL();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, textcccd.getText());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		}
	public void reset() {
		textten.setText("");
		textngavaod.setText("");
		textsdt.setText("");
		textcccd.setText("");
		textngaysinh.setText("");
		
	}
	public Qldv() {
		setResizable(false);
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GIGABYTE\\Downloads\\unnamed.png"));
		setTitle("Thanh niên VN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(510, 70, 500, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn =new JButton("q");
		btn.setBounds(450,510 ,100,100);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(-10, 78, 500, 480);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(panel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên (*)");
		
		textten = new JTextField();
		textten.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		textten.setColumns(10);
		textten.setBackground(Color.LIGHT_GRAY);
		JLabel lblNewLabel_2_1 = new JLabel("Chức vụ trong đoàn");
		
		JComboBox dv = new JComboBox();
		dv.setModel(new DefaultComboBoxModel(new String[] {"Đoàn viên", "Bí thư chi đoàn", "Phó bí thư chi đoàn", "UV Ban Chấp hành chi đoàn", "Bí thư chi đoàn cơ sở", "Phó bí thư chi đoàn cơ sở", "UV Ban Chấp hành chi đoàn cơ sở", "UV Ban Thường vụ chi đoàn cơ sở", "Bí thư thứ nhất", "Bí thư thường trực", "Bí thư Đoàn khối", "Bí thư Huyện đoàn", "Bí thư Đoàn cơ sở", "Bí thư Liên chi đoàn", "Bí thư Đoàn giao quyền cấp trên cơ sở", "Bí thư Đoàn bộ phận", "Phó Bí thư Tỉnh đoàn", "Phó Bí thư Huyện đoàn", "Phó Bí thư Đoàn cơ sở", "Phó Bí thư Liên chi đoàn", "Phó Bí thư Đoàn giao quyền cấp trên cơ sở", "Phó Bí thư Đoàn bộ phận", "UV Ban Chấp hành", "UV Ban Thường vụ", "UV Ủy ban Kiểm tra", "Chủ nhiêm Ủy ban Kiểm tra", "Phó chủ nhiêm Ủy ban Kiểm tra", "cán bộ đoàn chuyên trách"}));
		dv.setMaximumRowCount(5);
		dv.setBackground(Color.LIGHT_GRAY);			
		
		
		JLabel lblNewLabel_3_1 = new JLabel("Ngày vào đoàn");
		
		textngavaod = new JTextField();
		textngavaod.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textngavaod.setColumns(10);
		textngavaod.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_4_1 = new JLabel("Số điện thoại");
		
		textsdt = new JTextField();
		textsdt.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textsdt.setColumns(10);
		textsdt.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_5_1 = new JLabel("CCCD/CMND");
		
		textcccd = new JTextField();
		textcccd.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textcccd.setColumns(10);
		textcccd.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_6_1 = new JLabel("Ngày sinh");
		
		textngaysinh = new JTextField();
		textngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textngaysinh.setColumns(10);
		textngaysinh.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_7_1 = new JLabel("Giới tính");
		JCheckBox nam = new JCheckBox("");
		nam.setBackground(Color.LIGHT_GRAY);
		
		JCheckBox nu = new JCheckBox("");
		nu.setBackground(Color.LIGHT_GRAY);
		
        nam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nam.isSelected()) {
					nu.setEnabled(false);
				}else {
					nu.setEnabled(true);
				}
			}
		});        
        nu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nu.isSelected()) {
					nam.setEnabled(false);
				}else {
					nam.setEnabled(true);
				}
			}
		});            
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\user (9).png"));
		
		JButton btnadd = new JButton("Thêm");
		btnadd.setBackground(new Color(192, 192, 192));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gt="";
				if(nam.isSelected()) {
					gt="nam";
				}else {
					gt="nữ";
				}
				if(textten.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền tên");
					textten.requestFocus();
					return;
				}else if(textngavaod.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền ngày vào đoàn");
					textngavaod.requestFocus();
					return;
				}else if(textsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền số điện thoại");
					textsdt.requestFocus();
					return;
				}else if(textsdt.getText().matches("\\D+")) {
					JOptionPane.showMessageDialog(null, "số điện thoại không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
					textsdt.requestFocus();
					return;
				}else if(textsdt.getText().length()!=10) {
					JOptionPane.showMessageDialog(null, "sdt phải có 10 số");
					textsdt.requestFocus();
					return;
				}else if(textcccd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền cccd");
					textcccd.requestFocus();
					return;
				}else if(textcccd.getText().matches("\\D+")) {
					JOptionPane.showMessageDialog(null, "cccd không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
					textcccd.requestFocus();
					return;
				}else if(textngaysinh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui lòng điền ngày sinh");
					textngaysinh.requestFocus();
					return;				 					
				}else if(textcccd.getText().length()!=12) {	
					JOptionPane.showMessageDialog(null, "cccd phải có 12 số");
					textcccd.requestFocus();
					return;
				}else if(check()==true) {
					JOptionPane.showMessageDialog(null, "đã tồn tại cccd");
					textcccd.requestFocus();
				}else {	
					if(textngavaod.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
						
					}else {
						JOptionPane.showMessageDialog(null, "ngày vào đoàn không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
						textngavaod.requestFocus();
						return;
					}
					if(textngaysinh.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
						
					}else {
						JOptionPane.showMessageDialog(null, "ngày sinh không hợp lệ","Warning",JOptionPane.ERROR_MESSAGE);
						textngaysinh.requestFocus();
						return;
						}
				try {
					Connection connection= Ketnoicsdl.KetNoiCSDL();
					String query="INSERT INTO dbo.[DV](Ten, CVD, NVD, SDT, CCCD, NS, GT)"+"VALUES(?,?,?,?,?,?,?)";					
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, textten.getText());
					ps.setString(2, (String) dv.getSelectedItem());
					ps.setString(3, textngavaod.getText());
					ps.setString(4, textsdt.getText());
					ps.setString(5, textcccd.getText());
					ps.setString(6, textngaysinh.getText());
					ps.setString(7, gt);
				    ps.executeUpdate();					    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "thành công");
			}reset();
			nam.setSelected(false);
			nu.setSelected(false);
			nam.setEnabled(true);
			nu.setEnabled(true);
			}
			
		});
		
		btnadd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nam");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\3.png"));
		
		JLabel lblNewLabel_2 = new JLabel("Nữ");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\1.png"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\55281.png"));
		
		JLabel lblNewLabel_4 = new JLabel("ex: 01/01/2024");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_4_2 = new JLabel("ex: 01/01/2000");
		lblNewLabel_4_2.setForeground(Color.GRAY);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(textten, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(dv, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(textngavaod, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(textsdt, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(textcccd, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(textngaysinh, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(68)
							.addComponent(nam)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nu)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(btnadd)
					.addGap(205))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_1_1)
					.addGap(10)
					.addComponent(textten, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_2_1)
					.addGap(10)
					.addComponent(dv, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1)
						.addComponent(lblNewLabel_4))
					.addGap(10)
					.addComponent(textngavaod, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(lblNewLabel_4_1)
					.addGap(10)
					.addComponent(textsdt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_5_1)
					.addGap(10)
					.addComponent(textcccd, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6_1)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4_2))
					.addGap(10)
					.addComponent(textngaysinh, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_7_1)
							.addComponent(nam))
						.addComponent(nu)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnadd)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\blue-dgmxybg4kb7eab7x.jpg"));
		lblNewLabel_8_1.setBounds(0, 0, 500, 80);
		contentPane.add(lblNewLabel_8_1);
		
		JButton btnquaylai = new JButton("Trang chủ");
		btnquaylai.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\home-icon1.png"));
		btnquaylai.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnquaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							tieusu frame = new tieusu();
							frame.setVisible(true);
							Qldv.this.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnquaylai.setBackground(new Color(192, 192, 192));
		btnquaylai.setBounds(0, 562, 109, 21);
		btnquaylai.setFocusable(false);
		contentPane.add(btnquaylai);
		
		JButton btnlist = new JButton("Danh sách");
		btnlist.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnlist.setBackground(new Color(192, 192, 192));
		btnlist.setFocusable(false);
		btnlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {			
						try {			
							dulieu frame = new dulieu();
							frame.setVisible(true);
							Qldv.this.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnlist.setBounds(367, 562, 109, 21);
		contentPane.add(btnlist);
		
		
	    
		
		
	}
}
