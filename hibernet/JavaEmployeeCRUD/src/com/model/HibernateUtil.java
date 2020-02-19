package com.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil 
{

	private static SessionFactory sessionf;
	private static StandardServiceRegistry registry;
	
	public static SessionFactory getsessionfactore()
	{
		if(sessionf==null)
		{
			registry=new StandardServiceRegistryBuilder().configure().build();
			
			MetadataSources mds=new MetadataSources(registry);
			Metadata md=mds.getMetadataBuilder().build();
			sessionf = md.getSessionFactoryBuilder().build();
			
		}
		return sessionf;
	}
}
