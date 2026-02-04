//creating thread using lamda expression

class Practice01{
    public static void main(String []args){
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        };
        Thread t1 = new Thread(r);
        t1.run();
        System.out.println(t1.currentThread().getName());
    }
}