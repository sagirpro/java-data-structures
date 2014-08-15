package priorityqueue;

//StringLengthComparator.java
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String>
{
 @Override
 public int compare(String x, String y)
 {

     if (x.length() < y.length())
     {
         return -1;
     }
     else if (x.length() > y.length())
     {
         return 1;
     }
     else{
    	 return 0;
     }
 }
}