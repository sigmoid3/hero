package common;

/**
 * 双重检查，延迟加载
 */
class Singleton4 {
    private static volatile Singleton4 instance;

    private Singleton4() {}

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类实现，延迟加载
 */
class Singleton5 {
    private Singleton5() {}

    private static class SingletonInstance {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}