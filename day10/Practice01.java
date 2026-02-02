interface I{
    public int  add(int i,int j);

}

interface gov {
    double gettax(int tm ,double tax);
}


class Practice01 {
    public static void main(String[] args) {
        I i = (a,b) -> { return a+b; };
        System.out.println(i.add(10,20));

        gov g = (a1,b1) -> {return  (a1*b1)/100; };
        System.out.println(g.gettax(10000,5.6));
    }
}


