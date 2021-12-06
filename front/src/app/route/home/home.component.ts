import { Component, OnInit } from '@angular/core';
import {AccountService} from "../../service/account-service";
import {Account} from "../../model/account";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentAccount: Account | undefined;

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
  }

}
