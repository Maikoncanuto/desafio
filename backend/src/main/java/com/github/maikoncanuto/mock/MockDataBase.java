package com.github.maikoncanuto.mock;

import com.github.maikoncanuto.domains.dtos.OperatorDTO;
import com.github.maikoncanuto.domains.dtos.PersonDTO;
import com.github.maikoncanuto.domains.enums.RoleEnum;
import com.github.maikoncanuto.domains.enums.TypePersonEnum;
import com.github.maikoncanuto.services.OperatorService;
import io.quarkus.runtime.Startup;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.Date;

import static com.github.maikoncanuto.domains.enums.RoleEnum.ADMIN;
import static com.github.maikoncanuto.domains.enums.TypePersonEnum.NATURAL_PERSON;

@Startup
@Singleton
public class MockDataBase {

    @Inject
    OperatorService operatorService;

    @PostConstruct
    public void start() throws Exception {
        final var operatorPrincipal = new OperatorDTO();
        final var personPrincial = new PersonDTO();

        personPrincial.setTypePerson(NATURAL_PERSON);
        personPrincial.setName("Gabriela");
        personPrincial.setNameMother("Emanuela Santos");
        personPrincial.setNameFather("José Carlos Silva");
        personPrincial.setDateBirth(new Date());
        personPrincial.setDocument("00011122233");

        operatorPrincipal.setLogin("admin");
        operatorPrincipal.setPassword("123");
        operatorPrincipal.setPerson(personPrincial);
        operatorPrincipal.setRole(ADMIN);

        operatorService.save(operatorPrincipal);
    }

}
