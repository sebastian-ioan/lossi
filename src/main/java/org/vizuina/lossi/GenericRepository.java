package org.vizuina.lossi;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Slf4j
@Transactional
public abstract class GenericRepository<T extends Serializable, U extends Serializable> {
    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> type;

    public GenericRepository(Class<T> type) {
        this.type = type;
    }

    protected Session getSession() {
        log.info("Using session factory {}", sessionFactory);
        return sessionFactory.getCurrentSession();
    }

    protected Serializable save(T toSave) {
        return getSession().save(toSave);
    }

    protected T findById(U id) {
        return getSession().get(type, id);
    }
}
