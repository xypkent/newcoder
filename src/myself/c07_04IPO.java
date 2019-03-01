package myself;

import java.util.Comparator;
import java.util.PriorityQueue;

public class c07_04IPO {

    public static class Project {
        public int cost;
        public int profit;

        public Project(int c, int p) {
            cost = c;
            profit = p;
        }
    }

    public static class MinCompare implements Comparator<Project> {
        public int compare(Project a, Project b) {
            return a.cost - b.cost;
        }
    }

    public static class MaxCompare implements Comparator<Project> {
        public int compare(Project a, Project b) {
            return b.profit - a.profit;
        }
    }
    //w启动资金、k可以做的项目次数
    public int getMaxProfit(int[] cost,int[] profit,int w,int k){
        PriorityQueue<Project> costqueue = new PriorityQueue<>(new MinCompare());
        PriorityQueue<Project> profitqueue = new PriorityQueue<>(new MaxCompare());

        for (int i=0;i!=cost.length;i++){
            costqueue.add(new Project(cost[i],profit[i]));
        }

        while (k > 0){
            while(!costqueue.isEmpty()&&costqueue.peek().cost <= w){
                profitqueue.add(costqueue.poll());
            }
            if (profitqueue.isEmpty()) break;
            w += profitqueue.poll().profit;
            k--;
        }
        return w;
    }

}























