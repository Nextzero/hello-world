package nextzero.web.server.demo.entity.result;

import nextzero.web.server.demo.entity.domain.Menu;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class LoginResult {
    protected List<Menu> menuList;

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
