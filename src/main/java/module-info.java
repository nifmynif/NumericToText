module com.exprogs.numerictotext {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exprogs.numerictotext to javafx.fxml;
    exports com.exprogs.numerictotext;
    exports com.exprogs.numerictotext.models;
    opens com.exprogs.numerictotext.models to javafx.fxml;
    exports com.exprogs.numerictotext.constants;
    opens com.exprogs.numerictotext.constants to javafx.fxml;
    exports com.exprogs.numerictotext.models.suffix;
    opens com.exprogs.numerictotext.models.suffix to javafx.fxml;
    exports com.exprogs.numerictotext.models.ten;
    opens com.exprogs.numerictotext.models.ten to javafx.fxml;
    exports com.exprogs.numerictotext.models.hundred;
    opens com.exprogs.numerictotext.models.hundred to javafx.fxml;
    exports com.exprogs.numerictotext.models.unit;
    opens com.exprogs.numerictotext.models.unit to javafx.fxml;
}