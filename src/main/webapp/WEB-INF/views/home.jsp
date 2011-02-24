<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h1>Introduce your self!</h1>
        <form:form modelAttribute="person" method="PUT">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Nickname:</td>
                    <td><form:input path="nickname" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save Changes" />
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
