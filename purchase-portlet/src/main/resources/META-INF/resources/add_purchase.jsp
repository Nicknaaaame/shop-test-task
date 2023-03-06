<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ include file="init.jsp" %>

<%
    Calendar currentCalendarDate = new GregorianCalendar();
    currentCalendarDate.setTime(new Date());
%>

<portlet:renderURL var="viewPurchaseURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-ui:header
        backURL="<%= viewPurchaseURL %>"
        title='<%="Add new purchase"%>'/>
<portlet:actionURL name="addPurchase" var="addPurchaseURL"/>
<aui:form method="POST" name="fm" action="<%=addPurchaseURL%>">

    <aui:fieldset>
        <aui:input label="Electronic type id" name="eTypeId" required="true" type="number"/>
        <aui:input label="Employee id" name="employeeId" required="true" type="number"/>
        <aui:input label="Electronic product id" name="electroId" required="true" type="number"/>
        <label>Purchase date</label>
        <liferay-ui:input-date name="purchaseDate" required="true"
                               yearValue="<%=currentCalendarDate.get(Calendar.YEAR)%>"
                               monthValue="<%=currentCalendarDate.get(Calendar.MONTH)%>"
                               dayValue="<%=currentCalendarDate.get(Calendar.DAY_OF_MONTH)%>"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button onClick="<%= viewPurchaseURL %>" type="cancel"/>
    </aui:button-row>

</aui:form>