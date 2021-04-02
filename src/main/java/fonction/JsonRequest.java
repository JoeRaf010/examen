package fonction;

public class JsonRequest {
	int status;
   	Object data;
    String message;
    public JsonRequest() {
    }
    public JsonRequest(int status, Object data, String message) {
        super();
    	this.status = status;
        this.data= data;
        this.message = message;
    }
    public int getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
    
  

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }  

}
