package lms.controller.member;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lms.controller.utility.Utility;
import lms.dataAccess.DataAccess;
import lms.dataAccess.IDataAccess;
import lms.model.Address;
import lms.model.LibraryMember;

public class AddEditMemberController implements Initializable {
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Label lblMessage;

	@FXML
	private Button btnSave;
	@FXML
	private static TextField txtMemberId;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtStreet;
	@FXML
	private TextField txtCity;
	@FXML
	private TextField txtZip;
	@FXML
	private TextField txtPhoneNo;
	@FXML
	private ComboBox<String> cmbState;
	@FXML
	private Label hdnText;

	private IDataAccess IDataAccess;

	public AddEditMemberController() {
		IDataAccess = DataAccess.getDataAccessObject();
	}

	@FXML
	public void applySaveMember() {
		Address memberAddress = new Address(txtStreet.getText(),
				txtCity.getText(), cmbState.getPromptText(), txtZip.getText());
		HashMap<String, LibraryMember> allMember = IDataAccess.readMemberMap();
		if (allMember != null) {
			String memberId = Integer.toString(allMember.size() + 1);
			LibraryMember member = new LibraryMember(txtFirstName.getText(),
					txtLastName.getText(), txtPhoneNo.getText(), memberAddress,
					memberId);
			IDataAccess.saveNewMember(member);
			lblMessage.setText("Library Member with id " + memberId + " added");
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}