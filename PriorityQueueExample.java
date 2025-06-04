import java.util.PriorityQueue;
public class PriorityQueueExample{
public static void main(String [] args){
PriorityQueue<Integer> pq=new PriorityQueue<>();
pq.offer(30);
pq.offer(10);
pq.offer(20);
System.out.println("priorityQueue(min-Heap):");
while(!pq.isEmpty()){
System.out.println(pq.poll());
}
PriorityQueue<Integer> maxpq=new PriorityQueue<>((a,b)->b-a);
maxpq.offer(10);
maxpq.offer(30);
maxpq.offer(20);
System.out.println("Priority Queue(max-Heap):");
while(!maxpq.isEmpty()){
System.out.println(maxpq.poll());
}
}
}