public class AVLTest{

   public static void main(String[] args){
      
      int[] myInts = {1,4,7,9,3,8,0,2,5,6,4};
      
      String myString = "BANANACREAMPIE";
     
      AVLTree tree = new AVLTree<Integer,String>();
     
      tree.root = tree.insert(tree.root,6,"L");
      for (int i=0;i < myInts.length; i++)
         tree.root = tree.insert(tree.root,myInts[i],myString.substring(i,i+1));

      System.out.println("Keys:    " + tree.inOrderKeys());
      System.out.println("Values:  " + tree.inOrderValues());
      System.out.println("Balanced? " + tree.isBalanced());
   }
}