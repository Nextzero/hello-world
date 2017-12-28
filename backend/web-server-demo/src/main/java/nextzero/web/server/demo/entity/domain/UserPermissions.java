package nextzero.web.server.demo.entity.domain;

import java.util.List;

public class UserPermissions {

    protected List<String> urlPermissions;

    protected List<String> menuPermissions;

    public List<String> getUrlPermissions() {
        return urlPermissions;
    }

    public void setUrlPermissions(List<String> urlPermissions) {
        this.urlPermissions = urlPermissions;
    }

    public List<String> getMenuPermissions() {
        return menuPermissions;
    }

    public void setMenuPermissions(List<String> menuPermissions) {
        this.menuPermissions = menuPermissions;
    }
}
