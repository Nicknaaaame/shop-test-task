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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import shop.model.Purchase;
import shop.model.PurchaseModel;
import shop.model.PurchaseSoap;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.sql.Blob;
import java.sql.Types;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Purchase service. Represents a row in the &quot;SHOP_Purchase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PurchaseModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PurchaseImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PurchaseImpl
 * @generated
 */
@JSON(strict = true)
public class PurchaseModelImpl
        extends BaseModelImpl<Purchase> implements PurchaseModel {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a purchase model instance should use the <code>Purchase</code> interface instead.
     */
    public static final String TABLE_NAME = "SHOP_Purchase";

    public static final Object[][] TABLE_COLUMNS = {
            {"id_", Types.BIGINT}, {"purchaseDate", Types.TIMESTAMP},
            {"eTypeId", Types.BIGINT}, {"employeeId", Types.BIGINT},
            {"electroId", Types.BIGINT}
    };

    public static final Map<String, Integer> TABLE_COLUMNS_MAP =
            new HashMap<String, Integer>();
    public static final String TABLE_SQL_CREATE =
            "create table SHOP_Purchase (id_ LONG not null primary key,purchaseDate DATE null,eTypeId LONG,employeeId LONG,electroId LONG)";
    public static final String TABLE_SQL_DROP = "drop table SHOP_Purchase";
    public static final String ORDER_BY_JPQL = " ORDER BY purchase.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY SHOP_Purchase.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    /**
     * @deprecated As of Athanasius (7.3.x), replaced by {@link
     *        #getColumnBitmask(String)}
     */
    @Deprecated
    public static final long ID_COLUMN_BITMASK = 1L;
    private static final Map<String, Function<Purchase, Object>>
            _attributeGetterFunctions;
    private static final Map<String, BiConsumer<Purchase, Object>>
            _attributeSetterBiConsumers;
    private static final Map<String, String> _attributeNames;
    private static final Map<String, Long> _columnBitmasks;

    static {
        TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("purchaseDate", Types.TIMESTAMP);
        TABLE_COLUMNS_MAP.put("eTypeId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
        TABLE_COLUMNS_MAP.put("electroId", Types.BIGINT);
    }

    static {
        Map<String, Function<Purchase, Object>> attributeGetterFunctions =
                new LinkedHashMap<String, Function<Purchase, Object>>();
        Map<String, BiConsumer<Purchase, ?>> attributeSetterBiConsumers =
                new LinkedHashMap<String, BiConsumer<Purchase, ?>>();

        attributeGetterFunctions.put("id", Purchase::getId);
        attributeSetterBiConsumers.put(
                "id", (BiConsumer<Purchase, Long>) Purchase::setId);
        attributeGetterFunctions.put("purchaseDate", Purchase::getPurchaseDate);
        attributeSetterBiConsumers.put(
                "purchaseDate",
                (BiConsumer<Purchase, Date>) Purchase::setPurchaseDate);
        attributeGetterFunctions.put("eTypeId", Purchase::getETypeId);
        attributeSetterBiConsumers.put(
                "eTypeId", (BiConsumer<Purchase, Long>) Purchase::setETypeId);
        attributeGetterFunctions.put("employeeId", Purchase::getEmployeeId);
        attributeSetterBiConsumers.put(
                "employeeId", (BiConsumer<Purchase, Long>) Purchase::setEmployeeId);
        attributeGetterFunctions.put("electroId", Purchase::getElectroId);
        attributeSetterBiConsumers.put(
                "electroId", (BiConsumer<Purchase, Long>) Purchase::setElectroId);

        _attributeGetterFunctions = Collections.unmodifiableMap(
                attributeGetterFunctions);
        _attributeSetterBiConsumers = Collections.unmodifiableMap(
                (Map) attributeSetterBiConsumers);
    }

    static {
        Map<String, String> attributeNames = new HashMap<>();

        attributeNames.put("id_", "id");

        _attributeNames = Collections.unmodifiableMap(attributeNames);
    }

    static {
        Map<String, Long> columnBitmasks = new HashMap<>();

        columnBitmasks.put("id_", 1L);

        columnBitmasks.put("purchaseDate", 2L);

        columnBitmasks.put("eTypeId", 4L);

        columnBitmasks.put("employeeId", 8L);

        columnBitmasks.put("electroId", 16L);

        _columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
    }

    private long _id;
    private Date _purchaseDate;
    private long _eTypeId;
    private long _employeeId;
    private long _electroId;
    private transient Map<String, Object> _columnOriginalValues;
    private long _columnBitmask;
    private Purchase _escapedModel;

    public PurchaseModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     * @deprecated As of Athanasius (7.3.x), with no direct replacement
     */
    @Deprecated
    public static Purchase toModel(PurchaseSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Purchase model = new PurchaseImpl();

        model.setId(soapModel.getId());
        model.setPurchaseDate(soapModel.getPurchaseDate());
        model.setETypeId(soapModel.getETypeId());
        model.setEmployeeId(soapModel.getEmployeeId());
        model.setElectroId(soapModel.getElectroId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     * @deprecated As of Athanasius (7.3.x), with no direct replacement
     */
    @Deprecated
    public static List<Purchase> toModels(PurchaseSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Purchase> models = new ArrayList<Purchase>(soapModels.length);

        for (PurchaseSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public static long getColumnBitmask(String columnName) {
        return _columnBitmasks.get(columnName);
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Purchase.class;
    }

    @Override
    public String getModelClassName() {
        return Purchase.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        Map<String, Function<Purchase, Object>> attributeGetterFunctions =
                getAttributeGetterFunctions();

        for (Map.Entry<String, Function<Purchase, Object>> entry :
                attributeGetterFunctions.entrySet()) {

            String attributeName = entry.getKey();
            Function<Purchase, Object> attributeGetterFunction =
                    entry.getValue();

            attributes.put(
                    attributeName, attributeGetterFunction.apply((Purchase) this));
        }

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Map<String, BiConsumer<Purchase, Object>> attributeSetterBiConsumers =
                getAttributeSetterBiConsumers();

        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            String attributeName = entry.getKey();

            BiConsumer<Purchase, Object> attributeSetterBiConsumer =
                    attributeSetterBiConsumers.get(attributeName);

            if (attributeSetterBiConsumer != null) {
                attributeSetterBiConsumer.accept(
                        (Purchase) this, entry.getValue());
            }
        }
    }

    public Map<String, Function<Purchase, Object>>
    getAttributeGetterFunctions() {

        return _attributeGetterFunctions;
    }

    public Map<String, BiConsumer<Purchase, Object>>
    getAttributeSetterBiConsumers() {

        return _attributeSetterBiConsumers;
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        if (_columnOriginalValues == Collections.EMPTY_MAP) {
            _setColumnOriginalValues();
        }

        _id = id;
    }

    @JSON
    @Override
    public Date getPurchaseDate() {
        return _purchaseDate;
    }

    @Override
    public void setPurchaseDate(Date purchaseDate) {
        if (_columnOriginalValues == Collections.EMPTY_MAP) {
            _setColumnOriginalValues();
        }

        _purchaseDate = purchaseDate;
    }

    @JSON
    @Override
    public long getETypeId() {
        return _eTypeId;
    }

    @Override
    public void setETypeId(long eTypeId) {
        if (_columnOriginalValues == Collections.EMPTY_MAP) {
            _setColumnOriginalValues();
        }

        _eTypeId = eTypeId;
    }

    @JSON
    @Override
    public long getEmployeeId() {
        return _employeeId;
    }

    @Override
    public void setEmployeeId(long employeeId) {
        if (_columnOriginalValues == Collections.EMPTY_MAP) {
            _setColumnOriginalValues();
        }

        _employeeId = employeeId;
    }

    @JSON
    @Override
    public long getElectroId() {
        return _electroId;
    }

    @Override
    public void setElectroId(long electroId) {
        if (_columnOriginalValues == Collections.EMPTY_MAP) {
            _setColumnOriginalValues();
        }

        _electroId = electroId;
    }

    public long getColumnBitmask() {
        if (_columnBitmask > 0) {
            return _columnBitmask;
        }

        if ((_columnOriginalValues == null) ||
                (_columnOriginalValues == Collections.EMPTY_MAP)) {

            return 0;
        }

        for (Map.Entry<String, Object> entry :
                _columnOriginalValues.entrySet()) {

            if (!Objects.equals(
                    entry.getValue(), getColumnValue(entry.getKey()))) {

                _columnBitmask |= _columnBitmasks.get(entry.getKey());
            }
        }

        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(
                0, Purchase.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Purchase toEscapedModel() {
        if (_escapedModel == null) {
            Function<InvocationHandler, Purchase>
                    escapedModelProxyProviderFunction =
                    EscapedModelProxyProviderFunctionHolder.
                            _escapedModelProxyProviderFunction;

            _escapedModel = escapedModelProxyProviderFunction.apply(
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        PurchaseImpl purchaseImpl = new PurchaseImpl();

        purchaseImpl.setId(getId());
        purchaseImpl.setPurchaseDate(getPurchaseDate());
        purchaseImpl.setETypeId(getETypeId());
        purchaseImpl.setEmployeeId(getEmployeeId());
        purchaseImpl.setElectroId(getElectroId());

        purchaseImpl.resetOriginalValues();

        return purchaseImpl;
    }

    @Override
    public int compareTo(Purchase purchase) {
        int value = 0;

        if (getId() < purchase.getId()) {
            value = -1;
        } else if (getId() > purchase.getId()) {
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

        if (!(object instanceof Purchase)) {
            return false;
        }

        Purchase purchase = (Purchase) object;

        long primaryKey = purchase.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    /**
     * @deprecated As of Athanasius (7.3.x), with no direct replacement
     */
    @Deprecated
    @Override
    public boolean isEntityCacheEnabled() {
        return true;
    }

    /**
     * @deprecated As of Athanasius (7.3.x), with no direct replacement
     */
    @Deprecated
    public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
    }

    /**
     * @deprecated As of Athanasius (7.3.x), with no direct replacement
     */
    @Deprecated
    @Override
    public boolean isFinderCacheEnabled() {
        return true;
    }

    /**
     * @deprecated As of Athanasius (7.3.x), with no direct replacement
     */
    @Deprecated
    public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
    }

    @Override
    public void resetOriginalValues() {
        _columnOriginalValues = Collections.emptyMap();

        _columnBitmask = 0;
    }

    @Override
    public CacheModel<Purchase> toCacheModel() {
        PurchaseCacheModel purchaseCacheModel = new PurchaseCacheModel();

        purchaseCacheModel.id = getId();

        Date purchaseDate = getPurchaseDate();

        if (purchaseDate != null) {
            purchaseCacheModel.purchaseDate = purchaseDate.getTime();
        } else {
            purchaseCacheModel.purchaseDate = Long.MIN_VALUE;
        }

        purchaseCacheModel.eTypeId = getETypeId();

        purchaseCacheModel.employeeId = getEmployeeId();

        purchaseCacheModel.electroId = getElectroId();

        return purchaseCacheModel;
    }

    @Override
    public String toString() {
        Map<String, Function<Purchase, Object>> attributeGetterFunctions =
                getAttributeGetterFunctions();

        StringBundler sb = new StringBundler(
                (5 * attributeGetterFunctions.size()) + 2);

        sb.append("{");

        for (Map.Entry<String, Function<Purchase, Object>> entry :
                attributeGetterFunctions.entrySet()) {

            String attributeName = entry.getKey();
            Function<Purchase, Object> attributeGetterFunction =
                    entry.getValue();

            sb.append("\"");
            sb.append(attributeName);
            sb.append("\": ");

            Object value = attributeGetterFunction.apply((Purchase) this);

            if (value == null) {
                sb.append("null");
            } else if (value instanceof Blob || value instanceof Date ||
                    value instanceof Map || value instanceof String) {

                sb.append(
                        "\"" + StringUtil.replace(value.toString(), "\"", "'") +
                                "\"");
            } else {
                sb.append(value);
            }

            sb.append(", ");
        }

        if (sb.index() > 1) {
            sb.setIndex(sb.index() - 1);
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        Map<String, Function<Purchase, Object>> attributeGetterFunctions =
                getAttributeGetterFunctions();

        StringBundler sb = new StringBundler(
                (5 * attributeGetterFunctions.size()) + 4);

        sb.append("<model><model-name>");
        sb.append(getModelClassName());
        sb.append("</model-name>");

        for (Map.Entry<String, Function<Purchase, Object>> entry :
                attributeGetterFunctions.entrySet()) {

            String attributeName = entry.getKey();
            Function<Purchase, Object> attributeGetterFunction =
                    entry.getValue();

            sb.append("<column><column-name>");
            sb.append(attributeName);
            sb.append("</column-name><column-value><![CDATA[");
            sb.append(attributeGetterFunction.apply((Purchase) this));
            sb.append("]]></column-value></column>");
        }

        sb.append("</model>");

        return sb.toString();
    }

    public <T> T getColumnValue(String columnName) {
        columnName = _attributeNames.getOrDefault(columnName, columnName);

        Function<Purchase, Object> function = _attributeGetterFunctions.get(
                columnName);

        if (function == null) {
            throw new IllegalArgumentException(
                    "No attribute getter function found for " + columnName);
        }

        return (T) function.apply((Purchase) this);
    }

    public <T> T getColumnOriginalValue(String columnName) {
        if (_columnOriginalValues == null) {
            return null;
        }

        if (_columnOriginalValues == Collections.EMPTY_MAP) {
            _setColumnOriginalValues();
        }

        return (T) _columnOriginalValues.get(columnName);
    }

    private void _setColumnOriginalValues() {
        _columnOriginalValues = new HashMap<String, Object>();

        _columnOriginalValues.put("id_", _id);
        _columnOriginalValues.put("purchaseDate", _purchaseDate);
        _columnOriginalValues.put("eTypeId", _eTypeId);
        _columnOriginalValues.put("employeeId", _employeeId);
        _columnOriginalValues.put("electroId", _electroId);
    }

    private static class EscapedModelProxyProviderFunctionHolder {

        private static final Function<InvocationHandler, Purchase>
                _escapedModelProxyProviderFunction =
                ProxyUtil.getProxyProviderFunction(
                        Purchase.class, ModelWrapper.class);

    }

}