<%@ page import="util.ShopProjectKeys" %>
<%@ include file="init.jsp" %>

<portlet:actionURL name='importArchive' var="importArchiveURL" windowState="normal" />

<liferay-ui:error key="<%=ShopProjectKeys.EXCEPTION_KEY%>" message='<%=request.getParameter(ShopProjectKeys.EXCEPTION_MESSAGE)%>'/>

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