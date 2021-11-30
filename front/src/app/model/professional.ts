import {User} from "./user";

export class Professional extends User{
  job:string;
  password:string;
  agenda:Object;
  account:Object;
  appointments:Object[];
}
