import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ComponentReloadService {
  private reloadTrigger = new Subject<void>();
  reload$ = this.reloadTrigger.asObservable();

  triggerReload() {
    this.reloadTrigger.next();
  }
}
