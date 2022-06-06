package gao.javabase.algorithm.leetcode.bit.base;

import java.io.UnsupportedEncodingException;

/**
 * @author  gaosd
 * @description ：位运算
 */
public class IntToBinary {
	
    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println("the 4 is : " + Integer.toBinaryString(4));
        System.out.println("the 6 is : " + Integer.toBinaryString(6));

        //位与&(1&1=1 0&0=0 1&0=0)
        System.out.println("the 4&6 is : " + Integer.toBinaryString(6&4));

        //位或|(1|1=1 0|0=0 1|0=1)
        System.out.println("the 4|6 is : " + Integer.toBinaryString(6|4));

        //位非~(~1=0  ~0=1)
        System.out.println("the ~4 is : " + Integer.toBinaryString(~4));

        //位异或^(1^1=0 1^0=1  0^0=0)
        System.out.println("the 4^6 is : " + Integer.toBinaryString(6^4));
        System.out.println("the 17^17 is : " + Integer.toBinaryString(17^17));

        System.out.println("the -234567 is : " + Integer.toBinaryString(-234567));
        //有符号右移>>(若正数,高位补0,负数,高位补1)
        System.out.println("the 4>>1 is : " + Integer.toBinaryString(4>>1));
        System.out.println("the -234567>>1 is : " + Integer.toBinaryString(-234567>>1));
        System.out.println("");
        //有符号左移<<(若正数,高位补0,负数,高位补1)
        System.out.println("the -234567<<16 is : " + Integer.toBinaryString(-234567<<16));
        System.out.println("");

        //无符号右移>>>(不论正负,高位均补0)
        System.out.println("the 234567 is : " + Integer.toBinaryString(234567));
        System.out.println("the 234567>>>4 is : " + Integer.toBinaryString(234567>>>4));
        System.out.println("");
        //无符号右移>>>(不论正负,高位均补0)
        System.out.println("the -4 is : " + Integer.toBinaryString(-4));
        System.out.println("the -4>>>4 is : " + Integer.toBinaryString(-4>>>4));
        System.out.println("the -4>>4 is : " + Integer.toBinaryString(-4>>1));

        /*取模a % (2的幂) 等价于 a & (2的幂 - 1)*/
        System.out.println("the 345 % 32 is : " + (345%32)+" or "+(345&(32-1)));

        /*判断奇偶数*/
        System.out.println(4 % 2 == 0 ? "偶数":"奇数");
        System.out.println(5 % 2 == 0 ? "偶数":"奇数");

        System.out.println((4 & 1) == 0 ? "偶数":"奇数");
        System.out.println((5 & 1) == 0 ? "偶数":"奇数");

        /*实现数字翻倍或减半*/
        System.out.println(9>>1);
        System.out.println(9<<1);

        /*交换两数*/
        int a = 4 ,b = 6;
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a="+a+",b="+b);

        /*不借助临时变量交换两数*/
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a="+a+",b="+b);

        /*位操作交换两数*/
        a=a^b;
        b=a^b;// b=(a^b)^b=a^(b^b)=a
        a=a^b;// a=(a^b)^a=(a^a)^b=b
        System.out.println("a="+a+",b="+b);
    }
}