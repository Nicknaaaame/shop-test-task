<%@ page import="shop.model.Employee" %>
<%@ page import="shop.service.EmployeeLocalServiceUtil" %>
<%@ page import="util.ShopProjectKeys" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ include file="init.jsp" %>

<%
    int employeeCount = EmployeeLocalServiceUtil.getEmployeesCount();
    List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(0, employeeCount);
    SimpleDateFormat dateFormat = new SimpleDateFormat(ShopProjectKeys.DATE_OUTPUT_FORMAT);
%>

<aui:button-row>
    <portlet:renderURL var="addEmployeeURL">
        <portlet:param name="mvcPath" value="/add_employee.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%= addEmployeeURL %>" value='<%= "Add new employee" %>'/>
</aui:button-row>
<liferay-ui:header title='<%="Employees list"%>'/>
<liferay-ui:search-container emptyResultsMessage="No employee found">
    <liferay-ui:search-container-results results="<%=employees%>"/>
    <liferay-ui:search-container-row className="shop.model.Employee" modelVar="employee">
        <liferay-ui:search-container-column-text name="id" property="id"/>
        <liferay-ui:search-container-column-text name="lastName" property="lastName"/>
        <liferay-ui:search-container-column-text name="firstName" property="firstName"/>
        <liferay-ui:search-container-column-text name="patronymic" property="patronymic"/>
        <liferay-ui:search-container-column-text name="gender" property="gender"/>
        <liferay-ui:search-container-column-text name="birthDate"
                                                 value="<%=dateFormat.format(employee.getBirthDate())%>"/>
        <liferay-ui:search-container-column-text name="positionId" property="positionId"/>
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu>
                <portlet:renderURL var="updateEmployeeURL">
                    <portlet:param name="mvcPath" value="/update_employee.jsp"/>
                    <portlet:param name="id" value="<%= String.valueOf(employee.getId()) %>"/>
                </portlet:renderURL>
                <liferay-ui:icon image="edit" url="<%=updateEmployeeURL%>"/>
                <portlet:actionURL name="deleteEmployee" var="deleteEmployeeURL">
                    <portlet:param name="id" value="<%= String.valueOf(employee.getId()) %>"/>
                </portlet:actionURL>
                <liferay-ui:icon image="delete" url="<%=deleteEmployeeURL%>"/>
            </liferay-ui:icon-menu>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>