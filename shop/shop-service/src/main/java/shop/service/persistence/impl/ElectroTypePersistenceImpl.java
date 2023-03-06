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
import shop.exception.NoSuchElectroTypeException;
import shop.model.ElectroType;
import shop.model.impl.ElectroTypeImpl;
import shop.model.impl.ElectroTypeModelImpl;
import shop.service.persistence.ElectroTypePersistence;
import shop.service.persistence.ElectroTypeUtil;
import shop.service.persistence.impl.constants.SHOPPersistenceConstants;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The persistence implementation for the electro type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElectroTypePersistence.class)
public class ElectroTypePersistenceImpl
        extends BasePersistenceImpl<ElectroType> implements ElectroTypePersistence {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use <code>ElectroTypeUtil</code> to access the electro type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY =
            ElectroTypeImpl.class.getName();

    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
            FINDER_CLASS_NAME_ENTITY + ".List1";

    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
            FINDER_CLASS_NAME_ENTITY + ".List2";
    private static final String _SQL_SELECT_ELECTROTYPE =
            "SELECT electroType FROM ElectroType electroType";
    private static final String _SQL_COUNT_ELECTROTYPE =
            "SELECT COUNT(electroType) FROM ElectroType electroType";
    private static final String _ORDER_BY_ENTITY_ALIAS = "electroType.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
            "No ElectroType exists with the primary key ";
    private static final Log _log = LogFactoryUtil.getLog(
            ElectroTypePersistenceImpl.class);
    private static final Set<String> _badColumnNames = SetUtil.fromArray(
            new String[]{"id"});
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

    public ElectroTypePersistenceImpl() {
        Map<String, String> dbColumnNames = new HashMap<String, String>();

        dbColumnNames.put("id", "id_");

        setDBColumnNames(dbColumnNames);

        setModelClass(ElectroType.class);

        setModelImplClass(ElectroTypeImpl.class);
        setModelPKClass(long.class);
    }

    /**
     * Caches the electro type in the entity cache if it is enabled.
     *
     * @param electroType the electro type
     */
    @Override
    public void cacheResult(ElectroType electroType) {
        entityCache.putResult(
                ElectroTypeImpl.class, electroType.getPrimaryKey(), electroType);
    }

    /**
     * Caches the electro types in the entity cache if it is enabled.
     *
     * @param electroTypes the electro types
     */
    @Override
    public void cacheResult(List<ElectroType> electroTypes) {
        if ((_valueObjectFinderCacheListThreshold == 0) ||
                ((_valueObjectFinderCacheListThreshold > 0) &&
                        (electroTypes.size() > _valueObjectFinderCacheListThreshold))) {

            return;
        }

        for (ElectroType electroType : electroTypes) {
            if (entityCache.getResult(
                    ElectroTypeImpl.class, electroType.getPrimaryKey()) ==
                    null) {

                cacheResult(electroType);
            }
        }
    }

    /**
     * Clears the cache for all electro types.
     *
     * <p>
     * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        entityCache.clearCache(ElectroTypeImpl.class);

        finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the electro type.
     *
     * <p>
     * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ElectroType electroType) {
        entityCache.removeResult(ElectroTypeImpl.class, electroType);
    }

    @Override
    public void clearCache(List<ElectroType> electroTypes) {
        for (ElectroType electroType : electroTypes) {
            entityCache.removeResult(ElectroTypeImpl.class, electroType);
        }
    }

    @Override
    public void clearCache(Set<Serializable> primaryKeys) {
        finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Serializable primaryKey : primaryKeys) {
            entityCache.removeResult(ElectroTypeImpl.class, primaryKey);
        }
    }

    /**
     * Creates a new electro type with the primary key. Does not add the electro type to the database.
     *
     * @param id the primary key for the new electro type
     * @return the new electro type
     */
    @Override
    public ElectroType create(long id) {
        ElectroType electroType = new ElectroTypeImpl();

        electroType.setNew(true);
        electroType.setPrimaryKey(id);

        return electroType;
    }

    /**
     * Removes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the electro type
     * @return the electro type that was removed
     * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
     */
    @Override
    public ElectroType remove(long id) throws NoSuchElectroTypeException {
        return remove((Serializable) id);
    }

    /**
     * Removes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the electro type
     * @return the electro type that was removed
     * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
     */
    @Override
    public ElectroType remove(Serializable primaryKey)
            throws NoSuchElectroTypeException {

        Session session = null;

        try {
            session = openSession();

            ElectroType electroType = (ElectroType) session.get(
                    ElectroTypeImpl.class, primaryKey);

            if (electroType == null) {
                if (_log.isDebugEnabled()) {
                    _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchElectroTypeException(
                        _NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            return remove(electroType);
        } catch (NoSuchElectroTypeException noSuchEntityException) {
            throw noSuchEntityException;
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ElectroType removeImpl(ElectroType electroType) {
        Session session = null;

        try {
            session = openSession();

            if (!session.contains(electroType)) {
                electroType = (ElectroType) session.get(
                        ElectroTypeImpl.class, electroType.getPrimaryKeyObj());
            }

            if (electroType != null) {
                session.delete(electroType);
            }
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }

        if (electroType != null) {
            clearCache(electroType);
        }

        return electroType;
    }

    @Override
    public ElectroType updateImpl(ElectroType electroType) {
        boolean isNew = electroType.isNew();

        Session session = null;

        try {
            session = openSession();

            if (isNew) {
                session.save(electroType);
            } else {
                electroType = (ElectroType) session.merge(electroType);
            }
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }

        entityCache.putResult(ElectroTypeImpl.class, electroType, false, true);

        if (isNew) {
            electroType.setNew(false);
        }

        electroType.resetOriginalValues();

        return electroType;
    }

    /**
     * Returns the electro type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
     *
     * @param primaryKey the primary key of the electro type
     * @return the electro type
     * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
     */
    @Override
    public ElectroType findByPrimaryKey(Serializable primaryKey)
            throws NoSuchElectroTypeException {

        ElectroType electroType = fetchByPrimaryKey(primaryKey);

        if (electroType == null) {
            if (_log.isDebugEnabled()) {
                _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchElectroTypeException(
                    _NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
        }

        return electroType;
    }

    /**
     * Returns the electro type with the primary key or throws a <code>NoSuchElectroTypeException</code> if it could not be found.
     *
     * @param id the primary key of the electro type
     * @return the electro type
     * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
     */
    @Override
    public ElectroType findByPrimaryKey(long id)
            throws NoSuchElectroTypeException {

        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the electro type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the electro type
     * @return the electro type, or <code>null</code> if a electro type with the primary key could not be found
     */
    @Override
    public ElectroType fetchByPrimaryKey(long id) {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the electro types.
     *
     * @return the electro types
     */
    @Override
    public List<ElectroType> findAll() {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the electro types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electro types
     * @param end the upper bound of the range of electro types (not inclusive)
     * @return the range of electro types
     */
    @Override
    public List<ElectroType> findAll(int start, int end) {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the electro types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electro types
     * @param end the upper bound of the range of electro types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of electro types
     */
    @Override
    public List<ElectroType> findAll(
            int start, int end, OrderByComparator<ElectroType> orderByComparator) {

        return findAll(start, end, orderByComparator, true);
    }

    /**
     * Returns an ordered range of all the electro types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electro types
     * @param end the upper bound of the range of electro types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param useFinderCache whether to use the finder cache
     * @return the ordered range of electro types
     */
    @Override
    public List<ElectroType> findAll(
            int start, int end, OrderByComparator<ElectroType> orderByComparator,
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

        List<ElectroType> list = null;

        if (useFinderCache) {
            list = (List<ElectroType>) finderCache.getResult(
                    finderPath, finderArgs, this);
        }

        if (list == null) {
            StringBundler sb = null;
            String sql = null;

            if (orderByComparator != null) {
                sb = new StringBundler(
                        2 + (orderByComparator.getOrderByFields().length * 2));

                sb.append(_SQL_SELECT_ELECTROTYPE);

                appendOrderByComparator(
                        sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

                sql = sb.toString();
            } else {
                sql = _SQL_SELECT_ELECTROTYPE;

                sql = sql.concat(ElectroTypeModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(sql);

                list = (List<ElectroType>) QueryUtil.list(
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
     * Removes all the electro types from the database.
     *
     */
    @Override
    public void removeAll() {
        for (ElectroType electroType : findAll()) {
            remove(electroType);
        }
    }

    /**
     * Returns the number of electro types.
     *
     * @return the number of electro types
     */
    @Override
    public int countAll() {
        Long count = (Long) finderCache.getResult(
                _finderPathCountAll, FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(_SQL_COUNT_ELECTROTYPE);

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
    public Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    @Override
    protected EntityCache getEntityCache() {
        return entityCache;
    }

    @Override
    protected String getPKDBName() {
        return "id_";
    }

    @Override
    protected String getSelectSQL() {
        return _SQL_SELECT_ELECTROTYPE;
    }

    @Override
    protected Map<String, Integer> getTableColumnsMap() {
        return ElectroTypeModelImpl.TABLE_COLUMNS_MAP;
    }

    /**
     * Initializes the electro type persistence.
     */
    @Activate
    public void activate(BundleContext bundleContext) {
        _bundleContext = bundleContext;

        _argumentsResolverServiceRegistration = _bundleContext.registerService(
                ArgumentsResolver.class, new ElectroTypeModelArgumentsResolver(),
                MapUtil.singletonDictionary(
                        "model.class.name", ElectroType.class.getName()));

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

        _setElectroTypeUtilPersistence(this);
    }

    @Deactivate
    public void deactivate() {
        _setElectroTypeUtilPersistence(null);

        entityCache.removeCache(ElectroTypeImpl.class.getName());

        _argumentsResolverServiceRegistration.unregister();

        for (ServiceRegistration<FinderPath> serviceRegistration :
                _serviceRegistrations) {

            serviceRegistration.unregister();
        }
    }

    private void _setElectroTypeUtilPersistence(
            ElectroTypePersistence electroTypePersistence) {

        try {
            Field field = ElectroTypeUtil.class.getDeclaredField(
                    "_persistence");

            field.setAccessible(true);

            field.set(null, electroTypePersistence);
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

    private static class ElectroTypeModelArgumentsResolver
            implements ArgumentsResolver {

        private static final Map<FinderPath, Long>
                _finderPathColumnBitmasksCache = new ConcurrentHashMap<>();
        private static final long _ORDER_BY_COLUMNS_BITMASK;

        static {
            long orderByColumnsBitmask = 0;

            _ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
        }

        private static Object[] _getValue(
                ElectroTypeModelImpl electroTypeModelImpl, String[] columnNames,
                boolean original) {

            Object[] arguments = new Object[columnNames.length];

            for (int i = 0; i < arguments.length; i++) {
                String columnName = columnNames[i];

                if (original) {
                    arguments[i] = electroTypeModelImpl.getColumnOriginalValue(
                            columnName);
                } else {
                    arguments[i] = electroTypeModelImpl.getColumnValue(
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

            ElectroTypeModelImpl electroTypeModelImpl =
                    (ElectroTypeModelImpl) baseModel;

            long columnBitmask = electroTypeModelImpl.getColumnBitmask();

            if (!checkColumn || (columnBitmask == 0)) {
                return _getValue(electroTypeModelImpl, columnNames, original);
            }

            Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
                    finderPath);

            if (finderPathColumnBitmask == null) {
                finderPathColumnBitmask = 0L;

                for (String columnName : columnNames) {
                    finderPathColumnBitmask |=
                            electroTypeModelImpl.getColumnBitmask(columnName);
                }

                if (finderPath.isBaseModelResult() &&
                        (ElectroTypePersistenceImpl.
                                FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
                                finderPath.getCacheName())) {

                    finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
                }

                _finderPathColumnBitmasksCache.put(
                        finderPath, finderPathColumnBitmask);
            }

            if ((columnBitmask & finderPathColumnBitmask) != 0) {
                return _getValue(electroTypeModelImpl, columnNames, original);
            }

            return null;
        }

    }

}