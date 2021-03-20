package automation.practice.domain;

import lombok.Getter;
import lombok.Setter;

public class Book {
  public Book() { }

  public Book(String name, String author) {
    this.name = name;
    this.author = author;
  }

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String author;
}
