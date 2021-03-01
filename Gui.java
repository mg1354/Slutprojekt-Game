package game;


import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Gui {
	
	
	static JFrame window;
	static JPanel panel;
	static JTextArea showRoom;
	static JTextArea showplayer;
	
	static JTextField input;
	static String command;
	static JButton button;
	static JButton save;
	
	private JTextArea showperson;


	public Gui() {
		window = new JFrame("Game");
		panel = new JPanel(new GridLayout(4, 4));
		showRoom = new JTextArea("Room");
		showplayer = new JTextArea("Player");
		showperson = new JTextArea("Person");
		input = new JTextField("command");
		button = new JButton("Do");
		save = new JButton("save");
		showRoom.setBackground(Color.yellow);
		showplayer.setBackground(Color.green);
		showperson.setBackground(Color.green);
		input.setBackground(Color.yellow);
		button.setBackground(Color.orange);
		save.setBackground(Color.cyan);

		window.add(panel);
		panel.add(showRoom);
		panel.add(showplayer);
		panel.add(showperson);
		panel.add(input);
		panel.add(button);
		panel.add(save);

		window.setSize(800, 600);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		
//		 ActionListener inputListener = e -> {
//             command = input.getText();
//             System.out.println(command);
//            
//         };
//
//         
//
//         button.addActionListener(inputListener);

		
		
		
		
	}

//	public static void main(String[] args) {
//		gui();
//		showRoom.setText(kitchen.toSrting());
//		showplayer.setText(p.toString());
//		showperson.setText(Ali.toString());
//		
//		System.out.println(p.toString()+"\n"+Ali.toString());
//		
//	}
	
	public JTextArea getShowPerson() {
		return this.showperson;
	}

}
