package nextzero.web.server.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class BaseResponsePage<T>{

    @ApiModelProperty(value = "错误码")
    protected int error;

    @ApiModelProperty(value = "错误说明")
    protected String msg;

    @ApiModelProperty(value = "当前条件查询的数据量总数")
    protected long total;

    @ApiModelProperty(value = "业务数据")
    protected List<T> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
