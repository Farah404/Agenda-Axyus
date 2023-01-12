package com.axyus.tpagenda.utils;

import com.axyus.jdbc.pool.PoolManager;
import com.axyus.tpagenda.exceptions.FichierConfigurationIntrouvableException;
import java.io.File;
import java.io.IOException;
import java.rmi.UnexpectedException;
import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class Utils {

    private Logger logger;

    protected Logger getLogger() throws UnexpectedException {
        if (logger == null) {
            throw new UnexpectedException("Logger is not yet initialized");
        }
        return this.logger;
    }

    //methode utilitaires pour le chargement d’une fichier 
    protected File getConfFile(String fileNameSystemProperty, String fileNameIfSystemPropertyNotFound) {
        return getConfFile(fileNameSystemProperty, fileNameIfSystemPropertyNotFound, fileNameIfSystemPropertyNotFound);
    }

    protected File getConfFile(String fileNameSystemProperty, String fileNameIfSystemPropertyNotFound, String errorDisplayName) {
        String confFileName = System.getProperty(fileNameSystemProperty);
        File confFile;
        if (confFileName == null) {
            confFileName = "conf" + File.separator + fileNameIfSystemPropertyNotFound;
            confFile = new File(confFileName);
            if (!confFile.exists()) {
                confFileName = fileNameIfSystemPropertyNotFound;
                confFile = new File(confFileName);
                if (!confFile.exists()) {
                    return null;
                }
            }
        } else {
            confFile = new File(confFileName);
            if (!confFile.exists()) {
                return null;
            }
        }
        return confFile;
    }

//initialisation du pool a partir du fichier de conf 
    protected void initialize() throws IOException, FichierConfigurationIntrouvableException {
        File poolConfigFile = getConfFile("pool.conf.file", getClass().getClassLoader().getResource("pool-config.xml").toString());
        if (poolConfigFile == null) {
            throw new FichierConfigurationIntrouvableException("Fichier de configuration d'accès à la base de données introuvable");
        }
        if (PoolManager.getInstance().isInitialized()) {
            getLogger().warn("Le PoolManager a déjà été initialisé.");
        } else {
            PoolManager.getInstance().init(poolConfigFile);
        }
    }

// obtenir connexion et faire des operation sur la base
//try (Connection connection = PoolManager.getInstance().getConnection()) {
//…
//}
}
