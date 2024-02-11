package Logic;


import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase BinaryTree la cual representa el arbol binario de busqueda,
 * la cual utliza la clase Comparator para asi comparar la letras y
 * determinar un orden para la organizacion del diccionario
 *
 * @author Sebastian Vega y Luisa Merchan
 * @param <T> Parameteo que hace referencia al tipo de dato a almacenar en el arbol
 */
public class BinaryTree<T> {
    /**
     * Representa el nodo que hace referencia a lal raiz del arbol
     */
    private TreeNode<T> root;
    /**
     * Representa el Comparador el cual verifica los elementos del arbol
     * y dar un orden en el arbol
     */
    private final Comparator<T> comparator;
    /**
     * Representa la lista en la que se guardaran los datos del arbol
     * en forma ordenanda
     */
    private ArrayList<T> list;

    /**
     * Constructor de la lista BinaryTree el cual recibe el parametro
     * comparator para crear el árbol vacío, el cual inicia el parametro root
     * en null
     * @param comparator Recibe el parametro comparator árbol
     */
    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    /**
     * Representa el metodo de tipo boolean que verifica
     * si hay o no nodos en el arbol binario
     * @return el metodo devolvera true si al árbol esta vacío
     */
    public boolean isEmpty() {
        return root == null;
    }


    /**
     * Metodo void el cual añadira nodos al árbol binario
     * @param info representa la informacion que contendrá cada nodo.
     */
    public void addNode(T info) {
        TreeNode<T> newNode = new TreeNode<>(info);
        if (isEmpty()) {
            root = newNode;
        } else {
            TreeNode<T> actually = root;
            TreeNode<T> previous = null;
            while (actually != null) {
                previous = actually;
                actually = comparator.compare(info, actually.getInfo()) < 0 ? actually.getLeft() : actually.getRight();
            }
            if (comparator.compare(info, previous.getInfo()) < 0) {
                previous.setLeft(newNode);
            } else {
                previous.setRight(newNode);
            }
        }
    }

    /**
     * Es un método de tipo ArrayList que permite obtener una lista de los nodos existes dentro
     * del árbol binario, este metodo lo recorrerá en sentido Preorden, es decir visitará primero la raiz,
     * luego el subarbol izquierdo y por ultimo el subarbol derecho
     * @return list la cual contendra la lista de todos los nodos existes dentro del árbol binario
     */
    public ArrayList<T> listPresort() {
        list = new ArrayList<>();
        presort(root);
        return list;
    }

    /**
     * Es un método de tipo privado el cual permitirá recorrer el árbol binario de busqueda
     * en preorden y el cual añadirá los elementos del objeto ArryaList <T> llamado list,
     *
     * @param node Representa el nod actual desde el que se va a recorre el árbol binario
     */
    private void presort(TreeNode<T> node) {
        if (node != null) {
            list.add(node.getInfo());
            presort(node.getLeft());
            presort(node.getRight());
        }
    }

    /**
     * Es un método que recorre el árbol en sentido inorden lo que quiere decir que lo recorre
     * primero por el lado izquierdo llega a la raiz y lo empieza a recorrer por el lado derecho
     * Este método retorna una lista de objetos de tipo ArrayList
     * @return Devolverá una lista que contenga los elemntos del árbol en el orden mecionado
     */
    public ArrayList<T> listInsort() {
        list = new ArrayList<>();
        insort(root);
        return list;
    }

    /**
     *Método que se llama a el mismo, recibe como parametro un nodo el cual se el que se evaluará
     * para asi añadirla a la list que esta a nivel de clase
     * @param node Representa el nodo que se añadirá al árbol binario
     */

    private void insort(TreeNode<T> node) {
        if (node != null) {
            insort(node.getLeft());
            list.add(node.getInfo());
            insort(node.getRight());
        }
    }

    /**
     *Método que recorre el arbol en sentido PostOrden, ess decir primero recorre
     * la rama izquierda del árbol binario, luego la rama derecha del árbol y por ultimo
     * visita la raiz. El metodo utiliza una lista de tipo ArrayList para recorrer y almacenar
     * las palabras, significado y la traduccion que se encuentren dentro del árbol binario
     * @return Devolverá una lista que contendrá la informacion del diccionario
     */

    public ArrayList<T> listPosort() {
        list = new ArrayList<>();
        posort(root);
        return list;
    }

    /**
     *
     * @param node
     */

    private void posort(TreeNode<T> node) {
        if (node != null) {
            posort(node.getLeft());
            posort(node.getRight());
            list.add(node.getInfo());
        }
    }

    /**
     * Es un metodo el cual recorre el árbol binario y devuelve un TreeNode
     * que contiene la información (info). Este método comenzara su recorrido en la raiz del arbol
     * y continuara recorriendo el arbol hasta encontrar el nodo que requiere ser buscado
     * según la informacion que haya sido proporcionanda por el usuario
     * @param info Represneta la informacion que contiene el nodo y que se va a usar para
     *             la busqueda dentro de la lista
     * @return aux representa el nodo con la informacion requerida
     */

    public TreeNode<T> findNodo(T info) {
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
     * Método que permite devolver la informacion requerida y que se encuentra
     * de un nodo
     * @param info Representa la informacion que contiene el nodo y que se usara
     *            para la busqueda dentro de la lista
     * @return aux.getInfo() Representa la Información del nodo que se requería
     */

    public T findInfo(T info) {
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
     * Método que permite modificar la informacion  de algún nodo en especifico
     * el cual verificara priemro la existencia del mismo
     * @param info Representa la informacion que contien el nodo a modificar
     * @param newInfo Representa la informacion del nuevo nodo
     */

    public void modifyNode(T info, T newInfo) {
        TreeNode<T> node = findNodo(info);
        if (node == null) {
            return;
        }
        node.setInfo(newInfo);
    }

    /**
     * Método que recorre el arbol binario, el cual devolverá el nodo Padre
     * el metodo utiliza un comparator  para comparar la informacion del nodo
     * con la informacion que se busca
     * @param info Representa la informacion que se requiere para buscar y
     *             obtener el nodo dentro del árbol binario
     * @return padre Representa el nodo Padre que contiene la informacion
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
     * Método que recibe un Nodo y determinanra su grado segun la posicion
     * en la que se encuentre
     * @param node Representa la la cantidad de hijos que tiene un nodo
     * @return si el nodo tiene 2 hijos devolvera 2, si tiene 1 hijo devolverá 1
     * y si no tiene ninguno devolverá 0
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
     * Método que recibe un Nodo y lo elimina del árbol. El metodo promero
     * gusradará el nodo en una variable aux para despue sllamar al metodo gradeNode, para
     * determinar el grado del Nodo
     * @param node representa el nodo el cual se va a elminar
     * @return dependiendo del grado del Nodo se llamará a uno de los los metodos
     * para eliminar hijos
     */

    public T deleteNode(TreeNode<T> node) {
        T aux = node.getInfo();
        switch (gradeNode(node)) {
            case 0 -> deleteSheet(node);
            case 1 -> deleteNodeWithSon(node);
            default -> deleteNodeWithChild(node);
        }
        return aux;
    }

    /**
     * Método que recibe una hoja (sin hijos), y lo elimina del árbol.
     * Si el nodo es la raiz será nula, y si no sera el nodo padre
     * @param node reprrsenta el nodo hoja de referencia
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
     * Método que representa un nodo con un solo hijo. Si el nodo tiene 1 soloo hijo
     * se establecerá como nodo raiz
     * @param node Representa el nodo que hace referencia al nodo con un solo hijo
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
     * Método que recibe un nodo con 2 hijos y lo elimina del arbol. En este caso se buscara
     * el sucesor inmediato al nodo a eliminar
     * @param node representa al nodo con 2 hijos
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
