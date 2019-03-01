package myself;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class c07_06BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static class MinEndCompare implements Comparator<Program> {
        public int compare(Program a, Program b) {
            return a.end - b.end;
        }
    }

    //项目和开始时间
    public static int maxMeetingNum(Program[] programs, int start) {
        Arrays.sort(programs,new MinEndCompare());
        int num = 0;
        for (int i=0;i!=programs.length;i++){
            if (programs[i].start >= start){
                num++;
                start = programs[i].end;
            }
        }
        return num;
    }


}





























