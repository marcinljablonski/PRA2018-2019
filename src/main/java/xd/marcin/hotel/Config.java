package xd.marcin.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    public ObjectMapper getJSONmapper(){

        ObjectMapper mapper = new ObjectMapper();
        //Registering Hibernate4Module to support lazy objects
        mapper.registerModule(new Hibernate4Module());

        return mapper;

    }

    public XmlMapper getXMLmapper(){

        JacksonXmlModule module = new JacksonXmlModule();
        // and then configure, for example:
        module.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(module);
        //Registering Hibernate4Module to support lazy objects
        mapper.registerModule(new Hibernate4Module());

        return mapper;

    }
}
