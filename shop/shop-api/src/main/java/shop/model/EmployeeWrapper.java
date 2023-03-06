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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeWrapper
        extends BaseModelWrapper<Employee>
        implements Employee, ModelWrapper<Employee> {

    public EmployeeWrapper(Employee employee) {
        super(employee);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("lastName", getLastName());
        attributes.put("firstName", getFirstName());
        attributes.put("patronymic", getPatronymic());
        attributes.put("birthDate", getBirthDate());
        attributes.put("gender", isGender());
        attributes.put("positionId", getPositionId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String patronymic = (String) attributes.get("patronymic");

        if (patronymic != null) {
            setPatronymic(patronymic);
        }

        Date birthDate = (Date) attributes.get("birthDate");

        if (birthDate != null) {
            setBirthDate(birthDate);
        }

        Boolean gender = (Boolean) attributes.get("gender");

        if (gender != null) {
            setGender(gender);
        }

        Long positionId = (Long) attributes.get("positionId");

        if (positionId != null) {
            setPositionId(positionId);
        }
    }

    /**
     * Returns the birth date of this employee.
     *
     * @return the birth date of this employee
     */
    @Override
    public Date getBirthDate() {
        return model.getBirthDate();
    }

    /**
     * Sets the birth date of this employee.
     *
     * @param birthDate the birth date of this employee
     */
    @Override
    public void setBirthDate(Date birthDate) {
        model.setBirthDate(birthDate);
    }

    /**
     * Returns the first name of this employee.
     *
     * @return the first name of this employee
     */
    @Override
    public String getFirstName() {
        return model.getFirstName();
    }

    /**
     * Sets the first name of this employee.
     *
     * @param firstName the first name of this employee
     */
    @Override
    public void setFirstName(String firstName) {
        model.setFirstName(firstName);
    }

    /**
     * Returns the gender of this employee.
     *
     * @return the gender of this employee
     */
    @Override
    public boolean getGender() {
        return model.getGender();
    }

    /**
     * Returns the ID of this employee.
     *
     * @return the ID of this employee
     */
    @Override
    public long getId() {
        return model.getId();
    }

    /**
     * Sets the ID of this employee.
     *
     * @param id the ID of this employee
     */
    @Override
    public void setId(long id) {
        model.setId(id);
    }

    /**
     * Returns the last name of this employee.
     *
     * @return the last name of this employee
     */
    @Override
    public String getLastName() {
        return model.getLastName();
    }

    /**
     * Sets the last name of this employee.
     *
     * @param lastName the last name of this employee
     */
    @Override
    public void setLastName(String lastName) {
        model.setLastName(lastName);
    }

    /**
     * Returns the patronymic of this employee.
     *
     * @return the patronymic of this employee
     */
    @Override
    public String getPatronymic() {
        return model.getPatronymic();
    }

    /**
     * Sets the patronymic of this employee.
     *
     * @param patronymic the patronymic of this employee
     */
    @Override
    public void setPatronymic(String patronymic) {
        model.setPatronymic(patronymic);
    }

    /**
     * Returns the position ID of this employee.
     *
     * @return the position ID of this employee
     */
    @Override
    public long getPositionId() {
        return model.getPositionId();
    }

    /**
     * Sets the position ID of this employee.
     *
     * @param positionId the position ID of this employee
     */
    @Override
    public void setPositionId(long positionId) {
        model.setPositionId(positionId);
    }

    /**
     * Returns the primary key of this employee.
     *
     * @return the primary key of this employee
     */
    @Override
    public long getPrimaryKey() {
        return model.getPrimaryKey();
    }

    /**
     * Sets the primary key of this employee.
     *
     * @param primaryKey the primary key of this employee
     */
    @Override
    public void setPrimaryKey(long primaryKey) {
        model.setPrimaryKey(primaryKey);
    }

    /**
     * Returns <code>true</code> if this employee is gender.
     *
     * @return <code>true</code> if this employee is gender; <code>false</code> otherwise
     */
    @Override
    public boolean isGender() {
        return model.isGender();
    }

    /**
     * Sets whether this employee is gender.
     *
     * @param gender the gender of this employee
     */
    @Override
    public void setGender(boolean gender) {
        model.setGender(gender);
    }

    @Override
    public void persist() {
        model.persist();
    }

    @Override
    protected EmployeeWrapper wrap(Employee employee) {
        return new EmployeeWrapper(employee);
    }

}