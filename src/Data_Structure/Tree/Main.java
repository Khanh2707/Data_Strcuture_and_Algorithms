package Data_Structure.Tree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.addBST(bst.root,5);
        bst.root = bst.addBST(bst.root,3);
        bst.root = bst.addBST(bst.root,6);
        bst.root = bst.addBST(bst.root,2);
        bst.root = bst.addBST(bst.root,4);
        bst.root = bst.addBST(bst.root,8);
        bst.root = bst.addBST(bst.root,7);

        System.out.println(bst.hasPathSum2(bst.root,12));
        System.out.println(bst.maxDepth(bst.root));
    }
}
