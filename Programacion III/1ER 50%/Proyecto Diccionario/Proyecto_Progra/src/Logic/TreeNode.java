package Logic;

/**
 * Clase TreeNode la cual es la encragada de manejar los nodos
 * en el arbol binario
 * @author Sebastian Vega y Luisa Merchan
 * @param <T> hace referencia al ipo de dato que contiene el nodo
 */
public class TreeNode <T>{
    /**
     * Representa la informacion que contiene el nodo
     */
    private T info;
    /**
     * Representa al nodo hijo de lado izquierdo
     */
    private TreeNode left ;
    /**
     * Representa al nodo hijo del lado derecho
     */
    private TreeNode rigth ;

    /**
     * Constructor de la clase TreeNode, el cual crea un nuevo nodo con
     * la informacion que se envie
     * @param info Representa la Informacion que contiene el nodo
     */
    public TreeNode(T info) {
        this.info = info;
        left = rigth = null;
    }

    /**
     * Obtiene la informacion que contiene el nodo
     * @return info Representa la Informacion que contiene el nodo
     */
    public T getInfo() {
        return info;
    }

    /**
     * Establece la informacion que contiene el nodo
     * @param info Representa la Nueva valor de la informacion
     */

    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Obtiene la informacion del nodo hijo del lado izquierdo
     * @return left Representa la informacion del nodo hijo del lado izquierdo
     */

    public TreeNode getLeft() {
        return left;
    }

    /**
     * Establece la informacion del Nodo Hijo del lado derecho
     * @param left Representa la informacion del hijo del lado izquierdo
     *
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Obtiene la Informacion del nodo hijo del lado derecho
     * @return right Representa la Informacion del nodo hijo del lado derecho
     */

    public TreeNode getRight() {
        return rigth;
    }

    /**
     * Establece la Informacion del nodo hijo del lado derecho
     * @param rigth Representa la Informacion del nodo hijo del lado derecho
     */
    public void setRight(TreeNode rigth) {
        this.rigth = rigth;
    }
}