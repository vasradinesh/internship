//Program to implement a lambda expression to calculate the sum of squares of all odd and even numbers in a list.

import java.util.Arrays;
import java.util.List;

public class Practice10 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int sumeven[]={0};
        int sumodd[]={0};
        list.forEach(n-> {
            if(n%2==0){
               
                sumeven[0] = sumeven[0] + (n*n);
            }else{
                sumodd[0] =  sumodd[0] + (n*n);
            }
        });
        System.out.println("even : " + sumeven[0] );
        System.out.println("odd : " + sumodd[0] );

        int evensum = list.stream().filter( n -> n%2==0 ).mapToInt(n-> n*n).sum();
        int oddsum = list.stream().filter( n -> n%2!=0 ).mapToInt(n-> n*n).sum();

        System.out.println("evensum doing by Stream api : " + evensum);
        System.out.println("oddsum doing by Stream api : " + oddsum);

    }
}
