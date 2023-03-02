<%@ include file="init.jsp" %>

<portlet:renderURL var="viewEmployeeURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-ui:header
        backURL="<%= viewEmployeeURL %>"
        title='<%="Add new employee"%>'/>
<portlet:actionURL name="addEmployee" var="addEmployeeURL"/>
<aui:form method="POST" name="fm" action="<%=addEmployeeURL%>">

    <aui:fieldset>
        <aui:input label="Last name" name="lastName" required="true"/>
        <aui:input label="First name" name="firstName" required="true"/>
        <aui:input label="Patronymic" name="patronymic" required="true"/>
        <aui:select label="Gender" name="gender" required="true">
            <aui:option value="false">Male</aui:option>
            <aui:option value="true">Female</aui:option>
        </aui:select>
        <label>Birth date</label>
        <liferay-ui:input-date name="birthDate" yearValue="2000" required="true"/>
        <aui:input label="Position id" name="positionId" required="true"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button onClick="<%= viewEmployeeURL %>" type="cancel"/>
    </aui:button-row>

</aui:form>