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

package shop.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectroEmployeePK
        implements Comparable<ElectroEmployeePK>, Serializable {

    public long employeeId;
    public long eTypeId;

    public ElectroEmployeePK() {
    }

    public ElectroEmployeePK(long employeeId, long eTypeId) {
        this.employeeId = employeeId;
        this.eTypeId = eTypeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getETypeId() {
        return eTypeId;
    }

    public void setETypeId(long eTypeId) {
        this.eTypeId = eTypeId;
    }

    @Override
    public int compareTo(ElectroEmployeePK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (employeeId < pk.employeeId) {
            value = -1;
        } else if (employeeId > pk.employeeId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (eTypeId < pk.eTypeId) {
            value = -1;
        } else if (eTypeId > pk.eTypeId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ElectroEmployeePK)) {
            return false;
        }

        ElectroEmployeePK pk = (ElectroEmployeePK) object;

        if ((employeeId == pk.employeeId) && (eTypeId == pk.eTypeId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        hashCode = HashUtil.hash(hashCode, employeeId);
        hashCode = HashUtil.hash(hashCode, eTypeId);

        return hashCode;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(6);

        sb.append("{");

        sb.append("employeeId=");

        sb.append(employeeId);
        sb.append(", eTypeId=");

        sb.append(eTypeId);

        sb.append("}");

        return sb.toString();
    }

}