/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package shop.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.*;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import shop.exception.NoSuchElectroEmployeeException;
import shop.model.ElectroEmployee;
import shop.model.impl.ElectroEmployeeImpl;
import shop.model.impl.ElectroEmployeeModelImpl;
import shop.service.persistence.ElectroEmployeePK;
import shop.service.persistence.ElectroEmployeePersistence;
import shop.service.persistence.ElectroEmployeeUtil;
import shop.service.persistence.impl.constants.SHOPPersistenceConstants;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The persistence implementation for the electro employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElectroEmployeePersistence.class)
public class ElectroEmployeePersistenceImpl
        extends BasePersistenceImpl<ElectroEmployee>
        implements ElectroEmployeePersistence {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use <code>ElectroEmployeeUtil</code> to access the electro employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY =
            ElectroEmployeeImpl.class.getName();

    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
            FINDER_CLASS_NAME_ENTITY + ".List1";

    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
            FINDER_CLASS_NAME_ENTITY + ".List2";
    private static final String _SQL_SELECT_ELECTROEMPLOYEE =
            "SELECT electroEmployee FROM ElectroEmployee electroEmployee";
    private static final String _SQL_COUNT_ELECTROEMPLOYEE =
            "SELECT COUNT(electroEmployee) FROM ElectroEmployee electroEmployee";
    private static final String _ORDER_BY_ENTITY_ALIAS = "electroEmployee.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
            "No ElectroEmployee exists with the primary key ";
    private static final Log _log = LogFactoryUtil.getLog(
            ElectroEmployeePersistenceImpl.class);
    private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
            new String[]{"employeeId", "eTypeId"});
    @Reference
    protected EntityCache entityCache;
    @Reference
    protected FinderCache finderCache;
    private FinderPath _finderPathWithPaginationFindAll;
    private FinderPath _finderPathWithoutPaginationFindAll;
    private FinderPath _finderPathCountAll;
    private int _valueObjectFinderCacheListThreshold;
    private BundleContext _bundleContext;
    private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
            new HashSet<>();
    private ServiceRegistration<ArgumentsResolver>
            _argumentsResolverServiceRegistration;

    public ElectroEmployeePersistenceImpl() {
        setModelClass(ElectroEmployee.class);

        setModelImplClass(ElectroEmployeeImpl.class);
        setModelPKClass(ElectroEmployeePK.class);
    }

    /**
     * Caches the electro employee in the entity cache if it is enabled.
     *
     * @param electroEmployee the electro employee
     */
    @Override
    public void cacheResult(ElectroEmployee electroEmployee) {
        entityCache.putResult(
                ElectroEmployeeImpl.class, electroEmployee.getPrimaryKey(),
                electroEmployee);
    }

    /**
     * Caches the electro employees in the entity cache if it is enabled.
     *
     * @param electroEmployees the electro employees
     */
    @Override
    public void cacheResult(List<ElectroEmployee> electroEmployees) {
        if ((_valueObjectFinderCacheListThreshold == 0) ||
                ((_valueObjectFinderCacheListThreshold > 0) &&
                        (electroEmployees.size() >
                                _valueObjectFinderCacheListThreshold))) {

            return;
        }

        for (ElectroEmployee electroEmployee : electroEmployees) {
            if (entityCache.getResult(
                    ElectroEmployeeImpl.class,
                    electroEmployee.getPrimaryKey()) == null) {

                cacheResult(electroEmployee);
            }
        }
    }

    /**
     * Clears the cache for all electro employees.
     *
     * <p>
     * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        entityCache.clearCache(ElectroEmployeeImpl.class);

        finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the electro employee.
     *
     * <p>
     * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ElectroEmployee electroEmployee) {
        entityCache.removeResult(ElectroEmployeeImpl.class, electroEmployee);
    }

    @Override
    public void clearCache(List<ElectroEmployee> electroEmployees) {
        for (ElectroEmployee electroEmployee : electroEmployees) {
            entityCache.removeResult(
                    ElectroEmployeeImpl.class, electroEmployee);
        }
    }

    @Override
    public void clearCache(Set<Serializable> primaryKeys) {
        finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Serializable primaryKey : primaryKeys) {
            entityCache.removeResult(ElectroEmployeeImpl.class, primaryKey);
        }
    }

    /**
     * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
     *
     * @param electroEmployeePK the primary key for the new electro employee
     * @return the new electro employee
     */
    @Override
    public ElectroEmployee create(ElectroEmployeePK electroEmployeePK) {
        ElectroEmployee electroEmployee = new ElectroEmployeeImpl();

        electroEmployee.setNew(true);
        electroEmployee.setPrimaryKey(electroEmployeePK);

        return electroEmployee;
    }

    /**
     * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee that was removed
     * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
     */
    @Override
    public ElectroEmployee remove(ElectroEmployeePK electroEmployeePK)
            throws NoSuchElectroEmployeeException {

        return remove((Serializable) electroEmployeePK);
    }

    /**
     * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the electro employee
     * @return the electro employee that was removed
     * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
     */
    @Override
    public ElectroEmployee remove(Serializable primaryKey)
            throws NoSuchElectroEmployeeException {

        Session session = null;

        try {
            session = openSession();

            ElectroEmployee electroEmployee = (ElectroEmployee) session.get(
                    ElectroEmployeeImpl.class, primaryKey);

            if (electroEmployee == null) {
                if (_log.isDebugEnabled()) {
                    _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchElectroEmployeeException(
                        _NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            return remove(electroEmployee);
        } catch (NoSuchElectroEmployeeException noSuchEntityException) {
            throw noSuchEntityException;
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ElectroEmployee removeImpl(ElectroEmployee electroEmployee) {
        Session session = null;

        try {
            session = openSession();

            if (!session.contains(electroEmployee)) {
                electroEmployee = (ElectroEmployee) session.get(
                        ElectroEmployeeImpl.class,
                        electroEmployee.getPrimaryKeyObj());
            }

            if (electroEmployee != null) {
                session.delete(electroEmployee);
            }
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }

        if (electroEmployee != null) {
            clearCache(electroEmployee);
        }

        return electroEmployee;
    }

    @Override
    public ElectroEmployee updateImpl(ElectroEmployee electroEmployee) {
        boolean isNew = electroEmployee.isNew();

        Session session = null;

        try {
            session = openSession();

            if (isNew) {
                session.save(electroEmployee);
            } else {
                electroEmployee = (ElectroEmployee) session.merge(
                        electroEmployee);
            }
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }

        entityCache.putResult(
                ElectroEmployeeImpl.class, electroEmployee, false, true);

        if (isNew) {
            electroEmployee.setNew(false);
        }

        electroEmployee.resetOriginalValues();

        return electroEmployee;
    }

    /**
     * Returns the electro employee with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
     *
     * @param primaryKey the primary key of the electro employee
     * @return the electro employee
     * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
     */
    @Override
    public ElectroEmployee findByPrimaryKey(Serializable primaryKey)
            throws NoSuchElectroEmployeeException {

        ElectroEmployee electroEmployee = fetchByPrimaryKey(primaryKey);

        if (electroEmployee == null) {
            if (_log.isDebugEnabled()) {
                _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchElectroEmployeeException(
                    _NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
        }

        return electroEmployee;
    }

    /**
     * Returns the electro employee with the primary key or throws a <code>NoSuchElectroEmployeeException</code> if it could not be found.
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee
     * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
     */
    @Override
    public ElectroEmployee findByPrimaryKey(ElectroEmployeePK electroEmployeePK)
            throws NoSuchElectroEmployeeException {

        return findByPrimaryKey((Serializable) electroEmployeePK);
    }

    /**
     * Returns the electro employee with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee, or <code>null</code> if a electro employee with the primary key could not be found
     */
    @Override
    public ElectroEmployee fetchByPrimaryKey(
            ElectroEmployeePK electroEmployeePK) {

        return fetchByPrimaryKey((Serializable) electroEmployeePK);
    }

    /**
     * Returns all the electro employees.
     *
     * @return the electro employees
     */
    @Override
    public List<ElectroEmployee> findAll() {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the electro employees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electro employees
     * @param end the upper bound of the range of electro employees (not inclusive)
     * @return the range of electro employees
     */
    @Override
    public List<ElectroEmployee> findAll(int start, int end) {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the electro employees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electro employees
     * @param end the upper bound of the range of electro employees (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of electro employees
     */
    @Override
    public List<ElectroEmployee> findAll(
            int start, int end,
            OrderByComparator<ElectroEmployee> orderByComparator) {

        return findAll(start, end, orderByComparator, true);
    }

    /**
     * Returns an ordered range of all the electro employees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electro employees
     * @param end the upper bound of the range of electro employees (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param useFinderCache whether to use the finder cache
     * @return the ordered range of electro employees
     */
    @Override
    public List<ElectroEmployee> findAll(
            int start, int end,
            OrderByComparator<ElectroEmployee> orderByComparator,
            boolean useFinderCache) {

        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {

            if (useFinderCache) {
                finderPath = _finderPathWithoutPaginationFindAll;
                finderArgs = FINDER_ARGS_EMPTY;
            }
        } else if (useFinderCache) {
            finderPath = _finderPathWithPaginationFindAll;
            finderArgs = new Object[]{start, end, orderByComparator};
        }

        List<ElectroEmployee> list = null;

        if (useFinderCache) {
            list = (List<ElectroEmployee>) finderCache.getResult(
                    finderPath, finderArgs, this);
        }

        if (list == null) {
            StringBundler sb = null;
            String sql = null;

            if (orderByComparator != null) {
                sb = new StringBundler(
                        2 + (orderByComparator.getOrderByFields().length * 2));

                sb.append(_SQL_SELECT_ELECTROEMPLOYEE);

                appendOrderByComparator(
                        sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

                sql = sb.toString();
            } else {
                sql = _SQL_SELECT_ELECTROEMPLOYEE;

                sql = sql.concat(ElectroEmployeeModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(sql);

                list = (List<ElectroEmployee>) QueryUtil.list(
                        query, getDialect(), start, end);

                cacheResult(list);

                if (useFinderCache) {
                    finderCache.putResult(finderPath, finderArgs, list);
                }
            } catch (Exception exception) {
                throw processException(exception);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the electro employees from the database.
     *
     */
    @Override
    public void removeAll() {
        for (ElectroEmployee electroEmployee : findAll()) {
            remove(electroEmployee);
        }
    }

    /**
     * Returns the number of electro employees.
     *
     * @return the number of electro employees
     */
    @Override
    public int countAll() {
        Long count = (Long) finderCache.getResult(
                _finderPathCountAll, FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(_SQL_COUNT_ELECTROEMPLOYEE);

                count = (Long) query.uniqueResult();

                finderCache.putResult(
                        _finderPathCountAll, FINDER_ARGS_EMPTY, count);
            } catch (Exception exception) {
                throw processException(exception);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    public Set<String> getCompoundPKColumnNames() {
        return _compoundPKColumnNames;
    }

    @Override
    protected EntityCache getEntityCache() {
        return entityCache;
    }

    @Override
    protected String getPKDBName() {
        return "electroEmployeePK";
    }

    @Override
    protected String getSelectSQL() {
        return _SQL_SELECT_ELECTROEMPLOYEE;
    }

    @Override
    protected Map<String, Integer> getTableColumnsMap() {
        return ElectroEmployeeModelImpl.TABLE_COLUMNS_MAP;
    }

    /**
     * Initializes the electro employee persistence.
     */
    @Activate
    public void activate(BundleContext bundleContext) {
        _bundleContext = bundleContext;

        _argumentsResolverServiceRegistration = _bundleContext.registerService(
                ArgumentsResolver.class,
                new ElectroEmployeeModelArgumentsResolver(),
                MapUtil.singletonDictionary(
                        "model.class.name", ElectroEmployee.class.getName()));

        _valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
                PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

        _finderPathWithPaginationFindAll = _createFinderPath(
                FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
                new String[0], true);

        _finderPathWithoutPaginationFindAll = _createFinderPath(
                FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
                new String[0], true);

        _finderPathCountAll = _createFinderPath(
                FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
                new String[0], new String[0], false);

        _setElectroEmployeeUtilPersistence(this);
    }

    @Deactivate
    public void deactivate() {
        _setElectroEmployeeUtilPersistence(null);

        entityCache.removeCache(ElectroEmployeeImpl.class.getName());

        _argumentsResolverServiceRegistration.unregister();

        for (ServiceRegistration<FinderPath> serviceRegistration :
                _serviceRegistrations) {

            serviceRegistration.unregister();
        }
    }

    private void _setElectroEmployeeUtilPersistence(
            ElectroEmployeePersistence electroEmployeePersistence) {

        try {
            Field field = ElectroEmployeeUtil.class.getDeclaredField(
                    "_persistence");

            field.setAccessible(true);

            field.set(null, electroEmployeePersistence);
        } catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    @Override
    @Reference(
            target = SHOPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
            unbind = "-"
    )
    public void setConfiguration(Configuration configuration) {
    }

    @Override
    @Reference(
            target = SHOPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
            unbind = "-"
    )
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    @Reference(
            target = SHOPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
            unbind = "-"
    )
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    private FinderPath _createFinderPath(
            String cacheName, String methodName, String[] params,
            String[] columnNames, boolean baseModelResult) {

        FinderPath finderPath = new FinderPath(
                cacheName, methodName, params, columnNames, baseModelResult);

        if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
            _serviceRegistrations.add(
                    _bundleContext.registerService(
                            FinderPath.class, finderPath,
                            MapUtil.singletonDictionary("cache.name", cacheName)));
        }

        return finderPath;
    }

    private static class ElectroEmployeeModelArgumentsResolver
            implements ArgumentsResolver {

        private static final Map<FinderPath, Long>
                _finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

        private static Object[] _getValue(
                ElectroEmployeeModelImpl electroEmployeeModelImpl,
                String[] columnNames, boolean original) {

            Object[] arguments = new Object[columnNames.length];

            for (int i = 0; i < arguments.length; i++) {
                String columnName = columnNames[i];

                if (original) {
                    arguments[i] =
                            electroEmployeeModelImpl.getColumnOriginalValue(
                                    columnName);
                } else {
                    arguments[i] = electroEmployeeModelImpl.getColumnValue(
                            columnName);
                }
            }

            return arguments;
        }

        @Override
        public Object[] getArguments(
                FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
                boolean original) {

            String[] columnNames = finderPath.getColumnNames();

            if ((columnNames == null) || (columnNames.length == 0)) {
                if (baseModel.isNew()) {
                    return new Object[0];
                }

                return null;
            }

            ElectroEmployeeModelImpl electroEmployeeModelImpl =
                    (ElectroEmployeeModelImpl) baseModel;

            long columnBitmask = electroEmployeeModelImpl.getColumnBitmask();

            if (!checkColumn || (columnBitmask == 0)) {
                return _getValue(
                        electroEmployeeModelImpl, columnNames, original);
            }

            Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
                    finderPath);

            if (finderPathColumnBitmask == null) {
                finderPathColumnBitmask = 0L;

                for (String columnName : columnNames) {
                    finderPathColumnBitmask |=
                            electroEmployeeModelImpl.getColumnBitmask(columnName);
                }

                _finderPathColumnBitmasksCache.put(
                        finderPath, finderPathColumnBitmask);
            }

            if ((columnBitmask & finderPathColumnBitmask) != 0) {
                return _getValue(
                        electroEmployeeModelImpl, columnNames, original);
            }

            return null;
        }

    }

}