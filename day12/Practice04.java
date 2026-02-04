// Convert strings to upper/lowercase using streams

import java.util.*;
import java.util.stream.Collectors;
import javax.sound.midi.Soundbank;

public class Practice04 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello" ,"kevin","adi","parth");
        List<String> uppercaseL = list.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        List<String> lowercaseL = list.stream().map(s->s.toLowerCase()).collect(Collectors.toList());

        System.out.println("lowecase : " + lowercaseL);
        System.out.println("uppercase : " + uppercaseL);
        
    }
}
