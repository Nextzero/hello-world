package nextzero.web.server.demo.entity.params.sysadmin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel
public class CheckUsernameParams {

    @ApiModelProperty(value = "待检查的用户名")
    @NotEmpty
    @NotNull
    protected String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
