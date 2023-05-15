import java.util.*;
import java.lang.*;

class Arrays {
    public static void pairs_in_subarray(){
        //pairs in given array
        int arr [] = new int [6] ;
        for(int i=0;i<6;i++){
            arr[i] = i ;
        }

        for(int i=0;i<6;i++){
            for(int j=i+1;j<6;j++) System.out.print("("+arr[i]+","+arr[j]+") ");
            System.out.println("");
        }

    }
    public static void print_arr(ArrayList<Integer> arr){
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println() ;
    }

    public static void max_subarray_sum (){
        //prefix sum approach 
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-2);arr.add(1);arr.add(-3);arr.add(4);arr.add(-1);arr.add(2);arr.add(1);arr.add(-5);arr.add(4);

        // int max = -2147483648 ; //minimum  integer in java
    //     ArrayList<Integer> prefix = new ArrayList<>();
    //     prefix.add(arr.get(0));
        
         
    //     //calculating prefix sum
    //     for (int i=1;i<arr.size();i++){
    //         prefix.add(prefix.get(i-1) + arr.get(i));
    //     }

    //     for(int i=0;i<prefix.size();i++){
    //         //i->start variable
    //         //j->end variable
    //         int sum = 0 ;
    //         for(int j=i;j<prefix.size();j++){
    //         sum = (i==0) ? prefix.get(j) : prefix.get(j) - prefix.get(i-1) ;
    //             if(sum >= max)  max = sum ;
    //     }


     
    // }



        // Kadane's Algorithm

        int max = Integer.MIN_VALUE ;
        int sum = 0 ;
        // System.out.println(arr.get(0).getClass());
        for(int i=0;i<arr.size();i++){
            sum= sum + arr.get(i) ;
            if (sum>=max) max = sum  ;
            if(sum<=0) sum = 0 ;
        }

    System.out.println(max);
    }


    public static int trapping_rain_water(int[] height) {
        int [] lh = new int[height.length];
        int [] rh = new int[height.length];
    lh[0] = height[0];
    rh[height.length - 1]= height[height.length - 1] ;
        for(int i=1;i<height.length;i++){
            if(lh[i-1]> height[i]){
                lh[i] = lh[i-1];
            }
            else {
                lh[i] = height[i];
            }
        }
        rh[height.length - 1 ] = height[height.length - 1] ;
        for(int i=height.length - 2 ; i>0 ; i--){
            if (rh[i+1]>height[i]){
                rh[i] = rh[i+1];
            }
            else{
                rh[i] =height[i];
            }
        }

        int ans = 0 ;
        for(int i=1;i<height.length;i++){
            int k = (lh[i]>rh[i]) ? rh[i] : lh[i] ;
            if( k - height[i] > 0) ans+=k - height[i] ;
        }
        return (ans);
        
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        
        sc.close();
    }
}