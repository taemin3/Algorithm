import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] array = new int[n];
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for (int i = 0; i < n;i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        
        
        while(pq.size() >= 2)  {
            int a = pq.poll();
            int b = pq.poll();
            
            int newNum = a + b;

            sum += newNum;
            pq.offer(newNum);    
        }

        
        

        System.out.println(sum);

        
        
    }
}