package com.ttdat.agrisubackend.util;



import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.Properties;


public class StringPrefixedIdGenerator implements IdentifierGenerator {
    private String prefixValue;
    private String numberFormat;
    private String sequenceName;
    private boolean hasYearPrefix;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String SQL_QUERY = "SELECT next_" + sequenceName + "()";
        Integer nextSeqValue = session.createNativeQuery(SQL_QUERY, Integer.class).getSingleResult();
        if(hasYearPrefix){
            int year = Year.now().getValue();
            return String.valueOf(year).substring(2) + prefixValue + "." + String.format(numberFormat, nextSeqValue);
        }
        return prefixValue + String.format(numberFormat, nextSeqValue);
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        prefixValue = ConfigurationHelper.getString("prefixValue", params, "");
        numberFormat = ConfigurationHelper.getString("numberFormat", params, "%d");
        sequenceName = ConfigurationHelper.getString("sequenceName", params, "hibernate_sequence");
        hasYearPrefix = ConfigurationHelper.getBoolean("hasYearPrefix", params, false);
    }

}
