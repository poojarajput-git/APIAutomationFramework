package core;


public enum statusCode {

    SUCCESS(200, "request succeded"),
    BAD_REQUEST(400, "bad request sent");



    public final int code;

    public final String message;

    statusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
