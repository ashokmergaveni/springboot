<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-fit">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Event name</th>
					
					<th> venue </th>
					<th>Description</th>
					<th>EventId</th>
					<th> Action</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.name}</td>
					<%-- 	<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td> --%>
						 <td>${todo.venue}</td>
						 <td width="30%">${todo.description}</td>
						 <td>${todo.eventId}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?eventId=${todo.eventId}">Approve</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?eventId=${todo.eventId}">Reject</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>