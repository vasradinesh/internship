// Sum even and odd numbers in list using streams

import java.util.*;

public class Practice05 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,3,4,2,8,5);
        int sumeven = list.stream().filter(i->i%2==0).mapToInt(i->i).sum();
        int sumodd = list.stream().filter(i->i%2!=0).mapToInt(i->i).sum();

        System.out.println("sumeven : "+sumeven);
        System.out.println("sumodd : "+sumodd);

    }
}
