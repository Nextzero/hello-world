package nextzero.web.server.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 分页请求
 * @param <T>
 */
@ApiModel
public class PageRequest<T>{
    /**
     *  pageSize
     *  assign by frontend
     */
    @ApiModelProperty(value = "每页数据大小")
    @NotNull
    protected int count;

    /**
     * page index
     * assign by frontend
     */
    @ApiModelProperty(value = "页数，第几页，从1开始")
    @NotNull
    protected int page;

    /**
     * assign by frontend
     */
    protected T params;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        if(page < 1){
            page = 1;
        }
        return count * (page -1);
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "count=" + count +
                ", page=" + page +
                ", params=" + params +
                '}';
    }
}
