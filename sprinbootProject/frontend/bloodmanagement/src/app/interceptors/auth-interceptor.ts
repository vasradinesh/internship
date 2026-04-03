import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { tap, throwError } from 'rxjs';
import { Mystorage } from '../service/mystorage';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
   const router = inject(Router);
   const myStorage = inject(Mystorage)


  // Skip backend auth APIs
  const skipUrls = [
    '/auth/login',
    '/auth/register',
     '/auth/forget-password',
  '/auth/verifyotp',
  '/auth/resetPassword'
  ];

  const shouldSkip = skipUrls.some(url => req.url.includes(url));

  if (shouldSkip) {
    return next(req);
  }

  const token = localStorage.getItem('token');

  console.log('tewetee');
console.log(token);

if (!token || myStorage.isTokenExpired(token)) {
      myStorage.removeitem('token');
      router.navigate(['/login']);
      return throwError(() => new Error('Token expired. Logging out.'));
    }

  if (token) {
    console.log(token);
    
    const cloneReq = req.clone({
      setHeaders: {
        Authorization: 'Bearer ' + token,
         'Content-Type': 'application/json' 
      }
    });

     return next(cloneReq)
     //.pipe(
    //   tap({
    //     error: (err) => {
    //       if (err.status === 401) {
    //         localStorage.removeItem('token');
    //         router.navigate(['/login']);
    //       }
    //     }
    //   })
    // );
  }

  return next(req);
};
