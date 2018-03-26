<%@ include file="/WEB-INF/taglib.jsp" %>

<form:form modelAttribute="uploadModel" method="POST" action="/user/profile/image" enctype="multipart/form-data">

<form:input path="file" type="file"/>

<input type="submit" value="Upload image" class="btn btn-warning">
 
</form:form>