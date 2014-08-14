// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package heap;

/**
 * The HeapSort program simply take a series of input and sort
 * them using Heap Sort algorithm. The Heap follows a data
 * structure that,  "If A is a parent node of B then the key
 * of node A is ordered with respect to the key of node B 
 * with the same ordering applying across the heap. Either 
 * the keys of parent nodes are always greater than or equal 
 * to those of the children and the highest key is in the root 
 * node (this kind of heap is called max heap)". We will use 
 * Maxheap to sort the series of number.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-09
 */

public class HeapSort 
{ 
    private static int[] a; 
    private static int n; 
    private static int left; 
    private static int right; 
    private static int largest;
    
    public static void buildheap(int []a){ 
        n=a.length-1; 
        for(int i=n/2;i>=0;i--){ 
            maxheap(a,i); 
        } 
    } 
    
    public static void maxheap(int[] a, int i){ 
        left=2*i; 
        right=2*i+1; 
        if(left <= n && a[left] > a[i]){ 
            largest=left; 
        } 
        else{ 
            largest=i; 
        }         
        if(right <= n && a[right] > a[largest]){ 
            largest=right; 
        } 
        if(largest!=i){ 
            exchange(i,largest); 
            maxheap(a, largest); 
        } 
    } 
    
    public static void exchange(int i, int j){ 
        int t=a[i]; 
        a[i]=a[j]; 
        a[j]=t; 
        } 
    
    public static void sort(int [] a0){ 
        a=a0; 
        buildheap(a); 
        
        for(int i=n;i>0;i--){ 
            exchange(0, i); 
            n=n-1; 
            maxheap(a, 0); 
        } 
    } 
    
    public static void main(String[] args) { 
        int [] input={4,1,3,2,16,9,10,14,8,7}; 
        sort(input); 
        for(int i=0;i<input.length;i++){ 
            System.out.print(input[i] + " "); 
        } 
    } 
}