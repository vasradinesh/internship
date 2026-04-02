import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { tap } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
   const router = inject(Router);


  // Skip backend auth APIs
  const skipUrls = [
    '/auth/login',
    '/auth/register'
  ];

  const shouldSkip = skipUrls.some(url => req.url.includes(url));

  if (shouldSkip) {
    return next(req);
  }

  const token = localStorage.getItem('token');

  console.log('tewetee');
console.log(token);

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
