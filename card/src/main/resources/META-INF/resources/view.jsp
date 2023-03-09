<%@ page import="shop.model.Employee" %>
<%@ page import="util.ShopProjectKeys" %>
<%@ include file="init.jsp" %>

<%
    Employee employee = (Employee) request.getAttribute("employees");
    String empFio = null;
    if (employee != null)
        empFio = String.format("%s %s %s", employee.getFirstName(), employee.getLastName(), employee.getPatronymic());
%>
<liferay-ui:error key="<%=ShopProjectKeys.EXCEPTION_KEY%>"
                  message='<%=request.getParameter(ShopProjectKeys.EXCEPTION_MESSAGE)%>'/>
<label><%=employee == null ? "You need to choose position id" : "The best employee is " + empFio%>
</label>
<portlet:actionURL name="viewTopEmployee" var="viewTopEmployeeURL"/>
<aui:form method="POST" name="fm" action="<%=viewTopEmployeeURL%>">

    <aui:fieldset>
        <aui:input label="Position id" name="positionId" required="true" type="number"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
    </aui:button-row>

</aui:form>
