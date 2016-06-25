/**
 * Created by Dhaval on 6/2/2016.
 */

class Gap{

    private int fromPosition;
    private int toPosition;

    public Gap(int fromPosition, int toPosition) {
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public int getFromPosition() {
        return fromPosition;
    }

    public void setFromPosition(int fromPosition) {
        this.fromPosition = fromPosition;
    }

    public void setToPosition(int toPosition) {
        this.toPosition = toPosition;
    }

    public int getToPosition() {
        return toPosition;

    }

}
public class FrogJump {

    public static int solution(int a[], int x, int d){

        Gap[] gaps = new Gap[x/d+1];
        for(int i = 0; i < gaps.length; i++){
            gaps[i] = new Gap(Integer.MAX_VALUE, Integer.MIN_VALUE);

        }
        gaps[0].setFromPosition(0);
        gaps[0].setToPosition(0);
        gaps[gaps.length-1].setFromPosition(x);
        gaps[gaps.length-1].setToPosition(x);
        int disconnectedGapsCount = gaps.length-2;
        boolean[] isConnected = new boolean[gaps.length];
        isConnected[0] = true;
        isConnected[isConnected.length-1] = true;

        for(int i = 0; i<a.length; i++){
            int currentPos = a[i];
            int currentPosGap = currentPos/d;
            gaps[currentPosGap].setFromPosition(Math.min(gaps[currentPosGap].getFromPosition(), currentPos));

            if(currentPosGap == 0 || currentPosGap == gaps.length-1){
                continue;
            }
            Gap currentGap = gaps[currentPosGap];
            Gap previousGap = gaps[currentPosGap - 1];
            Gap nextGap = gaps[currentPosGap + 1];

            if((currentGap.getFromPosition()- previousGap.getToPosition()) <= d && (nextGap.getFromPosition() - currentGap.getToPosition())
                <=d && !isConnected[currentPosGap]){
                disconnectedGapsCount--;
                isConnected[currentPosGap] = true;
            }
            if(disconnectedGapsCount <= 0){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = {1,3,1,4,2,5,6};
        System.out.println(solution(a,7,3));
    }
}
