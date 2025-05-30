package src.java;

public class Dog extends Animal {
    Dog(String name){
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " sound");
    }
}

abstract class Animal {
    String name;

    Animal(String name) {  this.name = name;    }

    void eat(){
        System.out.println(name + " eat");
    }
    abstract void makeSound(); // 추상 메서드 - 자식 클래스가 구현해야 함
}

class main {
    public static void main(String[] args) {
        Dog dog = new Dog("Dog");
        dog.makeSound();
        dog.eat();
    }
}