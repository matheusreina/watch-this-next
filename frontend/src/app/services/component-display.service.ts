import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ComponentDisplayService {
  private openComponentId: string | null = null;

  constructor() {}

  setOpenComponentId(id: string) {
    this.openComponentId = id;
  }

  isComponentOpen(id: string): boolean {
    return this.openComponentId === id;
  }

  closeComponent() {
    this.openComponentId = null;
  }
}
