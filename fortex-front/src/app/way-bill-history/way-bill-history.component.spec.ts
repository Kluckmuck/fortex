import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WayBillHistoryComponent } from './way-bill-history.component';

describe('WayBillHistoryComponent', () => {
  let component: WayBillHistoryComponent;
  let fixture: ComponentFixture<WayBillHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WayBillHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WayBillHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
