package dec11;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//비만도
class MyFrame extends JFrame {
	private JTextField nameTF;
	private JTextField heightTF;
	private JTextField weightTF;
	private JButton resultBtn;
	private JButton deleteBtn;
	private JLabel resultLb;

	public MyFrame() {
		setLayout(new GridLayout(5, 1));

		JPanel nameP = new JPanel();
		nameP.setLayout(new GridLayout(1, 2));
		nameP.add(new JLabel("이름"));
		nameTF = new JTextField();
		nameP.add(nameTF);
		add(nameP);

		JPanel heightP = new JPanel();
		heightP.setLayout(new GridLayout(1, 2));
		heightP.add(new JLabel("키"));
		heightTF = new JTextField();
		heightP.add(heightTF);
		add(heightP);

		JPanel weightP = new JPanel();
		weightP.setLayout(new GridLayout(1, 2));
		weightP.add(new JLabel("몸무게"));
		weightTF = new JTextField();
		weightP.add(weightTF);
		add(weightP);

		JPanel buttonP = new JPanel();
		buttonP.setLayout(new GridLayout(1, 2));
		resultBtn = new JButton("결과값 보기");
		buttonP.add(resultBtn);
		deleteBtn = new JButton("초기화");
		buttonP.add(deleteBtn);
		add(buttonP);

		resultLb = new JLabel("결과값이 여기에 나타납니다.");
		add(resultLb);

		// resultBtn을 눌렀을 때 키와 몸무게를 가져와서 연산하고 / 이름과 함께 결과값 출력
		resultBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 키/몸무게/이름등 저장
				String name = nameTF.getText();
				double ki = Double.parseDouble(heightTF.getText());
				double mom = Double.parseDouble(weightTF.getText());

				// 키 몸무게 연산
				// (키 -100) * 0.9 : 표준 몸무게
				double stdweight = (ki - 100.0) * 0.9;
				double bimando = ((mom/stdweight) * 100);
				
				// 그리고 출력
				if(bimando > 120) {
					resultLb.setText(name+"님, 당신은 비만입니다.");
				}else if(bimando < 80) {
					resultLb.setText(name + "님, 당신은 저체중입니다.");
				}else {
					resultLb.setText(name + "님, 당신은 정상입니다.");
				}
			}
		});//리스너 끝
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameTF.setText("");
				heightTF.setText("");
				weightTF.setText("");
			}
		});//리스너 끝
		

	}

}

public class GUIbmd {
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		myFrame.setSize(300,600);
		myFrame.setTitle(":비만도 프로그램:");
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
