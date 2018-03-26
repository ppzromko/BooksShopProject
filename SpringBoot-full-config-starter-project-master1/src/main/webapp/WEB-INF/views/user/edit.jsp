<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Edit user</h3>
					<form:form action="/user/profile/edit" modelAttribute="editUserModel">
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						
						</div>
						<div class="form-group">
  							<label class="control-label">First name</label>
							<form:input path="firstName" cssClass="form-control" />
							
							<label class="control-label">Last name</label>
							<form:input path="lastName" cssClass="form-control" />
						
							<label class="control-label">Age</label>
							
							<form:select path="age" cssClass="form-control" >
							<c:forEach begin="16" end="95" var="a">
							<form:option value="${a}">${a}</form:option>
								</c:forEach>
							</form:select>
						</div>
						
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Submit">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>