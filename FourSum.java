import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

 


public class FourSum {
    
    // Brute force 
    // TC -> (O(n^4))
    // static List<List<Integer>> FourSum(int[] arr, int target) {
    //     int n = arr.length;
    //     HashSet<List<Integer>> st = new HashSet<>(); // TC -> on avg -> O(1), and on worst case -> O(Log(m))

    //     // TC -> O(n^4)
    //     // SC -> O(n^4)
    //     for (int i=0; i<n; i++) { // TC -> O(n)
    //         for (int j=i+1; j<n; j++) { // TC -> O(n)
    //             for (int k=j+1; k<n; k++) { // TC -> O(n)
    //                 for (int l=k+1; l<n; l++) { // TC -> O(n)
    //                     long sum = arr[i] + arr[j];
    //                     sum += arr[k];
    //                     sum += arr[l];
    //                     if (sum == target) {
    //                         List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
    //                         Collections.sort(temp); // (m Log(m)) where m = 4
    //                         st.add(temp);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(st);
    //     return ans;
    // }


    // Better solution 
    // TC -> O(n^3 Log(m))
    // SC -> O(n) + O(n^3)
    // static List<List<Integer>> FourSum(int[] arr, int target) {
    //     int n = arr.length;
    //     HashSet<List<Integer>> st = new HashSet<>(); // TC -> on avg -> O(1), and on worst case -> O(Log(m))
    //     // TC -> O(n^3)
    //     for (int i=0; i<n; i++) { // TC -> O(n)
    //         for (int j=i+1; j<n; j++) { // TC -> O(n)
    //             HashSet<Long> hashSt = new HashSet<>(); // TC -> O(Log(n))
    //             for (int k=j+1; k<n; k++) { // TC -> O(n)
    //                 long sum = arr[i] + arr[j] + arr[k];
    //                 long fourth = target - sum;
    //                 if (hashSt.contains(fourth)) {
    //                     List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],(int)fourth);// TC -> O(4)
    //                     Collections.sort(temp); // (m Log(m)) where m = 4
    //                     st.add(temp);
    //                 }
    //                 hashSt.add((long)arr[k]);
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(st);
    //     return ans;
    // }


    // Oprimal solution 
    // TC -> O(n^3) + O(nLog(n))
    // SC -> O(1) + O(n^3)or O(number of quadruplet)
    static List<List<Integer>> FourSum(int[] arr, int target) {
        // TC -> O(nLog(n))
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        // TC -> O(n^3)
        for (int i=0; i<n; i++) { // TC -> O(n)
            if (i > 0 && arr[i] == arr[i-1]) continue;
            for (int j=i+1; j<n; j++) { // TC -> O(n)
                if (j!=i+1 && arr[j] == arr[j-1])continue;
                int k = j+1;
                int l = n-1;
                while (k < l) { // TC -> O(n)
                    long sum = arr[i] + arr[j];
                    sum += arr[k] + arr[l];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k-1]) k++;
                        while (k < l && arr[l] == arr[l+1]) l--;
                    }
                    else if (sum < target) k++;
                    // sum > target
                    else l--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        int target = 8;

        List<List<Integer>> ans = FourSum(arr,target);
        System.out.println(ans);
    }

}
