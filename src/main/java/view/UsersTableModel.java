package view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.User;

public class UsersTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<User> users;
	private String[] columns;
	public JButton deleteButton;
	public JButton updateButton;

	public UsersTableModel(List<User> users) {
		super();
		this.users = users;
		deleteButton = new JButton("Delete");
		updateButton = new JButton("Update");
		columns = new String[] { "CNP", "Firstname", "Lastname", "Username", "Card number", "Email", "Country",
				"County", "City", "Street", "Street Number", "Type", "Delete", "Update" };
		setContent(users);
	}

	public void setContent(List<User> users) {
		for (int index = 0; index < users.size(); index++) {
			setValueAt(users.get(index).getCnp(), index, 0);
			setValueAt(users.get(index).getFirstName(), index, 1);
			setValueAt(users.get(index).getLastName(), index, 2);
			setValueAt(users.get(index).getUsername(), index, 3);
			setValueAt(users.get(index).getCardNumber(), index, 4);
			setValueAt(users.get(index).getEmail(), index, 5);
			setValueAt(users.get(index).getCountry(), index, 6);
			setValueAt(users.get(index).getCounty(), index, 7);
			setValueAt(users.get(index).getCity(), index, 8);
			setValueAt(users.get(index).getStreet(), index, 9);
			setValueAt(users.get(index).getStreetNumber(), index, 10);
			setValueAt(users.get(index).getType(), index, 11);
			setValueAt(deleteButton, index, 12);
			setValueAt(updateButton, index, 13);
		}
	}

	public int getColumnCount() {
		return columns.length;
	}

	public boolean isCellEditable(int row, int col) {
		if (col != 11 && col != 13 && col != 12 && col != 0) {
			return true;
		} else {
			return false;
		}
	}

	public String getColumnName(int col) {
		return columns[col];
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return user.getCnp();
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName();
		case 3:
			return user.getUsername();
		case 4:
			return user.getCardNumber();
		case 5:
			return user.getEmail();
		case 6:
			return user.getCountry();
		case 7:
			return user.getCounty();
		case 8:
			return user.getCity();
		case 9:
			return user.getStreet();
		case 10:
			return user.getStreetNumber();
		case 11:
			return user.getType();
		case 12:
			return deleteButton;
		case 13:
			return updateButton;
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			users.get(rowIndex).setCnp(aValue.toString());
		} else if (columnIndex == 1) {
			users.get(rowIndex).setFirstName(aValue.toString());
		} else if (columnIndex == 2) {
			users.get(rowIndex).setLastName(aValue.toString());
		} else if (columnIndex == 3) {
			users.get(rowIndex).setUsername(aValue.toString());
		} else if (columnIndex == 5) {
			users.get(rowIndex).setEmail(aValue.toString());
		} else if (columnIndex == 6) {
			users.get(rowIndex).setCountry(aValue.toString());
		} else if (columnIndex == 7) {
			users.get(rowIndex).setCounty(aValue.toString());
		} else if (columnIndex == 8) {
			users.get(rowIndex).setCity(aValue.toString());
		} else if (columnIndex == 9) {
			users.get(rowIndex).setStreet(aValue.toString());
		} else if (columnIndex == 10) {
			users.get(rowIndex).setStreetNumber(aValue.toString());

		} else if (columnIndex == 11) {
			users.get(rowIndex).setType(aValue.toString());
		}
	}
}
