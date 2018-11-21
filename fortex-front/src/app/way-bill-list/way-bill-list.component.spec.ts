import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WayBillListComponent } from './way-bill-list.component';

describe('WayBillListComponent', () => {
  let component: WayBillListComponent;
  let fixture: ComponentFixture<WayBillListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WayBillListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WayBillListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
