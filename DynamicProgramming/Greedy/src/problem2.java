import java.util.Arrays;

//N meetings in one room
public class problem2 {
    static class Meeting{
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args){
        Meeting[] arr = {new Meeting(0,5), new Meeting(3,4), new Meeting(1,2), new Meeting(5,9), new Meeting(5,7), new Meeting(8,9)};
        Arrays.sort(arr, (a, b)-> a.end - b.end);

        int count = 1;
        int freeTime = arr[0].end;
        for(int i=1;i<arr.length;i++){
            if(arr[i].start>freeTime){
                count++;
                freeTime = arr[i].end;
            }
        }

        System.out.println(count);
    }
}
