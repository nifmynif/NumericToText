module com.exprogs.numerictotext {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exprogs.numerictotext to javafx.fxml;
    exports com.exprogs.numerictotext;
    exports com.exprogs.numerictotext.models;
    opens com.exprogs.numerictotext.models to javafx.fxml;
    exports com.exprogs.numerictotext.constants;
    opens com.exprogs.numerictotext.constants to javafx.fxml;
}