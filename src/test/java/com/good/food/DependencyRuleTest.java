package com.good.food;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;

class DependencyRuleTest {

    private static final String ROOT_PACKAGE = "com.good.food";
    private static final String DOMAIN_LAYER = "domain";
    private static final String USECASE_LAYER = "application";
    private static final String ADAPTER_LAYER = "adapter";
    private static final String DRIVER_LAYER = "driver";
    private static final String USECASE_PACKAGE = ROOT_PACKAGE + "." + USECASE_LAYER + ".usecase.*";
    private static final String GATEWAYS_PACKAGE = ROOT_PACKAGE + "." + USECASE_LAYER + ".gateway";
    private static final String PRESENTERS_PACKAGE = ROOT_PACKAGE + "." + USECASE_LAYER + ".presenter.*";
    private static final String ADAPTER_PRESENTERS_PACKAGE = ROOT_PACKAGE + "." + ADAPTER_LAYER + "." + "presenter";

    @Test
    void checkDependencyRule() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        // Adapter não deve depender de camadas externas
        checkNoDependencyFromTo(DOMAIN_LAYER, USECASE_LAYER, classesToCheck);
        checkNoDependencyFromTo(DOMAIN_LAYER, ADAPTER_LAYER, classesToCheck);
        checkNoDependencyFromTo(DOMAIN_LAYER, DRIVER_LAYER, classesToCheck);

        // Usecase não deve depender de camadas externas
        checkNoDependencyFromTo(USECASE_LAYER, ADAPTER_LAYER, classesToCheck);
        checkNoDependencyFromTo(USECASE_LAYER, DRIVER_LAYER, classesToCheck);

        // Adapter não deve depender de camadas externas
        checkNoDependencyFromTo(ADAPTER_LAYER, DRIVER_LAYER, classesToCheck);
    }

    @Test
    void domainUsecaseImplShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(USECASE_PACKAGE) //
                .and().areNotInterfaces() //
                .and().areNotAnnotatedWith(ExtendWith.class) //
                .should().haveSimpleNameEndingWith("UseCaseImpl") //
                .check(classesToCheck);
    }

    @Test
    void domainUsecaseShouldEndWithUseCase() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(USECASE_PACKAGE) //
                .and().areInterfaces() //
                .should().haveSimpleNameEndingWith("UseCase") //
                .check(classesToCheck);
    }

    @Test
    void domainGatewaysShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(GATEWAYS_PACKAGE) //
                .should().haveSimpleNameEndingWith("Gateway") //
                .check(classesToCheck);
    }

    @Test
    void domainPresentersShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(PRESENTERS_PACKAGE) //
                .and().areInterfaces() //
                .should().haveSimpleNameEndingWith("Presenter") //
                .check(classesToCheck);
    }

    @Test
    void adapterPresentersImplShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(ADAPTER_PRESENTERS_PACKAGE)
                .and().areNotAnnotatedWith(ExtendWith.class) //
                .should().haveSimpleNameEndingWith("PresenterImpl") //
                .check(classesToCheck);
    }

    private void checkNoDependencyFromTo(String fromPackage, String toPackage, JavaClasses classesToCheck) {
        noClasses().that().resideInAPackage(fullyQualified(fromPackage)).should().dependOnClassesThat().resideInAPackage(fullyQualified(toPackage)).check(classesToCheck);
    }

    private String fullyQualified(String packageName) {
        return ROOT_PACKAGE + '.' + packageName + "..";
    }
}
