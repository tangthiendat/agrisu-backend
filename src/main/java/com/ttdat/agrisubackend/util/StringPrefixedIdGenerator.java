package com.ttdat.agrisubackend.util;



import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;




public class StringPrefixedIdGenerator implements IdentifierGenerator {
    public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    private String valuePrefix;
    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    private String numberFormat;
    public static final String SEQUENCE_NAME_PARAMETER = "sequenceName";
    private String sequenceName;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String SQL_INSERT = "INSERT INTO " + sequenceName + " (next_val) VALUES (NULL)";
        session.createNativeMutationQuery(SQL_INSERT).executeUpdate();
        Integer nextSeqValue = session.createNativeQuery("SELECT last_insert_id()", Integer.class).getSingleResult();
        return valuePrefix + String.format(numberFormat, nextSeqValue);
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, "");
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, "%d");
        sequenceName = ConfigurationHelper.getString(SEQUENCE_NAME_PARAMETER, params, "hibernate_sequence");
    }

}
