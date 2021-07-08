package common.building_blocks;

import java.util.ArrayList;
import java.util.List;

public class IsZeroA {

    private List<List<Integer>> retValue = new ArrayList<>();

    public List<List<Integer>> getIsZero(int[] input){
        if((input == null) || (input.length == 0)) {
            System.out.println("Bad data");
            return null;
        }
        int i  = 0;
        int currentSum = 0;
        try {
            while (i >= input.length) {
                try {
                    List<Integer> retCurrentList = new ArrayList<>();
                    for (int j = 0; j <= 3; j++) {
                        retCurrentList.add(input[i+j]);
                        currentSum += input[i+j];
                        if (currentSum == 0) {
                            retValue.add(retCurrentList);
                        }
                    }
                    i+=3;
                } catch (ArrayIndexOutOfBoundsException aoob) {
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}



