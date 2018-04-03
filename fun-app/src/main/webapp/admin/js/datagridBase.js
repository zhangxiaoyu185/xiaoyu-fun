mini.parse();

var grid = mini.get("datagrid");

grid.load();

function onKeyEnter(e) {
	grid.load({
	});
}

//导出在线人员
function checkPerson() {

	$.ajax({
		url : "/fun-app/admin/analysis/online/person/check",
		type : 'post',
		dataType : 'json',
		success : function(text) {
			if (text.success) {
				mini.alert("操作成功！", "提示消息");
			} else {
				mini.alert("操作失败", "提示消息");
			}
		},
		error : function() {
			mini.alert("操作失败", "提示消息");
		}
	});
}