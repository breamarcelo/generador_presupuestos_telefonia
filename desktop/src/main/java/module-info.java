module com.budgetsgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires jakarta.xml.bind;
    requires java.xml;
    requires openhtmltopdf.core;
    requires openhtmltopdf.pdfbox;
    requires transitive javafx.graphics;

    opens com.budgetsgenerator.xml.models to jakarta.xml.bind;
    opens com.budgetsgenerator to javafx.fxml;
    opens com.budgetsgenerator.dto to javafx.base;
    opens com.budgetsgenerator.viewmodels to javafx.base;
    opens com.budgetsgenerator.models to org.hibernate.orm.core;
    opens com.budgetsgenerator.controllers to java.base, javafx.fxml;
    exports com.budgetsgenerator;
}
