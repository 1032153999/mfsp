

    $.ajaxSetup( {
	//设置ajax请求结束后的执行动作
	complete :
		function(XMLHttpRequest, textStatus) {
			// 通过XMLHttpRequest取得响应头，sessionstatus
			
			var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
			if (sessionstatus == "TIMEOUT") {
				var win = window;
				while (win != win.top){
					win = win.top;
				}
			
				// win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");
				win.open(XMLHttpRequest.getResponseHeader("CONTEXTPATH"))
			}else if(XMLHttpRequest.getResponseHeader("CONTEXTPATH")!=null){
               
                window.open(XMLHttpRequest.getResponseHeader("CONTEXTPATH"))
            }
		}
});

Date.prototype.Format = function(formatStr)   

{   

    var str = formatStr;   

    var Week = ['日','一','二','三','四','五','六'];  

  

    str=str.replace(/yyyy|YYYY/,this.getFullYear());   

    str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));   

  

    str=str.replace(/MM/,this.getMonth()>9?this.getMonth().toString():'0' + this.getMonth());   

    str=str.replace(/M/g,this.getMonth());   

  

    str=str.replace(/w|W/g,Week[this.getDay()]);   

  

    str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());   

    str=str.replace(/d|D/g,this.getDate());   

  

    str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());   

    str=str.replace(/h|H/g,this.getHours());   

    str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());   

    str=str.replace(/m/g,this.getMinutes());   

  

    str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());   

    str=str.replace(/s|S/g,this.getSeconds());   

  

    return str;   

}   

   // 创建一个div
   var layer=document.createElement("div");
   // 设置div的id值
   layer.id="layer";
   // 上面按钮点击事件
   function funcTips(date){
       /* 创建div的样式，宽200px,高80px，下面的是css样式居中，
        * css样式居中具体了解链接：https://blog.csdn.net/A_Bear/article/details/80546181
        */
       
       var style={
           background:"#D5D5D5",
           position:"absolute",
           zIndex:10,
           width:"200px",
           height:"80px",
           left:"50%",
           top:"50%",
           marginLeft:"-100px",
           marginTop:"450px"
       }
       for(var i in style)
           layer.style[i]=style[i];   
       
       // 当找不到id为layer的控件时
       if(document.getElementById("layer")==null){
        
           // 在body中添加layer控件（layer在上面创建的）
           document.body.appendChild(layer);
           // 设置显示类容
           layer.innerHTML=date;
           // 将div中文本居中
           layer.style.textAlign="center";
           layer.style.lineHeight="80px"; // 作用是调节字体行高与div同高，使其保持水平居中
           // 设置1s后去掉弹出窗
           setTimeout("document.body.removeChild(layer)",1000)
       }
   }
