package nextzero.web.server.demo.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class Menu {

    @ApiModelProperty(value = "菜单唯一标识")
    protected Integer id;

    @ApiModelProperty(value = "菜单名称")
    protected String name;

    @ApiModelProperty(value = "上级菜单标识")
    protected Integer parentId;

    @ApiModelProperty(value = "菜单URL，可用于前端路由")
    protected String menuUrl;

    protected List<Menu> children = new ArrayList<>();

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public void addChild(Menu menu){
        children.add(menu);
    }
}
