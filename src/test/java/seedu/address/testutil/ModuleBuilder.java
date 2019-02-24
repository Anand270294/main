package seedu.address.testutil;

import java.util.Arrays;
import java.util.LinkedList;

import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.ModuleCredits;
import seedu.address.model.module.ModuleDepartment;
import seedu.address.model.module.ModuleDescription;
import seedu.address.model.module.ModuleTitle;
import seedu.address.model.module.ModulePrereq;

import seedu.address.testutil.TypicalModules;

public class ModuleBuilder {

    public static final String DEFAULT_MODULECODE  = "CS2103T";
    public static final String DEFAULT_MODULETITLE = "Software Engineering";
    public static final String DEFAULT_MODULEDESCRIPTION = "This module introduces the necessary conceptual and analytical tools for " +
            "systematic and rigorous development of software systems. " +
            "It covers four main areas of software development, namely object-oriented system analysis, " +
            "object-oriented system modelling and design, implementation, " +
            "and testing, with emphasis on system modelling and design and " +
            "implementation of software modules that work cooperatively to fulfill the requirements of the system. " +
            "Tools and techniques for software development, " +
            "such as Unified Modelling Language (UML), program specification, and testing methods, " +
            "will be taught. Major software engineering issues such as modularisation criteria, " +
            "program correctness, and software quality will also be covered.";
    public static final String DEFAULT_MODULEPREREQUISITE = "CS1010";
    public static final String DEFAULT_MODULEDEPARTMENT = "Computer Science";
    public static final int DEFAULT_MODULECREDITS = 4;

    public static final LinkedList<Module> DEFAULT_PREREQLIST =
            new LinkedList<>(Arrays.asList(TypicalModules.CS2030,
                    TypicalModules.CS2040, TypicalModules.CS2040C));

    private ModuleCode moduleCode;
    private ModuleTitle moduleTitle;
    private ModuleDescription moduleDescription;
    private ModuleDepartment moduleDepartment;
    private ModulePrereq modulePrereq;
    private ModuleCredits moduleCredits;

    public ModuleBuilder() {
        moduleCode = new ModuleCode(DEFAULT_MODULECODE);
        moduleTitle = new ModuleTitle(DEFAULT_MODULETITLE);
        moduleDescription = new ModuleDescription(DEFAULT_MODULEDESCRIPTION);
        moduleDepartment = new ModuleDepartment(DEFAULT_MODULEDEPARTMENT);
        modulePrereq = new ModulePrereq(DEFAULT_MODULEPREREQUISITE, new LinkedList<>());
        moduleCredits = new ModuleCredits(DEFAULT_MODULECREDITS);
    }

    public ModuleBuilder (Module moduleToCopy) {
        moduleCode = moduleToCopy.getModuleCode();
        moduleTitle = moduleToCopy.getModuleTitle();
        moduleDescription = moduleToCopy.getModuleDescription();
        moduleDepartment = moduleToCopy.getModuleDepartment();
        modulePrereq = moduleToCopy.getModulePrereq();
        moduleCredits = moduleToCopy.getModuleCredits();
    }

    public ModuleBuilder withModuleCode(String code) {
        this.moduleCode = new ModuleCode(code);
        return this;
    }

    /**
     * Sets the {@code moduleTitle} of the {@code Module} that we are building.
     */
    public ModuleBuilder withModuleTitle(String title) {
        this.moduleTitle = new ModuleTitle(title);
        return this;
    }

    /**
     * Sets the {@code moduleDescription
     *} of the {@code Module} that we are building.
     */
    public ModuleBuilder withModuleDescription(String description) {
        this.moduleDescription = new ModuleDescription(description);
        return this;
    }

    public ModuleBuilder withModulePrereq(String description, Module... modules) {
        this.modulePrereq = new ModulePrereq(description, new LinkedList<>(Arrays.asList(modules)));
        return this;
    }


    /**
     * Sets the {@code } of the {@code Module} that we are building.
     */
    public ModuleBuilder withModuleDepartment(String department) {
        this.moduleDepartment = new ModuleDepartment(department);
        return this;
    }

    public ModuleBuilder withModuleCredits(int credits) {
        this.moduleCredits = new ModuleCredits(credits);
        return this;
    }

    public Module build() {
        return new Module(moduleCode, moduleTitle, moduleDescription, modulePrereq, moduleDepartment, moduleCredits);
    }



}
