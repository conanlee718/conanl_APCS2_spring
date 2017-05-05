import javax.swing.ImageIcon;

public class BlackKnight implements Chesspiece {
	private int x;
	private int y;
	private boolean isWhite; 
	private ImageIcon bKnight= new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png");
	public BlackKnight(){
		}
	public boolean validMove(int moveX, int moveY) {
	
		return false;
	}
	public boolean isWhite(){
		return false;
	}
	public ImageIcon print(){
		return bKnight;
	}
}
