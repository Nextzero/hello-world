package nextzero.web.server.demo.entity.params.sysadmin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResetPwdParams {

    @ApiModelProperty(value = "待重置密码的用户账号")
    protected String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
