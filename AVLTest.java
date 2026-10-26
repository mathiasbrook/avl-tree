public class AVLTest{

   public static void main(String[] args){

      int[] myInts = {1,4,7,9,3,8,0,2,5,6,4};

      String myString = "BANANACREAMPIE";

      AVLTree<Integer,String> tree = new AVLTree<Integer,String>();

      tree.root = tree.insert(tree.root,6,"L");
      for (int i=0;i < myInts.length; i++)
         tree.root = tree.insert(tree.root,myInts[i],myString.substring(i,i+1));

      System.out.println("Expected 0 1 2 3 4 5 6 7 8 9  " + tree.inOrderKeys());
      System.out.println("Expected CBRNAELNAA  " + tree.inOrderValues()); //duplicate 6 and 4 keep their first value
      System.out.println("Expected true  " + tree.isBalanced());
      System.out.println("Expected 4  " + tree.getHeight());

      //right right case (left rotation)
      AVLTree<Integer,String> t2 = new AVLTree<Integer,String>();
      t2.root = t2.insert(t2.root,1,"a");
      t2.root = t2.insert(t2.root,2,"b");
      t2.root = t2.insert(t2.root,3,"c");
      System.out.println("Expected 2 1 3  " + t2.preOrderKeys());

      //left left case (right rotation)
      AVLTree<Integer,String> t3 = new AVLTree<Integer,String>();
      t3.root = t3.insert(t3.root,3,"c");
      t3.root = t3.insert(t3.root,2,"b");
      t3.root = t3.insert(t3.root,1,"a");
      System.out.println("Expected 2 1 3  " + t3.preOrderKeys());

      //left right case
      AVLTree<Integer,String> t4 = new AVLTree<Integer,String>();
      t4.root = t4.insert(t4.root,3,"c");
      t4.root = t4.insert(t4.root,1,"a");
      t4.root = t4.insert(t4.root,2,"b");
      System.out.println("Expected 2 1 3  " + t4.preOrderKeys());

      //right left case
      AVLTree<Integer,String> t5 = new AVLTree<Integer,String>();
      t5.root = t5.insert(t5.root,1,"a");
      t5.root = t5.insert(t5.root,3,"c");
      t5.root = t5.insert(t5.root,2,"b");
      System.out.println("Expected 2 1 3  " + t5.preOrderKeys());
   }
}
