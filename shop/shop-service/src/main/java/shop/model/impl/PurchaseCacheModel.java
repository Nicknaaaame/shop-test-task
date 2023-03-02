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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import shop.model.Purchase;

/**
 * The cache model class for representing Purchase in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PurchaseCacheModel
	implements CacheModel<Purchase>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseCacheModel)) {
			return false;
		}

		PurchaseCacheModel purchaseCacheModel = (PurchaseCacheModel)object;

		if (id == purchaseCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", purchaseDate=");
		sb.append(purchaseDate);
		sb.append(", eTypeId=");
		sb.append(eTypeId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", electroId=");
		sb.append(electroId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Purchase toEntityModel() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		purchaseImpl.setId(id);

		if (purchaseDate == Long.MIN_VALUE) {
			purchaseImpl.setPurchaseDate(null);
		}
		else {
			purchaseImpl.setPurchaseDate(new Date(purchaseDate));
		}

		purchaseImpl.setETypeId(eTypeId);
		purchaseImpl.setEmployeeId(employeeId);
		purchaseImpl.setElectroId(electroId);

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		purchaseDate = objectInput.readLong();

		eTypeId = objectInput.readLong();

		employeeId = objectInput.readLong();

		electroId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(purchaseDate);

		objectOutput.writeLong(eTypeId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(electroId);
	}

	public long id;
	public long purchaseDate;
	public long eTypeId;
	public long employeeId;
	public long electroId;

}