package Interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JPMCCropInterview{

	public static void main(String[] args)
	{
		new JPMCCropInterview();
	}
	
	public JPMCCropInterview()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		  
		System.out.println("Eneter X size: ");
		int ySize = in.nextInt();
		
		System.out.println("Eneter Y size: ");
		int xSize = in.nextInt();
		
		String[][] field = generateTwoDimensionalArray(ySize, xSize);
		
		for(int iX=0; iX<field.length; iX++)
		{
			for(int iY=0; iY<field[iX].length; iY++)
			{
				field[iX][iY] = Character.toString(waterCrop());
			}
		}
		
		for(int iX=0; iX<field.length; iX++)
			System.out.println(Arrays.toString(field[iX]));
		
		ArrayList<String> cropsWithNoWater = new ArrayList<String>();
		
		//checks if crops have water next to them
		for(int iX=0; iX<field.length; iX++)
		{
			for(int iY=0; iY<field[iX].length; iY++)
			{
				if(field[iX][iY].equals("c"))
				{
					//top left corner
					if(iX==0 && iY==0)
					{
						if(!field[iX+1][iY].equals("w") && !field[iX][iY+1].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					//top center
					if(iX==0 && iY>0 && iY<field[iX].length-1)
					{
						if(!field[iX][iY-1].equals("w") && !field[iX+1][iY].equals("w") && !field[iX][iY+1].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					//top left corner
					if(iX==0 && iY==field[iX].length-1)
					{
						if(!field[iX][iY-1].equals("w") && !field[iX+1][iY].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					
					//left edge
					if(iX>0 && iX<field.length-1 && iY==0)
					{
						if(!field[iX-1][iY].equals("w") && !field[iX][iY+1].equals("w") && field[iX+1][iY].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					//all other options
					if(iX!=field.length-1 && iY!=field[iX].length-1 && iX!=0 && iY !=0)
					{
						if(!field[iX][iY-1].equals("w") && !field[iX-1][iY].equals("w")
								&& !field[iX+1][iY].equals("w") && !field[iX+1][iY].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					//right edge
					if(iX>0 && iX<field.length-1 && iY==field[iX].length-1)
					{
						if(!field[iX-1][iY].equals("w") && !field[iX][iY-1].equals("w") && field[iX+1][iY].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					//bottom left corner 
					if(iX==field.length-1 && iY==0)
					{
						if(!field[iX-1][iY].equals("w") && !field[iX][iY+1].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					//bottom center
					if(iX==field.length && iY>0 && iY<field[iX].length-1)
					{
						if(!field[iX][iY-1].equals("w") && !field[iX-1][iY].equals("w") && !field[iX][iY+1].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					
					//bottom right corner
					if(iX==field.length-1 && iY==field[iX].length-1)
					{
						if(!field[iX][iY-1].equals("w") && !field[iX-1][iY].equals("w"))
							cropsWithNoWater.add("Found non water crop at: " +iX+","+iY);
					}
					

						
				}
			}
		}
		
		if(cropsWithNoWater.size()==0)
			System.out.println("There are no crops without water.");
		else
			for(int i=0; i<cropsWithNoWater.size();i++)
				System.out.println(cropsWithNoWater.get(i));
	}
	
	public static String[][] generateTwoDimensionalArray(int xSize, int ySize)
	{
		String twoDimensionalArray[][] = new String[xSize][ySize];
		for(int iX=0; iX<twoDimensionalArray.length; iX++)
		{
			for(int iY=0; iY<twoDimensionalArray[iX].length; iY++)
			{
				twoDimensionalArray[iX][iY] = Character.toString(waterCrop());
			}
		}
		
		return twoDimensionalArray;
	}
	
	public static char waterCrop()
	{
		String options = "wc";
		Random r = new Random(); // pass options.length;
		int randNumb = r.nextInt(options.length());
		return options.charAt(randNumb);
	}
}