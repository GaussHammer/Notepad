package notepad;

import javax.swing.JTextArea;

public class TextArea extends JTextArea{
	public TextArea(int height, int width) {
		setBounds(0, 0, height, width);
		setVisible(true);
	}
}
