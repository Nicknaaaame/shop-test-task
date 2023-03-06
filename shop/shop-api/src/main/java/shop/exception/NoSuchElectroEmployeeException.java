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
package shop.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;
import shop.service.persistence.ElectroEmployeePK;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchElectroEmployeeException extends NoSuchModelException {

    public NoSuchElectroEmployeeException() {
    }

    public NoSuchElectroEmployeeException(ElectroEmployeePK id) {
        super(String.format("Employee with id: %d has no electro type with id: %d", id.getEmployeeId(), id.getETypeId()));
    }

    public NoSuchElectroEmployeeException(String msg) {
        super(msg);
    }

    public NoSuchElectroEmployeeException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public NoSuchElectroEmployeeException(Throwable throwable) {
        super(throwable);
    }
}