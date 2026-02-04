class Agevalidation extends Exception {
    Agevalidation(String message) {
        super(message);
    }
}

class Voter {
    void Age(double age) throws Agevalidation {
        if (18 > age) {
            throw new Agevalidation("your age is less so your not allow to vote");
        }
        System.out.println("you can vote");
        }
}

class Practice9 {
    public static void main(String[] args) {
        Voter age = new Voter();

        try {
            age.Age(8);
        } catch (Agevalidation e) {
            e.printStackTrace();
        }
    }
}