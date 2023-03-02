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

package shop.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ElectroEmployeeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployeeService
 * @generated
 */
public class ElectroEmployeeServiceWrapper
	implements ElectroEmployeeService, ServiceWrapper<ElectroEmployeeService> {

	public ElectroEmployeeServiceWrapper(
		ElectroEmployeeService electroEmployeeService) {

		_electroEmployeeService = electroEmployeeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _electroEmployeeService.getOSGiServiceIdentifier();
	}

	@Override
	public ElectroEmployeeService getWrappedService() {
		return _electroEmployeeService;
	}

	@Override
	public void setWrappedService(
		ElectroEmployeeService electroEmployeeService) {

		_electroEmployeeService = electroEmployeeService;
	}

	private ElectroEmployeeService _electroEmployeeService;

}