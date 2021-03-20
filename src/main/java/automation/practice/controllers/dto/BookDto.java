package automation.practice.controllers.dto;

import lombok.Getter;
import lombok.Setter;

public class BookDto {
    public BookDto(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String author;
}
