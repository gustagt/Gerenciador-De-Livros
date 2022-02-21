import { Injectable } from '@angular/core';
import Swal, { SweetAlertIcon } from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor() { }

  private showAlert( message:string, icon: SweetAlertIcon): void{
    Swal.fire(message, icon);
  }

  public error(message: string):void{
    this.showAlert(message , 'error');
  }

  public sucess(message: string):void{
    this.showAlert(message , 'success');
  }
}
