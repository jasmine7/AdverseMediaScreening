import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddNewClientComponent} from "./add-new-client.component";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
    declarations: [
        AddNewClientComponent
    ],
    exports: [
        AddNewClientComponent
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule
    ]
})
export class AddNewClientModule { }
