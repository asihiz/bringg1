package common.building_blocks;

import java.util.ArrayList;
import java.util.List;

public class AClass {

    public static List<Integer> getPrimeForRange(Integer num){
        List<Integer> returnList = new ArrayList<>();
        for(int i = 1; i <= num; i++){
            if(isPrime(num)){
                returnList.add(i);
            }
        }
        return null;


    }

    private static boolean isPrime(Integer num){
        for(int i = 1; i <= num; i++){
            if((num / i) != 0){
               return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        getPrimeForRange(10);
    }

}
