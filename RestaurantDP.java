import java.util.Scanner;
import java.util.Arrays;

public class RestaurantDP {

	final static int INF = 10000000;

	static int[][] profitArray;
	static String[][] restaurantsChosen;

	public static void main(String[] args){

		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);

		int mileMarks[] = new int[n+1];
		int expProfits[] = new int[n+1];
		mileMarks[0] = 0;
		expProfits[0] = 0;
		for(int i = 0; i<n; i++) {
        mileMarks[i+1] = Integer.parseInt(args[i+2]);
				expProfits[i+1] = Integer.parseInt(args[i+n+2]);
    }

		int maxDist = mileMarks[n];
		int profitArray[][] = new int[n+1][maxDist+1];
		String restaurantsChosen[][] = new String[n+1][maxDist+1];

		for(int i=0; i<n+1; i++){
			for(int j=0; j< maxDist+1; j++){
				if (i == 0){
					profitArray[i][j] = 0;
					restaurantsChosen[i][j] = "Left";
				} else if(mileMarks[i] > j){
					profitArray[i][j] = profitArray[i-1][j];
					restaurantsChosen[i][j] = "Left";
				} else{
					if(mileMarks[i] >= k){
						if ((profitArray[i-1][mileMarks[i]-k] + expProfits[i]) > profitArray[i-1][j]){
							restaurantsChosen[i][j] = "Taken";
							profitArray[i][j] = profitArray[i-1][mileMarks[i]-k] + expProfits[i];
						} else{
							restaurantsChosen[i][j] = "Left";
							profitArray[i][j] = profitArray[i-1][j];
						}
					} else if(j >= 0){
						if(expProfits[i] > profitArray[i-1][j]){
							restaurantsChosen[i][j] = "Taken";
							profitArray[i][j] = expProfits[i];
						} else{
							restaurantsChosen[i][j] = "Left";
							profitArray[i][j] = profitArray[i-1][j];
						}
					}
				}
			}
		}
		//Find group of those chosen
		String restChosen = "";
		int findI = n;
		int findJ = maxDist;
		while(true){
			if(findI>0 && findJ>=0){
				if((restaurantsChosen[findI][findJ]).equals("Taken")){
					restChosen = restChosen +  Integer.toString(findI) + " " ;
					if(findJ >= k){
						findJ = mileMarks[findI] - k;
						findI = findI - 1;
					} else{
						break;
					}
				} else{
					findI = findI - 1;
				}
			} else{
				break;
			}
		}

		if(n>0 && maxDist>0){
			System.out.println(Integer.toString(profitArray[n][maxDist]) + " " + "at " + restChosen);
		}
	}





}
