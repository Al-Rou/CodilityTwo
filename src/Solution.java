import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] input = {60,10,30,20,40,50,55,56,57,58,11,12,8,13};
        //int[] input = {2,2,2,2,-1,0};
        //int[] input = {60,50,40,30,20,10};
        System.out.println(s.solution(input));
    }
    public int solution(int[] A) {
        //In case the array is absolutely descending, the answer is 0
        int result = 0;
        List<Integer> list = new ArrayList<>();
        //This boolean checks whether the array is absolutely descending
        boolean check = true;
        for (int i = 0; i < A.length-1; i++)
        {
            //This shows the array is NOT absolutely descending, so check changes for false and
            //the associated index is stored in the list. We need this later!
            if(A[i] < A[i+1])
            {
                check = false;
                list.add(i);
            }
        }
        if(check == false)
        {
            //The result is the first entry of the list unless otherwise is found!
            result = list.get(0);
            //This maps every index, which starts ascend, to the size of ascend. Later, these sizes
            //are compared to each other in order for us to determine the maximum slice!
            HashMap<Integer, Integer> map= new HashMap<>();
            //This counts the size of slice
            int counter = 1;
            //Every entry in the list will have a size of slice, which is determined here!
            for (int j = 0; j < list.size()-1; j++)
            {
                if(list.get(j+1) > (list.get(j)+1))
                {
                    map.put(result, counter);
                    counter = 1;
                    result = list.get(j+1);
                }
                else
                {
                    counter++;
                }
            }
            map.put(result, counter);
            //This list2 is used to store and sort sizes of slices
            List<Integer> list2 = new ArrayList<>();
            for (int a : map.values())
            {
                list2.add(a);
            }
            Collections.sort(list2);
            for(int a : map.keySet())
            {
                //The associated index to the maximum size of slice is determined and stored in result,
                //because it is the answer!
                if(map.get(a) == list2.get(list2.size()-1))
                {
                    result = a;
                }
            }
        }
        return result;
    }
}
