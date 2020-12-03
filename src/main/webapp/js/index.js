

    $.ajaxSetup( {
	//设置ajax请求结束后的执行动作
	complete :
		function(XMLHttpRequest, textStatus) {
			// 通过XMLHttpRequest取得响应头，sessionstatus
			alert("ajaxSetup")
			var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
			if (sessionstatus == "TIMEOUT") {
				var win = window;
				while (win != win.top){
					win = win.top;
				}
				alert("win.ope")
				// win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");
				win.open(XMLHttpRequest.getResponseHeader("CONTEXTPATH"))
			}else if(XMLHttpRequest.getResponseHeader("CONTEXTPATH")!=null){
                alert("win.open")
                window.open(XMLHttpRequest.getResponseHeader("CONTEXTPATH"))
            }
		}
});

