package text;

import java.util.Random;

public class day1018 {
    public static void main(String[] args) {
//        System.out.println(2,147,483,647);
        System.out.println(10%3);
    }
}
//
abstract class  Animal {
    private String name;
    private int age;

    public Animal() {}

    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println("name:"+name+",age:"+age);
    }

    public void sleep() {
        System.out.println("sleep");
    }

    public void eat() {
        System.out.println("eat");
    }
    abstract public void cc();
}

class Dog extends Animal {
    public Dog() {}

    public Dog(String name,int age) {
        super(name,age);
    }

    public void eat() {
        System.out.println("dog eat");
    }

    @Override
    public void cc() {
        System.out.println("我在狗里面");
    }

    public void sleep() {
        System.out.println("dog sleep");
    }
}

class Cat extends Animal {
    public Cat() {}

    public Cat(String name,int age) {
        super(name,age);
    }

    public void eat() {
        System.out.println("cat eat");
    }

    @Override
    public void cc() {
        System.out.println("我在猫里面");
    }

    public void sleep() {
        System.out.println("cat sleep");
    }
}

