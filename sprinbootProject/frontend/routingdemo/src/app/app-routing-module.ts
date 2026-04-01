import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { About } from './about/about';
import { Contact } from './contact/contact';
import { Login } from './login/login';
import { Home } from './home/home';
import { Notfound } from './notfound/notfound';
import { Registration } from './registration/registration';
import { Profile } from './profile/profile';

const routes: Routes = [
  {path:'about',component:About},
  {path:'contact',component:Contact},
  {path:'login',component:Login},
  {path:'home',component:Home},
  {path:'registration',component:Registration},
  {path:'',redirectTo:'home', pathMatch:'full'},
  {path:'profile',component:Profile},
  {path:'profile/:id',component:Profile},
  {path:'**',component:Notfound},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
