import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int n = a.length();
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            if (a.charAt(i) == '1') {
                sum += Math.pow(2, n - 1 - i);
            }
        }
        boolean flag = false;
        for (int i = 0 ; i < n ; i++) {
            if (a.charAt(i) == '0') {
                sum += Math.pow(2, n - 1 - i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            sum -= 1;
        }
        System.out.println(sum);
    }
}