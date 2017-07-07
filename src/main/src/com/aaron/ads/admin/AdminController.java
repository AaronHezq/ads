package com.aaron.ads.admin;

import com.jfinal.core.Controller;

public class AdminController extends Controller {

    public void index() {
        render("index.html");
    }

    public void layoutlist() {
        render("inner/layoutlist.html");
    }

    public void playlist() {
        render("inner/playlist.html");
    }


}


