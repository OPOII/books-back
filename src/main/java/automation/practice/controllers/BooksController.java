package automation.practice.controllers;

import automation.practice.controllers.dto.BookDto;
import automation.practice.domain.Book;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("books")
@CrossOrigin
public class BooksController {
  private HashMap<String, Book> books;

  public BooksController() {
    books = new HashMap<String, Book>() {{
      put(UUID.randomUUID().toString(), new Book("Patterns of Enterprise Application Architecture", "Martin Fowler"));
      put(UUID.randomUUID().toString(), new Book("Clean Architecture: A Craftsman's Guide to Software Structure and Design", "Robert C. \"Uncle Bob\" Martin"));
      put(UUID.randomUUID().toString(), new Book("The Art of Computer Programming", "Donald Knuth"));
      put(UUID.randomUUID().toString(), new Book("CODE: The Hidden Language of Computer Hardware and Software", "Charles Petzold"));
      put(UUID.randomUUID().toString(), new Book("Agile Software Development: Principles, Patterns, and Practices", "Robert C. \"Uncle Bob\" Martin"));
      put(UUID.randomUUID().toString(), new Book("Introduction to Algorithms", "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein"));
      put(UUID.randomUUID().toString(), new Book("Head First Design Patterns: A Brain-Friendly Guide", "Eric Freeman, Elizabeth Robson, Kathy Sierra, and Bert Bales"));
      put(UUID.randomUUID().toString(), new Book("Cracking the Coding Interview: 189 Programming Questions and Solutions", "Gayle Laakmann McDowell"));
      put(UUID.randomUUID().toString(), new Book("Don't Make Me Think: A Common Sense Approach to Web Usability", "Steve Krug"));
      put(UUID.randomUUID().toString(), new Book("The Clean Coder: A Code of Conduct for Professional Programmers", "Robert C. \"Uncle Bob\" Martin"));
      put(UUID.randomUUID().toString(), new Book("Soft Skills: The Software Developer's Life Manual", "John Sonmez"));
      put(UUID.randomUUID().toString(), new Book("Peopleware: Productive Projects and Teams", "Tom DeMarco and Timothy Lister"));
      put(UUID.randomUUID().toString(), new Book("Programming Pearls", "Jon Bentley"));
      put(UUID.randomUUID().toString(), new Book("Working Effectively with Legacy Code", "Michael Feathers"));
      put(UUID.randomUUID().toString(), new Book("The Mythical Man-Month: Essays on Software Engineering", "Frederick P. Brooks"));
      put(UUID.randomUUID().toString(), new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler"));
      put(UUID.randomUUID().toString(), new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, and Ralph Johnson"));
      put(UUID.randomUUID().toString(), new Book("Code Complete: A Practical Handbook of Software Construction", "Steve McConnell"));
      put(UUID.randomUUID().toString(), new Book("The Pragmatic Programmer: From Journeyman to Master", "Andrew Hunt and Dave Thomas"));
      put(UUID.randomUUID().toString(), new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. \"Uncle Bob\" Martin"));
    }};
  }

  @GetMapping("")
  public List<BookDto> getBooks() {
    return books.entrySet().stream().map(current -> {
      var id = current.getKey();
      var book = current.getValue();

      return new BookDto(id, book.getName(), book.getAuthor());
    }).collect(Collectors.toList());
  }

  @DeleteMapping("{id}")
  public void removeBook(@PathVariable("id") String bookId) {
    books.remove(bookId);
  }

  @PostMapping("")
  public BookDto saveBook(@RequestBody BookDto dto) {
    var id = UUID.randomUUID().toString();

    books.put(id, new Book(dto.getName(), dto.getAuthor()));

    return new BookDto(id, dto.getName(), dto.getAuthor());
  }

  @PutMapping("{id}")
  public BookDto updateBook(@PathVariable("id") String bookId, @RequestBody BookDto dto) {
    books.put(bookId, new Book(dto.getName(), dto.getAuthor()));

    return new BookDto(bookId, dto.getName(), dto.getAuthor());
  }
}
