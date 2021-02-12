import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class mazeGUI extends JPanel{
	public static maze maze = new maze(50,50);
	static int playerX = 0;
	static int playerY = 0;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Maze");
		frame.add(new mazeGUI());
		frame.setSize(maze.getX()*30, maze.getY()*30);
		frame.setBackground(Color.BLACK);
		KeyListener listener = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_UP) {
			    	if(playerX > 0 && maze.array[playerX-1][playerY] != 0) {
			    		for(int x = 0; x < 4; x++) {
			    			playerX--;
			    			frame.repaint();
			    		}
			    	}
			    }
			
			    else if (e.getKeyCode() == KeyEvent.VK_KP_DOWN) {
			    	if(playerX < maze.array.length - 1 && maze.array[playerX+1][playerY] != 0) {
			    		for(int x = 0; x < 4; x++) {
			    			playerX++;
			    			frame.repaint();
			    		}
			    	}
			    }
			
			    else if (e.getKeyCode() == KeyEvent.VK_KP_LEFT) {
			    	if(playerY > 0 && maze.array[playerX][playerY-1] != 0) {
			    		for(int x = 0; x < 4; x++) {
			    			playerY--;
			    			frame.repaint();
			    		}
			    	}
			    }
			
			    else if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT) {
			    	if(playerY < maze.array[0].length - 1 && maze.array[playerX][playerY+1] != 0) {
			    		for(int x = 0; x < 4; x++) {
			    			playerY++;
			    			frame.repaint();
			    		}
			    	}
			    }
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		frame.addKeyListener(listener);
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maze.printMaze();
	}
	
	public Color ColorMake() {
		Random rand = new Random();
		if(rand.nextBoolean()) {
			Color boxColor = new Color(128,128-rand.nextInt(10),128);
			return boxColor;
		}
		else {
			Color boxColor = new Color(128,128+rand.nextInt(10),128);
			return boxColor;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for(int x =  0; x < (maze.getX()*5)+5; x++) {
			for(int y = 0; y < (maze.getY()*5)+5; y++) {
				if(maze.array[x/5][y/5] == 1) {
					g2d.setColor(ColorMake());
					g2d.fillRect(y*4, x*4, 4, 4);
				}
				else if(maze.array[x/5][y/5] == 3) {
					g2d.setColor(Color.RED);
					g2d.fillRect(y*4, x*4, 4, 4);
				}
				
			}
		}
		g2d.setColor(Color.WHITE);
		g2d.fillOval(playerX, playerY, 4, 4);
	}
}
