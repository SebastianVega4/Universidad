package test;

import Logic.BinaryTree;
import Logic.Dictionary;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testAddNode() {
        BinaryTree<Dictionary> binaryTree = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        Dictionary dictionary1 = new Dictionary("apple", "fruit", "manzana");
        Dictionary dictionary2 = new Dictionary("banana", "fruit", "plátano");

        binaryTree.addNode(dictionary1);
        binaryTree.addNode(dictionary2);

        assertNotNull(binaryTree.findNodo(dictionary1));
        assertNotNull(binaryTree.findNodo(dictionary2));
    }

    @Test
    public void testDeleteNode() {
        BinaryTree<Dictionary> binaryTree = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        Dictionary dictionary1 = new Dictionary("apple", "fruit", "manzana");
        Dictionary dictionary2 = new Dictionary("banana", "fruit", "plátano");

        binaryTree.addNode(dictionary1);
        binaryTree.addNode(dictionary2);

        binaryTree.deleteNode(binaryTree.findNodo(dictionary1));

        assertNull(binaryTree.findNodo(dictionary1));
        assertNotNull(binaryTree.findNodo(dictionary2));
    }
    @Test
    public void testListPresort() {
        BinaryTree<Dictionary> binaryTree = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        Dictionary dictionary1 = new Dictionary("apple", "fruit", "manzana");
        Dictionary dictionary2 = new Dictionary("banana", "fruit", "plátano");

        binaryTree.addNode(dictionary1);
        binaryTree.addNode(dictionary2);

        assertEquals(2, binaryTree.listPresort().size());
        assertEquals(dictionary1, binaryTree.listPresort().get(0));
        assertEquals(dictionary2, binaryTree.listPresort().get(1));
    }

    @Test
    public void testFindInfo() {
        BinaryTree<Dictionary> binaryTree = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        Dictionary dictionary1 = new Dictionary("apple", "fruit", "manzana");
        Dictionary dictionary2 = new Dictionary("banana", "fruit", "plátano");

        binaryTree.addNode(dictionary1);
        binaryTree.addNode(dictionary2);

        assertEquals(dictionary1, binaryTree.findInfo(dictionary1));
        assertEquals(dictionary2, binaryTree.findInfo(dictionary2));
    }

    @Test
    public void testModifyNode() {
        BinaryTree<Dictionary> binaryTree = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        Dictionary dictionary1 = new Dictionary("apple", "fruit", "manzana");
        Dictionary dictionary2 = new Dictionary("banana", "fruit", "plátano");

        binaryTree.addNode(dictionary1);
        binaryTree.addNode(dictionary2);

        Dictionary newDictionary = new Dictionary("apple", "new fruit", "nueva manzana");
        binaryTree.modifyNode(dictionary1, newDictionary);

        assertEquals(newDictionary, binaryTree.findInfo(newDictionary));
    }

    @Test
    public void testGradeNode() {
        BinaryTree<Dictionary> binaryTree = new BinaryTree<>(Comparator.comparing(Dictionary::getWord));
        Dictionary dictionary1 = new Dictionary("apple", "fruit", "manzana");

        binaryTree.addNode(dictionary1);

        assertEquals(0, binaryTree.gradeNode(binaryTree.findNodo(dictionary1)));
    }
}