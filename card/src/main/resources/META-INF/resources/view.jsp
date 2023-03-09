<%@ page import="shop.model.Employee" %>
<%@ page import="util.ShopProjectKeys" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.StringJoiner" %>
<%@ page import="util.EmployeeUtil" %>
<%@ page import="shop.service.EmployeeLocalServiceUtil" %>
<%@ page import="shop.service.PurchaseLocalServiceUtil" %>
<%@ include file="init.jsp" %>

<%
    List<Employee> topEmployees = (List<Employee>) request.getAttribute("employees");
    String topEmployeesFio = null;
    if (topEmployees != null) {
        topEmployeesFio = EmployeeUtil.getFio(topEmployees);
    }
    String employeesSmartWatchesAndTabletsFio = EmployeeUtil.getFio(EmployeeLocalServiceUtil.getEmployeesSmartWatchesAndTablets());
    long purchaseSumForLastMonth = PurchaseLocalServiceUtil.getPurchaseSumForLastMonth();
%>
<liferay-ui:error key="<%=ShopProjectKeys.EXCEPTION_KEY%>"
                  message='<%=request.getParameter(ShopProjectKeys.EXCEPTION_MESSAGE)%>'/>
<portlet:actionURL name="viewTopEmployee" var="viewTopEmployeeURL"/>
<aui:form method="POST" name="fm" action="<%=viewTopEmployeeURL%>">

    <aui:fieldset>
        <aui:input label="Position id" name="positionId" required="true" type="number"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
    </aui:button-row>

</aui:form>

<label><%=topEmployees == null ? "You need to enter position id" : "The best employees: " + topEmployeesFio%>
</label>
<div class="separator"></div>
<label>All employees that sell smartwatches and tablets: <%=employeesSmartWatchesAndTabletsFio%></label>
<div class="separator"></div>
<label>Profit of the shop for the month: <%=purchaseSumForLastMonth%></label>
<div class="separator"></div>
<label>Profit received by the Shop from the sale of refrigerators, kettles and water heaters</label>

