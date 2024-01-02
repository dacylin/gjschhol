package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.studentDaoImpl;
import model.student;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class controller extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controller frame = new controller();
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
	public controller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 509, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學生管理系統");
		lblNewLabel.setBounds(206, 33, 101, 15);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 111, 509, 137);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(31, 23, 46, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文");
		lblNewLabel_1_1.setBounds(175, 23, 46, 15);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("英文");
		lblNewLabel_1_1_1.setBounds(304, 23, 46, 15);
		panel_1.add(lblNewLabel_1_1_1);
		
		name = new JTextField();
		name.setBounds(69, 20, 96, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setColumns(10);
		chi.setBounds(198, 20, 96, 21);
		panel_1.add(chi);
		
		eng = new JTextField();
		eng.setColumns(10);
		eng.setBounds(346, 20, 96, 21);
		panel_1.add(eng);
			
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 258, 509, 245);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(37, 57, 446, 178);
		panel_2.add(output);
		
		JButton btnNewButton_1 = new JButton("查詢 S");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				 * 1.queryAll2()--->List
				 * 2.String show="";
				 */
				
				output.setText(new studentDaoImpl().queryAll1());
						
			}
		});
		btnNewButton_1.setBounds(131, 24, 85, 23);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("查詢 L");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				 * 1.List-->queryAll2();
				 * 2.show:String;
				 * 
				 */
				
				List<student> l=new studentDaoImpl().queryAll2();
				String show="";
				int sum=0;
				int i=0;
				for(student o:l)
				{
					i++;
					sum=sum+(o.getChi()+o.getEng());
					
					
					
					show=show+"id:"+o.getId()+
							"\t名:"+o.getName()+
							"\t國文:"+o.getChi()+
							"\t英文:"+o.getEng()+
							"\t總分:"+(o.getChi()+o.getEng())+"\n";
					
				}
				
				
				show=show+"\n總分合計="+sum+"\t平均="+(sum/i);
				
				
				output.setText(show);
			}
			
		});
		btnNewButton_1_1.setBounds(294, 24, 85, 23);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取 name,chi,eng getText()
				 * 2.name,chi-->轉整數
				 * 3.new student(name,chi,eng);
				 * 4.add(s);
				 */
					
				String Name=name.getText();
				int CHI=Integer.parseInt(chi.getText());
				int ENG=Integer.parseInt(eng.getText());
							
				student s=new student(Name,CHI,ENG);
				
				new studentDaoImpl().add(s);
			}
		});
		btnNewButton.setBounds(209, 88, 85, 23);
		panel_1.add(btnNewButton);
	}
}
