package Logic;
/*
 * Package Logic
 *
 */




import java.security.PublicKey;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/*
 * Class BinaryTree
 *
 * clase arbolbinario
 *
 */
public class BinaryTree<T> {
    /*
     * private root
     *
     * dato de tipo nodo arbol binario
     *
     */
    private TreeNode<T> root;
    /*
     * private comparator
     *
     * dato de tipo comparator generico
     *
     */
    private Comparator<T> comparator;
    /*
     * private list
     *
     * dato de tipo ArrayList generico
     *
     */
    private ArrayList<T> list;
    /**
     * Public BinaryTree
     * Constructor de la clase arbol binario
     * @param (comparator) Tipo generico
     */
    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }
    /**
     * Public isEmpty
     * comprueba si el arbol esta vacio
     * @return (boolean)
     * @param ()
     */

    public boolean isEmpty() {

        return root == null ? true : false;
    }
    /**
     * Public addnode
     * añade un nodo al arbol binario
     * @return ()
     * @param (info)
     */
    public void addNode(T info) {
        TreeNode<T> newNode = new TreeNode<>(info);
        if (isEmpty()) {
            root = newNode;
        } else {
            TreeNode<T> aux = root;
            TreeNode<T> ant = null;
            while (aux != null) {
                ant = aux;
                aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
            }
            if (comparator.compare(info, ant.getInfo()) < 0) {
                ant.setLeft(newNode);
            } else {
                ant.setRight(newNode);
            }
        }
    }
    /**
     * Public listPresort
     * genera una lista con los datos
     * @return (list)
     * @param ()
     */
    public ArrayList<T> listPresort() {
        list = new ArrayList<>();
        presort(root);

        return list;
    }
    /**
     * private presort
     * metodo de ayuda
     * @return ()
     * @param (node)
     */
    private void presort(TreeNode<T> node) {
        if (node != null) {
            list.add(node.getInfo());
            presort(node.getLeft());
            presort(node.getRight());
        }
    }
    /**
     * Public listInsort
     * genera una lista con los datos
     * @return (list)
     * @param ()
     */
    public ArrayList<T> listInsort() {
        list = new ArrayList<T>();
        insort(root);
        return list;
    }
    /**
     * private insort
     * metodo de ayuda
     * @return ()
     * @param (node)
     */
    private void insort(TreeNode<T> node) {
        if (node != null) {
            insort(node.getLeft());
            list.add(node.getInfo());
            insort(node.getRight());
        }
    }
    /**
     * Public listPosort
     * genera una lista con los datos
     * @return (list)
     * @param ()
     */
    public ArrayList<T> listPosort() {
        list = new ArrayList<T>();
        posort(root);
        return list;
    }
    /**
     * private posort
     * metodo de ayuda
     * @return ()
     * @param (node)
     */
    private void posort(TreeNode<T> node) {
        if (node != null) {
            posort(node.getLeft());
            posort(node.getRight());
            list.add(node.getInfo());
        }
    }
    /**
     * public encontrarNodo
     * metodo para encontrar un nod
     * @return (TreeNode)
     * @param (info)
     */
    public TreeNode<T> encontrarNodo(T info) {
        TreeNode<T> aux = root;
        while (aux != null && comparator.compare(info, aux.getInfo()) != 0) {
            if (comparator.compare(info, aux.getInfo()) < 0) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }

        }
        return aux;
    }
    /**
     * public encontrarInfo
     * metodo para encontrar un nodo y su informacion
     * @return (TreeNode)
     * @param (info)
     */
    public T encontrarInfo(T info) {
        TreeNode<T> aux = root;
        while (aux != null && comparator.compare(info, aux.getInfo()) != 0) {
            if (comparator.compare(info, aux.getInfo()) < 0) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }

        }
        return aux.getInfo();
    }
    /**
     * public modifyNode
     * metodo para Modificar un nodo
     * @return ()
     * @param (info,newInfo)
     */
    public void modifyNode(T info, T newInfo) {
        TreeNode<T> node = encontrarNodo(info);

        if (node == null) {
            return;
        }
        node.setInfo(newInfo);

    }
    /**
     * public esPadre
     * metodo para encontrar el padre de un nodo en el arbol
     * @return (TreeNode)
     * @param (info)
     */
    public TreeNode<T> esPadre(T info) {
        TreeNode<T> aux = root;
        TreeNode<T> padre = root;
        while (comparator.compare(info, aux.getInfo()) != 0) {
            if (comparator.compare(info, aux.getInfo()) < 0) {
                padre = aux;
                aux = aux.getLeft();
            } else {
                padre = aux;
                aux = aux.getRight();
            }
        }
        return padre;
    }

    /**
     * public gradeNode
     * metodo para obtener el grado de un nodo
     * @return (int)
     * @param (node)
     */
    public int gradeNode(TreeNode<T> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            return 2;
        } else if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        } else {
            return 1;
        }
    }
    /**
     * public deleteNode
     * metodo para eliminar un nodo
     * @return (T)
     * @param (node)
     */
    public T deleteNode(TreeNode<T> node) {
        T aux = node.getInfo();

        switch (gradeNode(node)) {
            case 0:
                deleteSheet(node);
                break;

            case 1:
                deleteNodeWithSon(node);
                break;

            default:
                deleteNodeWithChild(node);
        }

        return aux;
    }
    /**
     * public deleteSheet
     * metodo para eliminar un nodo
     * @return ()
     * @param (node)
     */
    private void deleteSheet(TreeNode<T> node) {
        if (node == root) {
            root = null;
        } else {
            TreeNode<T> father = esPadre(node.getInfo());
            if (father.getLeft() == node) {
                father.setLeft(null);
            } else {
                father.setRight(null);
            }
        }
    }
    /**
     * public deleteNodeWithSon
     * metodo para eliminar un nodo
     * @return ()
     * @param (node)
     */
    private void deleteNodeWithSon(TreeNode<T> node) {
        TreeNode<T> father = esPadre(node.getInfo());
        if (father == root) {
            root = father.getLeft() == node ? father.getLeft() : father.getRight();
        } else {
            if (father.getRight() == node) {
                father.setRight(node.getRight() != null ? node.getRight() : node.getLeft());
            } else {
                father.setLeft(node.getRight() != null ? node.getRight() : node.getLeft());
            }
        }
    }
    /**
     * public deleteNodeWithChild
     * metodo para eliminar un nodo
     * @return ()
     * @param (node)
     */
    private void deleteNodeWithChild(TreeNode<T> node) {
        TreeNode<T> substitute = node.getRight();
        TreeNode<T> fatherSubstitute = null;
        while (substitute.getLeft() != null) {
            fatherSubstitute = substitute;
            substitute = substitute.getLeft();
        }
        if (fatherSubstitute != null) {
            fatherSubstitute.setLeft(substitute.getRight());
            substitute.setRight(node.getRight());
        }
        substitute.setLeft(node.getLeft());
        TreeNode<T> father = esPadre(node.getInfo());
        if (father == null) {
            root = substitute;
        } else {
            if (father.getLeft() == node) {
                father.setLeft(substitute);
            } else {
                father.setRight(substitute);
            }
        }
    }

}
