package nextzero.web.server.demo.entity.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Role {

    @ApiModelProperty(value = "id")
    protected Integer id;

    @ApiModelProperty(value = "角色名称")
    protected String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
