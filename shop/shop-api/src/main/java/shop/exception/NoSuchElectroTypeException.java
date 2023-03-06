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

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchElectroTypeException extends NoSuchModelException {

    public NoSuchElectroTypeException() {
    }

    public NoSuchElectroTypeException(String msg) {
        super(msg);
    }

    public NoSuchElectroTypeException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public NoSuchElectroTypeException(Throwable throwable) {
        super(throwable);
    }

    public NoSuchElectroTypeException(long id) {
        super(String.format("Electro type with id: %d does not exist", id));
    }

}