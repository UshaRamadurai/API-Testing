package Swagger;

public class CreateUserResponse {
    private int code;
    private String type;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printResponseBody(){
        System.out.println("code : " +getCode()+"\n"+
                "type : " + getType()+"\n"+
                "message : " +getMessage()+"\n");
    }
}