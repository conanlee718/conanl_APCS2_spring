import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.*;

public class ChessRunner extends JPanel implements MouseListener{
	public int mouseX ,mouseY;
	public Chesspiece changing;
	Chesspiece[][] board= new Chesspiece[8][8];
	private Graphics g;
	//	ImageIcon whiteKnight = new ImageIcon(this.getClass().getResource("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/whiteKnight.jpg"));
	//	ImageIcon blackKnight = new ImageIcon(this.getClass().getResource("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png"));

	public ChessRunner(){
		addMouseListener(this);
		for(int i=0;i<8;i++){
			for (int j=1;j<7;j++)
				if(j==1)
					board[i][j] = new BlackPawn();
				else if(j==6)
					board[i][j] = new WhitePawn();
				else
					board[i][j]= new BlankPiece();
		}
		board[1][0] = new BlackKnight();
		board[6][0] = new BlackKnight();
		board[0][0] = new BlackRook();
		board[7][0] = new BlackRook();
		board[2][0] = new BlackBishop();
		board[5][0] = new BlackBishop();
		board[4][0] = new BlackKing();
		board[3][0] = new BlackQueen();
		
		board[1][7] = new WhiteKnight();
		board[6][7] = new WhiteKnight();
		board[0][7] = new WhiteRook();
		board[7][7] = new WhiteRook();
		board[2][7] = new WhiteBishop();
		board[5][7] = new WhiteBishop();
		board[4][7] = new WhiteKing();
		board[3][7] = new WhiteQueen();
		
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(450, 450);
		f.add(new ChessRunner());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void paint(Graphics g) {
		for (int i=0;i<400;i=i+50){
			for (int j=0;j<400;j=j+50){
				if ((i%100==0&&j%100==0)||(i%100!=0 && j%100!=0)){
					g.setColor(Color.black);
					g.fillRect(i, j, 50, 50);
				}
				else{
					g.setColor(Color.white);
					g.fillRect(i, j, 50, 50);
				}
			}
		}
		for(int i=0;i<8;i++)
			for (int j=0;j<8;j++)
				if(!(board[i][j] instanceof BlankPiece))
					board[i][j].print().paintIcon(this, g, 50*i, 50*j);
		/*			    Graphics2D g2d = (Graphics2D) g;
			    AffineTransform tx = new AffineTransform();
			    double x = 150;
			    double y = .2;
			    tx.translate(x, y);
			    g2d.setTransform(tx);
			    g2d.drawImage(new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png").getImage(), tx, this);
			    x=-125;
			    tx.translate(x, y);
			    g2d.setTransform(tx);
			    g2d.drawImage(new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png").getImage(), tx, this);
		 */	}
	public void paint(Graphics g, int x, int y){
		if ((x/50*50%100==0&&y/50*50%100==0)||(x/50*50%100!=0 && y/50*50%100!=0))
			g.setColor(Color.black);
		else
			g.setColor(Color.white);
		g.fillRect(x/50*50, y/50*50, 50, 50);
	}
	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
		int row=mouseX/50;
		int col=mouseY/50;
		System.out.println(mouseX+"  "+mouseY);
		//get the chesspiece		
		changing= board [row][col];
		//delete the chesspiece
	}
	public void mouseReleased(MouseEvent e) {
		paint(getGraphics(), mouseX, mouseY);
		/*if ((mouseX%100==0&&mouseY%100==0)||(mouseX%100!=0 && mouseY%100!=0))
			.setColor(Color.black);
		else
			getGraphics().setColor(Color.white);
		g.fillRect(mouseX/50*50, mouseY/50*50, 50, 50);*/
		mouseX=e.getX();
		mouseY=e.getY();
		int row=mouseX/50;
		int col=mouseY/50;
		changing.print().paintIcon(this, getGraphics(), 50*row, 50*col);;
		System.out.println(mouseX+"  "+mouseY);
		board[row][col]=changing;
		//check ifValid
	}
}
