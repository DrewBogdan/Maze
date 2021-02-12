import java.util.*;

public class maze {
	public int[][] array;
	static int count = 0;
	static int playerX = 0;
	static int playerY = 0;
	
	public maze(int sizeX, int sizeY) {
		array = new int[sizeX][sizeY];
		mazeMake(0,0);
		array[sizeX-1][sizeY-1] = 3;
	}
	
	public int getCount() {
		return count;
	}
	public int getY() {
		return array.length-1;
	}
	public int getX() {
		return array[0].length-1;
	}
	
	
	public void printMaze() {
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[0].length; y++) {
				if (array[x][y] == 1) {
					System.out.print("|" + array[x][y] + "|");
				} else if (array[x][y] == 2) {
					System.out.print("(" + array[x][y] + ")");
				} else {
					System.out.print(" " + array[x][y] + " ");
				}
			}
			System.out.println();
		}
	}

	public boolean mazeMake(int row, int column) {
		int rowL = array.length;
		int colL = array[0].length;
		if (!(row >= rowL || column >= colL || row < 0 || column < 0)) {
			if (!(row == rowL - 1 && column == colL - 1)) {
				if (!(array[row][column] == 1)) {
					count++;
					// System.out.println(count);
					ArrayList<Integer> leftover = new ArrayList<Integer>();
					leftover.add(0);
					leftover.add(1);
					leftover.add(2);
					leftover.add(3);
					// 0 = up, 1 = down, 2 = left, 3 = right
					while (leftover.size() > 0) {
						Random rand = new Random();
						int randchoice = rand.nextInt(leftover.size());
						int choice = leftover.get(randchoice);
						leftover.remove(randchoice);
						if (choice == 0) {
							array[row][column] = 1;

							if (mazeMake(row + 1, column)) {
								return true;
							}
							array[row][column] = 0;

						}
						if (choice == 1) {
							array[row][column] = 1;
							if (column < array[0].length - 1 && column != 0) {
								if (mazeMake(row - 1, column)) {
									return true;
								}
							}
							array[row][column] = 0;
						}
						if (choice == 2) {
							array[row][column] = 1;
							if (mazeMake(row, column + 1)) {
								return true;
							}
							array[row][column] = 0;
						}
						if (choice == 3) {
							array[row][column] = 1;
							if (row < array.length - 1 && row != 0) {
								if (mazeMake(row, column - 1)) {
									return true;
								}
							}
							array[row][column] = 0;
						}
					}
				} else {
					return false;
				}

			} else {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	//helper method to move the player icon through array maze
	public void movePlayer() {
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[0].length; y++) {
				if(array[x][y] == 8) {
					array[x][y] = 1;
				}
			}
			
		}
		array[playerX][playerY] = 8;
	}
	
	
	//basic move method
	public void move(int input) {
		if (input == 1) {
	    	if(playerX > 0 && array[playerX-1][playerY] != 0) {
	    		playerX--;
	    		movePlayer();
	    	}
	    	System.out.flush();
	    	printMaze();
	    }
	
	    else if (input == 2) {
	    	if(playerX < array.length - 1 && array[playerX+1][playerY] != 0) {
	    		playerX++;
	    		movePlayer();
	    	}
	    	System.out.flush();
	    	printMaze();
	    }
	
	    else if (input == 3) {
	    	if(playerY > 0 && array[playerX][playerY-1] != 0) {
	    		playerY--;
	    		movePlayer();
	    	}
	    	System.out.flush();
	    	printMaze();
	    }
	
	    else if (input == 4) {
	    	if(playerY < array[0].length - 1 && array[playerX][playerY+1] != 0) {
	    		playerY++;
	    		movePlayer();
	    	}
	    	System.out.flush();
	    	printMaze();
	    }
	}
	
	
	
	
	
	

}


