/**
 * ReverseInteger class
 * 反转整数
 * @author Chun
 * @date 2018/5/22/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int result1 = reverse(-2147483640);
        int result2 = reverse2(-2147483640);
        System.out.println(result1);
        System.out.println(result2);
    }
    public static  int reverse(int x) {
        long start = System.currentTimeMillis();
        long y = Long.valueOf(x);
        if (Math.abs(y) < 10) {
            System.out.println("耗时"+(System.currentTimeMillis()-start));
            return x;
        }
        long result=1;
        String sign = "";
        if (y < 0) {
            sign = "-";
            y = Math.abs(y);
        }
        String str = Long.toString(y);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        str = sign+String.valueOf(chars);
        result = Long.valueOf(str);
        if (result <Math.pow(-2, 31)||result>Math.pow(2,31)-1) {
            System.out.println("耗时"+(System.currentTimeMillis()-start));
            return 0;
        }
        System.out.println("耗时"+(System.currentTimeMillis()-start));

        return (int)result;
    }
    public static  int reverse2(int x) {
        long start = System.currentTimeMillis();
        long result=0;
        while (x != 0) {
            result = result * 10;
            result = result + x % 10;
            x = x / 10;
        }
        if (result <Math.pow(-2, 31)||result>Math.pow(2,31)-1) {
            System.out.println("耗时"+(System.currentTimeMillis()-start));
            return 0;
        }
        System.out.println("耗时"+(System.currentTimeMillis()-start));
        return (int)result;

    }
}
