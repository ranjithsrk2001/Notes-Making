import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Notes } from '../notes';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NoteServiceService {
  private notesUrl="http://localhost:2020/api/v1/notes";
  private notesCategoryUrl="http://localhost:2020/api/v1/notes/category";
  //private categoryName:string='';
  argument: string ='';
  constructor(private httpclient:HttpClient) { }

  setNotes(notes:Notes):Observable<object>{
    
    return this.httpclient.post(this.notesUrl,notes);
  }
  getNotesList():Observable<Notes[]>{
    return this.httpclient.get<Notes[]>(this.notesUrl);
  }

  getById(id: number): Observable<Notes> { // Specify return type as Observable<Notes>
    return this.httpclient.get<Notes>(`${this.notesUrl}/${id}`); // Specify the expected type as Notes
  }

  updateNotes(id:number,notes:Notes):Observable<Object>{
    return this.httpclient.put(`${this.notesUrl}/${id}`,notes);
  }

  deleteNotes(id:number):Observable<Object>{
    return this.httpclient.delete(`${this.notesUrl}/${id}`);
  }

  setArgument(arg: string): void {
    this.argument = arg;
    
  }

  getArgument() {
    
    return this.argument;
  } 

  categoryrNotes(ar:string):Observable<Notes[]>{
   return this.httpclient.get<Notes[]>(`${this.notesCategoryUrl}/${ar}`);
      

  }

}
