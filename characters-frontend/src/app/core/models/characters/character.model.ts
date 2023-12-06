import { Thumbnail } from "../thumbnail/thumbnail.model"; 
export class Character{
    id: number=0;
    name: string = "";
    description: string = "";
    thumbnail: Thumbnail = new Thumbnail();
}