import {NgModule} from "@angular/core";
import {ResultDetailsComponent} from "./result-details.component";
import {CommonModule} from "@angular/common";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
    declarations: [ResultDetailsComponent],
    exports: [
        ResultDetailsComponent
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        RouterModule,
        SharedModule
    ]
})
export class ResultDetailsModule {

}
