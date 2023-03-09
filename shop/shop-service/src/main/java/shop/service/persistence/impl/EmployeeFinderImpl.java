package shop.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import shop.model.Employee;
import shop.model.impl.EmployeeImpl;
import shop.service.persistence.EmployeeFinder;

import java.util.List;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder {
    static final String FIND_TOP_EMPLOYEE_POSITION_ID = "findTopEmployeePositionId";
    @Reference
    private CustomSQL customSQL;
    public List<Employee> findTopEmployeesByPositionId(long positionId) {
        Session session = openSession();
        String sql = customSQL.get(getClass(), FIND_TOP_EMPLOYEE_POSITION_ID);
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        query.addEntity("Employee", EmployeeImpl.class);
        QueryPos queryPos = QueryPos.getInstance(query);
        queryPos.add(positionId);
        return (List<Employee>) query.list();
    }
}
