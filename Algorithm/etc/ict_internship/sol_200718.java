package etc.ict_internship;

public class sol_200718 {
    
    
    //1번 문제
    /*
    List<Integer> sort_height = height;
    이런 식으로 하면 두 리스트가 연결됨. 한쪽이 바뀌면 한쪽도 바뀜
     */
}


//1번문제
/*
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;


class Result {

    public static int countStudents(List<Integer> height) {
        // Write your code here

        int count = 0;
        List<Integer> sort_height = new ArrayList<>();
        sort_height.addAll(height); // height 리스트를 새로운 리스트에 복사 (깊은 복사)

        Collections.sort(sort_height); // 새로운 리스트를 오름차순 정렬

        for(int i = 0; i < height.size(); i++){
            // String s1 = height.get(i).toString();

            // String s2 = sort_height.get(i).toString();
            // System.out.println(s1);
            // System.out.println(s2);
            // if(s1.equals(s2)){
            //     count++;
            // }
            // 리스트 내부 객체를 차례대로 비교하여 값이 서로 다를 경우 count를 증가시킴
            if(!height.get(i).toString().equals(sort_height.get(i).toString()))
                count++;
        }

        return count;

    }

}
*/




//2번문제

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'commonSubstring' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static void commonSubstring(List<String> a, List<String> b) {
        // Write your code here
        Set<String> set = new HashSet<>();
        Set<String> set_A = new HashSet<>();
        Set<String> set_B = new HashSet<>();

        //안씀
        //int largerSize = a.size() >= b.size() ? a.size() : b.size(); //리스트 a, b중 size가 더 크거나 같은 값을 구함

        for(int i = 0; i < a.size(); i++){
            String[] splitWordA = a.get(i).toString().split(""); // a[i]의 문자열을 개별문자로 나눠 String 배열에 저장
            String[] splitWordB = b.get(i).toString().split(""); // b[i]의 문자열을 개별문자로 나눠 String 배열에 저장

            set_A.addAll(Arrays.asList(splitWordA)); // set_A에 a[0]의 문자들을 중복없이 저장
            set_B.addAll(Arrays.asList(splitWordB)); // set_B에 b[0]의 문자들을 중복없이 저장

            //새로운 set에 set_A와 set_B를 합침
            // 두 문자열에 같은 문자가 존재한다면 중복으로 간주하여 제거될 것
            set.addAll(set_A);
            set.addAll(set_B);

            //System.out.println(set);

            // (set에 합치기 전) set_A와 set_B의 크기를 합친 것과 합친 후 set의 크기 비교
            // 값이 같다면 두문자열에 같은 문자가 포함되어 있지 않은 것
            if(set.size() == set_A.size() + set_B.size()){
                System.out.println("NO");
            }
            // 같지 않다면 두문자열에 같은 문자가 포함되어 있는 것
            else{
                System.out.println("YES");
            }

            // 다음 반복에 다시 사용하기 위해 set들 초기화
            set.clear();
            set_A.clear();
            set_B.clear();


            // 안씀
            // for(int j = 0; j < splitWordB.length; j++)
            // {
            //     if(Arrays.asList(splitWordA).contains(splitWordB[j])){
            //         System.out.println("YES");
            //         break;
            //     }
            //     if(j == splitWordB.length - 1){
            //         System.out.println("NO");
            //     }
            // }


            //int sumOfArraySize = splitWordA.length + splitWordB.length;

        }



    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        Result.commonSubstring(a, b);

        bufferedReader.close();
    }
}


//3번 문제
//풀다 말았음
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.satream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY related as parameter.
     */

    public static int countGroups(List<String> related) {

        //ArrayList<String> list = new ArrayList<>();

        String[] res = new String[related.size() * related.size()];

        for(int i = 0; i < related.size() ; i++){
            String[] tmp = related.get(i).toString().split("");
            // list.add(Arrays.asList(tmp));
            System.arraycopy(tmp, 0, res, tmp.length * i, tmp.length);

        }
        System.out.println(Arrays.toString(res));

        return 2;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int relatedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> related = IntStream.range(0, relatedCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = Result.countGroups(related);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


//4번 문제
입력되는 리스트안에 타겟이 12일 경우
6이 하나 있는 경우는 걸러내야되고
6이 2개 있는 경우는 인식해야함. 이거 때문에 if문 하나 추가함

        import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'stockPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stocksProfit
     *  2. LONG_INTEGER target
     */

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        // Write your code here
        List<Long> al_list = new ArrayList<>(); // 사용된 요소를 담을 리스트 - (1,5), (5,1) 경우 중복 저장하는것 막기 위함
        List<Long> res_list = new ArrayList<>(); // stocks의 쌍이 담길 리스트

        for(int i = 0; i < stocksProfit.size(); i++){ // 리스트 전체 반복
            long x = stocksProfit.get(i);
            //System.out.println(x);
            long y = target - stocksProfit.get(i); // i번째 요소와 쌍이 될 수 있는 값을 찾기 위한 변수 y 선언
            //System.out.println(y);
            if(stocksProfit.indexOf((int)x) == stocksProfit.lastIndexOf((int)y)) continue;
            if(stocksProfit.contains((int)y)){ // 그 y가 stocksProfit 리스트에 들어있다면 if문 내부 실행
                //System.out.println("here!");
                if(al_list.contains(x) || al_list.contains(y)){ // 이미 리스트에 담긴 쌍이면 걸러내기 위한 if문
                    continue;
                }

                res_list.add(x); // res_list에 쌍 중 하나인 x를 저장
                res_list.add(y); // res_list에 쌍 중 하나인 y를 저장

                // x, y로 이루어진 쌍을 저장했던 이력을 남기기 위해 al_list에도 저장(후에 또 나타날 중복인 경우의 수를 막기 위함)
                al_list.add(x);
                al_list.add(y);
            }
        }
        System.out.println(res_list);
        System.out.println(al_list);

        // 쌍의 수를 구해 리턴(res_list에 4개 들어있다면 2쌍인 것)
        return res_list.size()/2;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> stocksProfit = IntStream.range(0, stocksProfitCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long target = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.stockPairs(stocksProfit, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


//5번
못품

        import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'connectedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY edges
     */

    public static int connectedSum(int n, List<String> edges) {
        // Write your code here
        // ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        Set<String> set = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set.add(edges.get(0));
        System.out.println(set);
        for(int i = 1; i < edges.size(); i++){
            if(set.contains(edges.get(i))){
                set.add(edges.get(i));
            }
            else{
                set2.add(edges.get(i));
            }
        }

        int isolated_node = n - set.size() - set2.size();


        return 1;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int edgesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> edges = IntStream.range(0, edgesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = Result.connectedSum(n, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
