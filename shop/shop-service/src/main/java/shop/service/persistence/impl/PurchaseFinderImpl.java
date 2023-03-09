package shop.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import shop.service.persistence.PurchaseFinder;

import java.math.BigDecimal;

@Component(service = PurchaseFinder.class)
public class PurchaseFinderImpl extends PurchaseFinderBaseImpl implements PurchaseFinder {
    static final String GET_PURCHASE_SUM_FOR_LAST_MONTH = "getPurchaseSumForLastMonth";

    @Reference
    private CustomSQL customSQL;

    public long getPurchaseSumForLastMonth() {
        Session session = openSession();
        String sql = customSQL.get(getClass(), GET_PURCHASE_SUM_FOR_LAST_MONTH);
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        BigDecimal result = (BigDecimal) query.iterateNext();
        return result.longValue();
    }
}
