import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CharactersComponent } from './components/characters/characters.component';
import { CharacterslogComponent } from './components/characterslog/characterslog.component';

const routes: Routes = [
  {path:'', redirectTo:'/characters',pathMatch:'full'},
  {
    path:'characters', component:CharactersComponent
  },
  {
    path:'characterslog', component:CharacterslogComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
