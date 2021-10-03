import {User} from "./user.model";

export class Decision {
  id: number;
  decision: boolean;
  date: string;
  user: User
}
