import {Component, OnInit} from '@angular/core';
import {BookRequest} from '../../../../services/models/book-request';
import {FormsModule} from '@angular/forms';
import {BookService} from '../../../../services/services/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BookResponse} from '../../../../services/models/book-response';

@Component({
  selector: 'app-manage-book',
  imports: [],
  templateUrl: './manage-book.component.html',
  styleUrl: './manage-book.component.css'
})
export class ManageBookComponent implements OnInit {
  bookRequest: BookRequest = {authorName: "", isbn: "", synopsis: "", title: ""};
  errorMsg: Array<string> = [];
  selectedBookCover: any;
  selectedPicture: string | undefined;

  constructor(
    private bookService: BookService,
    private router: Router,
    private activatedRout: ActivatedRoute
  ) {
  }

  onFileSelected(event: any) {
    this.selectedBookCover = event.target.files[0];
    console.log(this.selectedBookCover);
    if (this.selectedBookCover) {
      const reader = new FileReader();
      reader.onload = () => {
        this.selectedPicture = reader.result as string;
      }
      reader.readAsDataURL(this.selectedBookCover);
    }
  }

  saveBook() {
    this.bookService.saveBook({
      body: this.bookRequest
    }).subscribe({
      next: (bookId) => {
        this.bookService.uploadBookCoverPicture({
          'book-id': bookId,
          body: {
            file: this.selectedBookCover
          }
        }).subscribe({
          next: () => {
            this.router.navigate(['/books/my-books']);
          }
        })
      },
      error: err => {
        this.errorMsg = err.error.validatonErrors;
      }
    });
  }

  ngOnInit(): void {
    const bookId = this.activatedRout.snapshot.params['bookId'];
    if (bookId) {
      this.bookService.findBookById({
        'book-id': bookId
      }).subscribe({
        next: (book: BookResponse) => {
          this.bookRequest = {
            id: book.id,
            authorName: book.authorName as string,
            isbn: book.isbn as string,
            synopsis: book.synopsis as string,
            title: book.title as string,
            shareable: book.shareable
          }
          if (book.cover) {
            this.selectedPicture = 'data:image/jpg;base64,' + book.cover;
          }
        }
      });
    }
  }
}
