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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

import shop.exception.NoSuchElectroEmployeeException;

import shop.model.ElectroEmployee;

/**
 * The persistence interface for the electro employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployeeUtil
 * @generated
 */
@ProviderType
public interface ElectroEmployeePersistence
	extends BasePersistence<ElectroEmployee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElectroEmployeeUtil} to access the electro employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the electro employee in the entity cache if it is enabled.
	 *
	 * @param electroEmployee the electro employee
	 */
	public void cacheResult(ElectroEmployee electroEmployee);

	/**
	 * Caches the electro employees in the entity cache if it is enabled.
	 *
	 * @param electroEmployees the electro employees
	 */
	public void cacheResult(java.util.List<ElectroEmployee> electroEmployees);

	/**
	 * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
	 *
	 * @param electroEmployeePK the primary key for the new electro employee
	 * @return the new electro employee
	 */
	public ElectroEmployee create(
		shop.service.persistence.ElectroEmployeePK electroEmployeePK);

	/**
	 * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electroEmployeePK the primary key of the electro employee
	 * @return the electro employee that was removed
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee remove(
			shop.service.persistence.ElectroEmployeePK electroEmployeePK)
		throws NoSuchElectroEmployeeException;

	public ElectroEmployee updateImpl(ElectroEmployee electroEmployee);

	/**
	 * Returns the electro employee with the primary key or throws a <code>NoSuchElectroEmployeeException</code> if it could not be found.
	 *
	 * @param electroEmployeePK the primary key of the electro employee
	 * @return the electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee findByPrimaryKey(
			shop.service.persistence.ElectroEmployeePK electroEmployeePK)
		throws NoSuchElectroEmployeeException;

	/**
	 * Returns the electro employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electroEmployeePK the primary key of the electro employee
	 * @return the electro employee, or <code>null</code> if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee fetchByPrimaryKey(
		shop.service.persistence.ElectroEmployeePK electroEmployeePK);

	/**
	 * Returns all the electro employees.
	 *
	 * @return the electro employees
	 */
	public java.util.List<ElectroEmployee> findAll();

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
	public java.util.List<ElectroEmployee> findAll(int start, int end);

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
	public java.util.List<ElectroEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

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
	public java.util.List<ElectroEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electro employees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electro employees.
	 *
	 * @return the number of electro employees
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}