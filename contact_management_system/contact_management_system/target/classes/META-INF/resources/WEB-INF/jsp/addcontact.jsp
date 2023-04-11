<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

<div class="container">
	
	<h1>Enter Contact Details</h1>
	<br>
	
	<form:form method="post" modelAttribute="contact">

		<fieldset class="mb-3">				
			<form:label path="fname">First Name</form:label>
			<form:input type="text" path="fname" required="required"/>
			<form:errors path="fname" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">				
			<form:label path="lname">Last Name</form:label>
			<form:input type="text" path="lname" required="required"/>
			<form:errors path="lname" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">				
			<form:label path="email">E-mail   </form:label>
			<form:input type="text" path="email" required="required"/>
			<form:errors path="email" cssClass="text-warning"/>
		</fieldset>
		

		<fieldset class="mb-3">				
			<form:label path="phone">Phone</form:label>
			<form:input type="text" path="phone" required="required"/>
			<form:errors path="phone" cssClass="text-warning"/>
		</fieldset>


		<input type="submit" class="btn btn-success"/>
	
	</form:form>
	
</div>

<%@ include file="common/footer.jspf" %>