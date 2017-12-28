package nextzero.web.server.demo.entity.params.sysadmin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel
public class UpdateUserParams {

    @ApiModelProperty(value = "用户ID")
    protected Integer id;

    @ApiModelProperty(value = "用户显示名称，一般为用户实际姓名")
    protected String displayName;

    @ApiModelProperty(value = "手机，仅显示")
    protected String phone;

    @ApiModelProperty(value = "邮箱，仅显示")
    protected String email;

    @ApiModelProperty(value = "性别：0表示女的，1表示男的")
    protected Integer sex; // 0表示女的，1表示男的

    @ApiModelProperty(value = "生日，时间格式为：yyyy-MM-dd")
    protected String birthday;

    @ApiModelProperty(value = "备注")
    protected String remark;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "角色ID列表")
    protected List<Integer> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
}
