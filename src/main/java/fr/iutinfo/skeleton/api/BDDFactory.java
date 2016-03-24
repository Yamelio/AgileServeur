package fr.iutinfo.skeleton.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.inject.Singleton;

import org.postgresql.ds.PGPoolingDataSource;
import org.skife.jdbi.v2.DBI;

@Singleton
public class BDDFactory {

	private static DBI dbi = null;

	public static DBI getDbi() {
		if (dbi == null) {

			PGPoolingDataSource ds = new PGPoolingDataSource();
			ds.setServerName("psqlserv");
			ds.setDatabaseName("post_iut");			
			ds.setUser("ngoutans");
			ds.setPassword("moi");
			ds.setPortNumber(5432);
			
			
			System.out.println(ds.getUser());
			System.out.println(ds.getPortNumber());
			System.out.println(ds.getDescription());

			dbi = new DBI(ds);
		}
		return dbi;
	}
}