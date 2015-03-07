package dselect;

import java.util.Arrays;
import java.util.Scanner;

public class DSelect{
 
    public static int partition(int[] array, int left, int right,int pivot) {
     

        while (left < right) {
         
            while (array[left]< pivot) 
            {
                left++;
            }
            
            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
            if(left>right)//mosh lazm a3ml swap 
            {
            	int tmp = array[left];
                array[left] = pivot;
                pivot = tmp;
            }
        }
     
        return left;
    }
   
	public static int D_Select(int arr[],int len,int k)
	{
		
		int block = 5,p=0;
		if(len <= block)
		{
			Arrays.sort(arr);
			return arr[k];
		}
		int medians_len = (len + block - 1)/block;
		int medians[] = new int[medians_len];
		
		for(int i = 0, j = 0 ; i < medians_len ; i+=block, j++)
		{
			int new_len = Math.min(block, len-i);
			
			int []subArr = new int[new_len];
			System.arraycopy(arr, i, subArr, 0, new_len);
			
			medians[j] = D_Select(subArr,new_len, new_len/2);
		}
		int pivot = D_Select(medians,medians_len,medians_len/2);
		p=partition(arr,0,len-1,pivot);
		if(p==k)
		return pivot;
		else if(p<k)
	    return  D_Select(arr,p-1,k);
		else
			return  D_Select(arr,len-p,p-k);
			
		
		
					
					
}
    



	public static void main(String[] args) {
		
		try{
			System.out.println("Hello Enter the size of arry");
			Scanner n = new Scanner(System.in);
	        int ArrSize = n.nextInt();
	        int [] Arr = new int[ArrSize];
	        System.out.println("enter the element of  array ");
	        for(int i=0;i<ArrSize;i++)
	        {
	            Arr[i] = n.nextInt();
	        }
	        System.out.println("Enter order statistic less than the array size");
	        int I = n.nextInt();
                int p;
                p=D_Select(Arr,ArrSize,I);
	        System.out.println(D_Select(Arr,ArrSize,I));
                 System.out.println("After Dselect : " + Arrays.toString(Arr));
              
                 
		}
		catch(Exception e)
		{
			System.out.println("");
		}	
	}
}

