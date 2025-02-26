import {Component, OnInit} from '@angular/core';
import {PageResponseBorrowedBookResponse} from '../../../../services/models/page-response-borrowed-book-response';
import {FeedbackRequest} from '../../../../services/models/feedback-request';
import {BorrowedBookResponse} from '../../../../services/models/borrowed-book-response';
import {BookService} from '../../../../services/services/book.service';
import {FeedbackService} from '../../../../services/services/feedback.service';

@Component({
  selector: 'app-returned-books-list',
  imports: [],
  templateUrl: './returned-books-list.component.html',
  styleUrl: './returned-books-list.component.css'
})
export class ReturnedBooksListComponent implements OnInit {
  returnedBooks: PageResponseBorrowedBookResponse = {};
  page = 0;
  size = 5;
  message: string = '';
  level: string = 'success';

  constructor(
    private bookService: BookService,
  ) {
  }

  ngOnInit(): void {
    this.findAllReturnededBooks();
  }

  private findAllReturnededBooks() {
    this.bookService.findAllReturnedBooks({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (resp: PageResponseBorrowedBookResponse) => {
        this.returnedBooks = resp;
      }
    });
  }

  goToFirstPage() {
    this.page = 0;
    this.findAllReturnededBooks();
  }

  goToLastPage() {
    this.page = this.returnedBooks.totalPages as number - 1;
    this.findAllReturnededBooks();
  }

  goToPreviousPage() {
    this.page--;
    this.findAllReturnededBooks();
  }

  goToPage(pageIndex: number) {
    this.page = pageIndex;
    this.findAllReturnededBooks();
  }

  goToNextPage() {
    this.page++;
    this.findAllReturnededBooks();
  }

  get isLastPage(): boolean {
    return this.page == this.returnedBooks.totalPages as number - 1;
  }

  approveBookReturned(book: BorrowedBookResponse) {
    if (!book.returned) {
      return;
    }
    this.bookService.approveReturnBorrowBook({
      'book-id': book.id as number
    }).subscribe({
      next: () => {
        this.level='success';
        this.message='BOOK RETURN APPROVED';
        this.findAllReturnededBooks();
      }
    })
  }
}
