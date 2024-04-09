package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		TextArea text = new TextArea(frame.getHeight(),frame.getWidth());
		frame.add(text);
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenuItem itemSave = new JMenuItem("Save");
		itemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				
				int userSelect = fileChooser.showSaveDialog(frame);
				if(userSelect == fileChooser.APPROVE_OPTION) {
					File file;
					PrintWriter writer = null;
					file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					try {
						writer = new PrintWriter(file);
						writer.println(text.getText());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						writer.close(); 	
					}
				}
			}
		});
		menu.add(file);
		file.add(itemSave);
		frame.setJMenuBar(menu);
		frame.setVisible(true);
	
	}

}
