module com.exprogs.numerictotext {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exprogs.numerictotext to javafx.fxml;
    exports com.exprogs.numerictotext;
}