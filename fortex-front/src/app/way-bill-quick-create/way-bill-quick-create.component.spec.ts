import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WayBillQuickCreateComponent } from './way-bill-quick-create.component';

describe('WayBillQuickCreateComponent', () => {
  let component: WayBillQuickCreateComponent;
  let fixture: ComponentFixture<WayBillQuickCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WayBillQuickCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WayBillQuickCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
