import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Mystorage {

  setitem(key:any,item:any){
    localStorage.setItem(key,item);
  }

  removeitem(key:any){
    localStorage.removeItem(key);
  }

  getitem(key:any){
    return localStorage.getItem(key);
  }

  removeAllItem(){
    localStorage.clear();
  }

  getUserEmail(): string | null {
  return this.getitem('email');
}

getUserDetails() {
  const token = this.getitem('token');
  if (!token) return null;

  const payload = JSON.parse(atob(token.split('.')[1]));

  return {
    email: payload.sub,    
    role: payload.roles ? payload.roles[0] : payload.role
  };
}
isTokenExpired(token: string): boolean {
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      const now = Math.floor(new Date().getTime() / 1000);
      return payload.exp < now; // true if expired
    } catch (e) {
      return true; // invalid token as expired
    }
  }


  getUserRole(): string | null {

  const token = this.getitem('token');

  if (!token) return null;

  try {
    const payload: any = JSON.parse(atob(token.split('.')[1]));

    if (payload.roles) {
      return payload.roles[0];   // ["ROLE_ADMIN"]
    }

    if (payload.role) {
      return payload.role;       // "ROLE_ADMIN"
    }

    if (payload.authorities) {
      return payload.authorities[0]; // ["ROLE_ADMIN"]
    }

    return null;

  } catch (error) {
    console.error('Invalid token');
    return null;
  }
}

}
