public class Books {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Books(String title, String author, String isbn, int publicationYear) {
        if (title == null || author == null || isbn == null) {
            throw new IllegalArgumentException("Title, author, and ISBN cannot be null");
        }
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            throw new IllegalArgumentException("Title, author, and ISBN cannot be empty");
        }
        if (!isbn.matches("\\d{3}-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1}")) {
            throw new IllegalArgumentException("ISBN format is invalid");
        }
        if (publicationYear < 1450 || publicationYear > 2023) {
            throw new IllegalArgumentException("Publication year must be between 1450 and 2023");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }       
}
