import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;


public class tieusu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tieusu frame = new tieusu();
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
	public tieusu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1300, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GIGABYTE\\Downloads\\unnamed.png"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1300, 100);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\BannerHeader.jpg"));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 99, 1300, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(100, 0, 0, 0));
		menuBar.setBounds(0, 0, 1300, 50);
		menuBar.setBackground(new Color(29, 109, 163));
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("                                                                                                                                                      ");
		mnNewMenu.setEnabled(false);
		menuBar.add(mnNewMenu);
		
		JMenu mn2 = new JMenu("Trang chủ");
		mn2.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\home-icon.png"));
		mn2.setForeground(new Color(0, 0, 0));
		mn2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mn2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mn2.setBorder(BorderFactory.createEmptyBorder());
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mn2.setBorder(BorderFactory.createEmptyBorder());
				mn2.setSelected(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mn2.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menuBar.add(mn2);
		
		JMenu mnNewMenu_1 = new JMenu("    ");
		mnNewMenu_1.setEnabled(false);
		menuBar.add(mnNewMenu_1);
		
		JMenu mn = new JMenu("Quản lý đoàn viên");
		mn.setBackground(new Color(255, 255, 255));
		mn.setHorizontalAlignment(SwingConstants.CENTER);
		mn.setForeground(new Color(0, 0, 0));
		mn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mn.addMouseListener(new MouseListener() {
			
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
				mn.setBorder(BorderFactory.createEmptyBorder());
				mn.setSelected(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mn.setBorder(BorderFactory.createEtchedBorder());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {			
						try {			
							dulieu frame = new dulieu();
							frame.setVisible(true);
							tieusu.this.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		mn.setIcon(new ImageIcon("C:\\Users\\GIGABYTE\\Downloads\\3413419.png"));
		menuBar.add(mn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 1300, 1000);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1290, 620);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextPane txtpnMaXunNm = new JTextPane();
		txtpnMaXunNm.setToolTipText("");
		txtpnMaXunNm.setText("Mùa xuân năm 1931, từ ngày 20 đến ngày 26/3, tại Hội nghị Ban chấp hành Trung ương Đảng lần\r\n thứ 2, Trung ương Đảng đã giành một phần quan trọng trong chương trình làm việc để bàn về \r\ncông tác thanh niên và đi đến những quyết định có ý nghĩa đặc biệt, như các cấp ủy Đảng từ \r\nTrung ương đến địa phương phải cử ngay các ủy viên của Đảng phụ trách công tác Đoàn. Trước \r\nsự phát triển lớn mạnh của Đoàn trên cả 3 miền Bắc, Trung, Nam, ở nước ta xuất hiện nhiều tổ \r\nchức Đoàn cơ sở với khoảng 1.500 đoàn viên và một số địa phương đã hình thành tổ chức Đoàn \r\ntừ xã, huyện đến cơ sở. \r\n\r\n \r\n \r\n    Sự phát triển lớn mạnh của Đoàn đã đáp ứng kịp thời những đòi hỏi cấp bách của phong trào \r\nthanh niên nước ta. Đó là sự vận động khách quan phù hợp với cách mạng nước ta; đồng thời, \r\nphản ánh công lao trời biển của Đảng, của Chủ tịch Hồ Chí Minh vô cùng kính yêu - Người đã \r\nsáng lập và rèn luyện tổ chức Đoàn. Được Bộ Chính trị Ban chấp hành Trung ương Đảng và Bác \r\nHồ cho phép, theo đề nghị của Trung ương Đoàn thanh niên Lao động Việt Nam, Đại hội toàn \r\nquốc lần thứ 3 họp từ ngày 22 - 25/3/1961 đã quyết định lấy ngày 26/3/1931 (một ngày trong \r\nthời gian cuối của Hội nghị Trung ương Đảng lần thứ 2, dành để bàn bạc và quyết định những \r\nvấn đề rất quan trọng đối với công tác thanh niên) làm ngày thành lập Đoàn hàng năm. Ngày \r\n26/3 trở thành ngày vẻ vang của tuổi trẻ Việt Nam, của Đoàn Thanh niên cộng sản Hồ Chí Minh \r\nquang vinh.\r\n\r\n\r\n \r\n \r\n    Từ ngày 26/3/1931 đến nay, để phù hợp với yêu cầu nhiệm vụ của từng thời kỳ cách mạng, \r\nĐoàn đã đổi tên nhiều lần:\r\n\r\n \r\n \r\n       •    Từ 1931 - 1936: Đoàn TNCS Việt Nam, Đoàn TNCS Đông Dương \r\n \r\n \r\n       •    Từ 1937 - 1939: Đoàn Thanh niên Dân chủ Đông Dương \r\n \r\n \r\n       •    Từ 11/1939 - 1941: Đoàn Thanh niên phản đế Đông Dương \r\n \r\n \r\n       •    Từ 5/1941 - 1956: Đoàn Thanh niên cứu quốc Việt Nam \r\n \r\n \r\n      •    Từ 25/10/1956 - 1970: Đoàn Thanh niên Lao động Việt Nam \r\n \r\n \r\n      •    Từ 2/1970 - 11/1976: Đoàn Thanh niên lao động Hồ Chí Minh \r\n \r\n \r\n      •    Từ 12/1976 đến nay: Đoàn Thanh niên cộng sản Hồ Chí Minh \r\n \r\n \r\n    Những thế hệ thanh niên kế tiếp nhau đã chiến đấu anh dũng vì độc lập tự do của Tổ Quốc, vì \r\nchủ nghĩa xã hội đã liên tiếp lập nên những chiến công xuất sắc và trưởng thành vượt bậc. \r\n.");
		txtpnMaXunNm.setEditable(false);
		panel_2.add(txtpnMaXunNm);
		
	}

}


