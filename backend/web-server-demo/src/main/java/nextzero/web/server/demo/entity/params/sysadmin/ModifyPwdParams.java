package nextzero.web.server.demo.entity.params.sysadmin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class ModifyPwdParams {

    @ApiModelProperty(value = "用户旧密码")
    @NotNull
    protected String oldpwd;

    @ApiModelProperty(value = "用户新密码")
    @NotNull
    protected String newpwd;

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }
}
