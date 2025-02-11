import { Injectable } from '@angular/core';
import {Token} from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  set token(token: string) {
    localStorage.setItem('token', token);
  }

  get token() {
    return  localStorage.getItem('token') as string;
  }
}
