package Logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Graph<T> {

    public static final int DIRECT = 0;
    public static final int INDIRECT = 1;
    private final Comparator<T> comparator;
    private final List<Vertex<T>> vertexList;

    public Graph(Comparator<T> comparator) {
        this.comparator = comparator;
        vertexList = new ArrayList<>();
    }

    public void addVertex(T info) {
        vertexList.add(new Vertex<>(info));
    }

    public boolean addEdge(Vertex<T> source, Vertex<T> target, int mode) {
        if (!source.isAdyacent(target)) {
            source.addAdyacent(target);
            if (mode == INDIRECT) {
                target.addAdyacent(source);
            }
            return true;
        }
        return false;
    }

    public Vertex<T> findVertex(T info) {
        for (Vertex<T> vertex : vertexList) {
            if (comparator.compare(vertex.getInfo(), info) == 0) {
                return vertex;
            }
        }
        return null;
    }

    public List<T> getAdyacents(Vertex<T> vextex) {
        List<T> list = new ArrayList<>();
        for (Vertex<T> vertexAux : vextex.getAdyacent()) {
            list.add(vertexAux.getInfo());
        }
        return list;
    }

    public boolean isAdyacent(Vertex<T> vertex1, Vertex<T> vertex2){
     return vertex1.isAdyacent(vertex2);
    }

    public List<T> listGraph(Vertex<T> vertex) {
        List<T> list = new ArrayList<>();
        for (Vertex<T> vertexAux : vertex.getAdyacent()){
            list.add(vertexAux.getInfo());
        }
        return list;
    }
}
