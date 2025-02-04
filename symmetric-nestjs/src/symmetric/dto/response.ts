export class Response {
    timestamp: Date;
    token: string;

    constructor(token: string) {
        this.token = token;
        this.timestamp = new Date();
    }
}