package Logic;
/*
* Package Logic
*
 */


/*
 * Class TreeNode
 *
 * clase nodo arbolbinario
 *
 */
public class TreeNode <T>{

    /*
     * private info
     *
     * dato de tipo generico
     *
     */
    private T info;
    /*
     * private Left
     *
     * dato de tipo Nodo que almacena el dato izquierdo
     *
     */
    private TreeNode left ;
    /*
     * private Left
     *
     * dato de tipo Nodo que almacena el dato derecho
     *
     */

    private TreeNode rigth ;


    /**
     * Public TreeNode
     * Constructor de la clase nodo arbol binario
     * @param (info) Tipo generico
     */
    public TreeNode(T info) {
        this.info = info;
        left = rigth = null;
    }
    /**
     * Public getInfo
     * get de info
     * @return (info)
     * @param ()
     */
    public T getInfo() {
        return info;
    }
    /**
     * Public setinfo
     * set de info
     * @return ()
     * @param (info)
     */
    public void setInfo(T info) {
        this.info = info;
    }
    /**
     * Public getleft
     * get de left
     * @return (Left)
     * @param ()
     */
    public TreeNode getLeft() {
        return left;
    }
    /**
     * Public setleft
     * set de left
     * @return ()
     * @param (left)
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    /**
     * Public getRight
     * get de Right
     * @return (Right)
     * @param ()
     */
    public TreeNode getRight() {
        return rigth;
    }
    /**
     * Public setrigth
     * set de rigth
     * @return ()
     * @param (rigth)
     */
    public void setRight(TreeNode rigth) {
        this.rigth = rigth;
    }
}
