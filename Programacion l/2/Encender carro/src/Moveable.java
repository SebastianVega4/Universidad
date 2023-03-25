public interface Moveable {

    Double staticConstant = 12d;
    Double staticVariable = 12d;

    Boolean moveForward(Integer distance);

    default boolean advance(Integer distance) {
        System.out.println("\nSe movio adelante hacia adelante " + distance + " metros");
        return true;
    }

    default Boolean back(Integer distance) {
        System.out.println("\nRetrocedio " + distance + " metros");
        return true;
    }

    default Boolean scrollRight(Integer distance) {
        System.out.println("\nSe desplazo hacia la derecha " + distance + " metros");
        return true;
    }

    default Boolean scrollLeft(Integer distance) {
        System.out.println("\nSe desplazo hacia la izquierda " + distance + " metros");
        return true;
    }

    default Boolean scrollUp(Integer distance) {
        System.out.println("\n Se desplazo hacia arriba " + distance + " metros");
        return true;
    }

    default boolean scrollDown(Integer distance) {
        System.out.println("\nSe desplazo hacia abajo " + distance + " metros");
        return true;
    }

}
