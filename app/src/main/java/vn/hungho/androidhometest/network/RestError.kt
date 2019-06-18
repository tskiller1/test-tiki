package vn.hungho.androidhometest.network

class RestError {
    var code: Int? = null
    var message: String? = null

    constructor(code: Int?, message: String?) {
        this.code = code
        this.message = message
    }
}