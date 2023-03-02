<%@ include file="init.jsp" %>

<portlet:renderURL var="viewElectronicsURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-ui:header
        backURL="<%= viewElectronicsURL %>"
        title='<%="Add new electronic product"%>'/>
<portlet:actionURL name="addElectronics" var="addElectronicsURL"/>
<aui:form method="POST" name="fm" action="<%=addElectronicsURL%>">

    <aui:fieldset>
        <aui:input label="Name" name="name" required="true"/>
        <aui:input label="Electro type id" name="eTypeId" required="true"/>
        <aui:input label="Price" name="price" required="true"/>
        <aui:input label="Count" name="count" required="true"/>
        <aui:input label="Is in stock" name="isInStock" type="checkbox" checked="true"/>
        <aui:input label="Is archive" name="isArchive" type="checkbox" checked="false"/>
        <aui:input label="Description" name="description" required="true" type="textarea"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button onClick="<%= viewElectronicsURL %>" type="cancel"/>
    </aui:button-row>

</aui:form>