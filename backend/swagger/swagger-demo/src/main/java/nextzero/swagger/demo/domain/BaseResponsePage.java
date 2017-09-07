package nextzero.swagger.demo.domain;


public class BaseResponsePage extends BaseResponse{
    protected Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
