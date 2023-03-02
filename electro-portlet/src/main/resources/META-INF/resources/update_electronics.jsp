<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="shop.model.Electronics" %>
<%@ page import="shop.service.ElectronicsLocalServiceUtil" %>
<%@ include file="init.jsp" %>

<%
    long id = ParamUtil.getLong(request, "id");
    Electronics electronics = ElectronicsLocalServiceUtil.getElectronics(id);
%>

<portlet:renderURL var="viewElectronicsURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-ui:header
        backURL="<%= viewElectronicsURL %>"
        title='<%="Edit electronic product"%>'/>
<portlet:actionURL name="updateElectronics" var="updateElectronicsURL"/>
<aui:model-context bean="<%=electronics%>" model="<%=Electronics.class%>"/>
<aui:form method="POST" name="fm" action="<%=updateElectronicsURL%>">

    <aui:fieldset>
        <aui:input name="id" value="<%=electronics.getId()%>" type="hidden"/>
        <aui:input label="Name" name="name" value="<%=electronics.getName()%>" required="true"/>
        <aui:input label="Electro type id" name="eTypeId" value="<%=electronics.getETypeId()%>" required="true" type="number"/>
        <aui:input label="Price" name="price" value="<%=electronics.getPrice()%>" required="true" type="number"/>
        <aui:input label="Count" name="count" value="<%=electronics.getCount()%>" required="true" type="number"/>
        <aui:input label="Is in stock" name="isInStock" type="checkbox" value="<%=electronics.getIsInStock()%>"/>
        <aui:input label="Is archive" name="isArchive" type="checkbox" value="<%=electronics.getIsArchive()%>"/>
        <aui:input label="Description" name="description" value="<%=electronics.getDescription()%>" required="true" type="textarea"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button onClick="<%= viewElectronicsURL %>" type="cancel"/>
    </aui:button-row>

</aui:form>