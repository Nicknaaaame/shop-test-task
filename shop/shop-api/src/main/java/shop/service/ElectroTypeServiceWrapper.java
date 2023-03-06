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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ElectroTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElectroTypeService
 * @generated
 */
public class ElectroTypeServiceWrapper
        implements ElectroTypeService, ServiceWrapper<ElectroTypeService> {

    private ElectroTypeService _electroTypeService;

    public ElectroTypeServiceWrapper(ElectroTypeService electroTypeService) {
        _electroTypeService = electroTypeService;
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    @Override
    public String getOSGiServiceIdentifier() {
        return _electroTypeService.getOSGiServiceIdentifier();
    }

    @Override
    public ElectroTypeService getWrappedService() {
        return _electroTypeService;
    }

    @Override
    public void setWrappedService(ElectroTypeService electroTypeService) {
        _electroTypeService = electroTypeService;
    }

}