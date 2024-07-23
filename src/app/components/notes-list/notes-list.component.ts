import { ChangeDetectorRef, Component, HostListener } from '@angular/core';
import { NoteServiceService } from '../../services/note-service.service';
import { Router } from '@angular/router';
import { Notes } from '../../notes';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-notes-list',
  templateUrl: './notes-list.component.html',
  styleUrl: './notes-list.component.css'
})
export class NotesListComponent {
[x: string]: any;
  
  showDropdown: number | null = null;
  menuVisibility: { [key: number]: boolean } = {};
  notesList: Notes[] = []; 
  searchNotes:string='';

  constructor(private service: NoteServiceService,private router:Router, private cdr: ChangeDetectorRef) { 
    
   
  }
  
  ngOnInit(): void {
      this.getNotes();
    
     
  }

  getNotes() {
    this.service.getNotesList().subscribe(data => {
      this.notesList = data; // Assign the retrieved data to notesList property
      this.cdr.detectChanges();
    });
  }
  
  updateNotes(id: number): void {
    this.router.navigate(['/updateNotes', id]); // Assuming '/editNotes/:id' is the route to edit a note
  }


  deleteNotes(id: number): void {
    this.service.deleteNotes(id).subscribe(
      () => {
        this.getNotes();
      },
      (error) => {
        // This code will be executed if there's an error during deletion
        console.error('Error deleting note:', error);
        // Handle the error as needed
      }
    );
  }
  
  toggleMenu(noteId: number) {
    // Toggle the visibility of the menu associated with the clicked card
    this.menuVisibility[noteId] = !this.menuVisibility[noteId];
    console.log(noteId);
}



handleAdd(){
  this.router.navigate(['/addNotes']);
}

getByCategory(category:string){
  this.service.categoryrNotes(category).subscribe((data) =>{
 this.notesList = data;
  })
}


showList(): void {
  if (this.notesList) {
    
    if (this.searchNotes) {
    
      this.notesList = this.notesList.filter(data =>
        data.title.toLowerCase().includes(this.searchNotes.toLowerCase())
      );
    }
    else {
      this.getNotes();
    }
  } 
}
activeTool: string = 'All'; // Initialize the active tool to 'All'

// Function to update the active tool and apply the active class
setActiveTool(tool: string): void {
  this.activeTool = tool;
}
}
