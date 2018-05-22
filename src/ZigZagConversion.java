/**
 * ZigZagConversion class
 * Z字形变换
 * @author Chun
 * @date 2018/5/22/
 */
public class ZigZagConversion {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    /**
     * @param s       愿字符串
     * @param numRows 指定的行数
     * @return
     */
    public static String convert(String s, int numRows) {
        int strLength = s.length();

        if (numRows >= strLength || numRows == 1) {
            return s;
        }
//        将如下形状的字符化为一组
//        *
//        *   *
//        * *
//        *
        //计算每组中有多少个字符
        int groupNums = (numRows - 2) * 2 + 2;
        //计算不够一组的字符数
        int lave = strLength % groupNums;
        //计算有多少组
        int groups = strLength / groupNums;
        if (lave > 0) {
            groups += 1;
        }
        StringBuffer sb = new StringBuffer();
        int index;
        char[] chars = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            //处理第一层
            for (int j = 0; j < groups; j++) {
                if (i == 0) {
                    index = groupNums * j;
                    sb.append(chars[index]);
                } else if (i == numRows - 1) {
                    index = (groupNums * j) + numRows - 1;
                    if (index < strLength) {
                        sb.append(chars[index]);
                    }
                } else {
                    //处理中间层
                    //处理下行字符
                    index = (groupNums * j) + i;
                    if (index < strLength) {
                        sb.append(chars[index]);
                    } else {
                        continue;
                    }
                    //处理上行字符
                    index = groupNums * (j + 1) - i;
                    if (index < strLength) {
                        sb.append(chars[index]);
                    }
                }
            }
        }
        return sb.toString();
    }

}