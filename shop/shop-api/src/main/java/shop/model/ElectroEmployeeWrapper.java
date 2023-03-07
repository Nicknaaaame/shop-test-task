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

package shop.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ElectroEmployee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployee
 * @generated
 */
public class ElectroEmployeeWrapper
	extends BaseModelWrapper<ElectroEmployee>
	implements ElectroEmployee, ModelWrapper<ElectroEmployee> {

	public ElectroEmployeeWrapper(ElectroEmployee electroEmployee) {
		super(electroEmployee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("eTypeId", getETypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long eTypeId = (Long)attributes.get("eTypeId");

		if (eTypeId != null) {
			setETypeId(eTypeId);
		}
	}

	/**
	 * Returns the employee ID of this electro employee.
	 *
	 * @return the employee ID of this electro employee
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the e type ID of this electro employee.
	 *
	 * @return the e type ID of this electro employee
	 */
	@Override
	public long getETypeId() {
		return model.getETypeId();
	}

	/**
	 * Returns the primary key of this electro employee.
	 *
	 * @return the primary key of this electro employee
	 */
	@Override
	public shop.service.persistence.ElectroEmployeePK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the employee ID of this electro employee.
	 *
	 * @param employeeId the employee ID of this electro employee
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the e type ID of this electro employee.
	 *
	 * @param eTypeId the e type ID of this electro employee
	 */
	@Override
	public void setETypeId(long eTypeId) {
		model.setETypeId(eTypeId);
	}

	/**
	 * Sets the primary key of this electro employee.
	 *
	 * @param primaryKey the primary key of this electro employee
	 */
	@Override
	public void setPrimaryKey(
		shop.service.persistence.ElectroEmployeePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ElectroEmployeeWrapper wrap(ElectroEmployee electroEmployee) {
		return new ElectroEmployeeWrapper(electroEmployee);
	}

}