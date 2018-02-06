/**
 * @(#)Interviewanalysis.two_finalreturn.Finalreturn.java Copyright (c) 2014-2018 crimps
 */
package Interviewanalysis.two_finalreturn;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author crimps
 * @version 1.0  2018/2/5
 * @modified crimps  2018/2/5  <创建>
 */
public class Finalreturn {

    public static void main(String[] args) {
        System.out.println("test1:" + test1());
        System.out.println("----------------");
        System.out.println("test2:" + test2());
        System.out.println("----------------");
        System.out.println("test3:" + test3());
        System.out.println("----------------");
        System.out.println("test4:" + test4());
        System.out.println("----------------");
    }

    /**
     * finally在return语句执行之后,返回之前执行
     * @return
     */
    private static int test1() {
        int i = 1;
        try {
            System.out.println("try...");
            return i += 10;
        } catch (Exception e) {
            System.out.println("catch...");
        } finally {
            i++;
            System.out.println("finally...");
            System.out.println("i=" + i);
        }
        return i;

    }

    /**
     * finally块中的return语句覆盖try块中的return
     * @return
     */
    private static int test2() {
        int i = 1;
        try {
            System.out.println("try...");
            return i += 10;
        } catch (Exception e) {
            System.out.println("catch...");
        }finally {
            i++;
            System.out.println("finally...");
            System.out.println("i=" + i);
            return i;
        }
    }

    /**
     * 如果finally语句中没有return语句覆盖返回值，那么原来的返回值可能因为finally里的修改而改变也可能不变。
     * 传值类型的返回值：不变；传址类型的返回值：会变
     * @return
     */
    private static Map<String, String> test3() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("KEY", "INIT");
        try {
            System.out.println("try...");
            map.put("KEY", "TRY");
            return map;
        } catch (Exception e) {
            System.out.println("catch...");
            map.put("KEY", "CATCH");
        } finally {
            System.out.println("finally...");
            map.put("KEY", "FINALLY");
            map = null;
        }
        return map;
    }

    /**
     *  try代码块中的return语句在异常的情况下不会被执行，这样具体返回哪个看情况；
     *  catch中的return执行情况与未发生异常时try中return的执行情况完全一样
     * @return
     */
    private static int test4() {
        int i = 1;
        try {
            System.out.println("try...");
            i = i / 0;
            return i += 10;
        } catch (Exception e) {
            System.out.println("catch...");
            return i;
        } finally {
            i++;
            System.out.println("finally...");
            System.out.println("i=" + i);
        }
    }
}