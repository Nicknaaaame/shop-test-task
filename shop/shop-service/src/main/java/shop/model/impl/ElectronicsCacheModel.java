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
import shop.model.Electronics;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Electronics in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectronicsCacheModel
        implements CacheModel<Electronics>, Externalizable {

    public long id;
    public String name;
    public long eTypeId;
    public long price;
    public int count;
    public boolean isInStock;
    public boolean isArchive;
    public String description;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ElectronicsCacheModel)) {
            return false;
        }

        ElectronicsCacheModel electronicsCacheModel =
                (ElectronicsCacheModel) object;

        if (id == electronicsCacheModel.id) {
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
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", eTypeId=");
        sb.append(eTypeId);
        sb.append(", price=");
        sb.append(price);
        sb.append(", count=");
        sb.append(count);
        sb.append(", isInStock=");
        sb.append(isInStock);
        sb.append(", isArchive=");
        sb.append(isArchive);
        sb.append(", description=");
        sb.append(description);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Electronics toEntityModel() {
        ElectronicsImpl electronicsImpl = new ElectronicsImpl();

        electronicsImpl.setId(id);

        if (name == null) {
            electronicsImpl.setName("");
        } else {
            electronicsImpl.setName(name);
        }

        electronicsImpl.setETypeId(eTypeId);
        electronicsImpl.setPrice(price);
        electronicsImpl.setCount(count);
        electronicsImpl.setIsInStock(isInStock);
        electronicsImpl.setIsArchive(isArchive);

        if (description == null) {
            electronicsImpl.setDescription("");
        } else {
            electronicsImpl.setDescription(description);
        }

        electronicsImpl.resetOriginalValues();

        return electronicsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        name = objectInput.readUTF();

        eTypeId = objectInput.readLong();

        price = objectInput.readLong();

        count = objectInput.readInt();

        isInStock = objectInput.readBoolean();

        isArchive = objectInput.readBoolean();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(id);

        if (name == null) {
            objectOutput.writeUTF("");
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeLong(eTypeId);

        objectOutput.writeLong(price);

        objectOutput.writeInt(count);

        objectOutput.writeBoolean(isInStock);

        objectOutput.writeBoolean(isArchive);

        if (description == null) {
            objectOutput.writeUTF("");
        } else {
            objectOutput.writeUTF(description);
        }
    }

}