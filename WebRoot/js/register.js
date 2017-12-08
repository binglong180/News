$(function() {
	$("#regiterForm").submit(function() {
		var uName = $("#uName").val();
		var uPassword = $("#uPassword").val();
		var verifyPassword = $("#verifyPassword").val();
		if (uName == null || uName.trim() == "") {
			$("#text").html("用户名不能为空！");
			return false;
		} else if (uPassword == null || uPassword.trim() == ("")) {
			$("#text").html("密码不能为空！");
			return false;
		} else if (!uPassword == (verifyPassword)) {
			$("#text").html("两次密码不一致！");
			return false;
		}
		return true;
	});
});
