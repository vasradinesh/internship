import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router } from '@angular/router';
import { Mystorage } from '../service/mystorage';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate{

  constructor(
    private router: Router,
    private storage: Mystorage
  ) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {

    // get role from token
    const userRole = this.storage.getUserRole();

    //get required role from route
    const expectedRole = route.data['role'];

    if (userRole === expectedRole) {
      return true; // allow
    } else {
      alert("Access Denied ");
      this.router.navigate(['/login']); // redirect
      return false;
    }
  }
}
