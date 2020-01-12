import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: xumeng
 * @Date: 2019/12/17 23:01
 */
public class DemoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入和式分解的数字：");
        int i = scanner.nextInt();
        int[] integer = {i};
        if(i> 1){
            show(integer, 0);
        }
    }

    // 递归插入节点游标
    public static void show(int[] arr, Integer index) {
        Integer num = arr[index];
        if(num == 1){
            return ;// 递归结束条件
        }
        int[] newArr;
        for (int i = 1; i < num; i++) {
            int a = i;
            int b = num - i;

            newArr = add(arr, index, a);
            newArr[index + 1] = b;

            System.out.println(Arrays.toString(newArr));

            show(newArr, index);// 左节点
            show(newArr, index + 1);// 右节点
        }
    }

    /**
     * 给指定数组的指定位置插入元素并返回新数组
     * @param arr
     * @param index
     * @param num
     * @return
     */
    public static int[] add(int[] arr, Integer index, Integer num) {
        int[] arr1 = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index) {
                arr1[i] = arr[i];
            } else if (i == index) {
                arr1[i] = num;
                arr1[i + 1] = arr[i];
            } else {
                arr1[i + 1] = arr[i];
            }
        }

        return arr1;
    }


}
