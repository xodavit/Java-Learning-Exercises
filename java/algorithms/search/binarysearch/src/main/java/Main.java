import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10,
                        11,12,13,14,15,16,17,18,19,20,
                        21,22,23,24,25,26,27,28,29,30,
                        31,32,33,34,35,36,37,38,39,40,
                        41,42,43,44,45,46,47,48,49,50,
                        51,52,53,54,55,56,57,58,59,60,
                        61,62,63,64,65,66,67,68,69,70,
                        71,72,73,74,75,76,77,78,79,80,
                        81,82,83,84,85,86,87,88,89,90,
                        91,92,93,94,95,96,97,98,99,100,
                        101,105,108,199,200,
                        201,257,299,
                        555,615,666,777,888,999,
                        1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,
                        10005000,
                        100000000,365365365,999999999));
        ArrayList<Integer> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);
        ArrayList<Integer> shuffleList = new ArrayList<>(list);
        Collections.shuffle(shuffleList);


        System.out.println(list);
        binarySearch(list,number);
        System.out.println();
        binarySearch(list, 50);
        System.out.println();
        binarySearch(list, 32768);
        System.out.println(reverseList);
        System.out.println();
        binarySearch(reverseList, 50);
        System.out.println();
        binarySearch(reverseList, 32768);
        System.out.println(shuffleList);
        System.out.println();
        binarySearch(shuffleList, 50);
        System.out.println();
        binarySearch(shuffleList, 32768);
        int maxCountinList = Integer.MIN_VALUE;
        for (Integer in: list
             ) {
            int count = binarySearch(list,in);
            if (count>maxCountinList) {
                maxCountinList = count;
            }
        }
        int maxCountinReverseList = Integer.MIN_VALUE;
        for (Integer in: reverseList
        ) {
            int count = binarySearch(reverseList,in);
            if (count>maxCountinReverseList) {
                maxCountinReverseList = count;
            }
        }
        int maxCountinShuffleList = Integer.MIN_VALUE;
        for (Integer in: shuffleList
        ) {
            int count = binarySearch(shuffleList,in);
            if (count>maxCountinShuffleList) {
                maxCountinShuffleList = count;
            }
        }
        System.out.println(String.format("Максимальное число циклов в списках:\n упорядоченном = %d,\n развернутом = %d, \n перемешанном = %d",maxCountinList,maxCountinReverseList,maxCountinShuffleList));
    }
    public static int binarySearch(ArrayList<Integer> list, Integer item){
        //System.out.println(String.format("Ищем число %d, размер массива %d", item, list.size()));
        long start = System.currentTimeMillis();
        int low = 0;
        int hight = list.size()-1;
        int count = 1;
        while (low<=hight) {

            System.out.println(String.format("Ищем %d, %d цикл поиска",item,count));
            int mid = (low+hight)/2;
            int guess = list.get(mid);
            //System.out.println(String.format("Ищем %d, Минимальное %d, максимальное %d, среднее %d, угадываемое число в этом цикле =  %d", item,low,hight,mid,guess));
            count++;

            if (guess==item) {
                System.out.println(String.format("искомое число %d найдено, возвращаем индекс числа = %d",item,mid));
                long end = System.currentTimeMillis();
                System.out.println(String.format("Выполнено за %d ms.",end-start));
                //return mid;
                return count;
            }
            else if (guess>item) {
                //System.out.println(String.format("Угадываемое больше искомого, максимальное уменьшено на  среднее -1"));
                hight = mid - 1;
            }
            else {
                //System.out.println(String.format("Угадываемое меньше искомого, минимальное увеличено на среднее +1"));
                low = mid + 1;
            }


        }
        System.out.println("Число не найдено");
        //return -1;
        return  count;
    }
}
