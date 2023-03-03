<%@ page import="purchase.portlet.constants.PurchasePortletKeys" %>
<%@ page import="shop.model.Purchase" %>
<%@ page import="shop.service.PurchaseLocalServiceUtil" %>
<%@ page import="util.ShopProjectKeys" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ include file="init.jsp" %>

<%
    int purchaseCount = PurchaseLocalServiceUtil.getPurchasesCount();
    List<Purchase> purchases = PurchaseLocalServiceUtil.getPurchases(0, purchaseCount);
    SimpleDateFormat dateFormat = new SimpleDateFormat(ShopProjectKeys.DATE_FORMAT);
%>

<aui:button-row>
    <portlet:renderURL var="addPurchaseURL">
        <portlet:param name="mvcPath" value="/add_purchase.jsp"/>
    </portlet:renderURL>

    <aui:button onClick="<%= addPurchaseURL %>" value='<%= "Add new purchase" %>'/>
</aui:button-row>
<liferay-ui:error key="<%=PurchasePortletKeys.EMPLOYEE_HAS_NO_ETYPE%>" message="purchase.error.employee_has_no_etype"/>
<liferay-ui:error key="<%=PurchasePortletKeys.PRODUCT_IS_NOT_IN_STOCK%>" message="purchase.error.product_is_not_in_stock"/>
<liferay-ui:header title='<%="Purchases list"%>'/>
<liferay-ui:search-container emptyResultsMessage="No purchase found">
    <liferay-ui:search-container-results results="<%=purchases%>"/>
    <liferay-ui:search-container-row className="shop.model.Purchase" modelVar="purchase">
        <liferay-ui:search-container-column-text name="id" property="id"/>
        <liferay-ui:search-container-column-text name="eTypeId" property="ETypeId"/>
        <liferay-ui:search-container-column-text name="employeeId" property="employeeId"/>
        <liferay-ui:search-container-column-text name="electroId" property="electroId"/>
        <liferay-ui:search-container-column-text name="purchaseDate"
                                                 value="<%=dateFormat.format(purchase.getPurchaseDate())%>"/>
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu>
                <portlet:renderURL var="updatePurchaseURL">
                    <portlet:param name="mvcPath" value="/update_purchase.jsp"/>
                    <portlet:param name="id" value="<%= String.valueOf(purchase.getId()) %>"/>
                </portlet:renderURL>
                <liferay-ui:icon image="edit" url="<%=updatePurchaseURL%>"/>
                <portlet:actionURL name="deletePurchase" var="deletePurchaseURL">
                    <portlet:param name="id" value="<%= String.valueOf(purchase.getId()) %>"/>
                </portlet:actionURL>
                <liferay-ui:icon image="delete" url="<%=deletePurchaseURL%>"/>
            </liferay-ui:icon-menu>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>