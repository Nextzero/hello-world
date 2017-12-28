package nextzero.web.server.demo.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BaseResponse<T> {
    @ApiModelProperty(value = "错误码")
    protected int error;

    @ApiModelProperty(value = "错误说明")
    protected String msg;


    @ApiModelProperty(value = "业务数据")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected T data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
