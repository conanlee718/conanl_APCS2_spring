import javax.swing.ImageIcon;

public class BlackRook implements Chesspiece {
	private int x;
	private int y;
	private boolean isWhite; 
	private ImageIcon bRook= new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png");
	public BlackRook(){
		}
	public boolean validMove(int moveX, int moveY) {
	
		return false;
	}
	public boolean isWhite(){
		return false;
	}
	public ImageIcon print(){
		return bRook;
	}
}
