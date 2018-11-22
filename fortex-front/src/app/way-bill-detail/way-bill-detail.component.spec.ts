import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WayBillDetailComponent } from './way-bill-detail.component';

describe('WayBillDetailComponent', () => {
  let component: WayBillDetailComponent;
  let fixture: ComponentFixture<WayBillDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WayBillDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WayBillDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
