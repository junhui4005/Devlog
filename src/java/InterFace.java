package src.java;

public class InterFace {

    static class Cat implements Animal {
        @Override
        public void eat() {
            System.out.println("cat eat");
        }

        @Override
        public void makeSound() {
            System.out.println("cat makeSound");
        }
    }

    interface Animal {
        void eat();
        void makeSound();
    }

    public static void main(String[] args) {
        InterFace.Cat cat = new InterFace.Cat();
        cat.eat();
        cat.makeSound();
    }
}

