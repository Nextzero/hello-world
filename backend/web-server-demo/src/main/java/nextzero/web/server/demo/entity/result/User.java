package nextzero.web.server.demo.entity.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class User {

    @ApiModelProperty(value = "用户ID", required = true)
    protected Integer id;

    @ApiModelProperty(value = "用户登录账号")
    protected String username;



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

    @ApiModelProperty(value = "用户状态，0表示正常，1表示禁用',")
    protected Integer status;

    @ApiModelProperty(value = "用户创建时间")
    protected String createTime;

    @ApiModelProperty(value = "用户最近更新时间")
    protected String updateTime;

    @ApiModelProperty(value = "用户上次登陆时间")
    protected String lastLoginTime;

    @ApiModelProperty(value = "用户角色列表")
    protected List<Role> roles;


    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
