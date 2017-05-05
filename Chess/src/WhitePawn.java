import javax.swing.ImageIcon;

public class WhitePawn implements Chesspiece {
	private int x;
	private int y;
	private boolean isWhite; 
	private ImageIcon wPawn= new ImageIcon("C:/Users/Vincent/Desktop/Vincent_APCS_Spring/Chess/blackKnight.png");
	public WhitePawn(){
		}
	public boolean validMove(int moveX, int moveY) {
	
		return false;
	}
	public boolean isWhite(){
		return true;
	}
	public ImageIcon print(){
		return wPawn;
	}
}
