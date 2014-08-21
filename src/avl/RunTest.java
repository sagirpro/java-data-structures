// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package avl;

/**
 * This Test Class will fetch the operation and give feedback according to that
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-20
 */
public class RunTest {
 
 public static void main(String[] args) {
 
//  int[] values = new int[] {23, 18, 12, 8, 14, 20, 44, 52 };
   
  AVLTree tree = new AVLTree(23,18,44,12,20,52,4,14,16); //LR
//  AVLTree tree = new AVLTree(18,12,44,23,52,20,20); //RL 
//  AVLTree tree = new AVLTree(18,20,12,14,8,4); //LL
//  AVLTree tree = new AVLTree(14,12,20,18,23,44); //RR
//  AVLTree tree = new AVLTree(23,18,12);   //simple LL
   
//  AVLTree tree = new AVLTree(50, 20, 80, 10, 30, 60, 90, 70); //test delete
   
  AVLNode root = tree.getRoot();
  System.out.println("Root -> " + root.getValue() + ", with height " + root.getHeight());
  System.out.println("Root -> Left" + root.getLeft().getValue() + ", with height " + root.getLeft().getHeight());
  System.out.println("Root -> Right" +root.getRight().getValue() + ", with height " + root.getRight().getHeight());
 
  System.out.println("Root -> Left -> Left " +root.getLeft().getLeft().getValue() + ", with height " + root.getLeft().getLeft().getHeight());
  System.out.println("Root -> Right -> Right " +root.getRight().getRight().getValue() + ", with height " + root.getRight().getRight().getHeight());
 
  int toBeDeleted = 90;
  System.out.println("After deleting " + toBeDeleted);
  tree.delete(toBeDeleted);
  System.out.println("Root -> " +root.getValue() + ", with height " + root.getHeight());
  System.out.println("Root -> Right" + root.getRight().getValue() + ", with height " + root.getRight().getHeight());
//  System.out.println(root.getRight().getRight().getValue() + ", with height " + root.getRight().getRight().getHeight());
//  System.out.println(root.getRight().getLeft().getValue() + ", with height " + root.getRight().getLeft().getHeight());
//  System.out.println(root.getLeft().getRight() == null);
   
  tree.print(Order.PREORDER);
 
 }
}