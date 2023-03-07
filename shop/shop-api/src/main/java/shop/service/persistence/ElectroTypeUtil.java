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

package shop.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import shop.model.ElectroType;

/**
 * The persistence utility for the electro type service. This utility wraps <code>shop.service.persistence.impl.ElectroTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroTypePersistence
 * @generated
 */
public class ElectroTypeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ElectroType electroType) {
		getPersistence().clearCache(electroType);
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
	public static Map<Serializable, ElectroType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ElectroType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ElectroType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ElectroType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ElectroType update(ElectroType electroType) {
		return getPersistence().update(electroType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ElectroType update(
		ElectroType electroType, ServiceContext serviceContext) {

		return getPersistence().update(electroType, serviceContext);
	}

	/**
	 * Caches the electro type in the entity cache if it is enabled.
	 *
	 * @param electroType the electro type
	 */
	public static void cacheResult(ElectroType electroType) {
		getPersistence().cacheResult(electroType);
	}

	/**
	 * Caches the electro types in the entity cache if it is enabled.
	 *
	 * @param electroTypes the electro types
	 */
	public static void cacheResult(List<ElectroType> electroTypes) {
		getPersistence().cacheResult(electroTypes);
	}

	/**
	 * Creates a new electro type with the primary key. Does not add the electro type to the database.
	 *
	 * @param id the primary key for the new electro type
	 * @return the new electro type
	 */
	public static ElectroType create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the electro type
	 * @return the electro type that was removed
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public static ElectroType remove(long id)
		throws shop.exception.NoSuchElectroTypeException {

		return getPersistence().remove(id);
	}

	public static ElectroType updateImpl(ElectroType electroType) {
		return getPersistence().updateImpl(electroType);
	}

	/**
	 * Returns the electro type with the primary key or throws a <code>NoSuchElectroTypeException</code> if it could not be found.
	 *
	 * @param id the primary key of the electro type
	 * @return the electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public static ElectroType findByPrimaryKey(long id)
		throws shop.exception.NoSuchElectroTypeException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the electro type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the electro type
	 * @return the electro type, or <code>null</code> if a electro type with the primary key could not be found
	 */
	public static ElectroType fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the electro types.
	 *
	 * @return the electro types
	 */
	public static List<ElectroType> findAll() {
		return getPersistence().findAll();
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
	public static List<ElectroType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ElectroType> findAll(
		int start, int end, OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ElectroType> findAll(
		int start, int end, OrderByComparator<ElectroType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the electro types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of electro types.
	 *
	 * @return the number of electro types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ElectroTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ElectroTypePersistence _persistence;

}