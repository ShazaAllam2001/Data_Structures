package eg.edu.alexu.datastructure.iceHockey;

import java.awt.Point;

public class IceHockey implements IPlayersFinder{
	
	static int i, j, counter = 0;
	static Point[] center = new Point[10000];
	int xMax, yMax, xMin, yMin;
	boolean[][] covered = new boolean [50][50];
	
	public int checkAround(int i, int j, int[][] arr){
	    // variables for checking availability to check in all directions
		boolean canUp = (i - 1 >= 0);
        boolean canDown = (i + 1 < arr.length);
        boolean canRight = (j + 1 < arr[0].length);
        boolean canLeft = (j - 1 >= 0);
        
        //
        int up = 0, down = 0, right = 0, left =0;
        arr[i][j] = 2;
        covered[i][j] = true;
        
        //
        if(i < xMin) {
        	xMin = i;
        }
        else if(j  < yMin) {
        	yMin = j;
        }
        else if(i > xMax) {
        	xMax = i;	
        }
        else if(j > yMax) {
        	yMax = j;
        }
        
        // 
        if (canUp && arr[i-1][j] == 1){
        	covered[i-1][j] = true;
            up = checkAround(i-1,j,arr);
        }
        if (canDown && arr[i+1][j] == 1) {
        	covered[i+1][j] = true;
            down = checkAround(i+1,j,arr);
        }
        if (canLeft && arr[i][j-1] == 1){
        	covered[i][j-1] = true;
            right = checkAround(i,j-1,arr);
        }
        if (canRight && arr[i][j+1] == 1){
        	covered[i][j+1] = true;
            left = checkAround(i,j+1,arr);
        }
        return (up + down + right + left + 1);
	}

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		
		if(photo == null) {
			return null;
		}
		else {
			 // converting the type of inputs
			final int RADIX = 10;
			char Team = Character.forDigit(team,RADIX);
			int[][] teamNum = new int [photo.length][photo[0].length()];
			
			for(int i=0 ; i<photo.length ; i++) {
				for(int j=0 ; j<photo[0].length() ; j++) {
					if(photo[i].charAt(j) == Team) {
						teamNum[i][j] = 1;
					}
				}
			}
			// 
			for(i=0 ; i<photo.length ; i++) {
				for(j=0 ; j<photo[0].length() ; j++) {
					if(covered[i][j] == false && teamNum[i][j] == 1) {
						xMin = i;
						yMin = j;
						xMax = i;
						yMax = j;
						int area = 4 * checkAround(i,j,teamNum);
						if(area >= threshold) {
							xMin = xMin* 2;
							yMin = yMin * 2;
							xMax = (xMax + 1) * 2;
							yMax = (yMax + 1) * 2;
							center[counter] = new Point();
							center[counter].x = (yMax + yMin)/2;
							center[counter].y = (xMax + xMin)/2;;
							counter++;
							
						}
					}
				}
			}
			// Arrange points
			for(i=0 ; i<counter ; i++) {
				for(j=0 ; j<(counter-1-i) ; j++) {
					if(center[j+1].x < center[j].x  || (center[j+1].x == center[j].x && center[j+1].y < center[j].y)) {
					   Point temp = center[j];
					   center[j] = center[j+1];
					   center[j+1] = temp;
					}
				}
			}
			
			return center;
		}
		       
	}
	public static void main(String[] args) {
		String[] photo = {"8D88888J8L8E888",
				          "88NKMG8N8E8JI88",
				          "888NS8EU88HN8EO",
				          "LUQ888A8TH8OIH8",
				          "888QJ88R8SG88TY",
				          "88ZQV88B88OUZ8O",
				          "FQ88WF8Q8GG88B8",
				          "8S888HGSB8FT8S8",
				          "8MX88D88888T8K8",
				          "8S8A88MGVDG8XK8",
			              "M88S8B8I8M88J8N", 
				          "8W88X88ZT8KA8I8",
			           	  "88SQGB8I8J88W88",
			        	  "U88H8NI8CZB88B8",
			        	  "8PK8H8T8888TQR8"};
		int team = 8;
		int threshold = 9;
		IceHockey obj = new IceHockey();
		obj.findPlayers(photo, team, threshold);
	
		for(i=0 ; i<counter ; i++) {
			System.out.println("("+ center[i].x + "," + center[i].y + ")");
		}
	}

}
