package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static EntityManagerFactory factory;
    private PersistenceUtil(){}
    public static EntityManagerFactory getEntityManagerFactory()
    {
        if(factory==null)
            factory=Persistence.createEntityManagerFactory("musicalbums6");
        return factory;
    }
    public void closeFactory()
    {
        if(factory.isOpen() || factory!=null)
            factory.close();
            
    }
}

	//singleton pe care sa-l folosesc pe post de wraper
