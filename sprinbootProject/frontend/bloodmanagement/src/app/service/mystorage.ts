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


  getUserRole(): string | null {

  const token = this.getitem('token'); // ✅ your key

  if (!token) return null;

  try {
    const payload: any = JSON.parse(atob(token.split('.')[1]));

    // 🔥 handle different backend formats
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
