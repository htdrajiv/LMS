package lms.controller.menu;

import javafx.fxml.FXML;
import lms.controller.utility.Utility;

public class BothController extends AdministratorController {

	@FXML
	private void searchByISBNClick() {
		Utility.loadSearchByISBNView(anchorPane);
	}

	@FXML
	private void checkoutBookClick() {
		Utility.loadCheckoutBookView(anchorPane);
	}

	@FXML
	private void showMemberRecordClick() {
		Utility.loadPrintMemberRecordView(anchorPane);
	}
}
