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
public class NoSuchElectronicsException extends NoSuchModelException {

    public NoSuchElectronicsException() {
    }

    public NoSuchElectronicsException(long id) {
        super(String.format("Product with id: %d does not exist", id));
    }

    public NoSuchElectronicsException(String msg) {
        super(msg);
    }

    public NoSuchElectronicsException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public NoSuchElectronicsException(Throwable throwable) {
        super(throwable);
    }
}