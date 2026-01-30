import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movie {
    String name;
    double rating;

    public Movie(double rating,String name) {
        this.rating = rating;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double  getRating(){
        return rating;
    }
}

class sortRating  implements Comparator<Movie>{


    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o1.getRating(), o2.getRating());
    }

    
}
class sortName  implements Comparator<Movie>{


    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getName().compareTo(o2.getName());
    }

}



class Practice02 {

    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie(9.5, "the shawshank  redemption"));
        list.add(new Movie(9, "openheimer"));
        list.add(new Movie(8.9, "the dark khight"));

        System.out.println("sort by rating :-");
        Collections.sort(list,new sortRating());
        for(Movie m1 : list){
            System.out.println(m1.getName() + " " + m1.getRating());
        }

        System.out.println("sort by name :-");
        Collections.sort(list,new sortName());
        for(Movie m2 : list){
            System.out.println(m2.getName() + " " + m2.getRating());
        }

    }
}
    