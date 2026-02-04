
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice11 {
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(1,2,3,4,5));
        l.add(Arrays.asList(6,7,8,9,10));
        l.add(Arrays.asList(11,12,13,14,15));

        l.stream().flatMap(s->s.stream()).forEach(s->System.out.println(s));
        l.stream().forEach(s->System.out.println(s));
        l.stream().flatMap(s->s.stream()).map(s->s*10).forEach(s->System.err.println(s));

    }
}
