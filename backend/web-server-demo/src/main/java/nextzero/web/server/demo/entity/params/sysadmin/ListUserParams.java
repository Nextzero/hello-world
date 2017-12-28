package nextzero.web.server.demo.entity.params.sysadmin;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ListUserParams {

    @ApiModelProperty(value = "用户显示姓名，一般为用户姓名，支持前后模糊查询")
    protected String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
