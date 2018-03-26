<%@ include file="/WEB-INF/taglib.jsp" %>
<div class="row">
	<div class="col-sm-8 col-sm-offset-3">
		<div class="span2">
			<img
				src="data:image/png; base64,${userProfile.imagePath}"
				class="img-rounded" width="300px">
		</div>
		<div class="span4">
			<blockquote>
				<p> ${userProfile.firstName}  ${userProfile.lastName}  </p> 
				
			</blockquote>
			<p>
				<i class="icon-envelope"></i>Email: ${userProfile.email}  <br> 
				<i class="icon-globe"></i>Id user: ${userProfile.id} <br> 
				<i class="icon-gift"></i>Natal day: February 31, ${2018 - userProfile.age}
			</p>
			<p>
			<a href="/user/profile/image" class="btn btn-info">Upload image</a>
			<a href="/user/profile/edit" class="btn btn-success">Edit user data</a>
			</p>
		</div>
	</div>
</div>