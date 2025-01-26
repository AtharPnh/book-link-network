package com.athar.book.history;

import com.athar.book.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Long> {
    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.user.id = :userId
            """)
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Long userId);

    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.book.owner.id = :userId
            """)
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Long userId);

    @Query("""
            SELECT
            (COUNT(*) > 0) AS isBorrowed
            FROM BookTransactionHistory history
            WHERE history.user.id = :userID
            AND history.book.id = :bookId
            AND history.returnApproved = false 
            """)
    boolean isAlreadyBorrowedByUser(long bookId, Long userID);

    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.user.id = :userID
            AND history.book.id = :bookId
            AND history.returned = false
            AND history.returnApproved = false
            """)
    Optional<BookTransactionHistory> findByBookIdAndUserId(long bookId, Long userID);

    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.book.owner.id = :userID
            AND history.book.id = :bookId
            AND history.returned = true
            AND history.returnApproved = false
            """)
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(long bookId, Long userID);
}
