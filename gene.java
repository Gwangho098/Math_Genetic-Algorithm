package gene;

import java.util.Scanner;

public class gene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("# Generations : ");
		int generations = input.nextInt();
		double num = 0, temp = 0;
		
			   
		double [][] g_f = new double [100][2]; 
		double [] top4 = new double [20];
		for(int i = 0; i < 100; i++) {
			g_f[i][0] = num / 100;
			num = num + 1;
		}
	    
	    for(int k = 0; k < generations - 1; k++) {
	    	for(int i = 0; i < 100; i++) {
				g_f[i][1] = Math.abs(Math.pow(2, g_f[i][0]) - 3*g_f[i][0]);//적합도 측정 및 입력
			}
		    BubbleSort(g_f);
		    Superior(top4, g_f);
		    
		    for(int i = 0; i < 100; i++) {
		    	g_f[i][0] = (top4[(int)(Math.random()*20)] + top4[(int)(Math.random()*20)]) / 2 + Math.random()/1000000 - 0.00000005;//상위 4개의 유전자 중 임의의 2개의 유전자를 후대 유전자에 물려줌, "Math.random() - 0.5"는 변이를 나타냄 	    			 
		    }
	    }
	    
	    for(int i = 0; i < 100; i++) {																							
	    	System.out.print("[" + g_f[i][0] + ", " + g_f[i][1] + "]");
	    } 
	}
	public static void BubbleSort(double [][] arr) {
		double temp = 0;
		for(int i = 0; i < arr.length - 1; i++) {//적합도가 낮은 순서대로 정렬 (버블 정렬 사용)
	    	for(int j = 0; j < arr.length - 1 - i; j++) {
	    		if(arr[j][1] > arr[j + 1][1]) {
	    			temp = arr[j + 1][1];
	    			arr[j + 1][1] = arr[j][1];
	    			arr[j][1] = temp;
	    			
	    			temp = arr[j + 1][0];
	    			arr[j + 1][0] = arr[j][0];
	    			arr[j][0] = temp;
	    		}	
	    	}
	    }
	}
	public static void Superior (double [] arr_s, double [][] arr_g) {
		for(int i = 0; i < arr_s.length; i++) {
			arr_s[i] = arr_g[i][0];
		}
	}

}
