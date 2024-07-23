import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNotesComponent } from './components/add-notes/add-notes.component';
import { NotesListComponent } from './components/notes-list/notes-list.component';
import { UpdateNotesComponent } from './components/update-notes/update-notes.component';

const routes: Routes = [
  { path: 'addNotes', component: AddNotesComponent },
  { path: 'notesList', component:NotesListComponent },
  { path: 'updateNotes/:id' , component:UpdateNotesComponent},
  { path: '', redirectTo: 'notesList', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
