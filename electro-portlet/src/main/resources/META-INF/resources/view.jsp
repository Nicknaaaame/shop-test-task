<%@ page import="shop.model.Electronics" %>
<%@ page import="shop.service.ElectronicsLocalServiceUtil" %>
<%@ page import="util.ShopProjectKeys" %>
<%@ page import="java.util.List" %>
<%@ include file="init.jsp" %>

<%
    int electronicsCount = ElectronicsLocalServiceUtil.getElectronicsesCount();
    List<Electronics> electronics = ElectronicsLocalServiceUtil.getElectronicses(0, electronicsCount);
%>

<aui:button-row>
    <portlet:renderURL var="addElectroURL">
        <portlet:param name="mvcPath" value="/add_electronics.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%= addElectroURL %>" value='<%= "Add new electronic product" %>'/>
</aui:button-row>
<liferay-ui:error key="<%=ShopProjectKeys.EXCEPTION_KEY%>" message='<%=request.getParameter(ShopProjectKeys.EXCEPTION_MESSAGE)%>'/>
<liferay-ui:header title='<%="Electronics list"%>'/>
<liferay-ui:search-container emptyResultsMessage="No products found">
    <liferay-ui:search-container-results results="<%=electronics%>"/>
    <liferay-ui:search-container-row className="shop.model.Electronics" modelVar="electoProduct">
        <liferay-ui:search-container-column-text name="id" property="id"/>
        <liferay-ui:search-container-column-text name="name" property="name"/>
        <liferay-ui:search-container-column-text name="eTypeId" property="ETypeId"/>
        <liferay-ui:search-container-column-text name="price" property="price"/>
        <liferay-ui:search-container-column-text name="count" property="count"/>
        <liferay-ui:search-container-column-text name="isInStock"
                                                 value='<%=electoProduct.getIsInStock() ? "Yes" : "no"%>'/>
        <liferay-ui:search-container-column-text name="isArchive"
                                                 value='<%=electoProduct.getIsArchive() ? "Yes" : "no"%>'/>
        <liferay-ui:search-container-column-text name="description" property="description"/>
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu>
                <portlet:renderURL var="updateElectronicsURL">
                    <portlet:param name="mvcPath" value="/update_electronics.jsp"/>
                    <portlet:param name="id" value="<%= String.valueOf(electoProduct.getId()) %>"/>
                </portlet:renderURL>
                <liferay-ui:icon image="edit" url="<%=updateElectronicsURL%>"/>
                <portlet:actionURL name="deleteElectronics" var="deleteElectronicsURL">
                    <portlet:param name="id" value="<%= String.valueOf(electoProduct.getId()) %>"/>
                </portlet:actionURL>
                <liferay-ui:icon image="delete" url="<%=deleteElectronicsURL%>"/>
            </liferay-ui:icon-menu>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>