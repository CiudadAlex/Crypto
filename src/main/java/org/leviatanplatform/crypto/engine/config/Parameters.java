package org.leviatanplatform.crypto.engine.config;

import java.io.InputStream;
import java.util.Properties;

public class Parameters {

    private static final String CONFIG_FILE_NAME = "config.properties";
    private static final Parameters instance = load();

    public static Parameters getInstance() {
        return instance;
    }

    private final int lengthBlockBytes;
    private final String name;
    private final String surname;
    private final String birthdate;

    public Parameters(int lengthBlockBytes, String name, String surname, String birthdate) {
        this.lengthBlockBytes = lengthBlockBytes;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public int getLengthBlockBytes() {
        return lengthBlockBytes;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    private static Parameters load() {

        Properties props = new Properties();

        try (InputStream input = Parameters.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME)) {

            if (input == null) {
                throw new RuntimeException("File " + CONFIG_FILE_NAME + " not found");
            }

            props.load(input);

            String strLengthBlockBytes = props.getProperty("lengthBlockBytes");
            String name = props.getProperty("name");
            String surname = props.getProperty("surname");
            String birthdate = props.getProperty("birthdate");

            int lengthBlockBytes = Integer.parseInt(strLengthBlockBytes);

            return new Parameters(lengthBlockBytes, name, surname, birthdate);

        } catch (Exception e) {
            throw new RuntimeException("Exception loading configuration", e);
        }
    }
}
