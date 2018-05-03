package co.simplon.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {


        @Bean(name = "modelMapper")
        public ModelMapper getModelMapper() {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper;
        }

        @Bean(name = "modelMapperWithConverter")
        public ModelMapper getModelMapperWithConverter() {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper;
        }
}
