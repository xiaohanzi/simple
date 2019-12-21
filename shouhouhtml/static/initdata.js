var shouhouTypeMap={};
var shouhouTypeResultJson;

function initData(callbackfunc) {
	$.ajax({url:"/shouhouapi/shouhouType/list?pageNum=1&pageSize=100&status=1",success:function(result){
		//var result = "{\"code\":200,\"message\":\"success\",\"data\":{\"pageNum\":1,\"pageSize\":100,\"size\":14,\"startRow\":1,\"endRow\":14,\"total\":14,\"pages\":1,\"list\":[{\"id\":\"1\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"赔付\",\"value\":\"pf\",\"status\":1},{\"id\":\"10\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"淘宝-布丁\",\"value\":\"tb-bd\",\"status\":1},{\"id\":\"11\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"仓库发错补发\",\"value\":\"ckfc\",\"status\":1},{\"id\":\"12\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"厂家包错补发\",\"value\":\"cjbc\",\"status\":1},{\"id\":\"13\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"质量问题\",\"value\":\"zlwt\",\"status\":1},{\"id\":\"14\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"漏发补发\",\"value\":\"lf\",\"status\":1},{\"id\":\"2\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"仅退款\",\"value\":\"jtk\",\"status\":1},{\"id\":\"3\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"退货退款\",\"value\":\"thtk\",\"status\":1},{\"id\":\"4\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"物流催问\",\"value\":\"wlcw\",\"status\":1},{\"id\":\"5\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"天猫-lqyyfs\",\"value\":\"tm-lqy\",\"status\":1},{\"id\":\"6\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"天猫-朵卡连\",\"value\":\"tm-dkl\",\"status\":1},{\"id\":\"7\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"拼多多-嘟嘟\",\"value\":\"pdd-dd\",\"status\":1},{\"id\":\"8\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"拼多多-悠悠\",\"value\":\"pdd-yy\",\"status\":1},{\"id\":\"9\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"淘宝-伊甸园\",\"value\":\"tb-ydy\",\"status\":1}],\"prePage\":0,\"nextPage\":0,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[1],\"navigateFirstPage\":1,\"navigateLastPage\":1,\"firstPage\":1,\"lastPage\":1}}";
		//var res = JSON.parse(result);
		var res = result;
		if(result&&res.data && res.data.list) {
			shouhouTypeResultJson = result;
			for (var i = 0 ; i < res.data.list.length; i++) {
				var tdata = res.data.list[i];
				shouhouTypeMap[tdata.type+"_"+tdata.value] = tdata.name;
			}
		}else{
			alert("数据查询失败");
			
		}
		if (callbackfunc) {
			callbackfunc();
		}
	}});
	
}

function initSelect(type,objId,allowEmpity,value) {
	//var res = JSON.parse(shouhouTypeResultStr);
	if(!shouhouTypeResultJson) {
		$.ajax({url:"/shouhouapi/shouhouType/list?pageNum=1&pageSize=100&type="+type+"&status=1",success:function(result){
			//var result = "{\"code\":200,\"message\":\"success\",\"data\":{\"pageNum\":1,\"pageSize\":100,\"size\":14,\"startRow\":1,\"endRow\":14,\"total\":14,\"pages\":1,\"list\":[{\"id\":\"1\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"赔付\",\"value\":\"pf\",\"status\":1},{\"id\":\"10\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"淘宝-布丁\",\"value\":\"tb-bd\",\"status\":1},{\"id\":\"11\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"仓库发错补发\",\"value\":\"ckfc\",\"status\":1},{\"id\":\"12\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"厂家包错补发\",\"value\":\"cjbc\",\"status\":1},{\"id\":\"13\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"质量问题\",\"value\":\"zlwt\",\"status\":1},{\"id\":\"14\",\"ids\":null,\"sortColumns\":null,\"type\":\"bujian\",\"name\":\"漏发补发\",\"value\":\"lf\",\"status\":1},{\"id\":\"2\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"仅退款\",\"value\":\"jtk\",\"status\":1},{\"id\":\"3\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"退货退款\",\"value\":\"thtk\",\"status\":1},{\"id\":\"4\",\"ids\":null,\"sortColumns\":null,\"type\":\"et\",\"name\":\"物流催问\",\"value\":\"wlcw\",\"status\":1},{\"id\":\"5\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"天猫-lqyyfs\",\"value\":\"tm-lqy\",\"status\":1},{\"id\":\"6\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"天猫-朵卡连\",\"value\":\"tm-dkl\",\"status\":1},{\"id\":\"7\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"拼多多-嘟嘟\",\"value\":\"pdd-dd\",\"status\":1},{\"id\":\"8\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"拼多多-悠悠\",\"value\":\"pdd-yy\",\"status\":1},{\"id\":\"9\",\"ids\":null,\"sortColumns\":null,\"type\":\"shop\",\"name\":\"淘宝-伊甸园\",\"value\":\"tb-ydy\",\"status\":1}],\"prePage\":0,\"nextPage\":0,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[1],\"navigateFirstPage\":1,\"navigateLastPage\":1,\"firstPage\":1,\"lastPage\":1}}";
			//var res = JSON.parse(result);
			var res = result;
			if(result&&res.data && res.data.list) {
				var selecthtml = "";
				if (allowEmpity) {
					selecthtml = selecthtml + "<option value>请选择</option>";
				}
				for (var i = 0 ; i < res.data.list.length; i++) {
					var opobj = res.data.list[i];
					if (type == opobj.type) {
						if(value && value == opobj.value) {
							selecthtml = selecthtml + "<option value=\""+opobj.value+"\" selected>"+opobj.name+"</option>";
						}else {
							selecthtml = selecthtml + "<option value=\""+opobj.value+"\" >"+opobj.name+"</option>";
						}
					}
				}	
				$("#"+objId).html(selecthtml);
			}else{
				alert("数据查询失败");
				
			}
	    }});
	}
}

function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); return null; //返回参数值
}
