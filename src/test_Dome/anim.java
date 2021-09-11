package test_Dome;

public class anim {
//    public Object smoke;

    anim(){
        System.out.println("我是动物集合!!");

    }
    void eat(){
        System.out.println("吃东西");
    }
    void fun(){
        System.out.println("狩猎");
    }

}

class dog extends anim {
dog(){
    System.out.println("我是狗");
}
void eat(){
    System.out.println("吃猫");
}
void fun(){
    System.out.println("抓猫");
}
}

class cat extends anim implements Smoke {
    cat(){
        System.out.println("我是猫");
    }
    void eat(){
        System.out.println("我吃老鼠");
    }
    void fun(){
        System.out.println("抓老鼠");
    }

    @Override
    public void smoke() {
        Smoke.super.smoke();
    }
}
