public class AVLTree<K extends Comparable<K>, E> {

   TreeNode root;

   private class TreeNode {
      K key;
      E value;
      TreeNode left, right;
      int height;

      TreeNode(K key, E value) {
         this.key = key;
         this.value = value;
         left = null;
         right = null;
         height = 1;
      }
   }

   private int height(TreeNode node) {
      return node == null ? 0 : node.height;
   }

   private void updateHeight(TreeNode node) {
      node.height = Math.max(height(node.left), height(node.right)) + 1;
   }

   private int getBalance(TreeNode node) {
      return node == null ? 0 : height(node.left) - height(node.right);
   }

   private TreeNode rightRotate(TreeNode RR) {
      TreeNode temp = RR.left;
      RR.left = temp.right;
      temp.right = RR;
      updateHeight(RR);
      updateHeight(temp);
      return temp;
   }

   private TreeNode leftRotate(TreeNode LL) {
      TreeNode temp = LL.right;
      LL.right = temp.left;
      temp.left = LL;
      updateHeight(LL);
      updateHeight(temp);
      return temp;
   }

   private TreeNode RLRotate(TreeNode RL) {
      RL.right = rightRotate(RL.right);
      return leftRotate(RL);
   }

   private TreeNode LRRotate(TreeNode LR) {
      LR.left = leftRotate(LR.left);
      return rightRotate(LR);
   }

   public TreeNode insert(TreeNode root, K key, E value) {
      if (root == null)
         return new TreeNode(key, value);

      int cmp = key.compareTo(root.key);
      if (cmp < 0)
         root.left = insert(root.left, key, value);
      else if (cmp > 0)
         root.right = insert(root.right, key, value);
      else
         return root;

      updateHeight(root);

      int balance = getBalance(root);

      if (balance > 1 && key.compareTo(root.left.key) < 0)
         return rightRotate(root);

      if (balance < -1 && key.compareTo(root.right.key) > 0)
         return leftRotate(root);

      if (balance > 1 && key.compareTo(root.left.key) > 0)
         return LRRotate(root);

      if (balance < -1 && key.compareTo(root.right.key) < 0)
         return RLRotate(root);

      return root;
   }

   public String inOrderKeys() {
      return inOrderKeys(root);
   }

   private String inOrderKeys(TreeNode node) {
      if (node == null)
         return "";
      return inOrderKeys(node.left) + node.key + " " + inOrderKeys(node.right);
   }

   public String inOrderValues() {
      return inOrderValues(root);
   }

   private String inOrderValues(TreeNode node) {
      if (node == null)
         return "";
      return inOrderValues(node.left) + node.value + inOrderValues(node.right);
   }

   public String preOrderKeys() {
      return preOrderKeys(root);
   }

   private String preOrderKeys(TreeNode node) {
      if (node == null)
         return "";
      return node.key + " " + preOrderKeys(node.left) + preOrderKeys(node.right);
   }

   public int getHeight() {
      return height(root);
   }

   public boolean isBalanced() {
      return isBalanced(root);
   }

   private boolean isBalanced(TreeNode node) {
      if (node == null)
         return true;
      int balance = getBalance(node);
      return balance >= -1 && balance <= 1
         && isBalanced(node.left)
         && isBalanced(node.right);
   }

   public static void main(String[] args) {

      int[] myInts = { 1, 4, 7, 9, 3, 8, 0, 2, 5, 6, 4 };

      String myString = "BANANACREAMPIE";

      AVLTree<Integer, String> tree = new AVLTree<>();

      tree.root = tree.insert(tree.root, 6, "L");
      for (int i = 0; i < myInts.length; i++)
         tree.root = tree.insert(tree.root, myInts[i], myString.substring(i, i + 1));

      System.out.println("Inserted: 6 1 4 7 9 3 8 0 2 5 6 4");
      System.out.println("In order:  " + tree.inOrderKeys());
      System.out.println("Pre order: " + tree.preOrderKeys());
      System.out.println("Values:    " + tree.inOrderValues());
      System.out.println("Height: " + tree.getHeight() + "   Balanced? " + tree.isBalanced());

      //sorted input is the worst case for a normal BST (it turns into a linked list)
      AVLTree<Integer, Integer> sorted = new AVLTree<>();
      for (int i = 1; i <= 1000; i++)
         sorted.root = sorted.insert(sorted.root, i, i);
      System.out.println();
      System.out.println("Inserted 1 to 1000 in order");
      System.out.println("Height: " + sorted.getHeight() + " (a plain BST would be 1000)   Balanced? " + sorted.isBalanced());
   }
}
