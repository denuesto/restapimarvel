import { AfterViewInit,Component,ViewChild,Inject } from '@angular/core';
import { MatTableDataSource} from '@angular/material/table';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BehaviorSubject, Observable,  of as observableOf} from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Character } from 'src/app/core/models/characters/character.model';
import { CharactersService } from 'src/app/services/characters.service';
import { DialogData } from 'src/app/core/models/dialog/dialog-data.model';

@Component({
  selector: 'app-characters',
  templateUrl: './characters.component.html',
  styleUrls: ['./characters.component.css']
})
export class CharactersComponent implements AfterViewInit {

  displayedColumns: string[] = ['id', 'name',  'actions'];

  datasource!: MatTableDataSource<Character>;
  @ViewChild(MatTableDataSource) table!: MatTableDataSource<Character>; 

  constructor(public dialog: MatDialog,
              private charactersService: CharactersService,
              private router: Router){}

  ngAfterViewInit() {

   setTimeout(() => {   
    this.charactersService.findAll().subscribe(data =>{
      this.datasource = new MatTableDataSource(data);
    });
   });
  }



  view(id:string):void{
    console.log('view'+ id);
    this.charactersService.findById(id).subscribe(data =>{
      console.log(data);

      const dialogRef = this.dialog.open(DialogCharacterDetailComponent,{
        width:'650px',
        data:{ 
          message:'Character Details',
          details:data
        }
  
      });
  
      dialogRef.afterClosed().subscribe(res => {
        console.log(res); 
        /*if(res){
            this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
              this.router.navigate(['dashboard/hospitalapi']);
          });
        }*/
      });

    });
  }


}

@Component({
  selector: 'app-dialogcharacters',
  templateUrl: 'dialog.html',
  styleUrls: ['./dialog.css'],
})
export class DialogCharacterDetailComponent {

  constructor(
    public dialogRef: MatDialogRef<DialogCharacterDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  cancelClick(): void {
    this.dialogRef.close();
  }
}