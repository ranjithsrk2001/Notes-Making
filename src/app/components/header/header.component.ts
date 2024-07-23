import { Component, OnInit } from '@angular/core';
import { Notes } from '../../notes';
import { NoteServiceService } from '../../services/note-service.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent  implements OnInit{

 
  notesList: Notes[] = []; 
  constructor(private service: NoteServiceService,private router:Router) {}
 
  ngOnInit():void{
 
  }


  handleAdd(){
    this.router.navigate(['/addNotes']);
  }

  callMethod(category:string): void {
    const argument = category; // or any value you want to pass
    // Set the argument in the service
    console.log(argument);
    this.service.setArgument(argument);
  }

}
