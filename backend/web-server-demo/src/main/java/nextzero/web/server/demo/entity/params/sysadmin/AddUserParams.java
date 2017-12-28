package nextzero.web.server.demo.entity.params.sysadmin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel
public class AddUserParams {
    /**
     * 用户ID，插入成功后，由mybatis填充
     */
    @ApiModelProperty(value = "该字段仅由后台使用，前端请忽略")
    protected Integer id = 0;


    @ApiModelProperty(value = "用户名，登录时使用的账号", required = true)
    @NotEmpty
    @NotNull
    protected String username;

    /**
     * 由userService添加默认密码，不需要用户提供
     */
    @ApiModelProperty(value = "该字段仅由后台使用，前端请忽略")
    protected String password = "123456";

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
