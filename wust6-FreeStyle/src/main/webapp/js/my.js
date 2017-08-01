function loginCheck() {
	var password = document.getElementById("password");
	var username = document.getElementById("username");
	if (!(stringCheck(password) && stringCheck(username))) {
		alert("请重新输入");
		return false;
	}
	return true;
}
function registerCheck() {
	var u = document.getElementById("username");
	var p = document.getElementById("password");
	var c = document.getElementById("confirmWord");
	var ph = document.getElementById("phone");
	if (u.value == "" || u.value == "" || c.value == "" || ph.value == "") {
		alert("请检查输入是否正确");
		return false;
	}
	return true;
}
function userCheck(user) {// js原生ajax异步加载
	if (stringCheck(user)) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera,
									// Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var y = xmlhttp.responseText;
				var x = JSON.parse(y);
				if (x.result == "exist") {
					alert("该用户名已存在 ");
					user.value = "";
					return false;
				}
			}
		}
		xmlhttp.open("GET", "Servlet/register?username=" + user.value, true);
		xmlhttp.send();

	}
}
function phoneCheck(p) {
	var reg = /^[0-9]{11}$/;
	if (!reg.test(p.value) || p.value == null) {
		p.value = "";
		p.placeholder = "请输入11位的手机号"
		return false;
	}
}
function confirmWordCheck(s) {
	var password = document.getElementById("password").value;
	if (password != s.value) {
		s.value = "";
		s.placeholder = "输入密码不一致";
		return false;
	}
}
function stringCheck(s) {
	var str = s.value;
	var min = 6;
	var max = 16;
	if (str == null || str == "") {
		s.value = "";
		s.placeholder = "不能未空";
		return false;
	} else if (str.length < min) {
		s.value = "";
		s.placeholder = "长度需大于" + min;
		return false;
	} else if (str.length > max) {
		s.value = "";
		s.placeholder = "长度需小于16" + max;
		return false;
	}
	return true;
}
function register() {
	window.location.href = "register.htm";
}

function footer(){
	var obt=document.getElementById("footer");
	obt.style.margin='0 auto';
	
}