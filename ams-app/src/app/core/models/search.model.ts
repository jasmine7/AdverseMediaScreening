import {Client} from "./client.model";
import {Keyword} from "./keyword.model";
import {User} from "./user.model";

export class Search {
  id: number;
  createdDate: string;
  user: User;
  dateRestrict: string;
  client: Client;
  keywords: Keyword[];
  resultCount: number;
}
