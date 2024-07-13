/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojun
 * Date: 2024/6/30
 * Time: 下午21:19
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        int n = 100;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.print(i);
            if (i<n){
                System.out.print(" + ");
            }else {
                System.out.print(" = ");
            }
        }
        System.out.print(sum);
    }

}
