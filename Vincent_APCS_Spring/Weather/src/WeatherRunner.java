import java.awt.Graphics;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WeatherRunner extends JPanel{
	public void main(String[] args) {
		ImageIcon whiteKnight = new ImageIcon(this.getClass().getResource("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/whiteKnight.jpg"));
		Graphics g = null;
		JFrame f = new JFrame();
		f.setSize(450, 450);
		f.add(new WeatherRunner());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		whiteKnight.paintIcon(this, g, 0, 0);
	}
}
