<%@ include file="/WEB-INF/taglib.jsp"%>

<ul>
<c:forEach items="${users}" var ="user">
		<li >
			<img alt="dkh" src="data:image/png; base64,${user.imagePath}"
			width="150px">|${user.firstName} ${user.lastName}| ${user.age}
		</li>
</c:forEach>
</ul>