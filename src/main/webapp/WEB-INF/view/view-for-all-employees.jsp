<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>Information for all employee</h3>


<security:authorize access="hasAuthority('HR')">
    <div>
        <button type="button" onclick="window.location.href = 'hr-info'">Salary</button>
        Only for HR staff
    </div>
</security:authorize>

<security:authorize access="hasAuthority('MANAGER')">
    <div>
        <button type="button" onclick="window.location.href = 'manager-info'">Performance</button>
        Only for Managers
    </div>
</security:authorize>
</body>
</html>