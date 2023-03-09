<%@ page import="shop.model.Employee" %>
<%@ page import="util.ShopProjectKeys" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner" %>
<%@ include file="init.jsp" %>

<%
    List<Employee> topEmployees = (List<Employee>) request.getAttribute("employees");
    String topEmployeesFio = null;
    if (topEmployees != null) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Employee topEmployee : topEmployees) {
            stringJoiner.add(String.format("%s %s %s", topEmployee.getLastName(), topEmployee.getFirstName(), topEmployee.getPatronymic()));
        }
        topEmployeesFio = stringJoiner.toString();
    }

%>
<liferay-ui:error key="<%=ShopProjectKeys.EXCEPTION_KEY%>"
                  message='<%=request.getParameter(ShopProjectKeys.EXCEPTION_MESSAGE)%>'/>
<portlet:actionURL name="viewTopEmployee" var="viewTopEmployeeURL"/>
<aui:form method="POST" name="fm" action="<%=viewTopEmployeeURL%>">

    <aui:fieldset>
        <aui:input label="Position id" name="positionId" required="true" type="number"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
    </aui:button-row>

</aui:form>

<label><%=topEmployees == null ? "You need to enter position id" : "The best employees: " + topEmployeesFio%>
</label>
<label>All employees that sell smartwatches and tablets</label>
<label>Profit of the shot for the month</label>
<label>Profit received by the Shop from the sale of refrigerators, kettles and water heaters</label>

