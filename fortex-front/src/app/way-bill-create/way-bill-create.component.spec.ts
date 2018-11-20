import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WayBillCreateComponent } from './way-bill-create.component';

describe('WayBillCreateComponent', () => {
  let component: WayBillCreateComponent;
  let fixture: ComponentFixture<WayBillCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WayBillCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WayBillCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
