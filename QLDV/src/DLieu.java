

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

public class DLieu extends JFrame {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				try {			
					DLieu frame = new DLieu();
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
	public DLieu() {
		setResizable(false);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showdulieu();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(470, 70, 630, 630);
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
							DLieu.this.dispose();
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
		mns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							fix frame = new fix();
							frame.setVisible(true);
							DLieu.this.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}	
				});
			}
		});
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
							DLieu.this.dispose();
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
							DLieu.this.dispose();
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
		tableM.setRowSelectionAllowed(false);
		tableM.setEnabled(false);
		scrollPane.setViewportView(tableM);
	}
}
