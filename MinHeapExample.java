import java.util.*;
public static MinHeapExample{
public static void main(String[]args){
priorityQueue<Integer>minHeap=new priorityQueue<>();
minHeap.add(10);
minHeap.add(5);
minHeap.add(20);
minHeap.add(3);
while(!minHeap.isEmpty()){
System.out.print(minHeap.poll()+" ");
}
}
}