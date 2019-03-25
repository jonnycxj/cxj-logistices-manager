<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="/js/select-ui.min.js"></script>
<script type="text/javascript" src="/editor/kindeditor.js"></script>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<link href="/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	})
});

</script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">表单</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div class="formtitle">
			<span>基本信息</span>
		</div>

		<form action="/basicData/saveAddOrUpdate" method="post">
			<ul class="forminfo">
				<li><label></label><input name="baseId"
					value="${basicData.baseId}" type="hidden" class="dfinput" /><i></i></li>
				<li><label>名称：</label><input name="baseName"
					value="${basicData.baseName}" type="text" class="dfinput" /><i></i></li>
				<li><label>说明：</label><input name="baseDesc"
					type="text" class="dfinput" value="${basicData.baseDesc }" /><i></i></li>

				<li><label>父类ID：</label>
					<div class="vocation">
						<select class="select1" name="parentId">
						<option value="0">--大类--</option>
							<c:forEach items="${listBasic}" var="basic">
								<option value="${basic.baseId}"  ${basic.baseId eq basicData.parentId?"selected": ""}  >${basic.baseName }</option>
							</c:forEach>
						</select>
					</div> <i></i></li>
				<li><label>&nbsp;</label><input name="" type="submit"
					class="btn" value="确认保存" /></li>
			</ul>
		</form>

	</div>


	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>
