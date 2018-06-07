package demo;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;



/**
 * Created by lijing on 2018/5/24.
 */
public class LoggerController {
    public static Logger logger=null;
    private static LoggerController logg=null;

    public static LoggerController getLogger(String name){
        if(logger==null){
            Properties props=new Properties();
            try{
                String path=System.getProperty("user.dir");
                String filepath=path+"/configs/log4j.properties";
                FileInputStream is=new FileInputStream(filepath);
                props.load(is);
            }catch (IOException e){
                e.printStackTrace();
            }
            PropertyConfigurator.configure(props);

            logger=Logger.getLogger(name);
            logg=new LoggerController();
        }
       return logg;
    }
    public void info(String msg){
        logger.info(msg);
    }
    public void warning(String msg){
        logger.warning(msg);
    }
    public void error(String msg){
        logger.severe(msg);
   }




   /* public void debug(String msg){
        logger.debug(msg);
    }
    public void debug(String msg){
        logger.info(msg);
    }

    public void error(String msg){
        logger.error(msg);
    }*/
}
