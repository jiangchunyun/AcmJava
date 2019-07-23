//判断一个字符串是不是数 例如：+123   123   -123   12.3   11.   .456   11.22E+45   11.33e-123

import java.util.Scanner;

public class IsNumber {
    public static Integer index= new Integer(0);
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(isNumber(str));
    }

    public static boolean isNumber(String str) {
        if (str.length() <= 0)
            return false;
        boolean number=scanNumber(str);
        if(index<str.length()&&str.charAt(index)=='.'){
            index++;
            number=unsignNumber(str)||number;
        }
        if(index<str.length()&&(str.charAt(index)=='e'||str.charAt(index)=='E')){
            index++;
            number=number&&scanNumber(str);
        }
        return number&&index==(str.length());
    }

    public static boolean unsignNumber(String str) {
        Integer start = index;
        for (; index < str.length(); index++) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            } else {
                break;
            }
        }
        return start != index;
    }

    public static boolean scanNumber(String str) {
        if (index<str.length()&&(str.charAt(index) == '+' || str.charAt(index) == '-')) {
            index++;
        }
        return unsignNumber(str);
    }


}
