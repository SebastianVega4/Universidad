package Test;

import Logic.Vertex;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    @org.junit.jupiter.api.Test
    void addAdyacentes() {
        Vertex<Character> A = new Vertex<>('A');
        Vertex<Character> B = new Vertex<>('b');
        Vertex<Character> C = new Vertex<>('C');

        A.addAdyacent(B);
        A.addAdyacent(C);

        assertTrue(A.isAdyacent(B));
        assertTrue(A.isAdyacent(C));

    }

    @org.junit.jupiter.api.Test
    void isAdyacente() {
    }
}