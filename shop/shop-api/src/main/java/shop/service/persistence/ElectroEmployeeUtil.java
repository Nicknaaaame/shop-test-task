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

package shop.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import shop.exception.NoSuchElectroEmployeeException;
import shop.model.ElectroEmployee;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the electro employee service. This utility wraps <code>shop.service.persistence.impl.ElectroEmployeePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployeePersistence
 * @generated
 */
public class ElectroEmployeeUtil {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    private static volatile ElectroEmployeePersistence _persistence;

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
     */
    public static void clearCache(ElectroEmployee electroEmployee) {
        getPersistence().clearCache(electroEmployee);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
     */
    public static Map<Serializable, ElectroEmployee> fetchByPrimaryKeys(
            Set<Serializable> primaryKeys) {

        return getPersistence().fetchByPrimaryKeys(primaryKeys);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ElectroEmployee> findWithDynamicQuery(
            DynamicQuery dynamicQuery) {

        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ElectroEmployee> findWithDynamicQuery(
            DynamicQuery dynamicQuery, int start, int end) {

        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ElectroEmployee> findWithDynamicQuery(
            DynamicQuery dynamicQuery, int start, int end,
            OrderByComparator<ElectroEmployee> orderByComparator) {

        return getPersistence().findWithDynamicQuery(
                dynamicQuery, start, end, orderByComparator);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
     */
    public static ElectroEmployee update(ElectroEmployee electroEmployee) {
        return getPersistence().update(electroEmployee);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
     */
    public static ElectroEmployee update(
            ElectroEmployee electroEmployee, ServiceContext serviceContext) {

        return getPersistence().update(electroEmployee, serviceContext);
    }

    /**
     * Caches the electro employee in the entity cache if it is enabled.
     *
     * @param electroEmployee the electro employee
     */
    public static void cacheResult(ElectroEmployee electroEmployee) {
        getPersistence().cacheResult(electroEmployee);
    }

    /**
     * Caches the electro employees in the entity cache if it is enabled.
     *
     * @param electroEmployees the electro employees
     */
    public static void cacheResult(List<ElectroEmployee> electroEmployees) {
        getPersistence().cacheResult(electroEmployees);
    }

    /**
     * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
     *
     * @param electroEmployeePK the primary key for the new electro employee
     * @return the new electro employee
     */
    public static ElectroEmployee create(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK) {

        return getPersistence().create(electroEmployeePK);
    }

    /**
     * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee that was removed
     * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
     */
    public static ElectroEmployee remove(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK)
            throws shop.exception.NoSuchElectroEmployeeException {

        return getPersistence().remove(electroEmployeePK);
    }

    public static ElectroEmployee updateImpl(ElectroEmployee electroEmployee) {
        return getPersistence().updateImpl(electroEmployee);
    }

    /**
     * Returns the electro employee with the primary key or throws a <code>NoSuchElectroEmployeeException</code> if it could not be found.
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee
     * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
     */
    public static ElectroEmployee findByPrimaryKey(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK)
            throws shop.exception.NoSuchElectroEmployeeException {

        return getPersistence().findByPrimaryKey(electroEmployeePK);
    }

    /**
     * Returns the electro employee with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee, or <code>null</code> if a electro employee with the primary key could not be found
     */
    public static ElectroEmployee fetchByPrimaryKey(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK) {

        return getPersistence().fetchByPrimaryKey(electroEmployeePK);
    }

    /**
     * Returns all the electro employees.
     *
     * @return the electro employees
     */
    public static List<ElectroEmployee> findAll() {
        return getPersistence().findAll();
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
    public static List<ElectroEmployee> findAll(int start, int end) {
        return getPersistence().findAll(start, end);
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
    public static List<ElectroEmployee> findAll(
            int start, int end,
            OrderByComparator<ElectroEmployee> orderByComparator) {

        return getPersistence().findAll(start, end, orderByComparator);
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
    public static List<ElectroEmployee> findAll(
            int start, int end,
            OrderByComparator<ElectroEmployee> orderByComparator,
            boolean useFinderCache) {

        return getPersistence().findAll(
                start, end, orderByComparator, useFinderCache);
    }

    /**
     * Removes all the electro employees from the database.
     */
    public static void removeAll() {
        getPersistence().removeAll();
    }

    /**
     * Returns the number of electro employees.
     *
     * @return the number of electro employees
     */
    public static int countAll() {
        return getPersistence().countAll();
    }

    public static Set<String> getCompoundPKColumnNames() {
        return getPersistence().getCompoundPKColumnNames();
    }

    public static ElectroEmployeePersistence getPersistence() {
        return _persistence;
    }

}