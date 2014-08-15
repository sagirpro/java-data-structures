package priorityqueue;

//Test.java
import java.util.Comparator;
import java.util.PriorityQueue;

public class Operator
{
public static void main(String[] args)
{
   Comparator<String> comparator = new StringLengthComparator();
   PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);
   
   queue.add("I am very happy");
   queue.add("sad");
   queue.add("I am feeling awesome ! wow !");
   System.out.println("Here is the priority output <> based on the size of the string : ");
   while (queue.size() != 0)
   {
       System.out.println(queue.remove());
   }
}
}
