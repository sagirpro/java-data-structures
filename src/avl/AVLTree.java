// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package avl;

/**
 * This Class will collect the input into a varargs :) and process it through 
 * avl tree operation.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-20
 */

public class AVLTree {

private AVLNode root;

public AVLTree(int... values) {
 for (int value : values)
  insert(value);
}

public AVLNode getRoot() {
 return root;
}

public void insert(AVLNode node){
 if (root == null)
  root = node;
 else {
  root.insertToLeaf(node);
  AVLNode keyNode = updateHeightsAndDetectKeyNode(node);
  if (keyNode != null) // rotate to adjust the tree
   adjustTreeByRotation(keyNode);
 }
}
 
private void insert(int value){
 if (root == null)
  root = new AVLNode(value);
 else {
  AVLNode newNode = new AVLNode(value);
  root.insertToLeaf(newNode);
  AVLNode keyNode = updateHeightsAndDetectKeyNode(newNode);
  if (keyNode != null) // rotate to adjust the tree
   adjustTreeByRotation(keyNode);
 }
}

public void delete(AVLNode node){
 int value = node.value;
 delete(value);
}
 
public void delete(int value) {
 AVLNode parentOfDeletedLeaf = deleteBeforeAdjustment(value);
 if (parentOfDeletedLeaf != null) {
  AVLNode keyNode = detectKeyNode(parentOfDeletedLeaf);
  if (keyNode != null){
   AVLNode newkeyNode = adjustTreeByRotation(keyNode);
   updateHeights(newkeyNode.parent);
  }
 } else {
  System.out.println("The AVLTree doesn't contain " + value);
 }
}

private AVLNode detectKeyNode(AVLNode parentOfDeletedLeaf){
 AVLNode currentNode = parentOfDeletedLeaf;
 while (currentNode != null) {
  int bf = currentNode.getBalanceFactor();
  if (bf == 2 || bf == -2)
   return currentNode;
  else
   currentNode = currentNode.parent;
 }
 return null;
}
 
private AVLNode deleteBeforeAdjustment(int value) {
 AVLNode currentNode = root;
 while (currentNode != null) {
  if (currentNode.value == value)
   break;
  else
   currentNode = value < currentNode.value ? 
    currentNode.left : currentNode.right;
 }

 if (currentNode != null) {
  while (!currentNode.isLeaf()) {
   AVLNode replacement = currentNode.getBalanceFactor() < 0 ? 
    currentNode.right.getLeftmost() : currentNode.left.getRightmost();
   currentNode.value = replacement.value;
   currentNode = replacement;
  }

  AVLNode parent = currentNode.getParent();
  if (parent == null) root = null;
  else if (currentNode == parent.left) 
   parent.setLeft(null);
  else
   parent.setRight(null);
  updateHeights(parent);
  return parent;
 }
 return null;
}

private void updateHeights(AVLNode fromParentOfDeletedLeaf){
 AVLNode currentNode = fromParentOfDeletedLeaf;
 currentNode.adjustHeight();
 while (currentNode != null){
  currentNode.adjustHeight();
  currentNode = currentNode.parent;
 }
}
 
/**
 * called by insert(int) keyNode: the node closest to the newly inserted
 * node where |BF|>1
 * @param newNode : newly added leaf AVLNode
 * @return keyNode
 */
private AVLNode updateHeightsAndDetectKeyNode(AVLNode newNode) {
 AVLNode keyNode = null;
 while (newNode.parent != null) {
  if (newNode.getParent().height - newNode.height != 1) {
   if (keyNode == null) {
    int bf_parent = newNode.getParent().getBalanceFactor();
    if (bf_parent > 1 || bf_parent < -1) {
     keyNode = newNode.getParent();
     break;
    }
   }
   newNode.getParent().height++;
   newNode = newNode.getParent();
  } else
   break;
 }
 return keyNode;
}

public AVLNode lookup(int value) {
 AVLNode currentNode = root;
 while (currentNode != null) {
  if (currentNode.value == value)
   return currentNode;
  else
   currentNode = value < currentNode.value ? 
    currentNode.left : currentNode.right;
 }
 System.out.println("The AVLTree doesn't contain " + value);
 return null;
}

/**
 * LL or LR type if balance factor == 2; rotateRight for keyNode if bf of
 * keyNode.left == -1, it's LR type; rotateLeft for keyNode.left first RR or
 * RL type if balance factor == -2; rotateLeft for keyNode if bf of
 * keyNode.right == 1, it's RL type; rotateRight for keyNode.right first
 * 
 * @param keyNode
 */
private AVLNode adjustTreeByRotation(AVLNode keyNode) {
 AVLNode newKeyNode = null;
 int bf_keyNode = keyNode.getBalanceFactor();
 if (bf_keyNode == 2) {
  if (keyNode.left.getBalanceFactor() == -1) // LR
   keyNode.setLeft(keyNode.left.rotateLeft());
  newKeyNode = keyNode.rotateRight();
 } else if (bf_keyNode == -2) {
  if (keyNode.right.getBalanceFactor() == 1) // RL
   keyNode.setRight(keyNode.right.rotateRight());
  newKeyNode = keyNode.rotateLeft();
 } else {
  new Exception("There are some bugs").printStackTrace();
 }

 if (keyNode.parent == null) {
  root = newKeyNode;
  root.parent = null;
 }
 else {
  if (keyNode == keyNode.parent.left)
   keyNode.parent.setLeft(newKeyNode);
  else
   keyNode.parent.setRight(newKeyNode);
  newKeyNode.parent.adjustHeight();
 }
 return newKeyNode;
}

public void print(Order order) {
 switch (order) {
 case PREORDER:
  root.print_preorder();
  break;
 case INORDER:
  root.print_inorder();
  break;
 case POSTORDER:
  root.print_postorder();
  break;
 }
}
}