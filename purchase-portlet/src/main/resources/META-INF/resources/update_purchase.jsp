<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="shop.model.Purchase" %>
<%@ page import="shop.service.PurchaseLocalServiceUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ include file="init.jsp" %>

<%
    long id = ParamUtil.getLong(request, "id");
    Purchase purchase = PurchaseLocalServiceUtil.getPurchase(id);
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(purchase.getPurchaseDate());
%>

<portlet:renderURL var="viewPurchaseURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-ui:header
        backURL="<%= viewPurchaseURL %>"
        title='<%="Edit purchase"%>'/>
<portlet:actionURL name="updatePurchase" var="updatePurchaseURL"/>
<aui:model-context bean="<%=purchase%>" model="<%=Purchase.class%>"/>
<aui:form method="POST" name="fm" action="<%=updatePurchaseURL%>">

    <aui:fieldset>
        <aui:input name="id" value="<%=purchase.getId()%>" type="hidden"/>
        <aui:input label="Electronic type id" name="eTypeId" value="<%=purchase.getETypeId()%>" required="true"
                   type="number"/>
        <aui:input label="Employee id" name="employeeId" value="<%=purchase.getEmployeeId()%>" required="true"
                   type="number"/>
        <aui:input label="Electronic product id" name="electroId" value="<%=purchase.getElectroId()%>" required="true"
                   type="number"/>
        <label>Purchase date</label>
        <liferay-ui:input-date name="purchaseDate" required="true"
                               yearValue="<%=calendar.get(Calendar.YEAR)%>"
                               monthValue="<%=calendar.get(Calendar.MONTH)%>"
                               dayValue="<%=calendar.get(Calendar.DAY_OF_MONTH)%>"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button onClick="<%= viewPurchaseURL %>" type="cancel"/>
    </aui:button-row>

</aui:form>