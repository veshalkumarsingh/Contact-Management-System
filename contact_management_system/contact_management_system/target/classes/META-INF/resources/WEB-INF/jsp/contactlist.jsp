<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<div class="container">
	<h1>Your Contacts</h1>
	<table class="table">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>E-mail</th>
				<th>Phone</th>
				<th></th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${contacts}" var="contacts">
				<tr>
					<td>${contacts.fname}</td>
					<td>${contacts.lname}</td>
					<td>${contacts.email}</td>
					<td>${contacts.phone}</td>
					<td></td>
					<td> <a href="delete-contact?id=${contacts.id}" class="btn btn-warning">Delete</a>   </td>
					<td> <a href="update-contact?id=${contacts.id}" class="btn btn-success">Update</a>   </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-contact" class="btn btn-success">Add Contact</a>
</div>

<%@ include file="common/footer.jspf" %>