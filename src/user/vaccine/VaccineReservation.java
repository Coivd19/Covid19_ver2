package user.vaccine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jdbc.DB;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class VaccineReservation extends JFrame implements ActionListener {

	private JPanel p1;
	private JLabel lblicon;
	private JPanel p4;
	private JLabel lbl1;
	private JPanel p5;
	private JButton b3;
	private JButton b4;
	private JPanel p6;
	private JPanel p3;
	private JPanel last;
	private JPanel p2;
	private JLabel lblicon2;
	private JLabel name;
	private JLabel redStar;
	private JTextField nameTx;
	private JButton topButton;
	private JLabel topLabel1;
	private JLabel topLabel2;
	private JLabel topLabel3;
	private JButton nameButton;
	private JButton NumButton;
	private JLabel num;
	private JLabel redStarNum;
	private JTextField numTx;
	private JLabel num2;
	private JPasswordField numTx2;
	private JLabel phone;
	private JLabel redStarphone;
	private RoundJTextField phoneTx;
	private JLabel phone2;
	private RoundJTextField phoneTx2;
	private JLabel phone3;
	private RoundJTextField phoneTx3;
	private JLabel date;
	private JLabel redStardate;
	private RoundJTextField dateTx;
	private JLabel hostpital;
	private JLabel redStarHsp;
	private JButton btnCal;
	private Component datePicker;
	private String [] local = {"?????????", "????????????", "????????????"};
	private JComboBox<String> cb;
	private JButton btnReserve;
	private JButton btnCancle;
	private VaccineIntro vaccineIntro;
	private ButtonGroup bg;
	private JRadioButton hCenter;
	private JRadioButton uHospital;
	private JRadioButton hospital;
	
	
	// JFrame??? ?????? ?????? ????????? ?????? << ?????? ??? ?????????.
	public VaccineReservation(String title, int width, int height, VaccineIntro vaccineIntro) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); // ?????? ????????? ??????
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ????????? ?????? ?????? ???????????? ????????? ????????? ????????? ??????????????? ???????????? ??????????????? ?????? ?????????
		this.vaccineIntro = vaccineIntro;
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("images/logo2.JPG");
		lblicon = new JLabel(icon);
		lblicon.setToolTipText("???????????? ????????? ?????? ??????????????? ??????????????? ???????????????!!");
		p1.setBackground(Color.white);
		// lblicon.setPreferredSize(new Dimension(150, 150));
		p1.add(lblicon, BorderLayout.WEST);

		p4 = new JPanel();
		p4.setBackground(Color.white);
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.setBorder(BorderFactory.createEmptyBorder(15, 25, 0, 0));
		lbl1 = new JLabel("?????????19 ???????????? ???????????? ?????????");
		lbl1.setFont(new Font("?????? ??????", Font.BOLD, 19));
		p4.add(lbl1);

		p5 = new JPanel();
		p5.setBackground(Color.white);
		p5.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		p5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		b3 = new JButton("????????????");
		b3.setFont(new Font("?????? ??????", Font.BOLD, 13));
		b3.setBorderPainted(false);
		b3.setBackground(Color.white);
		b3.setFocusPainted(false);
		b3.addActionListener(this);
		b4 = new JButton("?????? ??????/??????");
		b4.setFont(new Font("?????? ??????", Font.BOLD, 13));
		b4.setBorderPainted(false);
		b4.setBackground(Color.white);
		b4.setFocusPainted(false);
		b4.addActionListener(this);
		//p5.add(b3);
		p5.add(b4);

		p6 = new JPanel();
		p6.setBackground(Color.white);
		p6.setLayout(new BorderLayout());
		p6.add(p4, BorderLayout.WEST);
		p6.add(p5, BorderLayout.EAST);

		p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(p1, BorderLayout.WEST);
		p3.add(p6);

		p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setLayout(null);

		topButton = new JButton();
		topButton.setBorderPainted(false);
		topButton.setBackground(new Color(240, 240, 240));
		topButton.setBounds(110, 30, 600, 150);
		topButton.setEnabled(false);

		topLabel1 = new JLabel("???????????? ?????? ??? ????????? ?????? ??????");
		topLabel1.setForeground(new Color(75, 137, 220));
		topLabel1.setFont(new Font("?????? ??????", Font.BOLD, 20));
		topLabel1.setBounds(260, 22, 400, 100);

		topLabel2 = new JLabel("??????????????? ?????? ??? ????????? ?????? ????????? ???33?????? 4 ??? ?????? ??? ????????? ???32?????? 3??? ??????");
		// TopLabel2.setForeground(new Color(75, 137, 220));
		topLabel2.setFont(new Font("?????? ??????", Font.BOLD, 13));
		topLabel2.setBounds(150, 60, 600, 100);

		topLabel3 = new JLabel("?????????19 ???????????? ??????????????? ????????? ????????? ??????????????? ???????????????.");
		// TopLabel2.setForeground(new Color(75, 137, 220));
		topLabel3.setFont(new Font("?????? ??????", Font.BOLD, 13));
		topLabel3.setBounds(205, 85, 600, 100);

		nameButton = new JButton();
		nameButton.setBorderPainted(false);
		nameButton.setBackground(new Color(240, 240, 240));
		nameButton.setBounds(110, 200, 130, 500);
		nameButton.setEnabled(false);

		name = new JLabel("??????");
		name.setFont(new Font("?????? ??????", Font.BOLD, 13));
		name.setBounds(160, 175, 100, 100);
		redStar = new JLabel("*");
		redStar.setForeground(Color.red);
		redStar.setBounds(195, 178, 100, 100);
		nameTx = new RoundJTextField(10);
		nameTx.setBounds(255, 210, 130, 30);

		num = new JLabel("??????????????????");
		num.setFont(new Font("?????? ??????", Font.BOLD, 13));
		num.setBounds(135, 225, 100, 100);
		redStarNum = new JLabel("*");
		redStarNum.setForeground(Color.red);
		redStarNum.setBounds(220, 228, 100, 100);
		numTx = new RoundJTextField(10);
		numTx.setBounds(255, 260, 130, 30);
		num2 = new JLabel("-");
		num2.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		num2.setBounds(395, 222, 100, 100);
		numTx2 = new RoundJPWField(10);
		numTx2.setBounds(412, 260, 130, 30);
		
		
		
		phone = new JLabel("???????????????");
		phone.setFont(new Font("?????? ??????", Font.BOLD, 13));
		phone.setBounds(142, 275, 100, 100);
		redStarphone = new JLabel("*");
		redStarphone.setForeground(Color.red);
		redStarphone.setBounds(218, 278, 100, 100);
		phoneTx = new RoundJTextField(10);
		phoneTx.setBounds(255, 310, 130, 30);
		phone2 = new JLabel("-");
		phone2.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		phone2.setBounds(395, 272, 100, 100);
		phoneTx2 = new RoundJTextField(10);
		phoneTx2.setBounds(412, 310, 130, 30);
		phone3 = new JLabel("-");
		phone3.setFont(new Font("?????? ??????", Font.PLAIN, 18));
		phone3.setBounds(552, 272, 100, 100);
		phoneTx3 = new RoundJTextField(10);
		phoneTx3.setBounds(568, 310, 130, 30);
		
		date = new JLabel("????????????");
		date.setFont(new Font("?????? ??????", Font.BOLD, 13));
		date.setBounds(150, 325, 100, 100);
		redStardate = new JLabel("*");
		redStardate.setForeground(Color.red);
		redStardate.setBounds(210, 328, 100, 100);
		//????????? ????????? ?????? ???????????? ????????? ?????????????????? 
		dateTx = new RoundJTextField(10);
		dateTx.setEnabled(false);
		dateTx.setBounds(255, 360, 130, 30);
		ImageIcon icon2 = new ImageIcon("images/Cal.png");
		btnCal = new JButton(icon2);
		btnCal.setBounds(400, 365, 23, 23);
		btnCal.setBorderPainted(false);
		btnCal.setBackground(Color.white);
		btnCal.setFocusPainted(false);
		btnCal.addActionListener(this);
		
		
		hostpital = new JLabel("????????????");
		hostpital.setFont(new Font("?????? ??????", Font.BOLD, 13));
		hostpital.setBounds(147, 385, 100, 100);
		redStarHsp = new JLabel("*");
		redStarHsp.setForeground(Color.red);
		redStarHsp.setBounds(207, 388, 100, 100);
		cb = new JComboBox<String>(local);
		cb.setBounds(260,420,80,35);
		cb.addActionListener(this);
		btnReserve = new JButton("??????");
		btnReserve.setBounds(500, 485, 100, 40);
		btnReserve.setBackground(new Color(75, 137, 220));
		btnReserve.setForeground(Color.white);
		btnReserve.setFont(new Font("?????? ??????", Font.BOLD, 16));
		btnReserve.setFocusPainted(false);
		btnReserve.addActionListener(this);
		btnCancle = new JButton("??????");
		btnCancle.setBounds(610, 485, 100, 40);
		btnCancle.setBackground(Color.white);
		btnCancle.setFont(new Font("?????? ??????", Font.PLAIN, 16));
		btnCancle.setFocusPainted(false);
		btnCancle.addActionListener(this);
		
		p2.add(name);
		p2.add(redStar);
		p2.add(nameTx);
		p2.add(topLabel1);
		p2.add(topLabel2);
		p2.add(topLabel3);
		p2.add(num);
		p2.add(redStarNum);
		p2.add(numTx);
		p2.add(num2);
		p2.add(numTx2);
		p2.add(phone);
		p2.add(redStarphone);
		p2.add(phoneTx);
		p2.add(phoneTx2);
		p2.add(phone2);
		p2.add(phone3);
		p2.add(phoneTx3);
		p2.add(date);
		p2.add(redStardate);
		p2.add(dateTx);
		p2.add(hostpital);
		p2.add(redStarHsp);
		p2.add(cb);
		p2.add(btnReserve);
		p2.add(btnCancle);
		p2.add(btnCal);
		p2.add(topButton);
		p2.add(nameButton);

		last = new JPanel();
		last.setBackground(Color.white);
		last.setLayout(new BorderLayout());
		last.add(p3, BorderLayout.NORTH);
		last.add(p2);
		add(last);
		setResizable(false);
		setVisible(true);

	}

	public RoundJTextField getDateTx() {
		return dateTx;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(0, 100, 1050, 100);
		g.drawLine(210, 40, 210, 88);
		g.drawLine(120, 300, 715, 300);
		g.drawLine(120, 350, 715, 350);
		g.drawLine(120, 400, 715, 400);
		g.drawLine(120, 450, 715, 450);
		g.drawLine(120, 500, 715, 500);
	}

//	public static void main(String[] args) {
//		new VaccineReservation("?????? ??????", 840, 900);
//	}

	
	// ????????? ????????? ????????? ????????? ?????? JtextField ???????????? RoundTextFiled???????????? ??????????????? ????????? ????????? ???????????? ?????????
	public class RoundJTextField extends JTextField {
		private Shape shape;

		public RoundJTextField(int size) {
			super(size);
			setOpaque(false); // As suggested by @AVD in comment.
		}

		protected void paintComponent(Graphics g) {
			g.setColor(getBackground());							//?????? 10,10 ????????? ?????? ????????? ???????????? 
			g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
			super.paintComponent(g);
		}

		protected void paintBorder(Graphics g) {
			g.setColor(new Color(140, 140, 140));
			g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
		}

		public boolean contains(int x, int y) {
			if (shape == null || !shape.getBounds().equals(getBounds())) {
				shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
			}
			return shape.contains(x, y);
		}
	}
	
	// 
	public class RoundJPWField extends JPasswordField {
		private Shape shape;

		public RoundJPWField(int size) {
			super(size);
			setOpaque(false); // As suggested by @AVD in comment.
		}

		protected void paintComponent(Graphics g) {
			g.setColor(getBackground());
			g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
			super.paintComponent(g);
		}

		protected void paintBorder(Graphics g) {
			g.setColor(new Color(140, 140, 140));                  
			g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
		}

		public boolean contains(int x, int y) {
			if (shape == null || !shape.getBounds().equals(getBounds())) {
				shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
			}
			return shape.contains(x, y);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnCal) {
			new Calendar("?????? ??????", 350, 200, this);
		}
		else if(obj == btnReserve) {
			
			if(vaccineIntro.getNumCheck(numTx2.getText())) {
				String sql = "INSERT INTO vaccine VALUES ('"+ numTx2.getText() +"', '"+ nameTx.getText() +"', '"+ numTx.getText() + "', '" + phoneTx.getText() + "-" + phoneTx2.getText() + "-" + phoneTx3.getText() + "', '"+ dateTx.getText() + "', '" + cb.getSelectedItem() + "')";	
				
				// ???????????? ??????????????? ????????????????????? ??????
				if(numTx2.getText().equals("") | nameTx.getText().equals("") | numTx.getText().equals("") | phoneTx.getText().equals("") | phoneTx2.getText().equals("") | phoneTx3.getText().equals("") | dateTx.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"?????? ?????? ????????????.","?????????",JOptionPane.ERROR_MESSAGE);
				}
				else {
				try {
					DB.stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"????????? ?????????????????????.","?????????",JOptionPane.INFORMATION_MESSAGE);
				numTx2.setText("");
				nameTx.setText("");
				numTx.setText("");
				phoneTx.setText("");
				phoneTx2.setText("");
				phoneTx3.setText("");
				dateTx.setText("");
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"?????? ?????????????????????.","?????????",JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
		else if(obj == btnCancle) {
			dispose();
		}
		else if(obj == b4) {
			new VaccineInquiry("?????? ?????? ??????", 750, 650);
		}
		else if(obj == cb) {
			repaint();
		}
	}

}
