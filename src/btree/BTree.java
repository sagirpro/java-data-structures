package btree;

public class BTree {
        private BNode root;

        public BTree() {
                root = null;
        }

        public void postorderDisplay(BNode node) {
            if (node != null) {
                    inorderDisplay(node.right);
                    System.out.print(node.key + " ");
                    inorderDisplay(node.left);
            }
    }
        public void inorderDisplay(BNode node) {
                if (node != null) {
                        inorderDisplay(node.left);
                        System.out.print(node.key + " ");
                        inorderDisplay(node.right);
                }
        }

        public void insert(int value) {
                BNode y = null; 
                BNode x = root; 
                while (x != null) {
                        y = x;
                        if (value < x.key) {
                                x = x.left;
                        } else {
                                x = x.right;
                        }
                }
                BNode z = new BNode(value);
                z.parent = y;
                if (y == null) {
                        root = z;
                } else {
                        {
                                if (value < y.key) {
                                        y.left = z;
                                } else {
                                        y.right = z;
                                }
                        }

                }

        }

        public boolean contains(BNode node, int value) {
                if (node == null)
                        return false;
                if (node.key == value)
                        return true;
                if (value < node.key) {
                        return contains(node.left, value);
                } else
                        return contains(node.right, value);

        }

        public boolean contains(int value) {
                BNode x = root;
                if (x == null)
                        return false;
                while (value != x.key) {
                        if (value < x.key) {
                                x = x.left;
                        } else
                                x = x.right;
                        if (x == null)
                                return false;

                }
                return true;

        }

        public int minValue() {
                BNode node = root;
                while (node.left != null) {
                        node = node.left;
                }
                return node.key;
        }

        public int maxValue() {
                BNode node = root;
                while (node.right != null) {
                        node = node.right;
                }
                return node.key;
        }

        public static void main(String[] args) {
                BTree tree = new BTree();
                tree.insert(5);
                tree.insert(8);
                tree.insert(2);
                tree.insert(3);
                tree.insert(1);
                tree.insert(100);
                tree.insert(4);
                tree.insert(999);
                tree.insert(400);
                tree.insert(401);
                tree.insert(-1000);
                
                System.out.println("In Order Display");
                tree.inorderDisplay(tree.root);
                
                System.out.println("\nPost Order Display");
                tree.postorderDisplay(tree.root);
                
                System.out.println("\nis -1 availble there ?");
                System.out.println(tree.contains(tree.root, -1));
                
                System.out.println("is 400 availble there ?");
                System.out.println(tree.contains(tree.root, 400));
                
                

                System.out.println("min:" + tree.minValue());
                System.out.println("max:" + tree.maxValue());
        }

}
