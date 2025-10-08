import java.util.*;
public class Subarraysumequalsk{
    public int subarraySum(int[] nums,int k){
        int res=0;
        int curr=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);

        for(int i:nums){
            curr+=i;
            res+=map.getOrDefault(curr-k,0);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return res;
    }
    public static void main(String args[]){
        Subarraysumequalsk sas = new Subarraysumequalsk();
        int[] nums = {1,2,3};
        int k=6;
        int result=sas.subarraySum(nums,k);
        System.out.println(result); 
    }

}