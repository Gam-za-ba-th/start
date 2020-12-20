///Copyright 2020 Hyun Min///
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class test extends JFrame{
	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("ID"); 
	private JLabel pwLabel = new JLabel("비밀번호");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton idpwSearchBtn = new JButton("회원가입");

	public test() {
		super("");
		
		this.setContentPane(loginPanel);
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(idpwSearchBtn);
		loginPanel.add(loginBtn);
		
		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);
		
		setSize(350,150);
		this.setLocationRelativeTo(null);		
		
		this.setVisible(true);
	
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				
				if(id.length()==0 || pw.length()==0) {
					
					return;
				}
				
				if(id.equals("test") && pw.equals("1234")) {
					new menu();
					return;
				}
				
				
			}
		});
		
		idpwSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占� 占십았쏙옙占싹댐옙."
						+ "", "占쏙옙占싱듸옙/占쏙옙橘占싫� 찾占쏙옙", JOptionPane.DEFAULT_OPTION);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new test();
	}
}
