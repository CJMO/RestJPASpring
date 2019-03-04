import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-ave',
  templateUrl: './ave.component.html',
  styleUrls: ['./ave.component.css']
})
export class AveComponent implements OnInit {

  aves:any = [];

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getAves();
  }

  getAves() {
    this.aves = [];
    this.rest.getAves().subscribe((data: {}) => {
      console.log(data);
      this.aves = data;
    });
  }

  add() {
    //this.router.navigate(['/ave-add']);
  }

  eliminar(id) {
    /*this.rest.eliminarAve(id)
      .subscribe(res => {
          this.getAves();
        }, (err) => {
          console.log(err);
        }
      );*/
  }

}