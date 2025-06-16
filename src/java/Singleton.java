package src.java;

public class Singleton {
    // 정적 참조 변수(싱글톤 객체를 담을 변수)
    private static Singleton singletonObject;

    // private 생성자
    private Singleton() {
    }

    // getInstance()
    public static Singleton getInstance() {
        if (singletonObject == null) {
            singletonObject = new Singleton();
        }

        return singletonObject;
    }

    public static void main(String[] args) {
        // private 생성자(에러 발생)
        // Singleton singleton = new Singleton();

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);

        System.out.println(instance1 == instance2);
        System.out.println(instance1 == instance3);
    }
}
