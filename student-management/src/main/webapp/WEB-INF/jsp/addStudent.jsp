<%--
  Created by IntelliJ IDEA.
  User: kunal
  Date: 30-10-2023
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <h1>Enter Student Credentials</h1>
    <form:form method="post" modelAttribute="student">
        <fieldset class="mb-3">
            <form:label path="studentname">Student Name</form:label>
            <form:input type="text" path="studentname" required="required" />
            <form:errors path="studentname" cssClass="text-warning" />
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="standard">Standard</form:label>
            <form:input type="text" path="standard" required="required" />
            <form:errors path="standard" cssClass="text-warning" />
        </fieldset>
        <form:input type="hidden" path="id" />
        <input type="submit" class="btn btn-success"/>
    </form:form>

</div>
<%@ include file="common/footer.jspf"%>
</body>
</html>
