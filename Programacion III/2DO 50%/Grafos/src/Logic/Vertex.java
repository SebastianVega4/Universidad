package Logic;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T info;
    private final List<Vertex<T>> adyacent;
    private boolean visited;

    public Vertex(T info) {
        super();
        this.info = info;
        adyacent = new ArrayList<>();
        visited = false;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addAdyacent(Vertex<T> vertex) {
        adyacent.add(vertex);
    }

    public boolean isAdyacent(Vertex<T> vertex) {
        return adyacent.contains(vertex);
    }

    public List<Vertex<T>> getAdyacent() {
        return adyacent;
    }
}
