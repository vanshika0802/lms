import java.util.Scanner;

//creating a class book

class Book {
    private String title;
    private String author;
    private boolean available;

    //creating a constructor

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    /*  creating a method getTitle
        creating a method getAuthor
        creating a method isAvailable
        creating a method borrowBook
        craeting a method returnBook*/

        // using polymorphism
        // using getter method

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }
}
// creating a class Library

class Library {
    private Book[] books;
    private int bookCount;

//creating a method Library

    public (Library int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    // creating a method addBook

    public void addBook(String title, String author) {

        //using conditional if else statements
        if (bookCount < books.length) {
            books[bookCount] = new Book(title, author);
            bookCount++;
            System.out.println("Book added successfully.")
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    //creating a method displayBooks

    public void displayBooks() {
        System.out.println("Books in the library:");

        // using for loop statememt

        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + books[i].getTitle() + " by " + books[i].getAuthor() +
                    (books[i].isAvailable() ? " (Available)" : " (Borrowed)"));
        }

        // using conditional satement if

        if (bookCount == 0) {
            System.out.println("No books in the library.");
        }
    }
    // creating a method borrowBook

    public void borrowBook(int index) {

        //using conditional statement

        if (index >= 1 && index <= bookCount) {
            if (books[index - 1].isAvailable()) {
                books[index - 1].borrowBook();
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("This book is already borrowed.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
    // creating a method returnBook

    public void returnBook(int index) {

        // using conditional statements

        if (index >= 1 && index <= bookCount) {
            if (!books[index - 1].isAvailable()) {
                books[index - 1].returnBook();
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("This book is not currently borrowed.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
}
// creating main class of Library management system

public class LMS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");
        System.out.print("Enter the maximum number of books the library can hold: ");
        int libraryCapacity = scanner.nextInt();

        Library library = new Library(libraryCapacity);

        // using while loop

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // using switch case statements

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.displayBooks();
                    System.out.print("Enter the index of the book you want to borrow: ");
                    int borrowIndex = scanner.nextInt();
                    library.borrowBook(borrowIndex);
                    break;
                case 3:
                    library.displayBooks();
                    System.out.print("Enter the index of the book you want to return: ");
                    int returnIndex = scanner.nextInt();
                    library.returnBook(returnIndex);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
