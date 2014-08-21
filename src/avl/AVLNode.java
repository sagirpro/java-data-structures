// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package avl;

/**
 * This Class will define every kind of nodes needed and its operations.
 * Here the preorder, inorder & postorder operations are defined.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-20
 */
public class AVLNode {
 
 protected AVLNode left, right, parent;
 protected Integer value, height;
 private Object object; //enable the AVLTree to store additional info
  
 public AVLNode(int value){
  this.value = value;
  this.height = 0;
 }
  
 public AVLNode(int value, Object object){
  this.value = value;
  this.height = 0;
  this.object = object;
 }
  
 public AVLNode(AVLNode node){
  this.value = node.value;
  this.height = node.height;
  this.left = node.left;
  this.right = node.right;
 }
  
 public Object getObject() {
  return object;
 }
 
 public void setObject(Object object) {
  this.object = object;
 }
  
 public int getValue(){
  return value;
 }
  
 public AVLNode getParent() {
  return parent;
 }
  
 public AVLNode getLeft() {
  return left;
 }
  
 protected void setLeft(AVLNode left){
  this.left = left;
  if (left != null)
   left.parent = this;
 }
  
 public AVLNode getRight() {
  return right;
 }
  
 protected void setRight(AVLNode right){
  this.right = right;
  if (right != null)
   right.parent = this;
 }
  
 public int getHeight() {
  return height;
 }
  
 public int getLevel(){
  int level = 0;
  AVLNode currentNode = this;
  while ((currentNode = currentNode.parent) != null)
   level++;
  return level;
 }
  
 protected int getBalanceFactor(){
  int leftHeight = getLeftHeight();
  int rightHeight = getRightHeight();
  return leftHeight - rightHeight;
 }
  
 protected void insertToLeaf(AVLNode node){
  if (node.value == value){
   System.out.println("Duplicate node " + value);
   return;
  }
  else {
   if (node.value < value){
    if (left == null)   setLeft(node);
    else left.insertToLeaf(node);
   }
   else {
    if (right == null) setRight(node);
    else right.insertToLeaf(node);
   }
  }
 }
  
  
 /**rotate right
  * change of height should be added;
  * applies to the LL type situation 
  */
 protected AVLNode rotateRight(){
  AVLNode newRight = new AVLNode(this);
  newRight.height = getRightHeight() + 1;
  newRight.setLeft(left.right);
  left.setRight(newRight);
  left.adjustHeight();
  return left;
 }
 
 /**
  * rotate left
  * change of height should be added;
  * applies to the LL type situation 
  */
 protected AVLNode rotateLeft(){
  AVLNode newLeft = new AVLNode(this);
  newLeft.height = getLeftHeight() + 1;
  newLeft.setRight(right.left);
  right.setLeft(newLeft);
  right.adjustHeight();
  return right;
 }
  
 protected void adjustHeight(){
  int leftHeight = getLeftHeight();
  int rightHeight = getRightHeight();
  height = (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
 } 
  
 protected int getLeftHeight(){
  return left == null ? -1 : left.height; 
 }
  
 protected int getRightHeight(){
  return right == null ? -1 : right.height;
 }
  
 protected boolean isLeaf(){
  return left == null && right == null;
 }
  
 protected AVLNode getLeftmost(){
  AVLNode leftmost = this;
  while (leftmost.left != null)
   leftmost = leftmost.left;
  return leftmost;
 }
  
 protected AVLNode getRightmost(){
  AVLNode rightmost = this;
  while (rightmost.right != null)
   rightmost = rightmost.right;
  return rightmost;
 }

 //RECURTIONS 
 
 protected void print_preorder(){
  System.out.print(value + " ");
  if (left != null) left.print_preorder();
  if (right != null) right.print_preorder();
 }
 
 protected void print_inorder(){
  if (left != null) left.print_inorder();
  System.out.print(value + " ");
  if (right != null) right.print_inorder();
 }
  
 protected void print_postorder(){
  if (left != null) left.print_postorder();
  if (right != null) right.print_postorder();
  System.out.print(value + " ");
 }
}
