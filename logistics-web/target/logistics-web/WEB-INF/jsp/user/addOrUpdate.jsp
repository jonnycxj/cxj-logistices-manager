<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
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

		<form action="/user/saveUserAddOrUpdate" method="post">
			<ul class="forminfo">
				<li><label></label><input name="user.userId"
					value="${user.userId}" type="hidden" class="dfinput" /><i></i></li>
				<li><label>账号：</label><input name="user.userName"
					value="${ user.userName}" type="text" class="dfinput" /><i></i></li>
				<li><label>姓名： </label><input name="user.realName"
					value="${user.realName }" type="text" class="dfinput" /><i></i></li>
				<li><label>密码：</label><input name="user.password"
					type="password" class="dfinput" /><i></i></li>
				<li><label>确认密码：</label><input name="" type="password"
					class="dfinput" /><i></i></li>
				<li><label>电话：</label><input name="user.phone"
					value="${ user.phone}" type="text" class="dfinput" /><i></i></li>
				<li><label>邮箱：</label><input name="user.email"
					value="${ user.email}" type="text" class="dfinput" /><i></i></li>
				<li><label>分配角色</label> <c:forEach items="${roles}" var="role">
						<c:set var="flag" value="false"></c:set>
						<c:forEach items="${roleids }" var="roleid">
							<c:if test="${roleid eq role.roleId }">
								<c:set var="flag" value="true"></c:set>
							</c:if>
						</c:forEach>
						<input type="checkbox" name="roles" ${flag eq true?'checked':'' }
							value="${role.roleId }">&nbsp;${role.roleName } &nbsp;&nbsp;
					<c:set var="flag" value="false"></c:set>
					</c:forEach> <i></i></li>
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
