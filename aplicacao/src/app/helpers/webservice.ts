import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';

@Injectable()
export class Webservice {
    _http: Http;
    _headers: Headers;
    _url: string = 'http://localhost:8080/projetoIntegrador/';

    constructor(http: Http) {
        this._http = http;
        this._headers = new Headers();
        this._headers.append('Content-Type', 'application/json');
    }

    getWebserviceUrl() {
        return this._url;
    }

    post(url: string, obj: string): Observable<Response> {
        return this._http
            .post(this._url + url, obj, { headers: this._headers });
    }

    get(url: string): Observable<Response> {
        return this._http.get(this._url + url);
    }

    put(url: string, obj: string): Observable<Response> {
        return this._http
            .post(this._url + url, obj, { headers: this._headers });
    }

    none(): Observable<Response> {
        return this._http.get('');
    }
}