/**
 * Created by hzq on 2017/7/5.
 */

$("#ads_addVideo").click(function () {
    var box = $('<div class="ads_video"></div>');
    addView(box);
});

$("#ads_addPicture").click(function () {
    var box = $('<div class="ads_picture"></div>');
    addView(box);
});

$("#ads_addNews").click(function () {
    var box = $('<div class="ads_news"></div>');
    addView(box);
});

$("#ads_addWeather").click(function () {
    var box = $('<div class="ads_weather"></div>');
    addView(box);
});

function addView(v, x, y, w, h) {
    v.appendTo($("#ads_contentLayout")).draggable({
        containment: 'parent',
        cursor: 'move',
        opacity: 0.6
    }).resizable({
        autoHide: true,
        containment: 'parent',
        handles: 'n, e, s, w, ne, se, sw, nw'
    }).css("left", x).css("top", y).css("width", w).css("height", h);
}

$("#ads_submit").click(function () {
    var json = "[";
    $("#ads_contentLayout").children().each(function (i, n) {
        var obj = $(n);
        json += ("{'x':'" + (obj.position().left-20) + "','y':'" + (obj.position().top-74) + "','h':'" + obj.height() + "','w':'" + obj.width() + "'}");//弹出子元素标签
    });
    json += "]";
    alert(json);
});

