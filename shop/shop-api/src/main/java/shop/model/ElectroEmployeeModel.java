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

package shop.model;

import com.liferay.portal.kernel.model.BaseModel;
import org.osgi.annotation.versioning.ProviderType;
import shop.service.persistence.ElectroEmployeePK;

/**
 * The base model interface for the ElectroEmployee service. Represents a row in the &quot;SHOP_ElectroEmployee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>shop.model.impl.ElectroEmployeeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>shop.model.impl.ElectroEmployeeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployee
 * @generated
 */
@ProviderType
public interface ElectroEmployeeModel extends BaseModel<ElectroEmployee> {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a electro employee model instance should use the {@link ElectroEmployee} interface instead.
     */

    /**
     * Returns the primary key of this electro employee.
     *
     * @return the primary key of this electro employee
     */
    public ElectroEmployeePK getPrimaryKey();

    /**
     * Sets the primary key of this electro employee.
     *
     * @param primaryKey the primary key of this electro employee
     */
    public void setPrimaryKey(ElectroEmployeePK primaryKey);

    /**
     * Returns the employee ID of this electro employee.
     *
     * @return the employee ID of this electro employee
     */
    public long getEmployeeId();

    /**
     * Sets the employee ID of this electro employee.
     *
     * @param employeeId the employee ID of this electro employee
     */
    public void setEmployeeId(long employeeId);

    /**
     * Returns the e type ID of this electro employee.
     *
     * @return the e type ID of this electro employee
     */
    public long getETypeId();

    /**
     * Sets the e type ID of this electro employee.
     *
     * @param eTypeId the e type ID of this electro employee
     */
    public void setETypeId(long eTypeId);

}