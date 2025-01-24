package com.athar.book.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private long id;
    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String ownerName;
    private byte[] cover;
    private double rate;
    private boolean shareable;
    private boolean archived;
}
