
import java.util.*;

//sorting custeom object by using lamda expression

class student{

    int id;
    String name;

    public student(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

public class Practice02 {
    public static void main(String[] args) {
        List<student> l = new ArrayList<>();
        l.add(new student(1, "adii"));
        l.add(new student(2, "dadi"));
        l.add(new student(3, "mari"));


        Collections.sort(l, (a,b) -> Integer.compare(b.getId(),a.getId()));

        for (student s : l) {
            System.out.println("id : " + s.getId() + " name : " + s.getName());
        }

        
    }
}
