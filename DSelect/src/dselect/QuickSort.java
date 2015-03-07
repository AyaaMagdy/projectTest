package dselect;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort{
 
    public static int partition(int[] array, int left, int right,int pivot) {
     
          int pos=-1;
        while (left <= right) {
         
            while (array[left] <= pivot) 
            {
                 if   ( ( array[ left ] == pivot )  &&  ( pos < 0 ) ) 
                pos = left;
            left++;
            continue;
            }
            
            while (array[right] > pivot) {
                right--;
                 continue;
            }

            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        int tmp = array[left-1];
                array[left-1] = array[pos];
                array[pos] = tmp;
        return left;
    }
   
	public static int D_Select(int arr[],int len,int k)
	{
		int t=0;
		int block = 5;
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
		t=partition(arr,0,len-1,pivot);
                if(t==k)
		return pivot;
                if(t>k)
                {
                   t= D_Select(arr,t-1,k);
                    return t;
                }
                if(t<k)
                {
                    t= D_Select(arr,len-t,k-t);
                    return t;
                }
                else
                    return 0;
                
                
		
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
                 //System.out.println("After Dselect : " + Arrays.toString(Arr));
              
                 
		}
		catch(Exception e)
		{
			System.out.println("");
		}	
	}
}

