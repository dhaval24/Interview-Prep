/**
 * Created by Dhaval on 6/4/2016.
 */
public class FrogJump1 {

    public static int solution(int[] a, int x, int d){

        if(d >= x){
            return 0;
        }

        int[] distTime = new int[x];

        for(int i = 0; i < distTime.length; i++){

            distTime[i] = Integer.MAX_VALUE;
        }

        for(int i = a.length-1; i >= 0; i--){
            int num = a[i];
            distTime[num] = i;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < distTime.length; i = i+d){
            count  = 0;
            for(int j = 0; j < i; j++){
                if(distTime[j] == Integer.MAX_VALUE){
                    count++;
                }
            }
            if(count == d){
                return -1;
            }
        }

        for(int i = distTime.length-1; i >= 0; i = i-d){

            for(int j = i; j > i-d && j >= 0; j--){

                min = Math.min(min, distTime[j]);

            }

            max = Math.max(max, min);
        }

        return max;
    }

    public static void main(String[] args) {

//        int[] a = {1,3,1,4,2,5,6};
//        System.out.println(solution(a,7,3));

        int[] a = {1,2,5,6};
        System.out.println(solution(a,7,2));


    }
}
