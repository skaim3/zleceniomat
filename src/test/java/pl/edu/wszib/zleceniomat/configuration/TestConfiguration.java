package pl.edu.wszib.zleceniomat.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "pl.edu.wszib.zleceniomat.controllers",
        "pl.edu.wszib.zleceniomat.services.impl",
        "pl.edu.wszib.zleceniomat.session"
})
public class TestConfiguration {


    public class TestCofiguration {
/*
        @Bean
        public IOfferDAO offerDAO(){
            return Mockito.mock(IOfferDAO.class);
        }

        @Bean
        public IAssignmentDAO assignmentDAO(){
            return Mockito.mock(IAssignmentDAO.class);
        }

        @Bean
        public IUserDAO userDAO(){
            return Mockito.mock(IUserDAO.class);
        }*/
    }
}
