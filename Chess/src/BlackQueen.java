import javax.swing.ImageIcon;

public class BlackQueen implements Chesspiece {
	private int x;
	private int y;
	private boolean isWhite; 
	private ImageIcon bQueen= new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png");
	public BlackQueen(){
		}
	public boolean validMove(int moveX, int moveY) {
	
		return false;
	}
	public boolean isWhite(){
		return false;
	}
	public ImageIcon print(){
		return bQueen;
	}
}
