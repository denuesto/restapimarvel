import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterslogComponent } from './characterslog.component';

describe('CharacterslogComponent', () => {
  let component: CharacterslogComponent;
  let fixture: ComponentFixture<CharacterslogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CharacterslogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CharacterslogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
