import javax.swing.ImageIcon;

public class WhiteQueen implements Chesspiece {
	private int x;
	private int y;
	private boolean isWhite; 
	private ImageIcon wQueen= new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png");
	public WhiteQueen(){
		}
	public boolean validMove(int moveX, int moveY) {
	
		return false;
	}
	public boolean isWhite(){
		return true;
	}
	public ImageIcon print(){
		return wQueen;
	}
}