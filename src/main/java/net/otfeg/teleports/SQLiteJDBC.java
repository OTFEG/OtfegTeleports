package net.otfeg.teleports;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteJDBC {
		private Logger logger;
		private Connection connection;

		public SQLiteJDBC(File dataFolder, Logger logger) throws Exception {
			this.logger = logger;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      String db = dataFolder.toString() + "/homes.db";
		      connection = DriverManager.getConnection("jdbc:sqlite:"+db);
		    } catch ( Exception e ) {
		      logger.log(Level.WARNING, e.getClass().getName() + ": " + e.getMessage() );
		      throw new Exception("Database failed.");
		    }
		    logger.log(Level.OFF, "Opened database successfully");
	}

}
