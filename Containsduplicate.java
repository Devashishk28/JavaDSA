//Dsa Day 4(question 2).
//contains duplicate
import java.util.*;
public class Containsduplicate{
    public static void containsduplicate(int nums[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);

            }
            else 
                { 
                    map.put(nums[i],1);
                
            }
        }

        for(Integer key:map.keySet()){
            if(map.get(key)>n/n){
                System.out.println(key);
            }
            else{
                System.out.println("False");
                break;
            }
        }
    }

    public static void main(String args[]){
        int nums[]={1,2,3,4,5,6,8};
        containsduplicate(nums);
    }
}
