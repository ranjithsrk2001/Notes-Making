import { Component, OnInit } from '@angular/core';
import { Notes } from '../../notes';
import { NoteServiceService } from '../../services/note-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-notes',
  templateUrl: './update-notes.component.html',
  styleUrl: './update-notes.component.css'
})
export class UpdateNotesComponent implements OnInit{
  id: number = 0;
  formData: Notes = {
    id:0,
    title: '', content: '', category: '',
    
  };


  constructor(private service: NoteServiceService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    
    this.id = this.route.snapshot.params['id'];
    this.service.getById(this.id).subscribe(data => {
      this.formData=data;
    });
  }


  updateNotes() {
   this.service.updateNotes(this.id,this.formData).subscribe(data =>{
    this.router.navigate(['/notesList']);
    
   })
  }

  submitForm() {
    this.updateNotes();
  }
}
