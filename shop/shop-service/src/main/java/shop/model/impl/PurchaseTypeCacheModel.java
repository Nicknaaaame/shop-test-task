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

package shop.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import shop.model.PurchaseType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PurchaseType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PurchaseTypeCacheModel
        implements CacheModel<PurchaseType>, Externalizable {

    public long id;
    public String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof PurchaseTypeCacheModel)) {
            return false;
        }

        PurchaseTypeCacheModel purchaseTypeCacheModel =
                (PurchaseTypeCacheModel) object;

        if (id == purchaseTypeCacheModel.id) {
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
        StringBundler sb = new StringBundler(5);

        sb.append("{id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public PurchaseType toEntityModel() {
        PurchaseTypeImpl purchaseTypeImpl = new PurchaseTypeImpl();

        purchaseTypeImpl.setId(id);

        if (name == null) {
            purchaseTypeImpl.setName("");
        } else {
            purchaseTypeImpl.setName(name);
        }

        purchaseTypeImpl.resetOriginalValues();

        return purchaseTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(id);

        if (name == null) {
            objectOutput.writeUTF("");
        } else {
            objectOutput.writeUTF(name);
        }
    }

}