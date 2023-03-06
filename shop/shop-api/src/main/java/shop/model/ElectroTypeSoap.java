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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link shop.service.http.ElectroTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ElectroTypeSoap implements Serializable {

    private long _id;
    private String _name;

    public ElectroTypeSoap() {
    }

    public static ElectroTypeSoap toSoapModel(ElectroType model) {
        ElectroTypeSoap soapModel = new ElectroTypeSoap();

        soapModel.setId(model.getId());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static ElectroTypeSoap[] toSoapModels(ElectroType[] models) {
        ElectroTypeSoap[] soapModels = new ElectroTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ElectroTypeSoap[][] toSoapModels(ElectroType[][] models) {
        ElectroTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ElectroTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new ElectroTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ElectroTypeSoap[] toSoapModels(List<ElectroType> models) {
        List<ElectroTypeSoap> soapModels = new ArrayList<ElectroTypeSoap>(
                models.size());

        for (ElectroType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ElectroTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

}