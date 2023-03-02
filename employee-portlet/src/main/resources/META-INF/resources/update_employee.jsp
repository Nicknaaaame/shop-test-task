<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="shop.model.Employee" %>
<%@ page import="shop.service.EmployeeLocalServiceUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ include file="init.jsp" %>

<%
    long id = ParamUtil.getLong(request, "id");
    Employee employee = EmployeeLocalServiceUtil.getEmployee(id);
    Calendar birthCalendarDate = new GregorianCalendar();
    birthCalendarDate.setTime(employee.getBirthDate());
%>

<portlet:renderURL var="viewEmployeeURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-ui:header
        backURL="<%= viewEmployeeURL %>"
        title='<%="Edit employee"%>'/>
<portlet:actionURL name="updateEmployee" var="updateEmployeeURL"/>
<aui:model-context bean="<%=employee%>" model="<%=Employee.class%>"/>
<aui:form method="POST" name="fm" action="<%=updateEmployeeURL%>">

    <aui:fieldset>
        <aui:input name="id" value="<%=employee.getId()%>" type="hidden"/>
        <aui:input label="Last name" name="lastName" value="<%=employee.getLastName()%>" required="true"/>
        <aui:input label="First name" name="firstName" value="<%=employee.getFirstName()%>" required="true"/>
        <aui:input label="Patronymic" name="patronymic" value="<%=employee.getPatronymic()%>" required="true"/>
        <aui:select label="Gender" name="gender" value="<%=employee.getGender()%>" required="true">
            <aui:option value="false">Male</aui:option>
            <aui:option value="true">Female</aui:option>
        </aui:select>
        <label>Birth date</label>
        <liferay-ui:input-date name="birthDate" required="true"
                               yearValue="<%=birthCalendarDate.get(Calendar.YEAR)%>"
                               monthValue="<%=birthCalendarDate.get(Calendar.MONTH)%>"
                               dayValue="<%=birthCalendarDate.get(Calendar.DAY_OF_MONTH)%>"/>
        <aui:input label="Position id" name="positionId" required="true"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button onClick="<%= viewEmployeeURL %>" type="cancel"/>
    </aui:button-row>

</aui:form>