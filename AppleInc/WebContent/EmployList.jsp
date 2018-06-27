<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of AppleEmployees</title>
</head>
<body>
    <center>
        <h1>AppleEmployee Management</h1>
        <h2>
            <a href="/new">Add New Employ</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Employees</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Employees</h2></caption>
            <tr>
                <th>EmployiD</th>
                <th>EName</th>
                <th>EDivision</th>
                <th>ESalary</th>
                <th>EPhone</th>
                <th>EmployJob</th>
            </tr>
            <c:forEach var="Employ" items="${listEmploy}">
                <tr>
                    <td><c:out value="${Employ.Employid}" /></td>
                    <td><c:out value="${Employ.EName}" /></td>
                    <td><c:out value="${Employ.EDivision}" /></td>
                    <td><c:out value="${Employ.ESalary}" /></td>
                    <td><c:out value="${Employ.EPhone}" /></td>
                    <td><c:out value="${Employ.EmployJob}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${Employ.Employid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${Employ.Employid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>