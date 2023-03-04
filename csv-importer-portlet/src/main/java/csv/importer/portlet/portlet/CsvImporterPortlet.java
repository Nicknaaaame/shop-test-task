package csv.importer.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import csv.importer.portlet.ZipArchiveImporter;
import csv.importer.portlet.constants.CsvImporterPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import java.io.File;
import java.io.IOException;

/**
 * @author dlyar
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=CsvImporter",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + CsvImporterPortletKeys.CSVIMPORTER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CsvImporterPortlet extends MVCPortlet {
    private ZipArchiveImporter archiveImporter;

    public CsvImporterPortlet() {
        archiveImporter = new ZipArchiveImporter();
    }

    public void importArchive(ActionRequest request, ActionResponse response) throws IOException {
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        File archive = uploadRequest.getFile("archive");
        archiveImporter.importFromZipArchive(archive);
    }
}