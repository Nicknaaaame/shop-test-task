<%@ page import="csv.importer.portlet.exception.WrongColumnNameException" %>
<%@ page import="csv.importer.portlet.exception.WrongTableNameException" %>
<%@ include file="init.jsp" %>

<portlet:actionURL name='importArchive' var="importArchiveURL" windowState="normal" />

<liferay-ui:error exception="<%=WrongColumnNameException.class%>" message='<%=request.getParameter("exceptionMessage")%>'/>
<liferay-ui:error exception="<%=WrongTableNameException.class%>" message='<%=request.getParameter("exceptionMessage")%>'/>

<aui:form action="<%= importArchiveURL %>" method="POST" name="fm" enctype="multipart/form-data">
	<aui:fieldset>

		<aui:input type="file" name="archive" label=".zip archive to import">
			<aui:validator name="acceptFiles">'zip'</aui:validator>
		</aui:input>

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>

	</aui:fieldset>
</aui:form>