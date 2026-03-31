import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Home } from './home/home';
import { About } from './about/about';
import { Login } from './login/login';
import { Registration } from './registration/registration';
import { Notfound } from './notfound/notfound';
import { GetBook } from './get-book/get-book';
import { Signup } from './signup/signup';

const routes: Routes = [
  {path:'home',component:Home},
  {path:'about',component:About},
  {path:'login',component:Login},
  {path:'registration',component:Registration},
  {path:'getbooks',component:GetBook},
  {path:'signup',component:Signup},
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'**',component:Notfound},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
