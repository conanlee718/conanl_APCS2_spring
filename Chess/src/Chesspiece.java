import javax.swing.ImageIcon;

public interface Chesspiece {
	public boolean validMove(int a, int b);
	public boolean isWhite();
	public ImageIcon print();
}
