import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-hotel',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './hotel.component.html',
  styleUrl: './hotel.component.css'
})
export class HotelComponent implements OnInit {

  isFilterOn = false;
  hotelList:any=[]
  constructor(private hotelService:HotelService){}

  city=new FormControl("")
  rating=new FormControl("")

  filterGroup = new FormGroup({
    city:this.city,
    rating:this.rating
  })

  ngOnInit(): void {
    this.hotelService.getAll().subscribe(res=>{
      console.log(res.payload);
      this.hotelList=res.payload;
    })
  }

  onfilterForm(){
    this.isFilterOn=!this.isFilterOn
  }

  fetchFilterData(){
    this.isFilterOn=!this.isFilterOn
    if(this.filterGroup.valid){
      let newHotelList: any[]=[]
      this.hotelList.array.forEach((hotel: any) => {
        
        
        if(this.filterGroup.value.rating && this.filterGroup.value.city){

          if(hotel.city===this.filterGroup.value.city && hotel.rating===this.filterGroup.value.rating){
            newHotelList.push(hotel);
          }
        
        }
        else if(this.filterGroup.value.city){

          if(hotel.city===this.filterGroup.value.city){
            newHotelList.push(hotel);
          }
          
        }else if(this.filterGroup.value.rating){
          if(hotel.rating===this.filterGroup.value.rating){
            newHotelList.push(hotel);
          }
        }
      });

      this.hotelList=newHotelList;
    }
 
  }
}
