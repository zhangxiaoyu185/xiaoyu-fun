var WEB_URL = 'http//127.0.0.1:8080/fun-app';
//设置版本信息  debug：无需验证身份 publish：需要身份验证
var ver = "publish";

__CreateJSPath = function(js) {
	var scripts = document.getElementsByTagName("script");
	var path = "";
	for ( var i = 0, l = scripts.length; i < l; i++) {
		var src = scripts[i].src;
		if (src.indexOf(js) != -1) {
			var ss = src.split(js);
			path = ss[0];
			break;
		}
	}
	var href = location.href;
	href = href.split("#")[0];
	href = href.split("?")[0];
	var ss = href.split("/");
	ss.length = ss.length - 1;
	href = ss.join("/");
	if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1
			&& path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
		path = href + "/" + path;
	}
	return path;
}

var bootPATH = __CreateJSPath("boot.js");

// debugger
mini_debugger = true;

// miniui
document.write('<script src="' + bootPATH
		+ 'jquery-1.6.2.min.js" type="text/javascript"></sc' + 'ript>');
document.write('<script src="' + bootPATH
		+ 'miniui/miniui.js" type="text/javascript" ></sc' + 'ript>');
document
		.write('<link href="'
				+ bootPATH
				+ 'miniui/themes/default/miniui.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + bootPATH
		+ 'miniui/themes/icons.css" rel="stylesheet" type="text/css" />');

// skin
var skin = getCookie("miniuiSkin");
if (skin) {
	document.write('<link href="' + bootPATH + 'miniui/themes/' + skin
			+ '/skin.css" rel="stylesheet" type="text/css" />');
}

// 校验是否登录
if(ver == "publish"){
	if (getCookie("login") == "" || getCookie("login") == null) {
		if(window.location.href.indexOf("index.html")<0 && window.location.href.indexOf("home.jsp")<0){
			alert("请先登录");
			window.parent.location = "../index.html";
		}
	}
}

// //////////////////////////////////////////////////////////////////////////////////////
function getCookie(sName) {
	var aCookie = document.cookie.split("; ");
	var lastMatch = null;
	for ( var i = 0; i < aCookie.length; i++) {
		var aCrumb = aCookie[i].split("=");
		if (sName == aCrumb[0]) {
			lastMatch = aCrumb;
		}
	}
	if (lastMatch) {
		var v = lastMatch[1];
		if (v === undefined)
			return v;
		return unescape(v);
	}
	return null;
}