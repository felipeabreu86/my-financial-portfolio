package portfolio.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * This class implements the service related to data transformation between Java
 * Object and Json format
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@Service
public class JsonConverterService {

    /**
     * ObjectMapper provides functionality for reading and writing JSON
     */
    private static ObjectMapper mapper;
    static {
	mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * Checks if the String received by parameter is in a valid Json format
     * 
     * @param json - String containing text in Json format
     * @return returns if the parameter is in a valid Json format or not
     */
    public boolean isValidJson(String json) {
	boolean valid = false;
	if (json != null && !json.trim().isEmpty()) {
	    try {
		mapper.readTree(json);
		valid = true;
	    } catch (JsonProcessingException e) {
		System.out.println(e.getMessage());
	    }
	}
	return valid;
    }

    /**
     * Converts the Java Object received by parameter to String Json format
     * 
     * @param obj - Java Object
     * @return Optional that may contain the Object converted to String Json format
     *         or null in case of error or non-viability
     */
    public Optional<String> toJson(Object obj) {
	String json = null;
	if (obj != null) {
	    try {
		ObjectWriter ow = new ObjectMapper().writer();
		json = ow.writeValueAsString(obj);
	    } catch (JsonProcessingException e) {
		System.out.println(e.getMessage());
	    }
	}
	return Optional.ofNullable(json);
    }

    /**
     * Converts the String Json format received by parameter in an <T> Object
     * 
     * @param <T>       - Java generic type
     * @param json      - String containing text in Json format
     * @param classType - class type of <T>
     * @return reference to an <T> object instantiated from json content
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public <T> T readValue(String json, Class<T> classType) throws JsonMappingException, JsonProcessingException {
	return mapper.readValue(json, classType);
    }

    /**
     * Converts the String Json format received by parameter in an <T>[] Array
     * Object
     * 
     * @param <T>       - Java generic type
     * @param json      - String containing text in Array Json format
     * @param classType - class type of <T>
     * @return reference to an <T>[] object instantiated from json content
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public <T> T[] readValues(String json, Class<T[]> classType) throws JsonMappingException, JsonProcessingException {
	return mapper.readValue(json, classType);
    }

    /**
     * Converts the String Json format received by parameter in an <T>[] Array
     * Object and returns the first element. In case of empty Array, returns null
     * 
     * @param <T>       - Java generic type
     * @param json      - String containing text in Array Json format
     * @param classType - class type of <T>
     * @return first reference of an array of <T> objects instantiated from json
     *         content
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public <T> T readFirstValue(String json, Class<T[]> classType)
	    throws JsonMappingException, JsonProcessingException {
	T[] result = mapper.readValue(json, classType);
	if (result.length > 0) {
	    return result[0];
	}
	return null;
    }

    /**
     * Checks if the String received by parameter is in a valid Array Json format,
     * for example, [{ "attribute" : "value" }]
     * 
     * @param json - String containing text in Json format
     * @return returns if the parameter is in a valid Array Json format or not
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public boolean isArray(String json) throws JsonMappingException, JsonProcessingException {
	if (json != null && !json.trim().isEmpty()) {
	    JsonNode jsonNode = mapper.readTree(json);
	    if (jsonNode.isArray()) {
		return true;
	    }
	}
	return false;
    }

}
