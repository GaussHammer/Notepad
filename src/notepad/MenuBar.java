package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	JMenu file = new JMenu("File");
	JMenuItem newFile = new JMenuItem("New");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem save = new JMenuItem("Save");
	public MenuBar(MyFrame frame, TextArea text) {
		add(file);
		file.add(newFile);
		newFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("");
			}
		});
		
		file.add(open);
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				int userSelection = fileChooser.showOpenDialog(frame);
				if(userSelection == fileChooser.APPROVE_OPTION) {
					File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					text.setText("");
					try {
						Scanner reader = new Scanner(file);
						while(reader.hasNextLine()) {
							String data = reader.nextLine()+"\n";
							text.append(data);
						}
						reader.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				
			}
		});
		
		file.add(save);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int userSelection = fileChooser.showSaveDialog(frame);
				if(userSelection == fileChooser.APPROVE_OPTION) {
					File file;
					file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					try {
						PrintWriter writer = new PrintWriter(file, "UTF-8");
						writer.println(text.getText());
						writer.close();
					} catch (IOException e1) {
						System.out.println("error in I/O");
						e1.printStackTrace();
					}
					
				}
				
			}
		});
	}
}
