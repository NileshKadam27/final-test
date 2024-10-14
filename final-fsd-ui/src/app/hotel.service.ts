import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  hotelUrl="/api";
  constructor(private httpclient:HttpClient) { }

  getAll():Observable<any>{
    return this.httpclient.get(this.hotelUrl+"/hotel");
  }
}
