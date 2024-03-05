public interface BookService {
    private void loadBooks();
    private void save(Book book);
    private List<Book> books = new ArrayList<>();

    public void loadBooks() {
        // Implementa la lógica para cargar libros desde el archivo JSON
        FileBook fileBook = new FileBook();
        String jsonContent = fileBook.readFile();
        // Usa una biblioteca como Gson para convertir el JSON a objetos Book
        // Gson gson = new Gson();
        // books = gson.fromJson(jsonContent, new TypeToken<List<Book>>(){}.getType());
    }

    public void save(Book book) {
        // Implementa la lógica para guardar un nuevo libro
        books.add(book);
        // También actualiza el archivo JSON con los libros
        // FileBook.saveToFile(books);
    }
    public List<Book> getBooks() {
        return books;
    }
}