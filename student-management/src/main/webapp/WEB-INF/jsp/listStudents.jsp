
<%--
  Created by IntelliJ IDEA.
  User: kunal
  Date: 30-10-2023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <a href="add-student" class="btn btn-success mt-2">Add Student</a>
    <h1 class="text-center mt-3" >Student List</h1>
    <table class="table table-hover">
      <thead>
        <tr>
          <th>Id</th>
            <th>Student Name</th>
            <th>Standard</th>
        </tr>
      </thead>
        <tbody>
            <c:forEach items="${student}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.studentname}</td>
                    <td>${student.standard}</td>
                    <td><a href="delete-student?id=${student.id}" class="btn btn-warning">DELETE</a></td>
                    <td><a href="update-student?id=${student.id}" class="btn btn-danger">UPDATE</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<%@ include file="common/footer.jspf"%>
</body>
</html>
