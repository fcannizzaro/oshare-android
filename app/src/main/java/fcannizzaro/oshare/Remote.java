package fcannizzaro.oshare;

import com.fcannizzaro.oshare.Oshare;

/**
 * Generated by Oshare (https://github.com/fcannizzaro/oshare)
 * @author Francesco Cannizzaro (fcannizzaro)
 * @version 1.0.2
 */
public class Remote {
    public static class api {
        public static int value;
        public static void run(Object ... args) {
            Oshare.invoke("api.run", args);
        }
        public static class submodule {
            public static void hello(Object ... args) {
                Oshare.invoke("api.submodule.hello", args);
            }
        }
    }
    public static class api2 {
        public static int value;
        public static void run(Object ... args) {
            Oshare.invoke("api2.run", args);
        }
        public static class submodule {
            public static void hello(Object ... args) {
                Oshare.invoke("api2.submodule.hello", args);
            }
        }
    }
    public static class obj {
        public static String node;
        public static int number;
        public static boolean flag;
    }
}