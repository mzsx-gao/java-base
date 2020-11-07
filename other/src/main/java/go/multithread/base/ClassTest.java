package go.multithread.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gao on 2018/4/18.
 */
public class ClassTest {

    public static void main(String[] args) {
        System.out.println("hello world");

        Map<Object,String> map = new HashMap<>();
        map.put(null,"nihao");
        System.out.println(map.get(null));
    }

    public int add(int a,int b){
        int c =a +b;
        int d = a-b;
        int e=a*b;
        int f=a/b;
        return 1+1;
    }

    public void iftest(){
        int a=10;
        if(a>10){
            System.out.println(">10");
        }else{
            System.out.println("");
        }
    }

}
