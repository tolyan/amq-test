package amqtest.ws.echo;

class Message {
    var data: String? = null

    constructor() {}
    constructor(data: String?) {
        this.data = data
    }
}