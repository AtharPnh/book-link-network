package com.athar.book.feedback;

import com.athar.book.book.Book;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

public record FeedbackRequest(
        @Positive(message = "200")
        @Min(value = 0, message = "201")
        @Max(value = 0, message = "202")
        Double note,
        @NotNull(message = "203")
        @NotEmpty(message = "203")
        @NotBlank(message = "203")
        String comment,
        @NotNull(message = "204")
        Long bookId
) {
}
