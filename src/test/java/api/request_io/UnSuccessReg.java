package api.request_io;

public class UnSuccessReg {
    private String error;

    public UnSuccessReg(String error) {
        this.error = error;
    }

    public UnSuccessReg() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
