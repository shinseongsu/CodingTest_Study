package Programers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EqualsNumberUgly {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Integer temp = null;

        for(int i = 0 ; i < arr.length ; i++) {
            if(!Objects.equals(temp, arr[i])) {
                temp = arr[i];
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(s -> s).toArray();
    }
}
