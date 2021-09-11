package test_Dome;

interface Sport {
    //跳高功能
    public abstract void jump();
}

//动物抽象类
abstract class Animal {
    private String name;
    private int age;

    public Animal(){}

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

    //睡觉
    public void sleep() {
        System.out.println("动物们要睡觉");
    }

    //吃饭
    public abstract void eat();
}

//猫
class Cat extends Animal {
    public Cat(){}

    public Cat(String name,int age) {
        super(name,age);
    }

    public void eat() {
        System.out.println("猫吃鱼");
    }
}

//具备跳高功能的猫
class JumpCat extends Cat implements Sport {
    public JumpCat(){}

    public JumpCat(String name,int age) {
        super(name,age);
    }

    public void jump() {
        System.out.println("猫来了一个后空翻跳过了栏杆");
    }
}

//狗
class Dog extends Animal {
    public Dog(){}

    public Dog(String name,int age) {
        super(name,age);
    }

    public void eat() {
        System.out.println("狗吃肉");
    }
}

//具备跳高功能的狗
class JumpDog extends Dog implements Sport {
    public JumpDog(){}

    public JumpDog(String name,int age) {
        super(name,age);
    }

    public void jump() {
        System.out.println("狗腾空而起越过了围墙");
    }
}

class spotify {
    public static void main(String[] args) {
        //跳高猫
        //无参
        JumpCat jc = new JumpCat();
        jc.setName("机器猫");
        jc.setAge(5);
        System.out.println(jc.getName()+"---"+jc.getAge());
        jc.sleep();
        jc.eat();
        jc.jump();
        //带参...

        //多态
        Animal a = new JumpCat();
        a.setName("蓝猫");
        a.setAge(6);
        System.out.println(a.getName()+"---"+a.getAge());
        a.sleep();
        a.eat();
        //a.jump();

        //多态
        Sport s = new JumpCat();
        s.jump();
//        s.eat();
        //s.sleep();
    }
}