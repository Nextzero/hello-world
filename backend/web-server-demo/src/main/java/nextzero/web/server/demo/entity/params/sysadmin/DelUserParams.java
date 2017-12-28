package nextzero.web.server.demo.entity.params.sysadmin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel
public class DelUserParams {
    @ApiModelProperty(value = "待删除的用户ID列表", required = true)
    @NotNull
    @NotEmpty
    protected List<Integer> userIds;

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }
}
