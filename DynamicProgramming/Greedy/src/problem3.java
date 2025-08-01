//shortest job first (CPU scheduling)

import java.util.Arrays;

public class problem3 {
    public static void main(String[] args){
        int[] processes = {4,3,7,1,2};
        int time = 0, waitTime = 0;
        Arrays.sort(processes);
        for(int i=0;i<processes.length;i++){
            waitTime = waitTime + time;
            time = time + processes[i];
        }
        double avgWaitTime = waitTime/processes.length;

        System.out.println(avgWaitTime);
    }
}
