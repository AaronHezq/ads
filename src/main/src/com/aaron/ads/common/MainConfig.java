package com.aaron.ads.common;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class MainConfig extends JFinalConfig {
	
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 80, "/", 5);
	}
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		PropKit.use("config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", true));
		//设置默认上传文件保存路径 getFile等使用
		me.setBaseUploadPath("upload");
		me.setJsonFactory(FastJsonFactory.me());
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add(new AdminRoutes());
	}
	
	public void configEngine(Engine me) {
		//me.addSharedFunction("/WEB-INF/view/template/mainlayout.html");
//		me.addSharedFunction("/WEB-INF/view/template/menu.html");
	}
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());

		//orm映射 配置ActiveRecord插件
		ActiveRecordPlugin arp=new ActiveRecordPlugin(druidPlugin);
		arp.setShowSql(PropKit.getBoolean("devMode"));
		arp.setDialect(new MysqlDialect());
		// 所有映射在 MappingKit 中自动化搞定
		_MappingKit.mapping(arp);
		me.add(druidPlugin);
		me.add(arp);
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		me.add(new BasePathHandler());
	}

}
