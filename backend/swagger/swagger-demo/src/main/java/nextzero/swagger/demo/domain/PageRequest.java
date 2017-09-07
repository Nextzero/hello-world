package nextzero.swagger.demo.domain;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Map;

public class PageRequest<T>{
    /**
     *  pageSize
     *  assign by frontend
     */
    @Min(1)
    protected int count;

    /**
     * page index
     * assign by frontend
     */
    @Min(1)
    protected int page;

    /**
     * assign by frontend
     */
    @Valid
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
}
