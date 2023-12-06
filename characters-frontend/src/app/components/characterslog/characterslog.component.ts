import { AfterViewInit,Component,ViewChild } from '@angular/core';
import { MatTableDataSource} from '@angular/material/table';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BehaviorSubject, Observable,  of as observableOf} from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Characterlog } from 'src/app/core/models/characterslog/characterlog.model';
import { CharactersService } from 'src/app/services/characters.service';

@Component({
  selector: 'app-characterslog',
  templateUrl: './characterslog.component.html',
  styleUrls: ['./characterslog.component.css']
})
export class CharacterslogComponent  implements AfterViewInit {

  displayedColumns: string[] = ['id', 'url',  'datelog'];

  datasource!: MatTableDataSource<Characterlog>;
  @ViewChild(MatTableDataSource) table!: MatTableDataSource<Characterlog>; 

  constructor(public dialog: MatDialog,
              private charactersService: CharactersService,
              private router: Router){}

  ngAfterViewInit() {

   setTimeout(() => {   
    this.charactersService.findAllCharacerLog().subscribe(data =>{
      this.datasource = new MatTableDataSource(data);
    });
   });
  }

}
