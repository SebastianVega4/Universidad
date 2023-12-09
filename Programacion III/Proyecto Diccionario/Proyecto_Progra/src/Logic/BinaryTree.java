package Logic;

import java.util.ArrayList;
import java.util.Comparator;
public class BinaryTree<T> {
    private TreeNode<T> root;
    private final Comparator<T> comparator;
    private ArrayList<T> list;
    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }

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

    public ArrayList<T> listPresort() {
        list = new ArrayList<>();
        presort(root);
        return list;
    }
    private void presort(TreeNode<T> node) {
        if (node != null) {
            list.add(node.getInfo());
            presort(node.getLeft());
            presort(node.getRight());
        }
    }

    public ArrayList<T> listInsort() {
        list = new ArrayList<>();
        insort(root);
        return list;
    }

    private void insort(TreeNode<T> node) {
        if (node != null) {
            insort(node.getLeft());
            list.add(node.getInfo());
            insort(node.getRight());
        }
    }

    public ArrayList<T> listPosort() {
        list = new ArrayList<>();
        posort(root);
        return list;
    }

    private void posort(TreeNode<T> node) {
        if (node != null) {
            posort(node.getLeft());
            posort(node.getRight());
            list.add(node.getInfo());
        }
    }

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

    public void modifyNode(T info, T newInfo) {
        TreeNode<T> node = findNodo(info);
        if (node == null) {
            return;
        }
        node.setInfo(newInfo);
    }

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

    public int gradeNode(TreeNode<T> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            return 2;
        } else if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public T deleteNode(TreeNode<T> node) {
        T aux = node.getInfo();
        switch (gradeNode(node)) {
            case 0 -> deleteSheet(node);
            case 1 -> deleteNodeWithSon(node);
            default -> deleteNodeWithChild(node);
        }
        return aux;
    }

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