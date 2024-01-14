import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appDrag]'
})
export class DragDirective {
  constructor(private el: ElementRef) { }
}

describe('DragDirective', () => {
  it('should create an instance', () => {
    const el = new ElementRef(document.createElement('div'));
    const directive = new DragDirective(el);
    expect(directive).toBeTruthy();
  });
});