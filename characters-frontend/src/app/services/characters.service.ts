import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import {from, Observable} from 'rxjs';
import { Character } from '../core/models/characters/character.model';
import { Characterlog } from '../core/models/characterslog/characterlog.model';

@Injectable({
  providedIn: 'root'
})
export class CharactersService {

  private urlPath='http://localhost:9090/backend/restapi';

  constructor(private http: HttpClient) { }

  
  public findAll():Observable<Character[]>{

    return this.http.get<Character[]>(this.urlPath.concat('/characters'),{
      headers: new HttpHeaders(
        {'Content-type':'application/json; charset=utf-8'}
      )
    });

  }

  public findById(id: string):Observable<Character>{

    return this.http.get<Character>(this.urlPath.concat("/characters/").concat(id),{
      headers: new HttpHeaders(
        {'Content-type':'application/json; charset=utf-8'}
      )
    });

  }

  public findAllCharacerLog():Observable<Characterlog[]>{

    return this.http.get<Characterlog[]>(this.urlPath.concat("/logcharacters"),{
      headers: new HttpHeaders(
        {'Content-type':'application/json; charset=utf-8'}
      )
    });

  }

}
