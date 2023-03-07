/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package shop.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import shop.model.ElectroEmployee;

import shop.service.ElectroEmployeeLocalService;
import shop.service.ElectroEmployeeLocalServiceUtil;
import shop.service.persistence.ElectroEmployeePK;
import shop.service.persistence.ElectroEmployeePersistence;
import shop.service.persistence.ElectroTypePersistence;
import shop.service.persistence.ElectronicsPersistence;
import shop.service.persistence.EmployeePersistence;
import shop.service.persistence.PositionTypePersistence;
import shop.service.persistence.PurchasePersistence;
import shop.service.persistence.PurchaseTypePersistence;

/**
 * Provides the base implementation for the electro employee local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link shop.service.impl.ElectroEmployeeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see shop.service.impl.ElectroEmployeeLocalServiceImpl
 * @generated
 */
public abstract class ElectroEmployeeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ElectroEmployeeLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ElectroEmployeeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ElectroEmployeeLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ElectroEmployee addElectroEmployee(ElectroEmployee electroEmployee) {
		electroEmployee.setNew(true);

		return electroEmployeePersistence.update(electroEmployee);
	}

	/**
	 * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
	 *
	 * @param electroEmployeePK the primary key for the new electro employee
	 * @return the new electro employee
	 */
	@Override
	@Transactional(enabled = false)
	public ElectroEmployee createElectroEmployee(
		ElectroEmployeePK electroEmployeePK) {

		return electroEmployeePersistence.create(electroEmployeePK);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ElectroEmployee deleteElectroEmployee(
			ElectroEmployeePK electroEmployeePK)
		throws PortalException {

		return electroEmployeePersistence.remove(electroEmployeePK);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ElectroEmployee deleteElectroEmployee(
		ElectroEmployee electroEmployee) {

		return electroEmployeePersistence.remove(electroEmployee);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ElectroEmployee.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return electroEmployeePersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return electroEmployeePersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return electroEmployeePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return electroEmployeePersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return electroEmployeePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ElectroEmployee fetchElectroEmployee(
		ElectroEmployeePK electroEmployeePK) {

		return electroEmployeePersistence.fetchByPrimaryKey(electroEmployeePK);
	}

	/**
	 * Returns the electro employee with the primary key.
	 *
	 * @param electroEmployeePK the primary key of the electro employee
	 * @return the electro employee
	 * @throws PortalException if a electro employee with the primary key could not be found
	 */
	@Override
	public ElectroEmployee getElectroEmployee(
			ElectroEmployeePK electroEmployeePK)
		throws PortalException {

		return electroEmployeePersistence.findByPrimaryKey(electroEmployeePK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(electroEmployeeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ElectroEmployee.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.employeeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			electroEmployeeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ElectroEmployee.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.employeeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(electroEmployeeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ElectroEmployee.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.employeeId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return electroEmployeePersistence.create(
			(ElectroEmployeePK)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return electroEmployeeLocalService.deleteElectroEmployee(
			(ElectroEmployee)persistedModel);
	}

	public BasePersistence<ElectroEmployee> getBasePersistence() {
		return electroEmployeePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return electroEmployeePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<ElectroEmployee> getElectroEmployees(int start, int end) {
		return electroEmployeePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of electro employees.
	 *
	 * @return the number of electro employees
	 */
	@Override
	public int getElectroEmployeesCount() {
		return electroEmployeePersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ElectroEmployee updateElectroEmployee(
		ElectroEmployee electroEmployee) {

		return electroEmployeePersistence.update(electroEmployee);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ElectroEmployeeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		electroEmployeeLocalService = (ElectroEmployeeLocalService)aopProxy;

		_setLocalServiceUtilService(electroEmployeeLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ElectroEmployeeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ElectroEmployee.class;
	}

	protected String getModelClassName() {
		return ElectroEmployee.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = electroEmployeePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ElectroEmployeeLocalService electroEmployeeLocalService) {

		try {
			Field field =
				ElectroEmployeeLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, electroEmployeeLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ElectroEmployeeLocalService electroEmployeeLocalService;

	@Reference
	protected ElectroEmployeePersistence electroEmployeePersistence;

	@Reference
	protected ElectronicsPersistence electronicsPersistence;

	@Reference
	protected ElectroTypePersistence electroTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected PositionTypePersistence positionTypePersistence;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		ElectroEmployeeLocalServiceBaseImpl.class);

}