package Logic;

public class TreeNode <T>{
    private T info;
    private TreeNode left ;
    private TreeNode rigth ;
    public TreeNode(T info) {
        this.info = info;
        left = rigth = null;
    }
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return rigth;
    }

    public void setRight(TreeNode rigth) {
        this.rigth = rigth;
    }
}