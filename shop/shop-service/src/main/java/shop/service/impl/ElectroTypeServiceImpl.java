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

package shop.service.impl;

import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;
import shop.service.base.ElectroTypeServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = {
                "json.web.service.context.name=shop",
                "json.web.service.context.path=ElectroType"
        },
        service = AopService.class
)
public class ElectroTypeServiceImpl extends ElectroTypeServiceBaseImpl {
}