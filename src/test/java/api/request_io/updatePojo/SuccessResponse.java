package api.request_io.updatePojo;

public class SuccessResponse extends User{
    private String updatedAt;

    public SuccessResponse(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }
    public SuccessResponse(){

    }
    public String getUpdatedAt() {
        return updatedAt;
    }
}
