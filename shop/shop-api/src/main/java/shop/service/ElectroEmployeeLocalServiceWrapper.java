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

package shop.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ElectroEmployeeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployeeLocalService
 * @generated
 */
public class ElectroEmployeeLocalServiceWrapper
        implements ElectroEmployeeLocalService,
        ServiceWrapper<ElectroEmployeeLocalService> {

    private ElectroEmployeeLocalService _electroEmployeeLocalService;

    public ElectroEmployeeLocalServiceWrapper(
            ElectroEmployeeLocalService electroEmployeeLocalService) {

        _electroEmployeeLocalService = electroEmployeeLocalService;
    }

    /**
     * Adds the electro employee to the database. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect ElectroEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param electroEmployee the electro employee
     * @return the electro employee that was added
     */
    @Override
    public shop.model.ElectroEmployee addElectroEmployee(
            shop.model.ElectroEmployee electroEmployee) {

        return _electroEmployeeLocalService.addElectroEmployee(electroEmployee);
    }

    /**
     * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
     *
     * @param electroEmployeePK the primary key for the new electro employee
     * @return the new electro employee
     */
    @Override
    public shop.model.ElectroEmployee createElectroEmployee(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK) {

        return _electroEmployeeLocalService.createElectroEmployee(
                electroEmployeePK);
    }

    /**
     * @throws PortalException
     */
    @Override
    public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
            java.io.Serializable primaryKeyObj)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _electroEmployeeLocalService.createPersistedModel(primaryKeyObj);
    }

    /**
     * Deletes the electro employee from the database. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect ElectroEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param electroEmployee the electro employee
     * @return the electro employee that was removed
     */
    @Override
    public shop.model.ElectroEmployee deleteElectroEmployee(
            shop.model.ElectroEmployee electroEmployee) {

        return _electroEmployeeLocalService.deleteElectroEmployee(
                electroEmployee);
    }

    /**
     * Deletes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect ElectroEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee that was removed
     * @throws PortalException if a electro employee with the primary key could not be found
     */
    @Override
    public shop.model.ElectroEmployee deleteElectroEmployee(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _electroEmployeeLocalService.deleteElectroEmployee(
                electroEmployeePK);
    }

    /**
     * @throws PortalException
     */
    @Override
    public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
            com.liferay.portal.kernel.model.PersistedModel persistedModel)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _electroEmployeeLocalService.deletePersistedModel(
                persistedModel);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _electroEmployeeLocalService.dynamicQuery();
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     */
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

        return _electroEmployeeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>shop.model.impl.ElectroEmployeeModelImpl</code>.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     */
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
            int end) {

        return _electroEmployeeLocalService.dynamicQuery(
                dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>shop.model.impl.ElectroEmployeeModelImpl</code>.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     */
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
            int end,
            com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

        return _electroEmployeeLocalService.dynamicQuery(
                dynamicQuery, start, end, orderByComparator);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

        return _electroEmployeeLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
            com.liferay.portal.kernel.dao.orm.Projection projection) {

        return _electroEmployeeLocalService.dynamicQueryCount(
                dynamicQuery, projection);
    }

    @Override
    public shop.model.ElectroEmployee fetchElectroEmployee(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK) {

        return _electroEmployeeLocalService.fetchElectroEmployee(
                electroEmployeePK);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
    getActionableDynamicQuery() {

        return _electroEmployeeLocalService.getActionableDynamicQuery();
    }

    /**
     * Returns the electro employee with the primary key.
     *
     * @param electroEmployeePK the primary key of the electro employee
     * @return the electro employee
     * @throws PortalException if a electro employee with the primary key could not be found
     */
    @Override
    public shop.model.ElectroEmployee getElectroEmployee(
            shop.service.persistence.ElectroEmployeePK electroEmployeePK)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _electroEmployeeLocalService.getElectroEmployee(
                electroEmployeePK);
    }

    /**
     * Returns a range of all the electro employees.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>shop.model.impl.ElectroEmployeeModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electro employees
     * @param end the upper bound of the range of electro employees (not inclusive)
     * @return the range of electro employees
     */
    @Override
    public java.util.List<shop.model.ElectroEmployee> getElectroEmployees(
            int start, int end) {

        return _electroEmployeeLocalService.getElectroEmployees(start, end);
    }

    /**
     * Returns the number of electro employees.
     *
     * @return the number of electro employees
     */
    @Override
    public int getElectroEmployeesCount() {
        return _electroEmployeeLocalService.getElectroEmployeesCount();
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
    getIndexableActionableDynamicQuery() {

        return _electroEmployeeLocalService.
                getIndexableActionableDynamicQuery();
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    @Override
    public String getOSGiServiceIdentifier() {
        return _electroEmployeeLocalService.getOSGiServiceIdentifier();
    }

    /**
     * @throws PortalException
     */
    @Override
    public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
            java.io.Serializable primaryKeyObj)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _electroEmployeeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
     * Updates the electro employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect ElectroEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param electroEmployee the electro employee
     * @return the electro employee that was updated
     */
    @Override
    public shop.model.ElectroEmployee updateElectroEmployee(
            shop.model.ElectroEmployee electroEmployee) {

        return _electroEmployeeLocalService.updateElectroEmployee(
                electroEmployee);
    }

    @Override
    public ElectroEmployeeLocalService getWrappedService() {
        return _electroEmployeeLocalService;
    }

    @Override
    public void setWrappedService(
            ElectroEmployeeLocalService electroEmployeeLocalService) {

        _electroEmployeeLocalService = electroEmployeeLocalService;
    }

}