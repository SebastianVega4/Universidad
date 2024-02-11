
import Logic.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class GraphTest1 {
    private Graph<Character> graph;

    void setup(){
        graph = new Graph<>((c1,c2)-> Character.compare(c1,c2));
        graph.addVertex('J');
        graph.addVertex('A');
        graph.addVertex('I');
        graph.addVertex('R');
        graph.addVertex('O');
        graph.addVertex('L');
        graph.addVertex('G');
    }

    void setupTwo(){
        setup();
        graph.addEdge( graph.findVertex('J'), graph.findVertex('A'),Graph.INDIRECT);
        graph.addEdge( graph.findVertex('J'), graph.findVertex('R'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('R'), graph.findVertex('J'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('J'), graph.findVertex('I'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('I'), graph.findVertex('R'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('I'), graph.findVertex('A'),Graph.INDIRECT);
        graph.addEdge( graph.findVertex('I'), graph.findVertex('O'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('R'), graph.findVertex('O'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('O'), graph.findVertex('R'),Graph.INDIRECT);
        graph.addEdge( graph.findVertex('O'), graph.findVertex('R'),Graph.INDIRECT);
        graph.addEdge( graph.findVertex('A'), graph.findVertex('G'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('G'), graph.findVertex('L'),Graph.INDIRECT);
        graph.addEdge( graph.findVertex('G'), graph.findVertex('I'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('L'), graph.findVertex('O'),Graph.DIRECT);
        graph.addEdge( graph.findVertex('L'), graph.findVertex('O'),Graph.DIRECT);
    }

    @Test
    void addEdge() {
        setup();
        assertTrue( graph.addEdge( graph.findVertex('J'), graph.findVertex('A'),Graph.INDIRECT));
        assertFalse( graph.addEdge( graph.findVertex('J'), graph.findVertex('A'),Graph.INDIRECT) );
        assertFalse( graph.addEdge( graph.findVertex('A'), graph.findVertex('J'),Graph.DIRECT) );
        assertTrue(graph.addEdge( graph.findVertex('J'), graph.findVertex('R'),Graph.DIRECT));
        assertTrue(graph.addEdge( graph.findVertex('R'), graph.findVertex('J'),Graph.DIRECT));
        assertFalse(graph.addEdge( graph.findVertex('J'), graph.findVertex('R'),Graph.INDIRECT));
        assertTrue(graph.addEdge( graph.findVertex('J'), graph.findVertex('I'),Graph.DIRECT));
        assertFalse(graph.addEdge( graph.findVertex('J'), graph.findVertex('I'),Graph.DIRECT));

        assertTrue( graph.addEdge( graph.findVertex('I'), graph.findVertex('R'),Graph.DIRECT));
        assertFalse( graph.addEdge( graph.findVertex('I'), graph.findVertex('R'),Graph.DIRECT));
        assertTrue(graph.addEdge( graph.findVertex('I'), graph.findVertex('A'),Graph.INDIRECT));
        assertTrue(graph.addEdge( graph.findVertex('I'), graph.findVertex('O'),Graph.DIRECT));
        assertFalse(graph.addEdge( graph.findVertex('I'), graph.findVertex('A'),Graph.INDIRECT));
        assertFalse(graph.addEdge( graph.findVertex('I'), graph.findVertex('O'),Graph.DIRECT));

        assertTrue(graph.addEdge( graph.findVertex('R'), graph.findVertex('O'),Graph.DIRECT));
        assertTrue(graph.addEdge( graph.findVertex('O'), graph.findVertex('R'),Graph.INDIRECT));
        assertFalse(graph.addEdge( graph.findVertex('O'), graph.findVertex('R'),Graph.INDIRECT));

        assertTrue(graph.addEdge( graph.findVertex('A'), graph.findVertex('G'),Graph.DIRECT));
        assertFalse(graph.addEdge( graph.findVertex('A'), graph.findVertex('G'),Graph.DIRECT));

        assertTrue(graph.addEdge( graph.findVertex('G'), graph.findVertex('L'),Graph.INDIRECT));
        assertFalse(graph.addEdge( graph.findVertex('G'), graph.findVertex('L'),Graph.INDIRECT));

        assertTrue(graph.addEdge( graph.findVertex('L'), graph.findVertex('O'),Graph.DIRECT));
        assertFalse(graph.addEdge( graph.findVertex('L'), graph.findVertex('O'),Graph.DIRECT));

    }

    @Test
    void findVertex() {
        setup();
        assertNotNull(graph.findVertex('J'));
        assertNotNull(graph.findVertex('A'));
        assertNotNull(graph.findVertex('I'));
        assertNotNull(graph.findVertex('R'));
        assertNotNull(graph.findVertex('O'));
        assertNotNull( graph.findVertex('L'));
        assertNotNull( graph.findVertex('G'));

        assertNull(graph.findVertex('C'));
        assertNull(graph.findVertex('M'));
        assertNull(graph.findVertex('E'));
    }

    @Test
    void getAdyacents() {
        setupTwo();

        assertEquals(3,graph.getAdyacents( graph.findVertex('J')).size());
        assertEquals(2,graph.getAdyacents( graph.findVertex('R')).size());
        assertEquals(3,graph.getAdyacents( graph.findVertex('A')).size());
        assertEquals(3,graph.getAdyacents( graph.findVertex('I')).size());
        assertEquals(1,graph.getAdyacents( graph.findVertex('O')).size());
        assertEquals(2,graph.getAdyacents( graph.findVertex('G')).size());
        assertEquals(2,graph.getAdyacents( graph.findVertex('L')).size());
    }

    @Test
    void listGraph() {
        setupTwo();
        graph.listGraph( graph.findVertex('L') ).forEach( o -> System.out.println( o ) );
        graph.listGraph( graph.findVertex('I') ).forEach( o -> System.out.println( o ) );
    }

    @Test
    void isAdyacent() {
        setupTwo();
        assertTrue( graph.isAdyacent( graph.findVertex('G'),graph.findVertex('I')));
        assertFalse( graph.isAdyacent( graph.findVertex('I'),graph.findVertex('J')));
    }
}