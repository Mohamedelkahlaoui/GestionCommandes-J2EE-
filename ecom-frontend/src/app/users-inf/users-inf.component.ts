import { Component, OnInit } from '@angular/core';
import { User } from '../_model/user.model';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-users-inf',
  templateUrl: './users-inf.component.html',
  styleUrls: ['./users-inf.component.css']
})
export class UsersInfComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(users => this.users = users);
  }

}
