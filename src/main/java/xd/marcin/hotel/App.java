package xd.marcin.hotel;

//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.Module;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.hotel.web.plugins.Docket;


@SpringBootApplication
@EnableJpaRepositories("xd.marcin.hotel.repositories")
//@EnableSwagger2
public class App {
    public static void main(String[] args) {

        new SpringApplicationBuilder(App.class).web(false).run(args);
    }
}
