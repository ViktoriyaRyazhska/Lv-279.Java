import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class BaseService {

  protected basePath = "http://localhost:8080/";
  protected parPath:string;

  constructor(private client: HttpClient) {

  }

  protected generateUrl(): string{
    return this.basePath + this.parPath;
  }

}
