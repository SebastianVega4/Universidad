public class FileBook {
    private static final String FILE_PATH = "C:\\Users\\A372144\\Downloads\\Git\\Universidad\\Programacion III\\2DO 50%\\BooksJsonJakartaEE\\src\\main\\Books.json"; // Ruta a tu archivo JSON
        public String readFile() throws IOException {
            Path path = Paths.get(FILE_PATH);
            return new String(Files.readAllBytes(path));
        }
    }
}