import java.util.*;

class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getage(){
        return age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age;
    }
    
}

class Practice01{
    public static void main(String []args){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(16, "ironman"));
        list.add(new Person(17, "krishna"));
        list.add(new Person(15, "bob"));
        list.add(new Person(18, "gobby"));

        Collections.sort(list);

        for(Person p1 : list){
            System.out.println(p1.getName() + " " + p1.getage());
        }
    }
}