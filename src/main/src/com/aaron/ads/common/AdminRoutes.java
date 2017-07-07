package com.aaron.ads.common;

import com.aaron.ads.admin.AdminController;
import com.jfinal.config.Routes;

public class AdminRoutes extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/WEB-INF/view");
        add("/admin", AdminController.class,"/admin");
    }

}
