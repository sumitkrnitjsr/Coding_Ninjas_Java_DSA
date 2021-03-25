package graph;
import java.util.Scanner;
import java.util.ArrayList;
/*
A fishmonger wants to bring his goods from port to the market. On his route, he has to traverse an area with many tiny city states. Of course he has to pay a toll at each border.
Because he is a good business man, he wants to choose the route in such a way that he has to pay as little money for tolls as possible. On the other hand, he has to be at the market within a certain time, otherwise his fish start to smell.
Given n number of states and the time t in which he has to reach the market. You need to find and print the minimum toll amount that he has to pay in order to reach the market in given time. The first state is the port and last one is the market.
*/



class Pair2{
    int time;
    int toll;
    public Pair2(){
        
    }
    public Pair2(int x,int y){
        time = x;
        toll = y;
    }
}

public class fishMonger {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        Pair2[][] tt = new Pair2[n][n];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
              tt[i][j] = new Pair2();
              tt[i][j].time = in.nextInt();  
            }
        }
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
              tt[i][j].toll = in.nextInt();  
            }
        }
        
        int src = 0;
        int dest = n-1;
        
        boolean[] visited = new boolean[n];
        Pair2[] tltm = new Pair2[n];
        
        for(int i = 0;i < n;i++){
            tltm[i] = new Pair2(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        
        tltm[src] = new Pair2(0,0);
        
        for(int i = 0;i < n;i++){
            int minIndex = -1;
            for(int j = 0;j < n;j++){
                if(!visited[j] && (minIndex == -1 || tltm[j].toll < tltm[minIndex].toll)){
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for(int k = 0;k < n;k++){
                if(!visited[k] && tltm[minIndex].toll != Integer.MAX_VALUE){
                    int toll = tltm[minIndex].toll + tt[minIndex][k].toll;
                    int time = tltm[minIndex].time + tt[minIndex][k].time;
                    if(toll > tltm[k].toll){
                        
                    }else if(toll == tltm[k].toll){
                        if(time < tltm[k].time){
                            tltm[k].time = time;
                        }
                    }else{
                        if(time <= tltm[k].time){
                            tltm[k].toll = toll;
                        }
                    }
                }
            }
        }
        
        System.out.println(tltm[n-1].toll);
    }
}

