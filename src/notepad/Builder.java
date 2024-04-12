package notepad;

import javax.swing.JScrollPane;

public class Builder {
	MyFrame frame = new MyFrame();
	TextArea text = new TextArea(frame.getHeight(), frame.getWidth());
	MenuBar menu = new MenuBar(frame, text);
	JScrollPane pane = new JScrollPane(text);
	public Builder() {
		frame.setJMenuBar(menu);
		frame.add(pane);
		frame.setVisible(true);
	}
}
