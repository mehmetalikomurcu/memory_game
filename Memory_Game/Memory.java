package Memory_Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

public class Memory extends JPanel{
	

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis(); //Gets the current time value in milliseconds.
		int[][] array = new int[4][4];
		boolean found[][] = new boolean [4][4];
		
		random(array, found);
		printRandomizedBoard(array);

		JFrame frame = new JFrame("Memory Game");
		Timer timer = new Timer();
		Memory g = new Memory();
	 	frame.add(g);
	 			 		 	
	 	frame.addMouseListener(new MouseAdapter() {
				int count=0;
				int[] guess = new int [2];
				int[] coordX = new int [2];
				int[] coordY = new int [2];				
				
				// Takes the values of MouseX and MouseY, and assign it to x and y parameters.
				public void mousePressed(MouseEvent e) {
		    	System.out.println((e.getX()-7) + ","+  (e.getY()-31));
		    	
		    	int x = (e.getX()-7);
		    	int y = (e.getY()-31);
		    	
		    	guess[count]=array[y/100][x/100];
		    	coordY[count]=(x/100);
		    	coordX[count]=(y/100);
		    	
		        g.drawCircle(g.getGraphics(), array, x/100, y/100);
		        count++;

		        if(count==2) {

		        	if(guess[0]==guess[1]) {
		        		if(coordX[0]==coordX[1] && coordY[0]==coordY[1]) {
		        			if (found[coordX[0]][coordY[0]]) {
		        				
							}
		        			else {
		        				TimerTask task = new TimerTask() {
			    		    	    
				    	            @Override
				    	            public void run() {
						        		g.clearRect(g.getGraphics(), coordY[0],coordX[0]);
						        		g.clearRect(g.getGraphics(), coordY[1],coordX[1]);
				    	            }
				    	        };
				    	        timer.schedule(task, 200);
		        			}
		        		}
		        		else {
			        		found[coordX[0]][coordY[0]]=true;
			        		found[coordX[1]][coordY[1]]=true;		        			
		        		}
		        		
		        	}
		        	else {
		        		if (found[coordX[0]][coordY[0]] && found[coordX[1]][coordY[1]]) {
							
						}
		        		else if(found[coordX[0]][coordY[0]] && !found[coordX[1]][coordY[1]]) { //Code for the avoid disappearing matched element because of unmatched element.
		        			TimerTask task = new TimerTask() {
		    		    	    
			    	            @Override
			    	            public void run() {
					        		g.clearRect(g.getGraphics(), coordY[1],coordX[1]);
			    	            }
			    	        };
			    	        timer.schedule(task, 200);
		        		}
		        		else if(!found[coordX[0]][coordY[0]] && found[coordX[1]][coordY[1]]) { //Code for the avoid disappearing matched element because of unmatched element.
		        			TimerTask task = new TimerTask() {
		    		    	    
			    	            @Override
			    	            public void run() {
					        		g.clearRect(g.getGraphics(), coordY[0],coordX[0]);
			    	            }
			    	        };
			    	        timer.schedule(task, 200);
		        		}
		        		else {
		        			TimerTask task = new TimerTask() {
		    		    	    
			    	            @Override
			    	            public void run() {
					        		g.clearRect(g.getGraphics(), coordY[0],coordX[0]);
					        		g.clearRect(g.getGraphics(), coordY[1],coordX[1]);
			    	            }
			    	        };
			    	        timer.schedule(task, 200);
		        		}
		        	}
		        count = 0;
		        }
		        else {
		        	
		        }
		        //Takes the initial time again and assign it end parameter so we can extract start from the end. In that way we can how many second passed in game.
		        if (isFinished(found)) {
			    	   long end = System.currentTimeMillis(); 
			    		int sec = (int) ((end - start) / 1000); 
			        	
			    		JOptionPane.showMessageDialog(frame,"YOU WON! in " + sec + " seconds!", "Congratulations",JOptionPane.INFORMATION_MESSAGE);
			    		if (JOptionPane.OK_OPTION==0) {
							System.exit(0);
						}
			        	
			       }
				}
		 	});
		setFrameProperties(frame);
	}
	
	//In this function we create a random generated board. Using for and if statements. 
	public static void random(int[][] array, boolean[][] found) {
		Random rnd = new Random();		
		int zeroCounter=0;
		int oneCounter=0;
		int twoCounter=0;
		int threeCounter=0;
		int fourCounter=0;
		int fiveCounter=0;
		int sixCounter=0;
		int sevenCounter=0;
		
		//Also we fill the found array to store any found matches.
		for (int i = 0; i < found.length; i++) {
			for (int j = 0; j < found.length; j++) {
				found[i][j]=false;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				int tempRandom = rnd.nextInt()%8; // We get a random number remainder of 8 which is 0-7.
				if(tempRandom<0) {	//If our random number is negative we decrease j by one and we take another random number.
					j--;
				}
				else {
					//If our random number is equal to 0 we need only two zero then if our counter more than 2 we decrease j by one and retaking the random number. Same in other statements.
					if(tempRandom == 0) { 
						zeroCounter++;
						if (zeroCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
					else if(tempRandom == 1) {
						oneCounter++;
						if (oneCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
					else if(tempRandom == 2) {
						twoCounter++;
						if (twoCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
					else if(tempRandom == 3) {
						threeCounter++;
						if (threeCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
					else if(tempRandom == 4) {
						fourCounter++;
						if (fourCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
					else if(tempRandom == 5) {
						fiveCounter++;
						if (fiveCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
					else if(tempRandom == 6) {
						sixCounter++;
						if (sixCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
					else if(tempRandom == 7) {
						sevenCounter++;
						if (sevenCounter>2) {
							j--;
						}
						else {
							array[i][j] = tempRandom;
						}
					}
				}
			}
		}
	}
	//Thanks to this function we can control the board that if it is random generated or if there is a mistake. Basically this is a control function.
	public static void printRandomizedBoard(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	//With this function we control that is user finished the game or not.
	public static boolean isFinished(boolean[][] found) {
		int ctWin=0;
        for (int i = 0; i < found.length; i++) {
			for (int j = 0; j < found.length; j++) {
				if(!found[i][j]) {
				}
				else {
					ctWin++; // We increase counter every found match. That helps us to control the game is over or not.
				}
				
			}
		
		}
        if (ctWin==16) { //If counter equals the element count in array matrix that means we found all the matches and game is over.
        	return true;
        }
        else {
        	return false;
        }
        
	}
	//This function sets the proerties of JFrame visual board.
	public static void setFrameProperties(JFrame frame) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	frame.pack();
	 	frame.setSize(416,438);
	 	frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	//In here we are drawing our board as 4x4 matrix and 400x400 pixels.
	public void paint(Graphics g) {
		int[][] array = new int[400][400]; //We created an array as the pixel sizes of the board.
		for (int i = 0; i < array.length; i+=101) {
			for (int j = 0; j < array.length; j+=101) {
				g.setColor(Color.white);
				g.drawRect(j, i, 100, 100);
				g.setColor(Color.black);
				g.fillRect(j, i, 100, 100);
			}
		}
	}
	
	//In this function we get the clicked position and turned it to a circle of different color to describe them.
	public void drawCircle(Graphics g, int[][] array, int xTemp, int yTemp) {
		
		
		switch (array[yTemp][xTemp]) {
		case 0:
			g.setColor(Color.BLUE);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		case 1:
			g.setColor(Color.green);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		case 2:
			g.setColor(Color.yellow);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		case 3:
			g.setColor(Color.red);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		case 4:
			g.setColor(Color.pink);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		case 5:
			g.setColor(Color.cyan);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		case 6:
			g.setColor(Color.white);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		case 7:
			g.setColor(Color.gray);
			g.fillOval(xTemp*100+25, yTemp*100+25, 50, 50);
			break;
		default:
			break;
		}	
	}
	
	//If this function called, there is a miss match and this function provides to clear those wrong matches.
	public void clearRect(Graphics g, int x, int y) {
		g.setColor(Color.black);
		g.fillRect(x*100+25, y*100+25, 50, 50);
	}
	


}
