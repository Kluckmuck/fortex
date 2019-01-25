import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WayBillFormComponent } from './way-bill-form.component';

describe('WayBillFormComponent', () => {
  let component: WayBillFormComponent;
  let fixture: ComponentFixture<WayBillFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WayBillFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WayBillFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
