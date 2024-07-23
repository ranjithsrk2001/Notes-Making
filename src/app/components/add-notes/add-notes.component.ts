import { Component } from '@angular/core';
import { NoteServiceService } from '../../services/note-service.service';
import { Router } from '@angular/router';
import { Notes } from '../../notes';

@Component({
  selector: 'app-add-notes',
  templateUrl: './add-notes.component.html',
  styleUrl: './add-notes.component.css'
})
export class AddNotesComponent {
  formData: Notes = {
    id:0,
    title: '', content: '', category: '',
    
  };
 // formData!: Notes;

  constructor( private service:NoteServiceService,private router: Router) {}
  
  saveNotes(){
    this.service.setNotes(this.formData).subscribe();
    
    this.router.navigate(['/notesList']);
   
    
  }
  submitForm() {
   this.saveNotes();
   
  }
}
