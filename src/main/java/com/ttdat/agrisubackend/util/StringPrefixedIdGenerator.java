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
    private String prefixValue;
    private String numberFormat;
    private String sequenceName;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String SQL_QUERY = "SELECT next_" + sequenceName + "()";
        Integer nextSeqValue = session.createNativeQuery(SQL_QUERY, Integer.class).getSingleResult();
        return prefixValue + String.format(numberFormat, nextSeqValue);
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        prefixValue = ConfigurationHelper.getString("prefixValue", params, "");
        numberFormat = ConfigurationHelper.getString("numberFormat", params, "%d");
        sequenceName = ConfigurationHelper.getString("sequenceName", params, "hibernate_sequence");
    }

}
