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

package shop.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import shop.model.ElectroEmployee;
import shop.service.persistence.ElectroEmployeePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ElectroEmployee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectroEmployeeCacheModel
	implements CacheModel<ElectroEmployee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectroEmployeeCacheModel)) {
			return false;
		}

		ElectroEmployeeCacheModel electroEmployeeCacheModel =
			(ElectroEmployeeCacheModel)object;

		if (electroEmployeePK.equals(
				electroEmployeeCacheModel.electroEmployeePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, electroEmployeePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", eTypeId=");
		sb.append(eTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElectroEmployee toEntityModel() {
		ElectroEmployeeImpl electroEmployeeImpl = new ElectroEmployeeImpl();

		electroEmployeeImpl.setEmployeeId(employeeId);
		electroEmployeeImpl.setETypeId(eTypeId);

		electroEmployeeImpl.resetOriginalValues();

		return electroEmployeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();

		eTypeId = objectInput.readLong();

		electroEmployeePK = new ElectroEmployeePK(employeeId, eTypeId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(eTypeId);
	}

	public long employeeId;
	public long eTypeId;
	public transient ElectroEmployeePK electroEmployeePK;

}